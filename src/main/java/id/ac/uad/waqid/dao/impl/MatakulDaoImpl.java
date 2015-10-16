package id.ac.uad.waqid.dao.impl;

import id.ac.uad.waqid.dao.MatakulDao;
import id.ac.uad.waqid.model.Matakul;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abnormal on 15/10/15.
 */
public class MatakulDaoImpl implements MatakulDao {

    private final Connection connection;

    public MatakulDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Matakul matakul) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Matakul (kode,namakul) VALUE (?,?)");
        preparedStatement.setInt(1, matakul.getKode());
        preparedStatement.setString(2, matakul.getNamakul());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(int kode, Matakul updatedMatakul) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Matakul SET namakul=? WHERE kode=?");
        preparedStatement.setString(1, updatedMatakul.getNamakul());
        preparedStatement.setInt(2, updatedMatakul.getKode());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int kode) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Matakul WHERE kode=?");
        preparedStatement.setInt(1, kode);

        preparedStatement.executeUpdate();

    }

    @Override
    public Matakul findBykode(int kode) {
        Matakul matakul = new Matakul();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT namakul FROM Matakul WHERE kode=?");
            preparedStatement.setInt(1,kode);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                matakul.setNamakul(resultSet.getString("namakul"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matakul;
    }

    @Override
    public List<Matakul> findAll(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT kode,namakul FROM Matakul");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Matakul>matakulList = new ArrayList<>();
            while(resultSet.next()){
                Matakul matakul = new Matakul();

                matakul.setKode(resultSet.getInt("kode"));
                matakul.setNamakul(resultSet.getString("namakul"));

                matakulList.add(matakul);
            }
            return matakulList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Matakul> findByNameLike(String name) {
        return null;
    }
}
