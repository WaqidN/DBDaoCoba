package id.ac.uad.waqid.model;

/**
 * Created by abnormal on 15/10/15.
 */
public class Matakul {

    private int kode;
    private String namakul;

    public Matakul() {
    }

    public Matakul(int kode, String namakul) {
        this.namakul = namakul;
        this.kode = kode;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getNamakul() {
        return namakul;
    }

    public void setNamakul(String namakul) {
        this.namakul = namakul;
    }
}
