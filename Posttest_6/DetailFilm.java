
package Posttest_6;

interface notification{
    public void addSucces();
    public void showChanges(String dataSebelum,String type);
    public void showChanges(int dataSebelum, String type);
}

public abstract class DetailFilm {
    protected String nama;
    protected int tahun;
    protected String sinopsis;
    protected String direktor;
    
    public abstract String getNama();

    public abstract void setNama(String nama);

    public abstract int getTahun();

    public abstract void setTahun(int tahun);

    public abstract String getSinopsis();

    public abstract void setSinopsis(String sinopsis);

    public abstract String getDirektor();

    public abstract void setDirektor(String direktor);
}

final class dataMovies extends DetailFilm implements notification{
    private int panjangFilm;
         
    public dataMovies(String Nama,int Tahun,String Direktor, String Sinopsis, int Panjang){
        this.nama = Nama;
        this.tahun = Tahun;
        this.direktor = Direktor;
        this.sinopsis = Sinopsis;
        this.panjangFilm = Panjang;
    }
    
    @Override
    final public void addSucces(){
        System.out.println("\n===================================");
        System.out.println("| Movie "+this.nama+" Berhasil ditambah");
        System.out.println("\n===================================");
    }
    
    @Override
    final public void showChanges(String dataSebelum, String type){
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
    
    @Override
    final public void showChanges(int dataSebelum, String type){
        if(type == "panjang"){
            System.out.println("| Panjang Film");
            System.out.println("| "+dataSebelum+" ====> "+this.panjangFilm);
        }else{
            System.out.println("| Tahun");
            System.out.println("| "+dataSebelum+" ====> "+this.tahun);
        }
    }
    
    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public int getTahun() {
        return tahun;
    }

    @Override
    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    @Override
    public String getSinopsis() {
        return sinopsis;
    }

    @Override
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String getDirektor() {
        return direktor;
    }

    @Override
    public void setDirektor(String direktor) {
        this.direktor = direktor;
    }
    
    public int getPanjangFilm(){
        return panjangFilm;
    }
    
    public void setPanjangFilm(int panjangFilm){
        this.panjangFilm = panjangFilm;
    }
}

final class dataShow extends DetailFilm implements notification{
    private int jumlahEpisode;
    
    public dataShow(String Nama,int Tahun,String Direktor, String Sinopsis, int Jumlah) {
        this.nama = Nama;
        this.tahun = Tahun;
        this.direktor = Direktor;
        this.sinopsis = Sinopsis;
        this.jumlahEpisode = Jumlah;
    }
    
    @Override
    final public void addSucces(){
        System.out.println("\n===================================");
        System.out.println("| TVShow "+this.nama+" Berhasil ditambah");
        System.out.println("\n===================================");
    }
    
    @Override
    final public void showChanges(String dataSebelum, String type){
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
    
    @Override
    final public void showChanges(int dataSebelum, String type){
        if(type == "jumlah"){
            System.out.println("| Jumlah Episode");
            System.out.println("| "+dataSebelum+" ====> "+this.jumlahEpisode);
        }else{
            System.out.println("| Tahun");
            System.out.println("| "+dataSebelum+" ====> "+this.tahun);
        }
    }
    
    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public int getTahun() {
        return tahun;
    }

    @Override
    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    @Override
    public String getSinopsis() {
        return sinopsis;
    }

    @Override
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String getDirektor() {
        return direktor;
    }

    @Override
    public void setDirektor(String direktor) {
        this.direktor = direktor;
    }
    
    public int getJumlahEpisode(){
        return jumlahEpisode;
    }
    
    public void setJumlahEpisode(int jumlahEpisode){
        this.jumlahEpisode = jumlahEpisode;
    }
}