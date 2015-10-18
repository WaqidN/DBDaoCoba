package id.ac.uad.waqid.dao.impl;

import id.ac.uad.waqid.dao.NilaiDao;
import id.ac.uad.waqid.model.Matakuliah;
import id.ac.uad.waqid.model.Nilai;
import id.ac.uad.waqid.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abnormal on 18/10/15.
 */
public class NilaiDaoImpl implements NilaiDao {

    private final Connection connection;

    public NilaiDaoImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void insert(Nilai nilai) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Nilai (nilai) VALUES (?,?,?)");
        //preparedStatement.setInt(1, nilai.getId());
        preparedStatement.setInt(1,nilai.getStudent().getId());
        preparedStatement.setInt(2,nilai.getMatakuliah().getKode());
        preparedStatement.setString(3, nilai.getNilai());

        preparedStatement.addBatch();

        preparedStatement.executeUpdate();

    }

    @Override
    public void update(Nilai updatedNilai) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Nilai SET mata_kuliah_kode=?, nilai=? WHERE id= ?");
        preparedStatement.setInt(1, updatedNilai.getId());
        preparedStatement.setInt(2, updatedNilai.getMatakuliah().getKode());
        preparedStatement.setString(3, updatedNilai.getNilai());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE  FROM Nilai WHERE id=?");
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

    }

    @Override
    public Nilai findById(int id) {
        Nilai nilai = new Nilai();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT nilai,mata_kuliah_kode AS kodekul ,student_id AS nim FROM Nilai WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                Matakuliah mk = new Matakuliah();
                mk.setKode(resultSet.getInt("kodekul"));

                Student s = new Student();
                s.setId(resultSet.getInt("nim"));

                nilai.setNilai(resultSet.getString("nilai"));
                nilai.setStudent(s);
                nilai.setMatakuliah(mk);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nilai;
    }

    @Override
    public List<Nilai> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "SELECT n.id,n.nilai,s.student_id as nim, s.student_name as name, " +
                    "   mk.namakuliah as makul, mk.mata_kuliah_kode AS kodekul FROM Nilai n\n" +
                    "  INNER JOIN Matakuliah mk ON mk.mata_kuliah_kode = n.mata_kuliah_kode\n" +
                    "  INNER JOIN Student s ON s.student_id = n.student_id");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Nilai>nilaiList = new ArrayList<>();
            while (resultSet.next()){
                Student s = new Student();
                Matakuliah mk = new Matakuliah();
                s.setId(resultSet.getInt("nim"));
                s.setName(resultSet.getString("name"));
                mk.setKode(resultSet.getInt("kodekul"));
                mk.setNama(resultSet.getString("makul"));
                Nilai nilai = new Nilai();
                nilai.setStudent(s);
                nilai.setMatakuliah(mk);
                nilai.setId(resultSet.getInt("id"));
                nilai.setNilai(resultSet.getString("nilai"));

                nilaiList.add(nilai);
            }
            return nilaiList;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();


        }
    }

    @Override
    public List<Nilai> findByNameLike(String name) {
        return null;
    }
}
