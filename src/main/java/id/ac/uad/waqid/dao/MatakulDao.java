package id.ac.uad.waqid.dao;

import id.ac.uad.waqid.model.Matakul;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by abnormal on 15/10/15.
 */
public interface MatakulDao {

    void insert(Matakul matakul) throws SQLException;

    void update(int kode, Matakul updatedMatakul) throws SQLException;

    void delete(int kode) throws SQLException;

    Matakul findBykode(int kode);

    List<Matakul> findAll() throws SQLException;

    List<Matakul> findByNameLike(String name);


}
