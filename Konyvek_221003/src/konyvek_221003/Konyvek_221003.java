/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konyvek_221003;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author user09
 */
public class Konyvek_221003 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] nevek = null;
        int[] konyvek = null;
        try
        {
            System.setProperty("file.encoding", "UTF8");
            FileReader fr = new FileReader("konyvek.txt");
            BufferedReader br = new BufferedReader(fr);
            
            int elemszam = Integer.parseInt(br.readLine());
            nevek = new String[elemszam];
            konyvek = new int[elemszam];
            String sor;
            
            int i = 0;
            while ((sor = br.readLine()) !=null) 
            {                
                nevek[i] = sor;
                sor = br.readLine();
                konyvek[i] = Integer.parseInt(sor);
                i++;
            }
        
        }
        catch (IOException | NumberFormatException hiba)
        {
            System.out.println("Nincs meg a fájl!:" + hiba);
        }
        for (int j = 0; j < nevek.length; j++) 
        {
            System.out.println(konyvek[j]);
        }
        
        int osszesen = 0;
        for (int j = 0; j < nevek.length; j++) 
        {
            osszesen = osszesen + konyvek[j];
        }
        System.out.println("Osszensen ennyi konyvet olvastak: " + osszesen);
        System.out.println("Átlag: " + (float) ((float) osszesen/konyvek.length));
                
        int max = konyvek[0];
        String maxnev = nevek[0];
        for(int j=1; j < j; j++)
        {
            if(konyvek[j] > max)
            {
                max = konyvek[j];
                maxnev = nevek[j];
            }
            
        }
	System.out.println(maxnev + " Olvasta a legtöbb könyvet: " + max + " db-ot");

        for(int i= nevek.length-1; i>0; i--)
            for(int j=0; j<i; j++)
                if(konyvek[j] < konyvek[j+1])
                    {
                        int tmp = konyvek[j];
                        konyvek[j] = konyvek[j+1];
                        konyvek[j+1] = tmp;
                        
                        String tmp2 = nevek[j];
                        nevek[j] = nevek[j+1];
                        nevek[j+1] = tmp2;
                        
                    }
                        for(int i=0; i < konyvek.length; i++)
                        {
                            
                            System.out.println(i+1 + ". " + nevek[i] + " olvasott " + konyvek[i] + " db-ot");
                        }
                                
                    }  
    
}
