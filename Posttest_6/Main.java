
package Posttest_6;

import java.util.*;
import java.io.*;

public class Main {
    static void menu(){
        System.out.println("===================================");
        System.out.println("       Sistem Pendataan Film");
        System.out.println("===================================");
        System.out.println("| 1. Tambah Film");
        System.out.println("| 2. Lihat Film");
        System.out.println("| 3. Update Film");
        System.out.println("| 4. Hapus Film");
        System.out.println("| 5. Keluar Program");
        System.out.println("===================================");
    }
    
    public static void main(String args[]) throws IOException, InterruptedException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        boolean running = true;
        DataFilm film = new DataFilm();
        
        while(running){
            // Memanggil static method
            DataFilm.clr();
            menu();
            
            System.out.print("| Masukan Pilihan : ");
            String input = br.readLine();
            switch(input){
                case "1" -> {
                    film.inputData();
                }
                case "2" -> {
                    film.lihatData();
                }
                case "3" -> {
                    film.updateData();
                }
                case "4" -> {
                    film.hapusData();
                }
                case "5" -> running = false ;
                default -> {
                    System.out.println("Masukan salah");
                    System.out.println("Klik Enter Untuk Lanjut");
                    br.readLine();
                }
            } 
        }
    }
}
