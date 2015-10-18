package id.ac.uad.waqid.model;

/**
 * Created by abnormal on 15/10/15.
 */
public class Nilai {

    private int id;
    private Matakuliah matakuliah;
    private Student student;
    private String nilai;

    public Nilai() {
    }

    public Nilai(int id, Matakuliah matakuliah, Student student, String nilai) {
        this.id = id;
        this.matakuliah = matakuliah;
        this.student = student;
        this.nilai = nilai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
}
