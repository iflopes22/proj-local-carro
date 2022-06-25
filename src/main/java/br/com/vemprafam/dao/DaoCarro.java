package br.com.vemprafam.dao;

import br.com.vemprafam.pojo.Carro;

public class DaoCarro {
    private Connection conn;

    public DaoCarro() {
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
    public void inserirCarro(Carro Carro) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO carro values(?,?,?,?,?,?,?)");
            pstmt.setInt(1, carro.getId());
            pstmt.setString(2, carro.getModelo());
            pstmt.setDouble(3, carro.getAno());
            pstmt.setDouble(4, carro.getCor());
            pstmt.setDouble(5, carro.getPorta());
            pstmt.setDouble(6, carro.getKm());
            pstmt.setDouble(7, carro.getLocado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Carro> getCarros() {
        List<Carro> result = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * from Carro where locado = false");
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() ) {
                result.add(new Carro(rs.getInt(1),rs.getString(2),
                        rs.getInt(3),rs.getString(4),rs.getInt(5), getInt(6), getBoolean(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }

    public Carro buscarPeloId( int id ) {
        Carro result = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * from Carro "
                            + "WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if ( rs.next() ) {
                result = new Carro(rs.getInt(1),rs.getString(2),
                        rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getBoolean(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }

    public void alterarStatus(Carro carro) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE Carro "
                            + "SET locado=?"
                            + "WHERE id=?");
            pstmt.setBoolean(1, carro.getLocado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

