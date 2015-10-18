package id.ac.uad.waqid.dao.impl;

import id.ac.uad.waqid.dao.MatakuliahDao;
import id.ac.uad.waqid.model.Matakuliah;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abnormal on 18/10/15.
 */
public class MatakuliahDaoImpl implements MatakuliahDao {

    private final Connection connection;

    public MatakuliahDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Matakuliah matakuliah) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Matakuliah (mata_kuliah_kode,namakuliah) VALUE (?,?)");
        preparedStatement.setInt(1, matakuliah.getKode());
        preparedStatement.setString(2, matakuliah.getNama());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(int kode, Matakuliah updatedMatakuliah) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Matakuliah SET namakuliah=? WHERE mata_kuliah_kode=?");
        preparedStatement.setString(1, updatedMatakuliah.getNama());
        preparedStatement.setInt(2, updatedMatakuliah.getKode());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int kode) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Matakuliah WHERE mata_kuliah_kode=?");
        preparedStatement.setInt(1, kode);

        preparedStatement.executeUpdate();


    }

    @Override
    public Matakuliah findBykode(int kode) {
        Matakuliah matakuliah = new Matakuliah();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT namakuliah FROM Matakuliah WHERE mata_kuliah_kode=?");
            preparedStatement.setInt(1,kode);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                matakuliah.setNama(resultSet.getString("namakuliah"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matakuliah;
    }

    @Override
    public List<Matakuliah> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT mata_kuliah_kode AS kode ,namakuliah as namakuliah FROM Matakuliah");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Matakuliah>matakuliahList = new ArrayList<>();
            while(resultSet.next()){
                Matakuliah matakul = new Matakuliah();

                matakul.setKode(resultSet.getInt("kode"));
                matakul.setNama(resultSet.getString("namakuliah"));

                matakuliahList.add(matakul);
            }
            return matakuliahList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public List<Matakuliah> findByNameLike(String name) {
        return null;
    }
}
