package id.ac.uad.waqid.dao.impl;

import id.ac.uad.waqid.dao.StudentDao;
import id.ac.uad.waqid.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abnormal on 15/10/15.
 */
public class StudentDaoImpl implements StudentDao{

    private  final  Connection connection;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Student student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Student (student_id,student_name) VALUE (?,?) ");
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getName());
        preparedStatement.executeUpdate();

    }

    @Override
    public void update(int id, Student updatedStudent) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Student SET student_name=? WHERE student_id =?");
        preparedStatement.setString(1, updatedStudent.getName());
        preparedStatement.setInt(2, updatedStudent.getId());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Student WHERE student_id = ?");
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

    }

    @Override
    public Student findById(int id) {

        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT student_name AS name FROM Student WHERE  student_id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                student.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT student_id AS id, student_name AS  name FROM Student");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student>studentList = new ArrayList<>();
            while (resultSet.next()){
                Student student= new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));

                studentList.add(student);
            }

            return  studentList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    @Override
    public List<Student> findByNameLike(String name) {
        return null;
    }
}
