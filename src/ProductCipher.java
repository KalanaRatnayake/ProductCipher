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
        
        System.out.println("==================== Welcome to the Product Cipher ==========================");
        System.out.println("\n");
        System.out.print("Enter encrypt/decrypt to proceed : ");
        String method = scanner.next();
        
        /*
        this will decrypt the file
        */
        if (method.equalsIgnoreCase("decrypt")){
            try{
                System.out.print("\nEnter the name of the encrypted file : " );
                String fileName = scanner.next();
                String encryptedText = reader.readFile(fileName + ".txt");
                
                String decryptedText = decryptor.decrypt(encryptedText);
                System.out.println("\n============ Successfully decrypted ===============");
                
                System.out.print("\nEnter the name required for the decrypted file : ");
                String decryptFileName = scanner.next();
                writer.writeFile(decryptedText, decryptFileName+ ".txt");
                
                System.out.println("\n========= Successfully Saved the file ==================");
                
            } catch (IOException e){
                System.out.println("File not found");  
            }
            
            
        /*
        this will encrypt the text
        */
        } else if (method.equalsIgnoreCase("encrypt")){
            try{
                System.out.print("\nEnter the name of the file that needs to be encrypted : " );
                String originalFileName = scanner.next();
                String text = reader.readFile(originalFileName + ".txt");
                
                String encryptedText = encryptor.encrypt(text);
                System.out.println("\n================= Successfully encrypted ================");
                
                System.out.print("\nEnter the name required for the encrypted file : ");
                String encryptedFileName = scanner.next();
                writer.writeFile(encryptedText, encryptedFileName + ".txt");
                
                System.out.println("\n============== Succesfully Saved the file ===============");
            
            } catch (IOException e){
                System.out.println("File not found");
            }
        } else {
            System.out.println("Not a valid function");
        }
        
    }
    
}
