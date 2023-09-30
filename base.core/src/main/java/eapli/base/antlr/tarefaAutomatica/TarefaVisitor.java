package eapli.base.antlr.tarefaAutomatica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import eapli.base.emailHandler.EmailHandler;
import eapli.base.gestaoServicosHD.domain.AtributoFormulario;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.xml.XML;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TarefaVisitor extends ScriptValidacaoTarefasAutomaticasBaseVisitor {

    private Pedido pedido;
    private List<String> dadosConsulta = new ArrayList<>();
    private List<String> dadosValorTotal = new ArrayList<>();
    private List<String> percentagemBaseDesconto = new ArrayList<>();
    private List<String> valoresDesconto = new ArrayList<>();
    private List<String> conteudoPedido = new ArrayList<>();
    private List<String> dados = new ArrayList<>();
    private List<String> erros = new ArrayList<>();
    private Boolean detecaoErro = false;

    public TarefaVisitor(Pedido pedido, List<String> conteudoPedido) {
        this.conteudoPedido = conteudoPedido;
        this.pedido = pedido;
        this.dados.addAll(conteudoPedido);
    }

    @Override
    public Integer visitAtomExpr(ScriptValidacaoTarefasAutomaticasParser.AtomExprContext ctx) {
        return Integer.parseInt(ctx.atom.getText());
    }

    @Override
    public Integer visitOpExprMulDiv(ScriptValidacaoTarefasAutomaticasParser.OpExprMulDivContext ctx) {
        int left = (int) visit(ctx.left), right = (int) visit(ctx.right);
        switch (ctx.op.getText().charAt(0)) {
            case '*':
                return left * right;
            case '/':
                return left / right;
        }
        return 0;
    }

    @Override
    public Integer visitOpExprSumDif(ScriptValidacaoTarefasAutomaticasParser.OpExprSumDifContext ctx) {
        int left = (int) visit(ctx.left), right = (int) visit(ctx.right);
        switch (ctx.op.getText().charAt(0)) {
            case '+':
                return left + right;
            case '-':
                return left - right;
        }
        return 0;
    }

    @Override
    public Integer visitEnviarEmail(ScriptValidacaoTarefasAutomaticasParser.EnviarEmailContext ctx) {
        EmailHandler emailHandler = null;
        try {
            emailHandler = new EmailHandler();
        } catch (IOException ex) {
        }
        emailHandler.sendEmail(pedido.colaborador().identity().toString(), ctx.subject.getText(), visitContent(ctx.content()));
        System.out.println(visitContent(ctx.content()));
        return 0;
    }

    @Override
    public String visitContent(ScriptValidacaoTarefasAutomaticasParser.ContentContext ctx) {
        String msg = "";
        if (ctx.PALAVRA() == null) {
            msg = dados.get(Integer.parseInt(ctx.INTEIRO().toString()) - 1);
        } else if(ctx.INTEIRO() == null) {
            msg = ctx.PALAVRA().toString();
        }
        
        if (ctx.content() == null) {
            return msg + " ";
        } else {
            msg = visitContent(ctx.content()) + msg;
            return msg + " ";
        }

    }
    
    @Override
    public Integer visitConsultar(ScriptValidacaoTarefasAutomaticasParser.ConsultarContext ctx) {
        List<String> lista = XML.obterPrecoECategoriaProduto(conteudoPedido.get(Integer.parseInt(ctx.cod_produto.getText())-1));
        dadosConsulta.addAll(lista);
        dados.addAll(lista);
        return 0;
    }
    
    @Override
    public Integer visitCalcValorTotal(ScriptValidacaoTarefasAutomaticasParser.CalcValorTotalContext ctx) {
        List<String> lista = XML.obterPrecoECategoriaProduto(conteudoPedido.get(Integer.parseInt(ctx.cod_produto.getText())-1));
        int quantidade = Integer.parseInt(conteudoPedido.get(Integer.parseInt(ctx.quantidade.getText())-1));
        
        double valorTotal = Double.parseDouble(lista.get(0)) * quantidade;
        
        dadosValorTotal.add(String.valueOf(valorTotal));
        dados.add(String.valueOf(valorTotal));
        return 0;
    }
    
    @Override
    public Integer visitPercentagemBaseDesconto(ScriptValidacaoTarefasAutomaticasParser.PercentagemBaseDescontoContext ctx) {
        
        if(dadosValorTotal.get(dadosValorTotal.size()-1) == null) {
            return 0;
        }
        
        double valorTotal = Double.parseDouble(dadosValorTotal.get(dadosValorTotal.size()-1));
        
        for(int i=0; i < ctx.verificacaoIf().size(); i++) {
            if((Boolean)visitVerificacaoIf(ctx.verificacaoIf(i))) {
                percentagemBaseDesconto.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
                System.out.println(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
                dados.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
            }
        }
        
//        for(int i=0; i < ctx.verificacaoIf().size(); i++) {
//            String operador = ctx.verificacaoIf(i).condicao().OPERADOR_COMPARAR().toString();
//            int segundoValor = Integer.parseInt(ctx.verificacaoIf(i).condicao().INTEIRO().toString());
//            switch (operador) {
//                    case "<":
//                        if (valorTotal < segundoValor) {
//                            percentagemBaseDesconto.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            dadosXML.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            return 0;
//                        }
//                    case ">":
//                        if (valorTotal > segundoValor) {
//                            percentagemBaseDesconto.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            dadosXML.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            return 0;
//                        }
//                    case "<=":
//                        if (valorTotal <= segundoValor) {
//                            percentagemBaseDesconto.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            dadosXML.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            return 0;
//                        }
//                    case ">=":
//                        if (valorTotal >= segundoValor) {
//                            percentagemBaseDesconto.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            dadosXML.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            return 0;
//                        }
//                    case "==":
//                        if (valorTotal == segundoValor) {
//                            percentagemBaseDesconto.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            dadosXML.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            return 0;
//                        }
//                    case "!=":
//                        if (valorTotal != segundoValor) {
//                            percentagemBaseDesconto.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            dadosXML.add(ctx.verificacaoIf(i).conteudoif().config().INTEIRO().toString());
//                            return 0;
//                        }
//                }
//        }
        
        return 0;
    }
    
    @Override
    public Integer visitAtualizarCategoria(ScriptValidacaoTarefasAutomaticasParser.AtualizarCategoriaContext ctx) {
        String parametro = ctx.parametro.getText();
        
        String categoria = ctx.categoria.getText();
        
        String valor = ctx.INTEIRO().toString();
        
        XML.atualizaParametro(categoria, valor, parametro);
        
        return 0;
    }
    
    
    @Override
    public Integer visitCalcValorDesconto(ScriptValidacaoTarefasAutomaticasParser.CalcValorDescontoContext ctx) {
        
        double percentagemBaseDescontoProduto = Double.parseDouble(percentagemBaseDesconto.get(percentagemBaseDesconto.size()-1));
        List<String> lista = XML.obterPrecoECategoriaProduto(conteudoPedido.get(Integer.parseInt(ctx.cod_produto.getText())-1));
        int quantidade = Integer.parseInt(conteudoPedido.get(Integer.parseInt(ctx.quantidade.getText())-1));
        double valorTotal = Double.parseDouble(lista.get(0)) * quantidade;
        String valorDesconto = String.valueOf(valorTotal * (percentagemBaseDescontoProduto / 100));
        valoresDesconto.add(valorDesconto);
        dados.add(valorDesconto);
        
        return 0;
    }
    
    @Override
    public Boolean visitVerificacaoIf(ScriptValidacaoTarefasAutomaticasParser.VerificacaoIfContext ctx) {
        
        if(ctx.condicao().compararConteudoPalavra() == null) {
            if(dadosValorTotal.isEmpty()) {
                System.out.println("Primeiro e preciso calcular valor total");
                return false;
            }
            double valorTotal = Double.parseDouble(dadosValorTotal.get(dadosValorTotal.size()-1));
            int segundoValor = Integer.parseInt(ctx.condicao().INTEIRO().toString());
            String operador = ctx.condicao().OPERADOR_COMPARAR().toString();
            
            switch (operador) {
                    case "<":
                        if (valorTotal < segundoValor) {
                            return true;
                        }
                        return false;
                    case ">":
                        if (valorTotal > segundoValor) {
                            return true;
                        }
                        return false;
                    case "<=":
                        if (valorTotal <= segundoValor) {
                            return true;
                        }
                        return false;
                    case ">=":
                        if (valorTotal >= segundoValor) {
                            return true;
                        }
                        return false;
                    case "==":
                        if (valorTotal == segundoValor) {
                            return true;
                        }
                        return false;
                    case "!=":
                        if (valorTotal != segundoValor) {
                            return true;
                        }
                        return false;
                }
            
        } else {
            String primeiroValor = conteudoPedido.get(Integer.parseInt(ctx.condicao().compararConteudoPalavra().INTEIRO().toString())-1);
            String segundoValor = ctx.condicao().compararConteudoPalavra().PALAVRA().toString();
            
            String operador = ctx.condicao().compararConteudoPalavra().OPERADOR_COMPARAR().toString();
            
            switch (operador) {
                    case "==":
                        if (primeiroValor.equalsIgnoreCase(segundoValor) ) {
                            System.out.println(segundoValor);
                            return true;
                        }
                        return false;
                    case "!=":
                        if (!primeiroValor.equalsIgnoreCase(segundoValor) ) {
                            return true;
                        }
                        return false;
                }
        }
        
        return false;
    }
}
