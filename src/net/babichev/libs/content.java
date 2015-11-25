package net.babichev.libs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Content {

    public static String getFile(String filePath) {
        try {
            File file = new File(filePath);
            byte bt[] = new byte[(int)file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(bt);
            fis.close();

            return new String(bt, "UTF-8");
        }
        catch(FileNotFoundException e){
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
        catch(IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        finally {
            System.out.println("getFile success");
        }

        return "";
    }
}
