package id.ac.uad.waqid.dao;

import id.ac.uad.waqid.model.Nilai;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by abnormal on 15/10/15.
 */
public interface NilaiDao {

    void insert(Nilai nilai) throws SQLException;

    void update(Nilai updatedNilai) throws SQLException;

    void delete(int id) throws SQLException;

    Nilai findById(int id);

    List<Nilai> findAll();

    List<Nilai> findByNameLike(String name);

}
