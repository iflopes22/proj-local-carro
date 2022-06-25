package br.com.vemprafam.logica;

import br.com.vemprafam.dao.DaoReserva;
import br.com.vemprafam.pojo.Reserva;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogicaCriarReserva implements Logica {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String status = "Aberta";
        int carroId = Integer.parseInt(request.getParameter("carroId"));
        int locatarioId = Integer.parseInt(request.getParameter("locatarioId"));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInicioReserva= new Date();
        try {
            dataInicioReserva = format.
                    parse(request.getParameter("dataInicioReserva"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date dataFimReserva=null;
        try {
            dataFimReserva = format.
                    parse(request.getParameter("dataFimReserva"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Reserva reserva = new Reserva(id,status,carroId,locatarioId,dataInicioReserva, dataFimReserva);
        DaoReserva dao = new DaoReserva();
        dao.criarReserva(reserva);
        return "/reserva-realizada.jsp";
    }
}
