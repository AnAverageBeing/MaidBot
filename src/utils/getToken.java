package utils;

import java.io.BufferedReader;
import java.io.File;

public class GetToken {
    
    public static String get(){
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(new File("C:\\Users\\someo\\Documents\\DEV\\MaidBot\\token.txt")));
            String line = br.readLine();
            br.close();
            return line;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
