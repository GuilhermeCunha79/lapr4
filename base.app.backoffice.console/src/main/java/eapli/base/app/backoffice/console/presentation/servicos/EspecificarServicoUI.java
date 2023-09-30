/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.antlr.formulario.ValidacaoFormulario;
import eapli.base.antlr.tarefaAutomatica.ExecucaoTarefa;
import eapli.base.app.backoffice.console.presentation.catalogos.CatalogoServicosPrinter;
import eapli.base.fluxosAtividade.domain.AtividadeAutomaticaScript;
import eapli.base.fluxosAtividade.domain.AtividadeManual;
import eapli.base.fluxosAtividade.domain.ScriptExecucao;
import eapli.base.gestaoServicosHD.application.EspecificarServicoController;
import eapli.base.gestaoServicosHD.domain.AtributoFormulario;
import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.CodigoServico;
import eapli.base.gestaoServicosHD.domain.DescricaoBreve;
import eapli.base.gestaoServicosHD.domain.DescricaoCompleta;
import eapli.base.gestaoServicosHD.domain.EtiquetaAtributoFormulario;
import eapli.base.gestaoServicosHD.domain.ExpressaoRegular;
import eapli.base.gestaoServicosHD.domain.Formulario;
import eapli.base.gestaoServicosHD.domain.IdentificadorFormulario;
import eapli.base.gestaoServicosHD.domain.Keyword;
import eapli.base.gestaoServicosHD.domain.NomeFormulario;
import eapli.base.gestaoServicosHD.domain.NomeVariavelAtributo;
import eapli.base.gestaoServicosHD.domain.ScriptValidacao;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosHD.domain.TipoDadosAtributoFormulario;
import eapli.base.gestaoServicosRH.domain.Colaborador;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EspecificarServicoUI extends AbstractUI {

    private final EspecificarServicoController theController = new EspecificarServicoController();

    @Override
    protected boolean doShow() {

        Iterable<Servico> servicos = this.theController.servicos();
        final Iterable<CatalogoServicos> catalogosServicos = this.theController.catalogos();
        boolean verificacao = false;
        //Dados Servico
        CatalogoServicos catalogoServicos = null;
        CodigoServico codigoServico = null;
        DescricaoBreve descricaoBreve;
        DescricaoCompleta descricaoCompleta;
        Keyword keyword;
        List<Keyword> keywords = new ArrayList<>();
        Servico servico = null;
        List<Formulario> formularios = new ArrayList<>();
        //Dados Formulario
        IdentificadorFormulario identificadorFormulario = null;
        NomeFormulario nomeFormulario;
        //Dados AtributoFormulario
        EtiquetaAtributoFormulario etiquetaAtributo = null;
        TipoDadosAtributoFormulario tipoDadosAtributo = null;
        DescricaoBreve descricaoAtributo;
        ExpressaoRegular expressaoRegular;
        NomeVariavelAtributo nomeVariavel;
        Formulario formulario = null;
        boolean requerFeedback = false;
        //Dados FluxoAtividade
        AtividadeManual novaAtividadeManual;
        Colaborador colaboradorResponsavel = null;
        final Iterable<Colaborador> colaboradores = this.theController.colaboradores();
        String script;
        AtividadeAutomaticaScript novaAtividadeAutomaticaScript;

        int opcao = 1;
        System.out.println("Especificar um Servico:");
        while (opcao == 1) {
            verificacao = false;
            while (!verificacao) {
                codigoServico = new CodigoServico(Console.readLine("Codigo de Servico"));
                verificacao = theController.verificarCodigoServico(servicos, codigoServico);
                if (!verificacao) {
                    System.out.println("O codigo ja esta associado a outro Servico");
                }
            }

            descricaoBreve = new DescricaoBreve(Console.readLine("Descricao Breve"));
            descricaoCompleta = new DescricaoCompleta(Console.readLine("Descricao Completa"));

            opcao = 1;
            while (opcao != 1 && opcao != 0) {
                opcao = Console.readInteger("Este Serviço requer feedback? 1-Sim 0-Não");
                if (opcao == 1) {
                    requerFeedback = true;
                }
                if (opcao == 0) {
                    requerFeedback = false;
                }
            }

            final SelectWidget<CatalogoServicos> selectorC = new SelectWidget<>("Catalogos de Servicos:", catalogosServicos,
                    new CatalogoServicosPrinter());

            opcao = 0;
            while (opcao == 0) {
                selectorC.show();
                catalogoServicos = selectorC.selectedElement();
                CatalogoServicosPrinter catalogoServicosPrinter = new CatalogoServicosPrinter();
                catalogoServicosPrinter.visit(catalogoServicos);

                opcao = Console.readInteger("É este o catálogo de serviços desejado?? 1-Sim 0-Não");
                while (opcao != 1 && opcao != 0) {
                    opcao = Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
                }
            }

            if (catalogoServicos != null) {
                servico = theController.criarServico(codigoServico, descricaoBreve, descricaoCompleta, requerFeedback, catalogoServicos);
                opcao = 0;
                System.out.println("Servico criado com sucesso!");
            } else {
                System.out.println("Nao foi possivel criar o servico.");
                opcao = Console.readInteger("Pretende tentar de novo? 1-Sim 0-Nao");
                while (opcao != 1 && opcao != 0) {
                    opcao = Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
                }
                if (opcao == 0) {
                    return false;
                }
            }
        }

        int menu = 0;
        while (menu != 6) {
            menu = Console.readInteger("1-Criar Formulario 2-Criar Atributo Formulario 3-Fluxo de Atividade 4-Keywords 5-Finalizar Servico 6-Sair");
            switch (menu) {
                case 1:
                    verificacao = false;
                    while (!verificacao) {
                        identificadorFormulario = new IdentificadorFormulario(Console.readLine("Identificador de Formulario"));
                        verificacao = theController.verificarIdentificadorFormulario(servico, identificadorFormulario);
                        if (!verificacao) {
                            System.out.println("O identificador ja esta associado a outro Formulario");
                        }
                    }

                    nomeFormulario = new NomeFormulario(Console.readLine("Nome do formulario"));
                    boolean formularioSolicitacao = false;
                    int opcaoFormulario;
                    opcaoFormulario = Console.readInteger("Pretende adicionar o formulario de solicitacao?? 1-Sim 0-Não");
                    while (opcaoFormulario != 1 && opcaoFormulario != 0) {
                        opcaoFormulario = Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
                    }
                    if (opcaoFormulario == 1) {
                        if (servico.formularioSolicitacao() != null) {
                            System.out.println("Ja existe um formulario de solicitacao!");
                            break;
                        } else {
                            formularioSolicitacao = true;
                        }
                    }
                    
                    ScriptValidacao scriptValidacao = null;
                    do {
                        try {
                            String scriptPath = Console.readLine("Path script validacao");
                            File scriptFile = new File(scriptPath);
                            scriptValidacao = new ScriptValidacao(scriptFile);
                        } catch (IOException ex) {
                        }
                    } while (!ValidacaoFormulario.validarScript(scriptValidacao));
                    
                    theController.criarFormularioServico(identificadorFormulario, nomeFormulario, servico, formularioSolicitacao, scriptValidacao);
                    System.out.println("Formulário criado com sucesso!");
                    break;
                case 2:
                    formularios = servico.formularios();
                    if (servico.formularioSolicitacao() != null && !formularios.contains(servico.formularioSolicitacao())) {
                        formularios.add(servico.formularioSolicitacao());
                    }
                    int verificarFormularios = 0;
                    for (Formulario f : formularios) {
                        verificarFormularios++;
                    }
                    if (verificarFormularios == 0) {
                        System.out.println("Este servico nao tem nenhum formulario associado!");
                        break;
                    }
                    final SelectWidget<Formulario> selectorF = new SelectWidget<>("Formularios:", formularios,
                            new FormularioPrinter());

                    opcao = 0;
                    while (opcao == 0) {
                        selectorF.show();
                        formulario = selectorF.selectedElement();
                        FormularioPrinter formulariosPrinter = new FormularioPrinter();
                        formulariosPrinter.visit(formulario);

                        opcao = Console.readInteger("É este o formulário desejado?? 1-Sim 0-Não");
                        while (opcao != 1 && opcao != 0) {
                            opcao = Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
                        }
                    }

                    verificacao = false;
                    while (!verificacao) {
                        etiquetaAtributo = new EtiquetaAtributoFormulario(Console.readLine("Etiqueta Atributo Formulario"));
                        verificacao = theController.verificarEtiquetaAtributoFormulario(formulario, etiquetaAtributo);
                        if (!verificacao) {
                            System.out.println("A etiqueta ja esta associado a outro Atributo");
                        }
                    }

                    tipoDadosAtributo = selectTipoDadosAtributoFormulario();

                    descricaoAtributo = new DescricaoBreve(Console.readLine("Descricao Breve"));
                    expressaoRegular = new ExpressaoRegular(Console.readLine("Expressao Regular"));
                    nomeVariavel = new NomeVariavelAtributo(Console.readLine("Nome Variavel Atributo"));

                    theController.criarAtributoFormulario(etiquetaAtributo, tipoDadosAtributo, descricaoAtributo, expressaoRegular, nomeVariavel, servico, formulario);
                    System.out.println("Atributo de Formulário criado com sucesso!");
                    break;
                case 3:
                    int menuFluxoAtividade = Console.readInteger("1-CriarFluxoAtividade 2-Atividade Manual 3-Atividade Automatica Script 4-Sair");
                    switch (menuFluxoAtividade) {
                        case 1:
                            if (servico.fluxoAtividade() != null) {
                                System.out.println("Servico ja tem fluxo de atividade.");
                                break;
                            }
                            String nomeFluxoAtividade = Console.readLine("Nome Fluxo de Atividade");
                            theController.criarFluxoAtividade(servico, nomeFluxoAtividade);
                            System.out.println("Fluxo Atividade criado com sucesso1");
                            break;
                        case 2:
                            if (servico.fluxoAtividade() == null) {
                                System.out.println("Este servico ainda nao tem fluxo de atividade.");
                                break;
                            }
                           
                            formularios = servico.formularios();
                            if (formularios.contains(servico.formularioSolicitacao()) && servico.formularioSolicitacao() != null) {
                                formularios.remove(servico.formularioSolicitacao());
                            }
                            verificarFormularios = 0;
                            for (Formulario f : formularios) {
                                verificarFormularios++;
                            }
                            if (verificarFormularios == 0) {
                                System.out.println("Este servico nao tem nenhum formulario associado!");
                                break;
                            }

                            descricaoBreve = new DescricaoBreve(Console.readLine("Descricao Breve"));
                            
                            final SelectWidget<Formulario> selectorF2 = new SelectWidget<>("Formularios:", formularios,
                                    new FormularioPrinter());

                            opcao = 0;
                            while (opcao == 0) {
                                selectorF2.show();
                                formulario = selectorF2.selectedElement();
                                FormularioPrinter formulariosPrinter = new FormularioPrinter();
                                formulariosPrinter.visit(formulario);

                                opcao = Console.readInteger("É este o formulário desejado?? 1-Sim 0-Não");
                                while (opcao != 1 && opcao != 0) {
                                    opcao = Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
                                }
                            }
                            novaAtividadeManual = theController.novaAtividadeManual(descricaoBreve, formulario);
                            int opcaoAtividadeManual;
                            opcaoAtividadeManual = Console.readInteger("1-Adicionar Atividade ao fluxo valido 2-Adicionar Atividade ao fluxo invalido 3-Adicionar Atividade Aprovacao");
                            while (opcaoAtividadeManual != 1 && opcaoAtividadeManual != 2 && opcaoAtividadeManual != 3) {
                                opcaoAtividadeManual = Console.readInteger("Introduza um dos valores pedidos! 1 ou 2 ou 3");
                            }
                            if (opcaoAtividadeManual == 1) {
                                theController.addAtividadeFluxoValido(servico, novaAtividadeManual);
                            }
                            if (opcaoAtividadeManual == 2) {
                                theController.addAtividadeFluxoInvalido(servico, novaAtividadeManual);
                            }
                            if (opcaoAtividadeManual == 3) {
                                System.out.println("Quem realiza atividade de aprovacao?");
                                opcao = Console.readInteger("1-Responsaveis pelo catalogo 2-Superior hierarquico");
                                while (opcao != 1 && opcao != 2) {
                                    opcao = Console.readInteger("Introduza um dos valores pedidos! 1 ou 2");
                                }
                                theController.novaAtividadeAprovacao(descricaoBreve, formulario, servico, opcao);
                            }
                            System.out.println("Atividade Manual adicionada!");
                            break;
                        case 3:
                            if (servico.fluxoAtividade() == null) {
                                System.out.println("Este servico ainda nao tem fluxo de atividade.");
                                break;
                            }
                            descricaoBreve = new DescricaoBreve(Console.readLine("Descricao Breve"));
                            ScriptExecucao scriptExecucao = null;
                            do {
                                try {
                                    String scriptPath = Console.readLine("Path script validacao");
                                    File scriptFile = new File(scriptPath);
                                    scriptExecucao = new ScriptExecucao(scriptFile);
                                    System.out.println("Conteudo do Script:");
                                    System.out.println(scriptExecucao.Conteudo());
                                } catch (IOException ex) {
                                }
                            } while (!ExecucaoTarefa.validarScript(scriptExecucao));
                            
                            novaAtividadeAutomaticaScript = theController.novaAtividadeAutomaticaScript(descricaoBreve, scriptExecucao);
                            
                            int opcaoAtividadeAutomaticaScript;
                            opcaoAtividadeAutomaticaScript = Console.readInteger("1-Adicionar Atividade ao fluxo valido 2-Adicionar Atividade ao fluxo invalido");
                            while (opcaoAtividadeAutomaticaScript != 1 && opcaoAtividadeAutomaticaScript != 2) {
                                opcaoAtividadeAutomaticaScript = Console.readInteger("Introduza um dos valores pedidos! 1 ou 2");
                            }
                            if (opcaoAtividadeAutomaticaScript == 1) {
                                theController.addAtividadeFluxoValido(servico, novaAtividadeAutomaticaScript);
                            }
                            if (opcaoAtividadeAutomaticaScript == 2) {
                                theController.addAtividadeFluxoInvalido(servico, novaAtividadeAutomaticaScript);
                            }
                            System.out.println("Atividade Automatica Script adicionada!");
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 4:
                    int adicionarKeyword = 1;
                    while (adicionarKeyword == 1) {
                        keyword = new Keyword(Console.readLine("Nova Keyword"));
                        keywords.add(keyword);
                        adicionarKeyword = Console.readInteger("Pretende adicionar mais keywords?? 1-Sim 0-Não");
                        while (adicionarKeyword != 1 && adicionarKeyword != 0) {
                            adicionarKeyword = Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
                        }
                    }
                    theController.atualizarServico(keywords, servico);
                    System.out.println("Lista de keywords atualizada!");
                    break;
                case 5:
                    if (theController.finalizarServico(servico)) {
                        System.out.println("Servico finalizado com sucesso!");
                        break;
                    }
                    System.out.println("Servico ainda nao pode ser finalizado!");
                    break;
                case 6:
                    theController.saveServico(servico);
                    System.out.println("Servico guardado com sucesso!");
                    break;
            }
        }

        return false;
    }

    private TipoDadosAtributoFormulario selectTipoDadosAtributoFormulario() {
        System.out.println("Tipos de Dados de Atributo de Formulario Disponiveis:");
        for (final TipoDadosAtributoFormulario type : TipoDadosAtributoFormulario.values()) {
            System.out.println("\t" + type);
        }
        do {
            try {
                final String type = Console.readLine("Tipo de Dados de Atributo de Formulario?");
                return TipoDadosAtributoFormulario.valueOf(type);
            } catch (final IllegalArgumentException e) {
                System.out.println("Por favor tente de novo. Insira um tipo de dados válido.");
            }
        } while (true);
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }
}
