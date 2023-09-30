/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.antlr.formulario;

import eapli.base.gestaoServicosHD.domain.AtributoFormulario;
import java.util.ArrayList;
import java.util.List;

public class FormularioVisitor extends ScriptValidacaoBaseVisitor {

    private List<AtributoFormulario> atributos = new ArrayList<>();
    private List<String> conteudoPedido = new ArrayList<>();
    private List<String> erros = new ArrayList<>();
    private Boolean detecaoErro = false;

    public FormularioVisitor(List<String> conteudoPedido, List<AtributoFormulario> atributos) {
        this.conteudoPedido = conteudoPedido;
        this.atributos = atributos;
    }

    @Override
    public Boolean visitProg(ScriptValidacaoParser.ProgContext ctx) {
        try {
            if (ctx.prog() != null) {
                if ((Boolean) this.visit(ctx.prog()) == false) {
                }
            }
            erros = new ArrayList<>();

            if (ctx.config() != null) {
                if ((Boolean) this.visit(ctx.config()) == false) {
                    for (String s : erros) {
                        System.out.println(s);
                    }
                    detecaoErro = true;
                    return false;
                }
            }
            if (ctx.verificacaoIf() != null) {
                if ((Boolean) this.visit(ctx.verificacaoIf()) == false) {
                    for (String s : erros) {
                        System.out.println(s);
                    }
                    detecaoErro = true;
                    return false;
                }
            }
            return !detecaoErro;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean visitVerificacaoIf(ScriptValidacaoParser.VerificacaoIfContext ctx) {
        try {
            if ((Boolean) this.visit(ctx.condicoes()) == false) {
                return true;
            }
            ScriptValidacaoParser.ConteudoContext valueConteudo = ctx.conteudo();
            Object avaliado = null;
            Boolean verificado = true;
            do {
                if (valueConteudo.conteudocondicoes() != null) {
                    avaliado = this.visit(valueConteudo.conteudocondicoes().condicoes());
                    if ((Boolean) avaliado == false) {
                        verificado = false;
                    }
                }
                if (valueConteudo.config() != null) {
                    avaliado = this.visit(valueConteudo.config());
                    if ((Boolean) avaliado == false) {
                        verificado = false;
                    }
                }
                if (valueConteudo.verificacaoIf() != null) {
                    avaliado = this.visit(valueConteudo.verificacaoIf());
                    if ((Boolean) avaliado == false) {
                        verificado = false;
                    }
                }
                valueConteudo = valueConteudo.conteudo();
            } while (valueConteudo != null);
            return verificado;
        } catch (Exception e) {
            e.printStackTrace();;
            return false;
        }
    }

    @Override
    public Boolean visitCondicoesSemOperador(ScriptValidacaoParser.CondicoesSemOperadorContext ctx) {
        try {
            return (Boolean) this.visit(ctx.condicao());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean visitCondicoesOperador(ScriptValidacaoParser.CondicoesOperadorContext ctx) {
        try {
            Object avaliado = null;
            ScriptValidacaoParser.CondicoesContext valueCondicoes = ctx.condicoes();
            do {
                avaliado = this.visit(valueCondicoes);
                if ((Boolean) avaliado == false) {
                    return false;
                }
            } while (valueCondicoes != null);

            String operador = ctx.OperadorCondicao().toString();
            Object avaliado2 = this.visit(ctx.condicao());

            switch (operador) {
                case "&&":
                    if ((Boolean) avaliado && (Boolean) avaliado2) {
                        return true;
                    } else {
                        return false;
                    }
                case "||":
                    if ((Boolean) avaliado || (Boolean) avaliado2) {
                        return true;
                    } else {
                        return false;
                    }
                default:
                    return false;

            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean visitValueTamanho(ScriptValidacaoParser.ValueTamanhoContext ctx) {
        String value = conteudoPedido.get(Integer.parseInt(ctx.Inteiro().get(0).toString()) - 1);
        int tamanho = Integer.parseInt(ctx.Inteiro().get(1).toString());
        try {
            if (value.length() == tamanho) {
                return true;
            }
            erros.add(String.format("O tamanho do valor %s não é %s \n", value, tamanho));
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean visitValueEstaEntre(ScriptValidacaoParser.ValueEstaEntreContext ctx) {
        try {
            int value = Integer.parseInt(conteudoPedido.get(Integer.parseInt(ctx.Inteiro().toString()) - 1));
            int entre1 = Integer.parseInt(ctx.intervalo().Inteiro().get(0).toString());
            int entre2 = Integer.parseInt(ctx.intervalo().Inteiro().get(1).toString());
            if (value <= entre1 && value >= entre2) {
                return true;
            }
            erros.add(String.format("O valor %d não está entre %d e %d\n", value, entre1, entre2));
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean visitValueEObrigadorio(ScriptValidacaoParser.ValueEObrigadorioContext ctx) {
        try {
            String value = conteudoPedido.get(Integer.parseInt(ctx.Inteiro().toString()) - 1);
            String obrigatoriedade = ctx.Obrigatoriedade().toString();

            if (obrigatoriedade.equals("obrigatorio")) {
                if (value.isBlank()) {
                    erros.add(String.format("Nao respondeu ao atributo %s que e obrigatorio\n", atributos.get(Integer.parseInt(ctx.Inteiro().toString()) - 1)));
                    return false;
                }
                return true;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean visitValueVerificarIgualOuDiferente(ScriptValidacaoParser.ValueVerificarIgualOuDiferenteContext ctx) {
        try {
            double valor = Double.parseDouble(conteudoPedido.get(Integer.parseInt(ctx.compararValores().Inteiro().toString()) - 1));
            double valorCalculado = 0.0;
            if(ctx.compararValores().expressaoIntDados() == null) {
                valorCalculado = visitExpressaoIntLiteral(ctx.compararValores().expressaoIntLiteral());
            } if(ctx.compararValores().expressaoIntLiteral() == null) {
                valorCalculado = visitExpressaoIntDados(ctx.compararValores().expressaoIntDados());
            }

//            if (valorCalculado == 0.0) {
//                System.out.println("Erro no cálculo");
//                return false;
//            }

            if (ctx.compararValores().IgualOuDiferente() == null && ctx.compararValores().OperadorLogico() != null) {
                String operador = ctx.compararValores().OperadorLogico().toString();
                switch (operador) {
                    case "<":
                        if (valor < valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era menor do que o valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                    case ">":
                        if (valor > valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era maior do que o valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                    case "<=":
                        if (valor <= valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era menor ou igual ao valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                    case ">=":
                        if (valor >= valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era maior ou igual ao valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                }
            } else if (ctx.compararValores().IgualOuDiferente() != null && ctx.compararValores().OperadorLogico() == null) {
                String operador = ctx.compararValores().IgualOuDiferente().toString();
                switch (operador) {
                    case "==":
                        if (valor == valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era igual ao valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                    case "!=":
                        if (valor != valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era diferente do valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    @Override
    public Boolean visitValueVerificarIgualOuDiferente2(ScriptValidacaoParser.ValueVerificarIgualOuDiferente2Context ctx) {
        try {
            double valor = Double.parseDouble(conteudoPedido.get(Integer.parseInt(ctx.compararValores().Inteiro().toString()) - 1));
            double valorCalculado = 0.0;
            if(ctx.compararValores().expressaoIntDados() == null) {
                valorCalculado = visitExpressaoIntLiteral(ctx.compararValores().expressaoIntLiteral());
            } else if(ctx.compararValores().expressaoIntLiteral() == null) {
                valorCalculado = visitExpressaoIntDados(ctx.compararValores().expressaoIntDados());
            }
//            if (valorCalculado == 0.0) {
//                System.out.println("Erro no cálculo");
//                return false;
//            }

            if (ctx.compararValores().IgualOuDiferente() == null && ctx.compararValores().OperadorLogico() != null) {
                String operador = ctx.compararValores().OperadorLogico().toString();
                switch (operador) {
                    case "<":
                        if (valor < valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era menor do que o valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                    case ">":
                        if (valor > valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era maior do que o valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                    case "<=":
                        if (valor <= valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era menor ou igual ao valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                    case ">=":
                        if (valor >= valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era maior ou igual ao valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                }
            } else if (ctx.compararValores().IgualOuDiferente() != null && ctx.compararValores().OperadorLogico() == null) {
                String operador = ctx.compararValores().IgualOuDiferente().toString();
                switch (operador) {
                    case "==":
                        if (valor == valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era igual ao valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                    case "!=":
                        if (valor != valorCalculado) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era diferente do valor calculado %.2f", atributos.get(Integer.parseInt(ctx.compararValores().Inteiro().toString())), valorCalculado));
                        return false;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    @Override
    public Boolean visitValueEstado(ScriptValidacaoParser.ValueEstadoContext ctx) {
        try {
            String valor = conteudoPedido.get(Integer.parseInt(ctx.Inteiro().toString()) - 1);
            String estado = ctx.EstadoString().toString();

            if (estado.equalsIgnoreCase("cheio")) {
                if (valor.isBlank()) {
                    erros.add(String.format("Atributo não preenchido %s", atributos.get(Integer.parseInt(ctx.Inteiro().toString()) - 1).nomeVariavel()));
                    return false;
                }
                return true;
            } else if (estado.equalsIgnoreCase("vazio")) {
                if (valor.isBlank()) {
                    return true;
                }
                erros.add(String.format("Atributo não devia estar preenchido %s", atributos.get(Integer.parseInt(ctx.Inteiro().toString()) - 1).nomeVariavel()));
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean visitValueStringIgual(ScriptValidacaoParser.ValueStringIgualContext ctx) {
        try {
            String valor = conteudoPedido.get(Integer.parseInt(ctx.Inteiro().toString()) - 1);
            StringBuilder aux = new StringBuilder();

            ScriptValidacaoParser.ValorStringContext context = ctx.condicaoString().stringEntreAspas().valorString();
            do {
                aux.append(context.String().toString());
                aux.append(" ");
                context = context.valorString();
            } while (context != null);

            String valorIgual = aux.toString();
            valorIgual = valorIgual.replace("\"", "");

            String operador = ctx.IgualOuDiferente().toString();

            switch (operador) {
                case "==":
                    if (valor.trim().equalsIgnoreCase(valorIgual.trim())) {
                        return true;
                    }
                    erros.add(String.format("O atributo %s devia ser igual a %s", atributos.get(Integer.parseInt(ctx.Inteiro().toString()) - 1).nomeVariavel(), valorIgual));
                    return false;
                case "!=":
                    if (!valor.equals(valorIgual)) {
                        return true;
                    }
                    erros.add(String.format("O atributo %s não pode ser igual a %s", atributos.get(Integer.parseInt(ctx.Inteiro().toString()) - 1).nomeVariavel(), valorIgual));
                    return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean visitValueBoolean(ScriptValidacaoParser.ValueBooleanContext ctx) {
        try {
            String valor = conteudoPedido.get(Integer.parseInt(ctx.Inteiro().toString()) - 1);
            String operador = ctx.IgualOuDiferente().toString();
            String valorBoolean = ctx.ValorBool().toString();

            switch (operador) {
                case "==":
                    if (valor.equals(valorBoolean)) {
                        return true;
                    }
                    erros.add(String.format("O atributo %s devia ser %s", atributos.get(Integer.parseInt(ctx.Inteiro().toString()) - 1).nomeVariavel(), valorBoolean));
                    return false;
                case "!=":
                    if (!valor.equals(valorBoolean)) {
                        return true;
                    }
                    erros.add(String.format("O atributo %s devia ser %s", atributos.get(Integer.parseInt(ctx.Inteiro().toString()) - 1).nomeVariavel(), valorBoolean));
                    return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean visitBooleanValue(ScriptValidacaoParser.BooleanValueContext ctx) {
        try {
            String valor = conteudoPedido.get(Integer.parseInt(ctx.Inteiro().toString()) - 1);
            String operador = ctx.IgualOuDiferente().toString();
            String valorBoolean = ctx.ValorBool().toString();

            switch (operador) {
                case "==":
                    if (valor.equals(valorBoolean)) {
                        return true;
                    }
                    erros.add(String.format("O atributo %s devia ser %s", atributos.get(Integer.parseInt(ctx.Inteiro().toString()) - 1).nomeVariavel(), valorBoolean));
                    return false;
                case "!=":
                    if (!valor.equals(valorBoolean)) {
                        return true;
                    }
                    erros.add(String.format("O atributo %s devia ser %s", atributos.get(Integer.parseInt(ctx.Inteiro().toString()) - 1).nomeVariavel(), valorBoolean));
                    return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Double visitExpressaoIntDados(ScriptValidacaoParser.ExpressaoIntDadosContext ctx) {
        try {
            double primeiroValor = Double.parseDouble(conteudoPedido.get(Integer.parseInt(ctx.Inteiro().toString()) - 1));
            if(ctx.OperadorMatematico() == null) {
                return primeiroValor;
            }
            String operador = ctx.OperadorMatematico().toString();

            if (ctx.expressaoIntDados().expressaoIntDados() == null) {
                double segundoValor = Double.parseDouble(conteudoPedido.get(Integer.parseInt(ctx.expressaoIntDados().Inteiro().toString()) - 1));
                switch (operador) {
                    case "+":
                        return primeiroValor + segundoValor;
                    case "-":
                        return primeiroValor - segundoValor;
                    case "*":
                        return primeiroValor * segundoValor;
                    case "/":
                        return primeiroValor / segundoValor;
                }
                return 0.0;
            } else {
                double segundoValor = visitExpressaoIntDados(ctx.expressaoIntDados());
                switch (operador) {
                    case "+":
                        return primeiroValor + segundoValor;
                    case "-":
                        return primeiroValor - segundoValor;
                    case "*":
                        return primeiroValor * segundoValor;
                    case "/":
                        return primeiroValor / segundoValor;
                }
                return 0.0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    @Override
    public Double visitExpressaoIntLiteral(ScriptValidacaoParser.ExpressaoIntLiteralContext ctx) {
        try {
            double primeiroValor = Double.parseDouble(ctx.Inteiro().toString());
            if(ctx.OperadorMatematico() == null) {
                return primeiroValor;
            }
            String operador = ctx.OperadorMatematico().toString();

            if (ctx.expressaoIntLiteral().expressaoIntLiteral() == null) {
                double segundoValor = Double.parseDouble(ctx.expressaoIntLiteral().Inteiro().toString());
                switch (operador) {
                    case "+":
                        return primeiroValor + segundoValor;
                    case "-":
                        return primeiroValor - segundoValor;
                    case "*":
                        return primeiroValor * segundoValor;
                    case "/":
                        return primeiroValor / segundoValor;
                }
                return 0.0;
            } else {
                double segundoValor = visitExpressaoIntLiteral(ctx.expressaoIntLiteral());
                switch (operador) {
                    case "+":
                        return primeiroValor + segundoValor;
                    case "-":
                        return primeiroValor - segundoValor;
                    case "*":
                        return primeiroValor * segundoValor;
                    case "/":
                        return primeiroValor / segundoValor;
                }
                return 0.0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
    
    @Override
    public Boolean visitDecimalVerificarIgualOuDiferente(ScriptValidacaoParser.DecimalVerificarIgualOuDiferenteContext ctx) {
        try {
            double primeiroValor = Double.parseDouble(conteudoPedido.get(Integer.parseInt(ctx.decimal().Inteiro().toString()) - 1));
            int intPart = (int) primeiroValor;
            double parteDecimal = primeiroValor - intPart;
            System.out.println(parteDecimal);
            double segundoValor = Double.parseDouble(ctx.Inteiro().toString());
            
            if (ctx.IgualOuDiferente() == null && ctx.OperadorLogico() != null) {
                String operador = ctx.OperadorLogico().toString();
                switch (operador) {
                    case "<":
                        if (parteDecimal < segundoValor) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era menor do que o valor %.2f", atributos.get(Integer.parseInt(ctx.decimal().Inteiro().toString())), segundoValor));
                        return false;
                    case ">":
                        if (parteDecimal > segundoValor) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era maior do que o valor %.2f", atributos.get(Integer.parseInt(ctx.decimal().Inteiro().toString())), segundoValor));
                        return false;
                    case "<=":
                        if (parteDecimal <= segundoValor) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era menor ou igual ao valor %.2f", atributos.get(Integer.parseInt(ctx.decimal().Inteiro().toString())), segundoValor));
                        return false;
                    case ">=":
                        if (parteDecimal >= segundoValor) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era maior ou igual ao valor %.2f", atributos.get(Integer.parseInt(ctx.decimal().Inteiro().toString())), segundoValor));
                        return false;
                }
            } else if (ctx.IgualOuDiferente() != null && ctx.OperadorLogico() == null) {
                String operador = ctx.IgualOuDiferente().toString();
                switch (operador) {
                    case "==":
                        if (parteDecimal == segundoValor) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era igual ao valor %.2f", atributos.get(Integer.parseInt(ctx.decimal().Inteiro().toString())), segundoValor));
                        return false;
                    case "!=":
                        if (parteDecimal != segundoValor) {
                            return true;
                        }
                        erros.add(String.format("O valor do atributo %s não era diferente do valor %.2f", atributos.get(Integer.parseInt(ctx.decimal().Inteiro().toString())), segundoValor));
                        return false;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
