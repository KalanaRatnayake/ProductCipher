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
        
        
        System.out.println("\n\n==================== Welcome to the Product Cipher of 150533H ==========================");
        System.out.println("\n");
        System.out.print("Enter encrypt/decrypt to proceed : ");
        String method = scanner.next();
        
        
        /*
        this will decrypt the file
        */
        if (method.equalsIgnoreCase("decrypt")){
            try{
                System.out.print("Enter the Key(without spaces) : ");
                String Key = scanner.next();
        
                Decryptor decryptor = new Decryptor(Key);
                
                System.out.print("\nEnter the path of the encrypted file : " );
                String fileName = scanner.next();
                String encryptedText = reader.readFile(fileName);
                
                String decryptedText = decryptor.decrypt(encryptedText);
                System.out.println("\n============ Successfully decrypted ===============");
                
                System.out.print("\nEnter the path of the folder to save the decrypted file : ");
                String decryptFilePath = scanner.next();
                writer.writeFile(decryptedText, decryptFilePath+ "\\decrypted.txt");
                
                System.out.println("\n========= Successfully Saved the file as decrypted.txt ==================");
                
            } catch (IOException e){
                System.out.println("File not found");  
            }
            
            
        /*
        this will encrypt the text
        */
        } else if (method.equalsIgnoreCase("encrypt")){
            try{
                
                System.out.print("Enter the Key(without spaces) : ");
                String Key = scanner.next();
        
                Encryptor encryptor = new Encryptor(Key);
                
                
                System.out.print("\nEnter the path of the file that needs to be encrypted : " );
                String originalFileName = scanner.next();
                String text = reader.readFile(originalFileName);
                
                String encryptedText = encryptor.encrypt(text);
                System.out.println("\n================= Successfully encrypted ================");
                
                System.out.print("\nEnter the path of the folder to save encrypted file : ");
                String encryptedFilePath = scanner.next();
                writer.writeFile(encryptedText, encryptedFilePath + "\\encrypted.txt");
                
                System.out.println("\n=========== Succesfully Saved the file as encrypted.txt ===============");
            
            } catch (IOException e){
                System.out.println("File not found");
            }
        } else {
            System.out.println("Not a valid function");
        }
        
    }
    
}
