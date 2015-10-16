package id.ac.uad.waqid.model;

/**
 * Created by abnormal on 15/10/15.
 */
public class Nilai {

    private int id;
    private int kode;
    private  String nilai;

    public Nilai() {
    }

    public Nilai(int id, int kode, String nilai) {
        this.id = id;
        this.kode = kode;
        this.nilai = nilai;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
}
