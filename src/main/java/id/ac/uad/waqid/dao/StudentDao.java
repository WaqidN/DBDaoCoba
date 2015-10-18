package id.ac.uad.waqid.dao;

import id.ac.uad.waqid.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by abnormal on 15/10/15.
 */
public interface StudentDao {

    void  insert(Student student) throws SQLException;

    void  update (int id, Student updatedStudent) throws SQLException;

    void  delete (int id ) throws SQLException;

    Student findById(int id );

    List<Student>findAll();

    List<Student>findByNameLike(String name);


}
