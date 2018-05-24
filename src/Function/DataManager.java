/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author indon
 */
public class DataManager {
    
    public ArrayList<String> getData(String filename) throws FileNotFoundException
    {
        if(!filename.endsWith(".txt"))
        {
            filename = filename.concat(".txt");
        }
        ArrayList<Integer> data = FileHandling.getFile(filename);
        ArrayList<Character> hasil = new ArrayList<>();
        for(Integer tmp : data)
        {
            hasil.add((char) tmp);
        }
    }
    
    public static void main(String[] args) {
        DataManager dm = new DataManager();
        try {
            ArrayList<String> data = dm.getData("matrix.txt");
            
        } catch (FileNotFoundException ex) {
            System.out.println("File tidak ada");
        }
    }
}
