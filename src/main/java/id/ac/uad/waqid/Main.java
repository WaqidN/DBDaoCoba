package id.ac.uad.waqid;

import id.ac.uad.waqid.dao.NilaiDao;
import id.ac.uad.waqid.dao.impl.NilaiDaoImpl;
import id.ac.uad.waqid.db.DatabaseConnection;
import id.ac.uad.waqid.model.Matakuliah;
import id.ac.uad.waqid.model.Nilai;
import id.ac.uad.waqid.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by abnormal on 15/10/15.
 */
public class Main {
    public static void main(String args[]){

        Student kipli = new Student(1, "Bayu Zuklifly");
        Student deny = new Student(2, "Deny Prasetyo");
        Student ahmad = new Student(3, "Ahmad Nugrahantoro");
        Student Waqid = new Student(4, "Waqid Nugroho");
        Student Bowo = new Student(5, "Mukti Wibowo");
        Student gita = new Student(6, "Gita Reynaldi");
        Student jamal = new Student(7, "Jamalludin");

        Matakuliah logica = new Matakuliah(103, "Logika Informatika");
        Matakuliah Kalkulus = new Matakuliah(104, "Kalkulus 2");
        Matakuliah Basis = new Matakuliah(105, "Basis Data");
        Matakuliah si = new Matakuliah(106, " Study Islam 2");
        Matakuliah sa = new Matakuliah(107, "Strategi Algoritma");
        Matakuliah apbo = new Matakuliah(108, "Algoritma ");

       /*Nilai a = new Nilai(1, 104, "A");
        Nilai b = new Nilai(4, 102, "B");
        Nilai c = new Nilai(2, 105, "A");
        Nilai d = new Nilai(3, 104, "A");
        Nilai e = new Nilai(5, 102, "A");
        Nilai x = new Nilai(4, 103, "A");
        Nilai w = new Nilai(3, 102, "A");*/




        try {
            //StudentDao studentDao = new StudentDaoImpl(DatabaseConnection.getInstance().getConnection());


            /*studentDao.insert(kipli);
            studentDao.insert(deny);
            studentDao.insert(ahmad);
            studentDao.insert(Waqid);
            studentDao.insert(gita);
            studentDao.insert(Bowo);
            studentDao.insert(jamal);*/
            //System.out.println("Nama : " + studentDao.findById(4).getName());

            /*List<Student> studentsList = studentDao.findAll();
            for (Student s : studentsList){
                System.out.println("Id         :" + s.getId());
                System.out.println("Nama       :" + s.getName());
                System.out.println("--------------------------");
                }*/

            //studentDao.update(3,ahmad);
            //studentDao.delete(2);


            //MatakuliahDao matakuliahDao = new MatakuliahDaoImpl(DatabaseConnection.getInstance().getConnection());

            /*matakuliahDao.insert(logica);
            matakuliahDao.insert(Kalkulus);
            matakuliahDao.insert(Basis);
            matakuliahDao.insert(si);
            matakuliahDao.insert(sa);
            matakuliahDao.insert(apbo);*/
            //System.out.println("namakuliah :"+ matakuliahDao.findBykode(103).getNama());

            /*List<Matakuliah> matakulList = matakuliahDao.findAll();
            for (Matakuliah w : matakulList){
                System.out.println(" Kode    :"+ w.getKode());
                System.out.println("Nama Kul :"+ w.getNama());
                System.out.println("----------------------");
            }*/


            //matakuliahDao.update(3,logica);
            //matakuliahDao.delete(103);


            NilaiDao nilaiDao = new NilaiDaoImpl(DatabaseConnection.getInstance().getConnection());

            /*nilaiDao.insert(a);
            nilaiDao.insert(b);
            nilaiDao.insert(c);
            nilaiDao.insert(d);
            nilaiDao.insert(e);
            nilaiDao.insert(x);
            nilaiDao.insert(w);*/
            System.out.println("nim     : "+ nilaiDao.findById(4).getStudent().getId());
            System.out.println("kodekul : "+ nilaiDao.findById(4).getMatakuliah().getKode());
            System.out.println("nilai   : "+ nilaiDao.findById(4).getNilai());


            /*List<Nilai> nilaiList = nilaiDao.findAll();
            for (Nilai n : nilaiList){
                System.out.println("Id               :"+ n. getId());
                System.out.println("kodekul          :"+ n.getMatakuliah().getKode());
                System.out.println("makul            :"+ n.getMatakuliah().getNama());
                System.out.println("nim              :"+ n.getStudent().getId());
                System.out.println("name             :"+ n.getStudent().getName());
                System.out.println("Nilai            :"+n.getNilai());
                System.out.println("-------------------------------------------------");
            }*/

           // nilaiDao.update(b);
           //nilaiDao.delete(1);


        } catch (SQLException z) {
            z.printStackTrace();
            z.getMessage();
        }


    }
}
