/**
 *
 * @author Kalana
 */

public class Encryptor {
    private int[] text;
    private String key;
    private int[] processedKey;
   
    Encryptor(String encryptionKey){
        key = encryptionKey;
    }
    
    /*
    this method will process the 'encryptionKey' to a key that can be used as
    parameters for substituition and permutation methods
    */
    public int[] processKey(String text){
        int[] keyTraits = new int[text.length()];
        for(int i= 0; i<text.length();i++){
            keyTraits[i] = (int) text.charAt(i);
            if (i%2==1){
                keyTraits[i] %= 10;
            }
        }
        return keyTraits;
    }
    
    /*
    this will convert the originalText in to array of integers which are 
    derieved from the ascii table. This array will be used to create the 
    encrypted text using substitution method and permutation method.
    */
    public int[] processText(String text){
        int[] textArray = new int[text.length()];
        for(int i= 0; i<text.length();i++){
            textArray[i] = (int) text.charAt(i);
            }
        return textArray;
    }
    
    /*
    this will add 'key' value to each value in 'text' array increasing their 
    ascii value thus moving the position in the ascii table. by doing this we
    archieve substituition required
    */
    public int[] substituition(int[] text, int key){
        for (int i=0; i<text.length; i++){
            text[i]=text[i] + key;
        }
        return text;
    }
    
    public int[] permutation(int[] text, int value){
        
    }
    
    public String encrypt(String originalText){
        processedKey = processKey(key);
        text = processText(originalText);
        
        for(int i=0; i<processedKey.length;i++){
            if(i%2==0){
                text = substituition(text, processedKey[i]);
            } else {
                text = permutation(text, processedKey[i]);
            }
        }
        
    }
}
