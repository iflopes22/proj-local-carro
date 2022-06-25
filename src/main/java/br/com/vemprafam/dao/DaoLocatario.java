package br.com.vemprafam.dao;

import br.com.vemprafam.pojo.Locatario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoLocatario {

    private Connection conn;

    public DaoLocatario() {
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

    public Locatario buscarPeloId( int cpf ) {
        Locatario result = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * from Locatario "
                            + "WHERE id = ?");
            pstmt.setInt(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            if ( rs.next() ) {
                result = new Locatario(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getDate(4),rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }
    public void inserirLocatario(Locatario locatario) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO locatario values(?,?,?,?,?)");
            pstmt.setInt(1, locatario.getCpf());
            pstmt.setString(2, locatario.getEmail());
            pstmt.setString(3, locatario.getNome());
            pstmt.setString(4, locatario.getTelefone());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

