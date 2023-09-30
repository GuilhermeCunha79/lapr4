/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExecutorTarefasAutomatico;

import MotorFluxoAtividadesDaemon.PedidoProtocolRequest;
import eapli.framework.csv.CsvRecord;

/**
 *
 * @author sandr
 */
    public abstract class BaseErrorRequest extends TarefasProtocolRequest {
    
    private final String descricaoErro;
    
    protected BaseErrorRequest(final int pedido, final String descricaoErro){
        super(null,pedido);
        this.descricaoErro= descricaoErro;
    }
    
    protected BaseErrorRequest(final int pedido){
        super(null,pedido);
        this.descricaoErro=null;
    }
    
    @Override
    public String execute(){
        return resposta();
    }
    
    
    protected String resposta(){
        final Object [] fields = { messageType(),pedido,descricaoErro};
        final boolean mask[] = {false, true,true};
        return CsvRecord.valueOf(fields, mask).toString()+'\n';
    }
    
    protected abstract String messageType();
}

