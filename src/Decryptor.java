/**
 *
 * @author Kalana
 */
public class Decryptor {
    private int[] text;
    private String key;
    private int[] processedKey;
   
    Decryptor(String decryptionKey){
        key = decryptionKey;
    }
    
    /*
    this method will process the 'decryptionKey' to a key that can be used as
    parameters for inverseSubstituition and inversePermutation methods
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
    this will convert the encryptedText in to array of integers which are 
    derieved from the ascii table. This array will be used to create the 
    original text using substitution method and permutation method.
    */
    private int[] processText(String text){
        String[] splittedString = text.split("\\s+");
        int[] textArray = new int[splittedString.length];
        for(int i= 0; i<splittedString.length;i++){
            textArray[i] = Integer.parseInt(splittedString[i]);
        }
        return textArray;
    }
    
    /*
    this will subsstract 'key' value from each value in 'text' array decreasing 
    their ascii value thus moving the position in the ascii table. by doing this 
    we remove substituition required
    */
    private int[] inverseSubstituition(int[] text, int key){
        for (int i=0; i<text.length; i++){
            text[i]=text[i] + (128 - key);
            text[i] %= 128;
        }
        return text;
    }
    
    /*
    this method will Inverse permutate the array by taking a sub array and changing their 
    element order (one with the last, second with the one before last etc). sub 
    array size will be decided by the 'value' wich will be betwween 0 and 10.
    */
    private int[] inversePermutation(int[] text, int value){
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
            temp += (char) array[i];
        }
        return temp;
    }
    
    /*
    this method will decrypt the encrypted text using inverseSubstituition medthod
    and inversePermutation methods
    */
    public String decrypt(String encryptedText){
        processedKey = processKey(key);
        text = processText(encryptedText);
        
        for(int i=processedKey.length-1; i>=0;i--){
            if(i%2==0){
                text = inverseSubstituition(text, processedKey[i]);
            } else {
                text = inversePermutation(text, processedKey[i]);
            }
        }
        return finalizeText(text); 
    }
}
