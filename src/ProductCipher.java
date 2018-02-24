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
        TextFileWriter writer = new TextFileWriter();
        Encryptor encryptor = new Encryptor("kalana");
        Decryptor decryptor = new Decryptor("kalana");
        
        System.out.println("Enter encrypt/decrypt to proceed :");
        String method = scanner.next();
        
        /*
        this will decrypt the file
        */
        if (method.equalsIgnoreCase("decrypt")){
            try{
                String encryptedText = reader.readFile("encrypted.txt");
                
                String decryptedText = decryptor.decrypt(encryptedText);
                
                writer.writeFile(decryptedText, "decrypted.txt");
                System.out.println("Decryption Successful");
                
            } catch (IOException e){
                System.out.println("File not found");  
            }
            
            
        /*
        this will encrypt the text
        */
        } else if (method.equalsIgnoreCase("encrypt")){
            try{
                String text = reader.readFile("text2.txt");
                
                String encryptedText = encryptor.encrypt(text);
                
                writer.writeFile(encryptedText, "encrypted.txt");
                System.out.println("Encryption Succesful");
            
            } catch (IOException e){
                System.out.println("File not found");
            }
        } else {
            System.out.println("Not a valid function");
        }
        
    }
    
}
