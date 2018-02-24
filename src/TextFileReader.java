
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Kalana
 */
public class TextFileReader {
    private BufferedReader buffInput;
    
    TextFileReader(){
    }
    
    public String readFile(String path) throws IOException{
        String line;
        String text = "";

        buffInput = new BufferedReader(new FileReader(new File(path)));
        
        while ((line = buffInput.readLine()) != null) {
            text += line;
            text += "\n";
        }

        return text;
    }
}
