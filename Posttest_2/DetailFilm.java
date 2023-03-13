
package Posttest_2;

import Posttest_1.*;

public class DetailFilm {
    private String nama;
    private int tahun;
    private String sinopsis;
    private String direktor;
    
    public DetailFilm(String Nama,int Tahun,String Direktor, String Sinopsis){
        this.nama = Nama;
        this.tahun = Tahun;
        this.direktor = Direktor;
        this.sinopsis = Sinopsis;
    }
    
    void addSucc(){
        System.out.println("===================================");
        System.out.println("| Film "+this.getNama()+" Berhasil Ditambah");
        System.out.println("===================================");
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirektor() {
        return direktor;
    }

    public void setDirektor(String direktor) {
        this.direktor = direktor;
    }
}
