/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosHD.domain;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sandr
 */
public class PedidoTest {

    @Test(expected = IllegalArgumentException.class)
    public void assegurarDataResolucaoPosteriorDataSolicitacao() {
        Servico servico = new Servico(new CodigoServico("S1"), new DescricaoBreve("descB1"), new DescricaoCompleta("descCS1"), true);
        Pedido pedido = new Pedido(Urgencia.MODERADA, new Date(2020 / 06 / 12), servico, new IdentificadorPedido("2021/00035"),null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarFormatoIdentificadorPedido() {
        Servico servico = new Servico(new CodigoServico("S1"), new DescricaoBreve("descB1"), new DescricaoCompleta("descCS1"), true);
        Pedido pedido = new Pedido(Urgencia.MODERADA, new Date(2023 / 06 / 12), servico, new IdentificadorPedido("09"),null,null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void assegurarFormatoIdentificadorPedido2() {
        Servico servico = new Servico(new CodigoServico("S1"), new DescricaoBreve("descB1"), new DescricaoCompleta("descCS1"), true);
        Pedido pedido = new Pedido(Urgencia.MODERADA, new Date(2023 / 06 / 12), servico, new IdentificadorPedido("2020/9"),null,null);
    }
     @Test(expected = IllegalArgumentException.class)
    public void assegurarFormatoIdentificadorPedido3() {
        Servico servico = new Servico(new CodigoServico("S1"), new DescricaoBreve("descB1"), new DescricaoCompleta("descCS1"), true);
        Pedido pedido = new Pedido(Urgencia.MODERADA, new Date(2023 / 06 / 12), servico, new IdentificadorPedido("0/92356"),null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarUrgenciaNotNull() {
        Servico servico = new Servico(new CodigoServico("S1"), new DescricaoBreve("descB1"), new DescricaoCompleta("descCS1"), true);
        Pedido pedido = new Pedido(null, new Date(2022 / 06 / 12), servico, new IdentificadorPedido("2021/00035"),null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarDataLimiteNotNull() {
        Servico servico = new Servico(new CodigoServico("S1"), new DescricaoBreve("descB1"), new DescricaoCompleta("descCS1"), true);
        Pedido pedido = new Pedido(Urgencia.MODERADA, null, servico, new IdentificadorPedido("2021/00035"),null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarServicoNotNull() {
        Pedido pedido = new Pedido(Urgencia.MODERADA,new Date(2022 / 06 / 12), null, new IdentificadorPedido("2021/00035"),null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assegurarIdentificadorPedidoNotNull() {
        Servico servico = new Servico(new CodigoServico("S1"), new DescricaoBreve("descB1"), new DescricaoCompleta("descCS1"), true);
        Pedido pedido = new Pedido(Urgencia.MODERADA, new Date(2022 / 06 / 12), servico, null,null,null);
    }

}
