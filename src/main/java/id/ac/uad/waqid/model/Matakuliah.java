package id.ac.uad.waqid.model;

/**
 * Created by abnormal on 18/10/15.
 */
public class Matakuliah {

    private int kode;
    private String nama;

    public Matakuliah() {
    }

    public Matakuliah(int kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
