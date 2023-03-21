
package Posttest_3;


public class DetailFilm {
    protected String nama;
    protected int tahun;
    protected String sinopsis;
    protected String direktor;
    
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

class dataMovies extends DetailFilm {
    private int panjangFilm;
         
    public dataMovies(String Nama,int Tahun,String Direktor, String Sinopsis, int Panjang){
        super(Nama,Tahun,Direktor,Sinopsis);
        this.panjangFilm = Panjang;
    }
    
    public int getPanjangFilm(){
        return panjangFilm;
    }
    
    public void setPanjangFilm(int panjangFilm){
        this.panjangFilm = panjangFilm;
    }
}

class dataShow extends DetailFilm {
    private int jumlahEpisode;
    
    public dataShow(String Nama,int Tahun,String Direktor, String Sinopsis, int Jumlah) {
        super(Nama,Tahun,Direktor,Sinopsis);
        this.jumlahEpisode = Jumlah;
    }
    
    public int getJumlahEpisode(){
        return jumlahEpisode;
    }
    
    public void setJumlahEpisode(int jumlahEpisode){
        this.jumlahEpisode = jumlahEpisode;
    }
}