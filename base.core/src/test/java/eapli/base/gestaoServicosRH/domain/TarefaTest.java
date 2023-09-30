/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoServicosRH.domain;

import eapli.base.gestaoServicosHD.domain.*;
import org.junit.Test;

import java.util.Date;


public class TarefaTest {

    @Test(expected = NullPointerException.class)
    public void assegurarPedidoNotEmpty() {
        Tarefa tarefa = new Tarefa(null,null,null);
    }

}