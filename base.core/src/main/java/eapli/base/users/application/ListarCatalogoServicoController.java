/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.users.application;

import eapli.base.users.application.ListarCatalogoServicoService;
import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.domain.Keyword;
import eapli.base.gestaoServicosHD.domain.Servico;
import java.util.List;

/**
 *
 * @author sandr
 */
public class ListarCatalogoServicoController {

    private final ListarCatalogoServicoService svc = new ListarCatalogoServicoService();

    public Iterable<CatalogoServicos> catalogos() {
        return this.svc.todosCatalogos();
    }

    public Iterable<CatalogoServicos> consultar() {
        return this.svc.consultarCatalogos();
    }

    public List<Servico> pesquisar(Keyword kw) {
        return this.svc.pesquisarCatalogos(kw);
    }

}
