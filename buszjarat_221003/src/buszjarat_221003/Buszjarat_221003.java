/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buszjarat_221003;

import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class Buszjarat_221003 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] utasok = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int i = 0;
        Calendar datum=Calendar.getInstance();
        
        System.out.printf("%tB\n",datum);
        
        Scanner olvaso = new Scanner(System.in);
        System.out.println("Milyen hónapban vagyunk? (számmal adjuk meg!): ");
        
        while (i<1 || i >12) 
        {            
            i = olvaso.nextInt();
        }
        int napszam = 31;
        switch(i)
        {
            case 1: System.out.println("Január"); break;
            case 2: System.out.println("Február"); napszam=28; break;
            case 3: System.out.println("Március"); break;   
            case 4: System.out.println("Április"); napszam=30; break;
            case 5: System.out.println("Május"); break;
            case 6: System.out.println("Június"); napszam=30; break;
            case 7: System.out.println("Július"); break;
            case 8: System.out.println("Augusztus"); break;
            case 9: System.out.println("Szeptember"); napszam=30; break;
            case 10: System.out.println("Október"); break;    
            case 11: System.out.println("November"); napszam=30; break; 
            case 12: System.out.println("December"); break;    
        }
        
        try
        {
            System.setProperty("file.encoding", "UTF8");
            FileReader fr = new FileReader("busz.txt");
            BufferedReader br = new BufferedReader(fr);
            String sor;
            int j = 0;
            while ((sor = br.readLine())!=null) 
            {           
                utasok[j]=Integer.parseInt(sor);
                j++;
            }
            br.close();
            System.err.println("Az adatokat kiírtam!");
            
        }
        catch (IOException | NumberFormatException hiba)
        {
            System.out.println("Nincs meg a fájl!: " + hiba);
        }
        int osszesen = 0;
        int db = 0;
        int max = utasok[0];
        int nap = 1;
        boolean van = false;
        for (int k = 0; k < napszam; k++) 
        {   
            osszesen=osszesen+utasok[i];
            if (utasok[k]>200)
            {
                db++;
            }
            if (utasok[k]>max)
            {
                max = utasok[k];
                nap=k+1;
            }
            if (utasok[k] == 200) 
            {
                van = true;
            }
        }
        System.out.println("Ennyien utaztak: " + osszesen + " db.");
        System.out.println("Kétszáz feletti utasok egy nap: " + db + " db.");
        System.out.println("Ennyi volt a maximum utasszám: " + max + " és ez a " + nap + " napon volt");
        
        
    }
    
}
