package audiolibrary;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenFolder {
    public OpenFolder(String str) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File(str);
            desktop.open(dirToOpen);
        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        }
    }
    
}