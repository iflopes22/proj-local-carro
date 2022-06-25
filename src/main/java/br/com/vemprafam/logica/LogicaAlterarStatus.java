package br.com.vemprafam.logica;

import br.com.vemprafam.dao.DaoCarro;
import br.com.vemprafam.dao.DaoReserva;
import br.com.vemprafam.pojo.Carro;
import br.com.vemprafam.pojo.Reserva;

public class LogicaAlterarStatus {
    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        DaoReserva daoRes = new DaoReserva();
        DaoCarro dao = new DaoCarro();
        Carro carro = dao.buscarPeloId(id);
        Reserva reserva = daoRes.buscarPeloCarro(id);
        date hoje = new Date();

        if (reserva.getDataInicioReserva().after(hoje)) {
            reserva.setStatus("Reservada");
        }

        if (reserva.getDataInicioReserva().after(hoje) && hoje.before(reserva.getDataFimReserva())) {
            reserva.setStatus("ativa");
        }

        if(hoje.after(reserva.getDataFimReserva())) {
            reserva.setStatus("Finalizada");
        }

        if(reserva.getStatus() == "Aberta" || reserva.getStatus()  == "ativa"){
            carro.setLocado(true);
        } else {
            carro.setLocado(false);
        }
        dao.alterarStatus(carro);
        daoRes.alterarReserva(reserva);
        request.setAttribute("carro", carro);
        return "/Alteracao.jsp";
    }
}
