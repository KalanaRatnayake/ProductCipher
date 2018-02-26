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
    private int[] processKey(String text){
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
    private int[] processText(String text){
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
    private int[] substituition(int[] text, int key){
        for (int i=0; i<text.length; i++){
            text[i]=text[i] + key;
            text[i] %= 128;
        }
        return text;
    }
    
    /*
    this method will permutate the array by taking a sub array and changing their 
    element order (one with the last, second with the one before last etc). sub 
    array size will be decided by the 'value' wich will be betwween 0 and 10.
    */
    private int[] permutation(int[] text, int value){
        int[] temp = text;
        int tempVariable;
        int multiplier = temp.length % value;
        for(int i=0; i<multiplier; i++){
            for (int j=i*value; j<(i+1)*value; j++){
                tempVariable = temp[i];
                temp[i] = temp[(((2*i)+1)*value)-1];
                temp[(((2*i)+1)*value)-1] = tempVariable;
                
            }
        }
        return temp;
    }
    
    /*
    this method will convert the array of numbers into a array of char and 
    concatenate them
    */
    private String finalizeText(int[] array){
        String temp = "";
        for(int i=0;i<array.length;i++){
            temp += Integer.toString(array[i]);
            temp += " ";
        }
        return temp;
    }
    
    /*
    this method will call create the encryption key and the prepare the original 
    text. then it will call permutation method and substituition method one after
    on the riginal text taking values from the encryption key.
    */
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
        return finalizeText(text);   
    }
}
