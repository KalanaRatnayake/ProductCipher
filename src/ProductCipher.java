import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Kalana
 */

public class ProductCipher {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextFileReader reader = new TextFileReader();
        Encryptor encryptor = new Encryptor("kalana");
        
        System.out.println("Enter encrypt/decrypt to proceed :");
       
        String method = scanner.next();
        
        if (method.equalsIgnoreCase("decrypt")){
            try{
                String encryptedText = reader.readFile("enText.txt");
                System.out.println(encryptedText);
                
            } catch (IOException e){
                System.out.println("File not found");
                
            }
        } else if (method.equalsIgnoreCase("encrypt")){
            try{
                String encryptedText = reader.readFile("Text.txt");
                
            } catch (IOException e){
                System.out.println("File not found");
                
            }
        } else {
            System.out.println("Not a valid function");
        }
        
    }
    
}
