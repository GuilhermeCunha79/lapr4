/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.catalogos;

import eapli.base.app.backoffice.console.presentation.servicos.ServicoPrinter;
import eapli.base.users.application.ListarCatalogoServicoController;
import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.IdentificadorCatalogo;
import eapli.base.gestaoServicosHD.domain.Keyword;
import eapli.base.gestaoServicosHD.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.visitor.Visitor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sandr
 */
public class ListarCatalogoServicosUI extends AbstractUI {

    private ListarCatalogoServicoController theController = new ListarCatalogoServicoController();

    @Override
    protected boolean doShow() {
        int optionOne = 1;
        int optionTwo = 1;
        List<Servico> listaServicosDisponiveis = new ArrayList<>();
        ServicoPrinter sp= new ServicoPrinter();

        Iterable<CatalogoServicos> catalogos;
        System.out.println("Pretende Consultar(1) ou Pesquisar(2) os nossos catálogos");
        optionOne = Console.readInteger("1 = Consulta || 2 = Pesquisa (Não implementado) || 0 = Exit");
        if (optionOne == 1) {
            catalogos = theController.consultar();
            for (CatalogoServicos cs : catalogos) {
                System.out.println(cs.toString());
            }

            System.out.println("Pretende consultar os serviços de algum catálogo?");
            optionTwo = Console.readInteger("1 = Sim || 2 = Não");
            if (optionTwo == 1) {
                System.out.println("Introduza o identificador do catálogo?");
                String sIdCat = Console.readLine("Idenficador:");
                IdentificadorCatalogo idCat = new IdentificadorCatalogo(sIdCat);

                catalogos = theController.consultar();
                for (CatalogoServicos cs : catalogos) {
                    if (cs.identificadorCatalogo().equals(idCat)) {
                        listaServicosDisponiveis = cs.listaServicosDisponiveis();
                        for (Servico s : listaServicosDisponiveis) {
                            if (s.isDraft() == true) {
                                System.out.println("Brevemente Disponivel");
                            } else {
                                sp.visit(s);
                            }
                        }
                        return false;
                    }
                }
                System.out.println("Não existe nenhum catalogo com este identificador");
                return false;
            }

        } else if (optionOne == 2) {
            System.out.println("Para pesquisar um serviço, insira uma KeyWord.");
            String skw = Console.readLine("Idenficador:");
            Keyword kw = new Keyword(skw);

            System.out.println("Eis a lista de todos os serviços que contem a keyword introduzida:");
            List<Servico> listaServicosComKeyword = theController.pesquisar(kw);
            for (Servico sv : listaServicosComKeyword) {
                if (sv.isDraft() == true) {
                    System.out.println("Brevemente Disponivel");
                } else {
                    System.out.println(sv.toString());
                }
            }
        }
        return false;

    }

    @Override
    public String headline() {
        return "Listar Catalogos e Servicos";
    }
}
