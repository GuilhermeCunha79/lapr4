/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.pedidos;

import eapli.base.antlr.formulario.ValidacaoFormulario;
import eapli.base.app.backoffice.console.presentation.catalogos.CatalogoServicosPrinter;
import eapli.base.app.backoffice.console.presentation.servicos.ServicoPrinter;
import eapli.framework.validations.Preconditions;
import eapli.base.gestaoServicosHD.application.EspecificarServicoController;
import eapli.base.gestaoServicosHD.application.SolicitarPedidoController;
import eapli.base.gestaoServicosHD.domain.AtributoFormulario;
import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.CodigoServico;
import eapli.base.gestaoServicosHD.domain.Feedback;
import eapli.base.gestaoServicosHD.domain.IdentificadorPedido;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.base.gestaoServicosHD.domain.Urgencia;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sandr
 */
public class SolicitarPedidoUI extends AbstractUI {

    private final SolicitarPedidoController theController = new SolicitarPedidoController();

    @Override
    protected boolean doShow() {

        boolean verificacao = false;
        CodigoServico codigoServico = null; ///
        Urgencia urgencia = null; ///
        Feedback feedback = null; ///
        Date dataLimiteResolucao = null;
        IdentificadorPedido identificadorPedido = null;
        String idPedido;
        CatalogoServicos catalogoServicos = null;

        int ano = 0, mes = 0, dia = 0;
        Servico servico = null;
        
        Iterable<CatalogoServicos> catalogosServicos = this.theController.catalogos();

        System.out.println("Solicitar Pedido:");

        final SelectWidget<CatalogoServicos> selectorC = new SelectWidget<>("Catalogos de Servicos:", catalogosServicos,
                new CatalogoServicosPrinter());

        int opcao = 0;
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

        List<Servico> servicos = catalogoServicos.listaServicosDisponiveis();

        final SelectWidget<Servico> selectorS = new SelectWidget<>("Servicos:", servicos,
                new ServicoPrinter());

        opcao = 0;
        while (opcao == 0) {
            selectorS.show();
            servico = selectorS.selectedElement();
            ServicoPrinter servicoPrinter = new ServicoPrinter();
            servicoPrinter.visit(servico);

            opcao = Console.readInteger("É este o serviço desejado?? 1-Sim 0-Não");
            while (opcao != 1 && opcao != 0) {
                opcao = Console.readInteger("Introduza um dos valores pedidos! 1-Sim 0-Não");
            }
        }

        urgencia = selectTiposUrgencia();
        //feedback = new Feedback(Console.readInteger("Feedback (Inteiro compreendido entre 0-10)"));
        System.out.println("Em relação à data limite de resolução do seu pedido:");
        ano = Console.readInteger("Ano da data limite de resolucao");
        mes = Console.readInteger("Mês da data limite de resolucao");
        dia = Console.readInteger("Dia da data limite de resolucao");

        dataLimiteResolucao = new Date(ano - 1900, mes, dia);

        idPedido = theController.novoIdentificadorPedido(new Date());
        identificadorPedido = new IdentificadorPedido(idPedido);

        List<AtributoFormulario> atributosFormulario = servico.formularioSolicitacao().atributosFormulario();
        List<String> dadosFormulario;
        do {
            String string = null;
            dadosFormulario = new ArrayList<>();
            for (AtributoFormulario af : atributosFormulario) {
                System.out.println("Insira: " + af.descricaoAtributo().descricaoBreve());
                string = Console.readLine("Introduza os dados referidos:");
                while (!string.matches(af.expressaoRegular().expRegular())) {
                    string = Console.readLine("Introduza os dados referidos:");
                }
                dadosFormulario.add(string);
            }
            System.out.println(dadosFormulario);
        } while (!ValidacaoFormulario.verificarConteudo(servico.formularioSolicitacao().scriptValidacao(), dadosFormulario, atributosFormulario));

        theController.criarPedido(urgencia, dataLimiteResolucao, servico, identificadorPedido, dadosFormulario);
        System.out.println("Pedido submetido com sucesso!");

        return false;
    }

    @Override
    public String headline() {
        return "Solicitar Pedido";
    }

    private Urgencia selectTiposUrgencia() {
        System.out.println("Tipos de Urgencia Disponiveis:");
        for (final Urgencia type : Urgencia.values()) {
            System.out.println("\t" + type);
        }
        do {
            try {
                final String type = Console.readLine("Tipo de Urgencia?");
                return Urgencia.valueOf(type);
            } catch (final IllegalArgumentException e) {
                System.out.println("Por favor tente de novo. Insira um tipo de dados válido.");
            }
        } while (true);
    }
}
