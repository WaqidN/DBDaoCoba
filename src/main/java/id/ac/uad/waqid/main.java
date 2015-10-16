package id.ac.uad.waqid;

import id.ac.uad.waqid.dao.MatakulDao;
import id.ac.uad.waqid.dao.NilaiDao;
import id.ac.uad.waqid.dao.StudentDao;
import id.ac.uad.waqid.dao.impl.MatakulDaoImpl;
import id.ac.uad.waqid.dao.impl.NilaiDaoImpl;
import id.ac.uad.waqid.dao.impl.StudentDaoImpl;
import id.ac.uad.waqid.db.DatabaseConnection;
import id.ac.uad.waqid.model.Matakul;
import id.ac.uad.waqid.model.Nilai;
import id.ac.uad.waqid.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by abnormal on 15/10/15.
 */
public class main {
    public static void main(String args[]){

        /*Student kipli = new Student(1, "Bayu Zuklifly");
        Student deny = new Student(2, "Deny Prasetyo");
        Student ahmad = new Student(3, "Ahmad Nugrahantora");
        Student Waqid = new Student(4, "Waqid Nugroho");
        Student Bowo = new Student(5, "Mukti Wibowo");
        Student gita = new Student(6, "Gita Reynaldi");*/

        /*Matakul logica = new Matakul(1, "Logica Informatika");
        Matakul Kalkulus = new Matakul(2, "Kalkulus 2");
        Matakul Basis = new Matakul(3, "Basis Data");
        Matakul si = new Matakul(4, " Study Islam 2");
        Matakul sa = new Matakul(5, "Strategi Algoritma");
        Matakul apbo = new Matakul(6, "Algoritma ");*/

        Nilai a = new Nilai(1, 4, "A");
        Nilai b = new Nilai(4, 2, "B");
        Nilai c = new Nilai(2, 5, "A");
        Nilai d = new Nilai(3, 4, "A");
        Nilai e = new Nilai(5, 2, "A");
        Nilai x = new Nilai(4, 3, "A");
        Nilai w = new Nilai(3, 2, "A");




        try {
            //StudentDao studentDao = new StudentDaoImpl(DatabaseConnection.getInstance().getConnection());


            /*studentDao.insert(kipli);
            studentDao.insert(deny);
            studentDao.insert(ahmad);
            studentDao.insert(Waqid);
            studentDao.insert(gita);
            studentDao.insert(Bowo);*/
            //System.out.println("Nama : " + studentDao.findById(4).getName());

            /*List<Student> studentsList = studentDao.findAll();
            for (Student s : studentsList){
                System.out.println("Id         :" + s.getId());
                System.out.println("Nama       :" + s.getName());
                System.out.println("--------------------------");
                }*/

            //studentDao.update(3,ahmad);
            //studentDao.delete(2);


            //MatakulDao matakulDao = new MatakulDaoImpl(DatabaseConnection.getInstance().getConnection());

            /*matakulDao.insert(logica);
            matakulDao.insert(Kalkulus);
            matakulDao.insert(Basis);
            matakulDao.insert(si);
            matakulDao.insert(sa);
            matakulDao.insert(apbo);*/
            //System.out.println("Name :"+ matakulDao.findBykode(3).getNamakul());

            /*List<Matakul>matakulList = matakulDao.findAll();

            for (Matakul w : matakulList){
                System.out.println(" Kode    :"+ w.getKode());
                System.out.println("Nama Kul :"+ w.getNamakul());
                System.out.println("----------------");
            }*/

            //matakulDao.update(1, logica);
            //matakulDao.delete(6);


            NilaiDao nilaiDao = new NilaiDaoImpl(DatabaseConnection.getInstance().getConnection());

            /*nilaiDao.insert(a);
            nilaiDao.insert(b);
            nilaiDao.insert(c);
            nilaiDao.insert(d);
            nilaiDao.insert(e);
            nilaiDao.insert(x);
            nilaiDao.insert(w);*/
            //System.out.println("nilai "+ nilaiDao.findById(4).getNilai());

            /*List<Nilai>nilaiList = nilaiDao.findAll();
            for (Nilai n : nilaiList){
                System.out.println("id       :"+ n. getId());
                System.out.println("kode Kul :"+ n.getKode());
                System.out.println("Nilai    :"+n.getNilai());
                System.out.println("-----------------------");
            }*/

            //nilaiDao.update(b);
            nilaiDao.delete(5);








        } catch (SQLException z) {
            z.printStackTrace();
            z.getMessage();
        }


    }
}
