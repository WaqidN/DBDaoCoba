package id.ac.uad.waqid.dao.impl;

import id.ac.uad.waqid.dao.NilaiDao;
import id.ac.uad.waqid.model.Nilai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abnormal on 15/10/15.
 */
public class NilaiDaoImpl implements NilaiDao{

    private Connection connection;

    public NilaiDaoImpl(Connection connection) {
        this.connection = connection;

    }

    @Override
    public void insert(Nilai nilai) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(" INSERT INTO Nilai (id,kode,nilai) VALUE (?,?,?)");
        preparedStatement.setInt(1, nilai.getId());
        preparedStatement.setInt(2, nilai.getKode());
        preparedStatement.setString(3, nilai.getNilai());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Nilai updatedNilai) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Nilai SET kode=?, nilai=? WHERE id= ?");
        preparedStatement.setInt(1, updatedNilai.getId());
        preparedStatement.setInt(2, updatedNilai.getKode());
        preparedStatement.setString(3, updatedNilai.getNilai());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE  FROM  Nilai WHERE id=?");
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

    }

    @Override
    public Nilai findById(int id) {
        Nilai nilai = new Nilai();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT nilai FROM Nilai WHERE id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                nilai.setNilai(resultSet.getString("nilai"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nilai;
    }

    @Override
    public List<Nilai> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,kode,nilai FROM Nilai");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Nilai>nilaiList = new ArrayList<>();
            while (resultSet.next()){
                Nilai nilai = new Nilai();

                nilai.setId(resultSet.getInt("id"));
                nilai.setKode(resultSet.getInt("kode"));
                nilai.setNilai(resultSet.getString("nilai"));

                nilaiList.add(nilai);
            }
            return  nilaiList;

        } catch (SQLException e) {
            e.printStackTrace();
            return  new ArrayList<>();
        }

    }

    @Override
    public List<Nilai> findByNameLike(String name) {
        return null;
    }
}
