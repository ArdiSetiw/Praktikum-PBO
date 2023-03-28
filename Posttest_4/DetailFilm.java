
package Posttest_4;


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
    
    public void addSucces(){
        System.out.println("\n===================================");
        System.out.println("Film "+this.nama+" Berhasil ditambah");
        System.out.println("\n===================================");
    }
    
    //Overloading
    public void showChanges(String dataSebelum,String type){
        if (type == "nama"){
            System.out.println("| Nama");
            System.out.println("| "+dataSebelum+" ====> "+this.nama);
        }else if(type == "direktor"){
            System.out.println("| Direktor");
            System.out.println("| "+dataSebelum+" ====> "+this.direktor);
        }else{
            System.out.println("| Sinopsis");
            System.out.println("Sebelum : ");
            System.out.println(dataSebelum);
            System.out.println("Sesudah :");
            System.out.println(this.sinopsis);
        }
        
    }
    
    public void showChanges(int tahunSebelum){
        System.out.println("| Tahun");
        System.out.println("| "+tahunSebelum+" ====> "+this.tahun);
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
    
    @Override
    public void addSucces(){
        System.out.println("\n===================================");
        System.out.println("| Movie "+this.nama+" Berhasil ditambah");
        System.out.println("\n===================================");
    }
    
    public void showChangesChild(int dataSebelum){
        System.out.println("| Panjang Film");
        System.out.println("| "+dataSebelum+" ====> "+this.panjangFilm);
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
    
    @Override
    public void addSucces(){
        System.out.println("\n===================================");
        System.out.println("| TVShow "+this.nama+" Berhasil ditambah");
        System.out.println("\n===================================");
    }
    
    public void showChangesChild(int dataSebelum){
        System.out.println("| Jumlah Episode");
        System.out.println("| "+dataSebelum+" ====> "+this.jumlahEpisode);
    }
    
    public int getJumlahEpisode(){
        return jumlahEpisode;
    }
    
    public void setJumlahEpisode(int jumlahEpisode){
        this.jumlahEpisode = jumlahEpisode;
    }
}
