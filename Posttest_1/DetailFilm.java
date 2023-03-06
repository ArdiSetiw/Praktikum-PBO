
package Posttest_1;

public class DetailFilm {
    String nama;
    int tahun;
    String sinopsis;
    String direktor;
    
    public DetailFilm(String Nama,int Tahun,String Direktor, String Sinopsis){
        this.nama = Nama;
        this.tahun = Tahun;
        this.direktor = Direktor;
        this.sinopsis = Sinopsis;
    }
    
    void addSucc(){
        System.out.println("===================================");
        System.out.println("| Film "+this.nama+" Berhasil Ditambah");
        System.out.println("===================================");
    }
    
    void updateSucc(){
        System.out.println("===================================");
        System.out.println("| Film Berhasil Diupdate");
        System.out.println("===================================");
    }
}
