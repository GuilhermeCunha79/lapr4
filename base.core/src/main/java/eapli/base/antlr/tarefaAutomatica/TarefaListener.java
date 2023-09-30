package eapli.base.antlr.tarefaAutomatica;

import eapli.base.emailHandler.EmailHandler;
import eapli.base.gestaoServicosHD.domain.AtributoFormulario;
import eapli.base.gestaoServicosHD.domain.Pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TarefaListener extends  ScriptValidacaoTarefasAutomaticasBaseListener {

    private List<AtributoFormulario> atributos = new ArrayList<>();
    private Pedido pedido;
    private List<String> conteudoPedido = new ArrayList<>();
    private List<String> erros = new ArrayList<>();
    private Boolean detecaoErro = false;


    public TarefaListener(List<AtributoFormulario> atributos,Pedido pedido,List<String> conteudoPedido){
        this.atributos = atributos;
        this.conteudoPedido = conteudoPedido;
        this.pedido = pedido;
    }

    //@Override
    //public void exitStart(ScriptValidacaoTarefasAutomaticasParser.StartContext ctx){
    //}

    @Override
    public void exitEnviarEmail(ScriptValidacaoTarefasAutomaticasParser.EnviarEmailContext ctx){
        if(this.detecaoErro){
            try{
                EmailHandler emailHandler  = new EmailHandler();
                emailHandler.sendEmail(pedido.colaborador().identity().toString(),ctx.subject.getText(),"");
            }catch (IOException io){
                this.detecaoErro = true;
            }
        }
    }

}
