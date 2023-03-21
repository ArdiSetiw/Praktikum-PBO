
package Posttest_3;

import java.util.*;
import java.io.*;

public class DataFilm{
    ArrayList<DetailFilm> arr = new ArrayList<>();
    
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
                System.out.println("| Sinopsis Film : ");
                String sinopsis = br.readLine();
                
                if(pilihan == 1){
                    System.out.print("| Pajang Film(Menit) : ");
                    int panjang = Integer.parseInt(br.readLine());
                    dataMovies movie = new dataMovies(namaFilm,tahunFilm,
                                    direktor,sinopsis,panjang);
                    
                    arr.add(movie);
                }else{
                    System.out.print("| Jumlah Episode : ");
                    int episode = Integer.parseInt(br.readLine());
                    dataShow show = new dataShow(namaFilm,tahunFilm,
                                    direktor,sinopsis,episode);
                    
                    arr.add(show);
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
    
    void detail(int index){
        System.out.println("| Nama Film : "+arr.get(index).getNama());
        System.out.println("| Tahun Film : "+arr.get(index).getTahun());
        System.out.println("| Direktor Film : "+arr.get(index).getDirektor());
        System.out.println("| Sinopsis Film : ");
        System.out.println("| "+arr.get(index).getSinopsis()+"\n");
        if(arr.get(index) instanceof dataMovies movie){
            System.out.println("| Panjang Film : "+movie.getPanjangFilm()+" Menit");
        }else{
            dataShow show = (dataShow) arr.get(index);
            System.out.println("| Jumlah Episode : "+show.getJumlahEpisode()+" Episode");
        }
    }

    void listData(String type){
        if(arr.isEmpty()){
            System.out.println("| List Kosong");
        }
        else if (type == "All"){
            for (int i = 0; i < arr.size();i++){
                int no = i+1;
                System.out.println(no+". "+arr.get(i).getNama()+" ("+
                        arr.get(i).getTahun()+")");
            }
        }else if (type == "Movie"){
            int isi = 0;
            for (int i = 0; i < arr.size();i++){
                if(arr.get(i) instanceof dataMovies){
                    int no = i+1;
                    System.out.println(no+". "+arr.get(i).getNama()+" ("+
                        arr.get(i).getTahun()+")");
                    isi++;
                }
            }
            if (isi == 0){
                System.out.println("| List Kosong");
            }
        }else{
            int isi = 0;
            for (int i = 0; i < arr.size();i++){
                if(arr.get(i) instanceof dataShow){
                    int no = i+1;
                    System.out.println(no+". "+arr.get(i).getNama()+" ("+
                        arr.get(i).getTahun()+")");
                    isi++;
                }
            }
            if (isi == 0){
                System.out.println("| List Kosong");
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

                    clr();
                    System.out.println("===================================");
                    System.out.println("  Detail Film "+arr.get(idx-1).getNama());
                    System.out.println("===================================");
                    detail(idx-1);
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

                    if(!(arr.get(idx-1) instanceof dataMovies)){
                        System.out.println("===================================");
                        System.out.println("| Nomor Film Tidak Terdapat Pada List");
                        System.out.println("===================================");
                        break;
                    }

                    clr();
                    System.out.println("===================================");
                    System.out.println("  Detail Movie "+arr.get(idx-1).getNama());
                    System.out.println("===================================");
                    detail(idx-1);
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

                    if(!(arr.get(idx-1) instanceof dataShow)){
                        System.out.println("===================================");
                        System.out.println("| Nomor Film Tidak Terdapat Pada List");
                        System.out.println("===================================");
                        break;
                    }

                    clr();
                    System.out.println("===================================");
                    System.out.println("  Detail Tv Show "+arr.get(idx-1).getNama());
                    System.out.println("===================================");
                    detail(idx-1);
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
                detail(idx-1);
                System.out.println("===================================\n");
                
                System.out.println("===================================");
                System.out.println("| Detail Film Setelah Diupdate : ");
                
                System.out.print("| Nama Film : ");
                String nama = br.readLine();
                System.out.print("| Tahun Film : ");
                int tahun = Integer.parseInt(br.readLine());
                System.out.print("| Direktor Film : ");
                String direktor = br.readLine();
                System.out.println("| Sinopsis Film : ");
                String sinopsis = br.readLine();
                if (arr.get(idx-1) instanceof dataMovies){
                    System.out.println("| Panjang Film(Menit) : ");
                    int panjang = Integer.parseInt(br.readLine());
                    dataMovies movie = new dataMovies(nama,tahun,
                                    direktor,sinopsis,panjang);
                    arr.set(idx-1, movie);
                }else{
                    System.out.println("| Jumlah Episode : ");
                    int jumlah = Integer.parseInt(br.readLine());
                    dataShow show = new dataShow(nama,tahun,
                                    direktor,sinopsis,jumlah);
                    arr.set(idx-1, show);
                }
                
                System.out.println("===================================");
                
                System.out.println("===================================");
                System.out.println("| Film Berhasil Diupdate");
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

            arr.remove(idx-1);
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
