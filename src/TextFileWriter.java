
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kalana
 */
public class TextFileWriter {
    private BufferedWriter writer;
    
    /*
    constructor of the class
    */
    TextFileWriter(){}
    
    /*
    this method will write the given text into a text file in utf-8 encoding
    */
    public void writeFile(String text, String name) {
        try{
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), "utf-8"));
            writer.write(text);
            writer.close();
        } catch(UnsupportedEncodingException e) {
            System.out.println("File Encoding is not supported");
        } catch(IOException e){
            System.out.println("String not supported");
        }
    }
}
