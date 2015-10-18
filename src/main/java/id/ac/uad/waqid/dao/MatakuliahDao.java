package id.ac.uad.waqid.dao;

import id.ac.uad.waqid.model.Matakuliah;
import id.ac.uad.waqid.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by abnormal on 18/10/15.
 */
public interface MatakuliahDao {

    void  insert(Matakuliah matakuliah) throws SQLException;

    void  update (int kode, Matakuliah updatedMatakuliah) throws SQLException;

    void  delete (int kode ) throws SQLException;

    Matakuliah findBykode(int kode );

    List<Matakuliah> findAll();

    List<Matakuliah>findByNameLike(String name);

}
