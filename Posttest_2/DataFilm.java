
package Posttest_2;

import Posttest_1.*;
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

            System.out.print("| Nama Film : ");
            String namaFilm = br.readLine();
            System.out.print("| Tahun Film : ");
            int tahunFilm = Integer.parseInt(br.readLine());
            System.out.print("| Direktor Film : ");
            String direktor = br.readLine();
            System.out.println("| Sinopsis Film : ");
            String sinopsis = br.readLine();
            
            DetailFilm detFilm = new DetailFilm(namaFilm,
                    tahunFilm,direktor,
                    sinopsis);
            
            arr.add(detFilm);
            
            detFilm.addSucc();
            
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
        System.out.println("| "+arr.get(index).getSinopsis());
    }

    void listData(){
        if(arr.isEmpty()){
            System.out.println("| List Kosong");
        }
        for (int i = 0; i < arr.size();i++){
            int no = i+1;
            System.out.println(no+". "+arr.get(i).getNama()+" ("+
                    arr.get(i).getTahun()+")");
        }
    }
    
    void lihatData() throws InterruptedException, IOException{
        clr();
        System.out.println("===================================");
        System.out.println("            Lihat Data");
        System.out.println("===================================");
        System.out.println("| 1. Lihat List Film");
        System.out.println("| 2. Lihat Detail Film");
        System.out.println("===================================");

        System.out.print("| Masukan Pilihan : ");
        String input = br.readLine();

        switch(input){
            case "1" ->{
                clr();
                System.out.println("===================================");
                System.out.println("            List Film");
                System.out.println("===================================");
                listData();
            }
            case "2" ->{
                try{
                    clr();
                    System.out.println("===================================");
                    System.out.println("            List Film");
                    System.out.println("===================================");
                    listData();
                    System.out.println("===================================");
                    System.out.println("| Ketik 0 untuk kembali");
                    System.out.print("| Masukan Pilihan : ");
                    int idx = Integer.parseInt(br.readLine());

                    if(idx == 0){
                        break;
                    }

                    clr();
                    System.out.println("===================================");
                    System.out.println("  Detail Film "+arr.get(idx-1).getNama());
                    System.out.println("===================================");
                    detail(idx-1);
                }catch(NumberFormatException  exc1){
                    System.out.println("\n===================================");
                    System.out.println("| Telah Terjadi Error");
                    System.out.println("===================================");
                }catch(IndexOutOfBoundsException exc2){
                    System.out.println("===================================");
                    System.out.println("| Nomor Film Tidak Terdapat Pada List");
                    System.out.println("===================================");
                }
            }
            default ->{
                System.out.println("Masukan salah");
                System.out.println("Klik Enter Untuk Lanjut");
                br.readLine();
            }
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
            listData();
            
            System.out.println("===================================");
            System.out.print("| Nomor Film Yang Ingin diupdate : ");
            int idx = Integer.parseInt(br.readLine());

            String tempNama = arr.get(idx-1).getNama();
            int tempTahun = arr.get(idx-1).getTahun();
            String tempDirektor = arr.get(idx-1).getDirektor();
            String tempSinopsis = arr.get(idx-1).getSinopsis();
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
                arr.get(idx-1).setNama(br.readLine());
                System.out.print("| Tahun Film : ");
                arr.get(idx-1).setTahun(Integer.parseInt(br.readLine()));
                System.out.print("| Direktor Film : ");
                arr.get(idx-1).setDirektor(br.readLine());
                System.out.println("| Sinopsis Film : ");
                arr.get(idx-1).setSinopsis(br.readLine());
                
                System.out.println("===================================");
                
                System.out.println("===================================");
                System.out.println("| Film Berhasil Diupdate");
                System.out.println("===================================");
            }catch(NumberFormatException exc){
                arr.get(idx-1).setNama(tempNama);
                arr.get(idx-1).setDirektor(tempDirektor);
                arr.get(idx-1).setTahun(tempTahun);
                arr.get(idx-1).setSinopsis(tempSinopsis);
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
            listData();

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
