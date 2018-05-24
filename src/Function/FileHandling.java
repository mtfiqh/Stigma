/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author indon
 */
public class FileHandling {
    
    public static ArrayList<Integer> getFile(String filename) throws FileNotFoundException
    {
        FileReader fr = new FileReader(filename);
        ArrayList<Integer> data = new ArrayList<>();
        try {
            int ch;
            while((ch=fr.read())!=-1)
            {
                data.add(ch);
            }
            fr.close();
        } catch (IOException ex) {
            System.out.println("File kosong");
        }
        return data;
    }
    
    public static void main(String[] args) {
        try {
            ArrayList<Integer> data = FileHandling.getFile("matrix.txt");
            for(Integer tmp : data)
            {
                System.out.println(tmp);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File tidak ada");
        }
    }
}
