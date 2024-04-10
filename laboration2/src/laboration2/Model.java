package laboration2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Model {
   
    public Model() {
        
    }

    //https://www.tabnine.com/code/java/classes/java.io.BufferedReader
    public String open(File file) {
    	
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
          
            return stringBuilder.toString();
        } catch (IOException e) {
        	 e.printStackTrace();
           return "error";
        }
    }
    
   
    public void writeToFile(File file, String text) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(text);
        } catch (IOException e) {
        	e.printStackTrace();
          
        }
    }
    
	 
    }



