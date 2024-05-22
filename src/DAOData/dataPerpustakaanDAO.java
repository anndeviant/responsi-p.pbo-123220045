/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOData;

import Connection.Connector;
import DAOImplement.dataPerpustakaanImplement;
import Model.dataPerpustakaan;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.dataPerpustakaan;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author L E N O V O
 */
public class dataPerpustakaanDAO implements dataPerpustakaanImplement {

    Connection connection;
    final String select = "SELECT * FROM buku";
    final String insert = "INSERT INTO `buku` (`judul`, `penulis`, `rating`, `harga`) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE buku SET judul = ?, penulis = ?, rating = ?, harga = ? WHERE judul = ?;";
    final String delete = "DELETE FROM buku WHERE judul = ?;";

    public dataPerpustakaanDAO() {
        connection = Connector.connection();
    }

    @Override
    public void insert(dataPerpustakaan listData) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, listData.getJudul());
            statement.setString(2, listData.getPenulis());
            statement.setFloat(3, listData.getRating());
            statement.setFloat(4, listData.getHarga());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(dataPerpustakaan listData) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, listData.getJudul());
            statement.setString(2, listData.getPenulis());
            statement.setFloat(3, listData.getRating());
            statement.setFloat(4, listData.getHarga());
            statement.setString(5, listData.getJudul());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<dataPerpustakaan> getAll() {
        List<dataPerpustakaan> listData = null;
        try {
            listData = new ArrayList<dataPerpustakaan>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                dataPerpustakaan perpus = new dataPerpustakaan();
                perpus.setJudul(resultSet.getString("judul"));
                perpus.setPenulis(resultSet.getString("penulis"));
                perpus.setRating(resultSet.getFloat("rating"));
                perpus.setHarga(resultSet.getFloat("harga"));
                listData.add(perpus);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(dataPerpustakaanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listData;
    }

}
