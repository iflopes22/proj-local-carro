package br.com.vemprafam.dao;

import br.com.vemprafam.pojo.Carro;
import br.com.vemprafam.pojo.Reserva;

public class DaoReserva {

    private Connection conn;

    public DaoReserva() {
        super();
        try {
            conn = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/",
                    "SA", "");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void criarReserva(Reserva reserva) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Reserva values(?,?,?,?,?)");
            pstmt.setCarro(2, reserva.getCarro());
            pstmt.setLocatario(3, reserva.getLocatario());
            pstmt.setDate(4,
                    new java.sql.Date(reserva.getDataInicioReserva().getTime()));
            pstmt.setDate(5,
                    new java.sql.Date(reserva.getDataFimReserva().getTime()));
            pstmt.setString(6, "Aberta");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void alterarReserva(Reserva reserva) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE Reserva "
                            + "SET status=? "
                            + "WHERE id=?");
            pstmt.setString(1, reserva.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Reserva buscarPeloCarro(int id ) {
        Reserva result = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * from Reserva "
                            + "WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if ( rs.next() ) {
                result = new Reserva(rs.getInt(1),rs.getString(2),
                        rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getBoolean(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }

    public Reserva buscarPeloId( int id ) {
        Reserva result = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * from Reserva "
                            + "WHERE id = ? and status != Finalizada");
            pstmt.setInt(1, ra);
            ResultSet rs = pstmt.executeQuery();
            if ( rs.next() ) {
                result = new Aluno(rs.getInt(1),rs.getString(2),
                        rs.getDouble(3),rs.getDate(4),rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }
}
