/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MotorFluxoAtividadesDaemon;

import eapli.base.dashboard.application.DashboardController;
import eapli.base.gestaoServicosHD.domain.CatalogoServicos;
import eapli.base.gestaoServicosHD.repositories.CatalogoServicosRepository;
import eapli.base.gestaoServicosRH.domain.Tarefa;
import eapli.base.gestaoServicosHD.domain.Pedido;
import eapli.base.gestaoServicosRH.repositories.TarefaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.csv.CsvRecord;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sandr
 */
public class ConteudoDashboard extends PedidoProtocolRequest{

    private final String colaborador;
    private final TarefaRepository tarefaRepository = PersistenceContext.repositories().tarefas();
    private final CatalogoServicosRepository catalogosRepository = PersistenceContext.repositories().catalogosServicos();

    public ConteudoDashboard(final DashboardController controller, final int request, final String colaborador) {
        super(controller, request);
        this.colaborador = colaborador;
    }
    
    @Override
    public String execute() {
        try {
            System.out.println(colaborador);
            final Iterable<Tarefa> tarefas = controller.obterTarefasColaborador(colaborador);
            //System.out.println(tarefas);
            return buildResponse(tarefas);
        } catch (final Exception e) {
            return buildServerError(e.getMessage());
        }
    }
    
    private String buildResponse(final Iterable<Tarefa> tarefas) {

        final var sb = new StringBuilder();

        // header
        sb.append("\"SERVICO\", \"ID_PEDIDO\", \"URGENCIA\", \"CRITICIDADE\",\"DATA_CONCLUSAO\",\"TEMPO_RESTANTE\"");
        sb.append(";");

        // result rows
        for (final Tarefa t : tarefas) {
            
            
            Pedido p = t.pedidoTarefa();
            CatalogoServicos cs = catalogosRepository.pesquisarCatalogosPorServico(p.servicoReferenteAoPedido());
            

            Date currentDate = new Date();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String date = sdf.format(new Date());
            try {
                currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

            } catch (ParseException ex) {
            }

            int aux =  p.dataLimiteResolucaoPedido().compareTo(currentDate);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = formatter.format(p.dataLimiteResolucaoPedido());
            
            
            if (aux > 0) {
                sb.append(CsvRecord.valueOf(new Object[]{
                    p.servicoReferenteAoPedido().descricaoBreve(),//servico
                    p.identificadorPedido(),
                    p.urgenciaReferenteAoPedido(),//URGENCIA
                    cs.criticidadeCatalogo(),//CRITICIDADE
                    p.dataLimiteResolucaoPedido(),//DATA CONCLUSAO
                    calculateRemainTime(strDate) + " Restante" //TEMPO Restante
                }).toString());
            } else {
                sb.append(CsvRecord.valueOf(new Object[]{
                    p.servicoReferenteAoPedido().descricaoBreve(),//servico
                    p.identificadorPedido(),
                    p.urgenciaReferenteAoPedido(),//URGENCIA
                    cs.criticidadeCatalogo(),//CRITICIDADE
                    p.dataLimiteResolucaoPedido(),//DATA CONCLUSAO
                    calculateRemainTime(strDate) + " Atrasado" //TEMPO Restante
                }).toString());
            }
            // end of line
            sb.append(";");
        }

        // end of message
        sb.append(";");

        return sb.toString();
    }
    public static long calculateRemainTime(String scheduled_date) {
            // date format
        SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY");
        // two dates
        java.util.Date scheduledDate;
        Calendar current = Calendar.getInstance();
        java.util.Date currentDate;
        String current_date = format.format(current.getTime());
        long diffence_in_days = 0;
        try {
            scheduledDate = format.parse(scheduled_date);
            currentDate = format.parse(current_date);
            long diffInMillies = scheduledDate.getTime() - currentDate.getTime();
            diffence_in_days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            return diffence_in_days;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diffence_in_days;
    }
    
    
}
