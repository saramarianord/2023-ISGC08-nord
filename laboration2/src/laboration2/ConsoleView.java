package laboration2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView implements ViewInterface {
	
    private BufferedReader in;
    private Controler controler;
    String textContent; 
    
    public ConsoleView() {
    	controler = new Controler(this);
        in=new BufferedReader(new InputStreamReader(System.in));
      
    }
    public void clear()  {
    	//benneths f�rel�sning
        String slask="100";
        try {
             while (Integer.parseInt(slask)!=0) {
                 System.out.println("*********Menu*******************");
                 System.out.println("1. Read File/ Open");
                 System.out.println("2. Save File");
                 System.out.println("3. New File");
                 System.out.println("\n0. Quit");
                 slask=in.readLine();
                 
                 if(slask.equals("1")) {
                	 controler.handleEvent("Open");
                 }
                 if(slask.equals("2")) {
                	 controler.handleEvent("Save As");
                 }
                 if(slask.equals("3")) {
                	 controler.handleEvent("New File");
                 }
                 if(slask.equals("0")) {
                	 controler.handleEvent("Exit");
                	 
                 }
	           }
	        }
	        catch (Exception e) {
	            System.exit(1);
	        } 
    	}

	@Override
	public void chooseFile() {
	    try{
            System.out.println("Enter the file path:");
            String fileName = in.readLine();
            File chosenFile = new File(System.getProperty("user.home") + File.separator + "Documents", fileName + ".txt");
           
            if (chosenFile.exists()) { //https://www.geeksforgeeks.org/file-exists-method-in-java-with-examples/
                controler.goToOpen(chosenFile);
            } else {
                System.out.println("Error");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
	@Override
	public void showFile(String file) {
	System.out.println(file);
	}

	@Override
	public File save() {
		
		return null;
	}

	@Override
	public void saveAs() { 
		 try{
		        System.out.println("Enter the file path:");
		        String fileName = in.readLine();
		        File currentFile = new File(System.getProperty("user.home") + File.separator + "Documents", fileName + ".txt");

		        System.out.println("Write in the file:");
		        textContent = in.readLine();
		        
		        controler.save(currentFile);
		    }catch (IOException e) {
		        e.printStackTrace();
		    }
		}

	@Override
	public String getText() {
	
		return textContent;
	}

	@Override
	public void closeFile() {
		
	}

}
