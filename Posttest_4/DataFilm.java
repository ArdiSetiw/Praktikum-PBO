
package Posttest_4;

import java.util.*;

import java.io.*;

public class DataFilm{
    ArrayList<dataMovies> arrMovie = new ArrayList<>();
    ArrayList<dataShow> arrShow = new ArrayList<>();
    
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    void clr() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    
    void inputData()throws IOException, InterruptedException{
        try {
            clr();
            System.out.println("===================================");
            System.out.println("         Menambahkan Data");
            System.out.println("===================================");
            System.out.println("| Pilih Tipe Film");
            System.out.println("| 1. Movie");
            System.out.println("| 2. TV Show");
            System.out.print("| Masukkan Pilihan : ");
            int pilihan = Integer.parseInt(br.readLine());
            if(pilihan == 1 || pilihan == 2){
                clr();
                System.out.println("===================================");
                System.out.println("         Menambahkan Data");
                System.out.println("===================================");

                System.out.print("| Nama Film : ");
                String namaFilm = br.readLine();
                System.out.print("| Tahun Film : ");
                int tahunFilm = Integer.parseInt(br.readLine());
                System.out.print("| Direktor Film : ");
                String direktor = br.readLine();
                
                if(pilihan == 1){
                    System.out.print("| Panjang Film(Menit) : ");
                    int panjang = Integer.parseInt(br.readLine());
                    System.out.println("| Sinopsis Film : ");
                    String sinopsis = br.readLine();

                    dataMovies movie = new dataMovies(namaFilm,tahunFilm,
                                    direktor,sinopsis,panjang);
                    
                    arrMovie.add(movie);
                    movie.addSucces();
                }else{
                    System.out.print("| Jumlah Episode : ");
                    int episode = Integer.parseInt(br.readLine());
                    System.out.println("| Sinopsis Film : ");
                    String sinopsis = br.readLine();

                    dataShow show = new dataShow(namaFilm,tahunFilm,
                                    direktor,sinopsis,episode);
                    
                    arrShow.add(show);
                    show.addSucces();
                }
            }else {
                System.out.println("\n===================================");
                System.out.println("| Telah Terjadi Error");
                System.out.println("===================================");
            }
            
            
            
        } catch (NumberFormatException exc1) {
            System.out.println("\n===================================");
            System.out.println("| Telah Terjadi Error");
            System.out.println("===================================");
        }
        

        System.out.println("| Klik Enter Untuk Lanjut");
        br.readLine();
    }
    
    void detailMovie(int index){
        System.out.println("| Nama              : "+arrMovie.get(index).getNama());
        System.out.println("| Tahun             : "+arrMovie.get(index).getTahun());
        System.out.println("| Direktor          : "+arrMovie.get(index).getDirektor());
        System.out.println("| Panjang Movie     : "+arrMovie.get(index).getPanjangFilm());
        System.out.println("| Sinopsis Movie    : ");
        System.out.println("| "+arrMovie.get(index).getSinopsis()+"\n");
    }
    void detailShow(int index){
        System.out.println("| Nama              : "+arrShow.get(index).getNama());
        System.out.println("| Tahun             : "+arrShow.get(index).getTahun());
        System.out.println("| Direktor          : "+arrShow.get(index).getDirektor());
        System.out.println("| Jumlah Episode    : "+arrShow.get(index).getJumlahEpisode());
        System.out.println("| Sinopsis      : ");
        System.out.println("| "+arrShow.get(index).getSinopsis()+"\n");
    }

    void listData(String type){
        if (type == "All"){
            if(arrMovie.isEmpty()&&arrShow.isEmpty()){
                System.out.println("| List Kosong");
            }else if(!(arrMovie.isEmpty()&&arrShow.isEmpty())){
                int no = 0;
                for (int i = 0; i < arrMovie.size();i++){
                    no = i+1;
                    System.out.println(no+". "+arrMovie.get(i).getNama()+" ("+
                            arrMovie.get(i).getTahun()+")");
                }
                for (int i = 0; i < arrShow.size();i++){
                    no = no + 1;
                    System.out.println(no+". "+arrShow.get(i).getNama()+" ("+
                            arrShow.get(i).getTahun()+")");
                }
            }else if(arrShow.isEmpty()){
                for (int i = 0; i < arrMovie.size();i++){
                    int no = i+1;
                    System.out.println(no+". "+arrMovie.get(i).getNama()+" ("+
                            arrMovie.get(i).getTahun()+")");
                }
            }else if(arrMovie.isEmpty()){
                for (int i = 0; i < arrShow.size();i++){
                    int no = i+1;
                    System.out.println(no+". "+arrShow.get(i).getNama()+" ("+
                            arrShow.get(i).getTahun()+")");
                }
            }
        }else if (type == "Movie"){
            if(arrMovie.isEmpty()){
                System.out.println("| List Kosong");
            }else{
                for (int i = 0; i < arrMovie.size();i++){
                    int no = i+1;
                    System.out.println(no+". "+arrMovie.get(i).getNama()+" ("+
                            arrMovie.get(i).getTahun()+")");
                }
            }
        }else{
            if(arrShow.isEmpty()){
                System.out.println("| List Kosong");
            }else{
                for (int i = 0; i < arrShow.size();i++){
                    int no = i+1;
                    System.out.println(no+". "+arrShow.get(i).getNama()+" ("+
                            arrShow.get(i).getTahun()+")");
                }
            }
        }
    }
    
    void lihatData() throws InterruptedException, IOException{
        clr();
        System.out.println("===================================");
        System.out.println("            Lihat Data");
        System.out.println("===================================");
        System.out.println("| 1. Lihat List Semua Film");
        System.out.println("| 2. Lihat List Movie");
        System.out.println("| 3. Lihat List TV Show");
        System.out.println("===================================");

        System.out.print("| Masukan Pilihan : ");
        String input = br.readLine();
        try{
        switch(input){
            case "1" ->{
                    clr();
                    System.out.println("===================================");
                    System.out.println("            List Film");
                    System.out.println("===================================");
                    listData("All");
                    System.out.println("===================================");
                    System.out.println("| Ketik 0 untuk kembali");
                    System.out.print("| Masukan Nomor Film Untuk Detail: ");
                    int idx = Integer.parseInt(br.readLine());

                    if(idx == 0){
                        break;
                    }

                    if(idx-1 < arrMovie.size()){
                        clr();
                        System.out.println("===================================");
                        System.out.println("  Detail Film "+arrMovie.get(idx-1).getNama());
                        System.out.println("===================================");
                        detailMovie(idx-1);
                    }else{
                        clr();
                        System.out.println("===================================");
                        System.out.println("  Detail Film "+arrShow.get(idx-arrMovie.size()-1).getNama());
                        System.out.println("===================================");
                        detailShow(idx-arrMovie.size()-1);
                    }

                    
            }case "2" ->{
                    clr();
                    System.out.println("===================================");
                    System.out.println("            List Movie");
                    System.out.println("===================================");
                    listData("Movie");
                    System.out.println("===================================");
                    System.out.println("| Ketik 0 untuk kembali");
                    System.out.print("| Masukan Nomor Film Untuk Detail: ");
                    int idx = Integer.parseInt(br.readLine());

                    if(idx == 0){
                        break;
                    }

                    clr();
                    System.out.println("===================================");
                    System.out.println("  Detail Movie "+arrMovie.get(idx-1).getNama());
                    System.out.println("===================================");
                    detailMovie(idx-1);
            }case "3"->{
                    clr();
                    System.out.println("===================================");
                    System.out.println("            List Tv Show");
                    System.out.println("===================================");
                    listData("Show");
                    System.out.println("===================================");
                    System.out.println("| Ketik 0 untuk kembali");
                    System.out.print("| Masukan Nomor Film Untuk Detail: ");
                    int idx = Integer.parseInt(br.readLine());

                    if(idx == 0){
                        break;
                    }

                    clr();
                    System.out.println("===================================");
                    System.out.println("  Detail Tv Show "+arrShow.get(idx-1).getNama());
                    System.out.println("===================================");
                    detailShow(idx-1);
            }
            default ->{
                System.out.println("Masukan salah");
                System.out.println("Klik Enter Untuk Lanjut");
                br.readLine();
            }
            }
        }catch(NumberFormatException  exc1){
                    System.out.println("\n===================================");
                    System.out.println("| Telah Terjadi Error");
                    System.out.println("===================================");
        }catch(IndexOutOfBoundsException exc2){
            System.out.println("===================================");
            System.out.println("| Nomor Film Tidak Terdapat Pada List");
            System.out.println("===================================");
        }
        System.out.println("===================================");
        System.out.println("| Klik Enter Untuk Lanjut");
        br.readLine();
    }
    
    void detailChangesMovie(String nama, int tahun, String direktor, String sinopsis, int panjangOrEpisode, int index){
        System.out.println("===================================");
        System.out.println(" Konfirmasi Update Data "+nama);
        System.out.println("===================================");
        arrMovie.get(index).showChanges(nama, "nama");
        arrMovie.get(index).showChanges(tahun);
        arrMovie.get(index).showChanges(direktor, "direktor");
        arrMovie.get(index).showChangesChild(panjangOrEpisode);
        arrMovie.get(index).showChanges(sinopsis, "sinopsis");
    }

    void detailChangesShow(String nama, int tahun, String direktor, String sinopsis, int panjangOrEpisode, int index){
        System.out.println("===================================");
        System.out.println(" Konfirmasi Update Data "+nama);
        System.out.println("===================================");
        arrShow.get(index).showChanges(nama, "nama");
        arrShow.get(index).showChanges(tahun);
        arrShow.get(index).showChanges(direktor, "direktor");
        arrShow.get(index).showChangesChild(panjangOrEpisode);
        arrShow.get(index).showChanges(sinopsis, "sinopsis");
    }
    
    boolean confirmUpdate(String nama, int tahun, String direktor, String sinopsis, int panjangOrEpisode, int index, String type) throws IOException, InterruptedException{
        clr();
        if(type == "Movie"){
            detailChangesMovie(nama,tahun,direktor,sinopsis,panjangOrEpisode,index);
        }else{
            detailChangesShow(nama,tahun,direktor,sinopsis,panjangOrEpisode,index);
        }

        System.out.println("===================================");
        System.out.println("| Konfirmasi Update");
        System.out.println("| 1. Ya");
        System.out.println("| 2. Tidak");
        System.out.println("===================================");
        System.out.println("Masukan Pilihan : ");String pilihan = br.readLine();
        switch(pilihan){
            case "1"->{
                return true;
            }
            case "2"->{
                return false;
            }default->{
                clr();
                System.out.println("Inputan Salah");
                System.out.println("===================================");
                System.out.println("| Klik Enter Untuk Lanjut");
                br.readLine();
                return false;
            }
        }
    }
    
    void updateData() throws  IOException, InterruptedException{
        try {
            clr();
            System.out.println("===================================");
            System.out.println("            Update Data");
            System.out.println("===================================");
            listData("All");
            
            System.out.println("===================================");
            System.out.print("| Nomor Film Yang Ingin diupdate : ");
            int idx = Integer.parseInt(br.readLine());
            try{
                clr();
                System.out.println("===================================");
                System.out.println("            Update Data");
                System.out.println("===================================");

                System.out.println("\n===================================");
                System.out.println("| Detail Film Sebelum Diupdate : ");
                if(idx-1 < arrMovie.size()){
                    detailMovie(idx-1);
                }else{
                    detailShow(idx-arrMovie.size()-1);
                }
                System.out.println("===================================\n");
                
                System.out.println("===================================");
                System.out.println("| Detail Film Setelah Diupdate : ");
                
                System.out.print("| Nama Film : ");
                String nama = br.readLine();
                System.out.print("| Tahun Film : ");
                int tahun = Integer.parseInt(br.readLine());
                System.out.print("| Direktor Film : ");
                String direktor = br.readLine();

                if(idx-1 < arrMovie.size()){
                    System.out.print("| Panjang Film(Menit) : ");
                    int panjang = Integer.parseInt(br.readLine());
                    System.out.println("| Sinopsis Film : ");
                    String sinopsis = br.readLine();
                    
                    String tempNama = arrMovie.get(idx-1).getNama();
                    int tempTahun = arrMovie.get(idx-1).getTahun();
                    String tempDirektor = arrMovie.get(idx-1).getDirektor();
                    String tempSinopsis = arrMovie.get(idx-1).getSinopsis();
                    int tempPanjang = arrMovie.get(idx-1).getPanjangFilm();
                    
                    dataMovies movie = new dataMovies(nama,tahun,
                                    direktor,sinopsis,panjang);
                    
                    arrMovie.set(idx-1, movie);

                    boolean confirm = confirmUpdate(tempNama,tempTahun,tempDirektor,tempSinopsis,tempPanjang,idx-1,"Movie");
                    
                    if(confirm == false){
                        movie = new dataMovies(tempNama,tempTahun,tempDirektor,tempSinopsis,tempPanjang);
                        arrMovie.set(idx-1, movie);
                        return;
                    }

                    System.out.println("===================================");
                    System.out.println("| Data Berhasil Diupdate");
                }else{
                    System.out.print("| Jumlah Episode : ");
                    int jumlah = Integer.parseInt(br.readLine());
                    System.out.println("| Sinopsis Film : ");
                    String sinopsis = br.readLine();

                    String tempNama = arrShow.get(idx-1-arrMovie.size()).getNama();
                    int tempTahun = arrShow.get(idx-1-arrMovie.size()).getTahun();
                    String tempDirektor = arrShow.get(idx-1-arrMovie.size()).getDirektor();
                    String tempSinopsis = arrShow.get(idx-1-arrMovie.size()).getSinopsis();
                    int tempJumlah = arrShow.get(idx-1-arrMovie.size()).getJumlahEpisode();

                    dataShow show = new dataShow(nama,tahun,
                                    direktor,sinopsis,jumlah);
                    
                    arrShow.set(idx-1-arrMovie.size(), show);

                    boolean confirm = confirmUpdate(tempNama,tempTahun,tempDirektor,tempSinopsis,tempJumlah,idx-1-arrMovie.size(),"Show");

                    if(confirm == false){
                        show = new dataShow(tempNama,tempTahun,tempDirektor,tempSinopsis,tempJumlah);
                        arrShow.set(idx-1-arrMovie.size(), show);
                        return;
                    }

                    System.out.println("===================================");
                    System.out.println("| Data Berhasil Diupdate");
                }
                
                System.out.println("===================================");
                
                
            }catch(NumberFormatException exc){
                System.out.println("\n===================================");
                System.out.println("| Telah Terjadi Error");
                System.out.println("===================================");
            }
            System.out.println("===================================");
            System.out.println("| Klik Enter Untuk Lanjut");
            br.readLine();

        } catch (NumberFormatException exc1) {
            System.out.println("\n===================================");
            System.out.println("| Telah Terjadi Error");
            System.out.println("===================================");
        }catch(IndexOutOfBoundsException exc2){
            System.out.println("===================================");
            System.out.println("| Nomor Film Tidak Terdapat Pada List");
            System.out.println("===================================");
        }
        
    }
    
    void hapusData() throws IOException, InterruptedException{
        try{
            clr();
            System.out.println("===================================");
            System.out.println("           Menghapus Data");
            System.out.println("===================================");
            listData("All");

            System.out.println("===================================");
            System.out.print("| Masukan Nomor Film yang ingin Dihapus : ");
            int idx = Integer.parseInt(br.readLine());

            if(idx-1 < arrMovie.size()){
                arrMovie.remove(idx-1);
            }else{
                arrShow.remove(idx-1-arrMovie.size());
            }
            System.out.println("===================================");
            System.out.println("| Data berhasil dihapus");
        
        }catch(NumberFormatException exc1){
            System.out.println("\n===================================");
            System.out.println("| Telah Terjadi Error");
            System.out.println("===================================");
        }catch(IndexOutOfBoundsException exc2){
            System.out.println("===================================");
            System.out.println("| Nomor Film Tidak Terdapat Pada List");
            System.out.println("===================================");
        }
        System.out.println("===================================");
        System.out.println("| Klik Enter Untuk Lanjut");
        br.readLine();
    }
}
