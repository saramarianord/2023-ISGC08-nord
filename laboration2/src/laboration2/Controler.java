package laboration2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class Controler implements ActionListener {
    private ViewInterface viewInterface;
    private Model m;
    private File file;
 

    public Controler(ViewInterface view) {
        viewInterface = view; 
        m = new Model();
    }

    public void actionPerformed(ActionEvent e) {
        handleEvent(e.getActionCommand());
    }

    public void handleEvent(String command) {
        switch (command) {
            case "New File":
                newFile();
                break;
            case "Exit":
            	viewInterface.closeFile();
                break;
            case "Open":
            	viewInterface.chooseFile();
                break;
            case "Save As":
            	viewInterface.saveAs();
                break;
            case "Save":
                unsavedChanges();
                break;
        }
    }
  


    public void goToOpen(File currentFile) {
        this.file = currentFile;
        String text = m.open(currentFile);
        viewInterface.showFile(text);
    }

    public void save(File currentfile) {
    	//System.out.println(viewInterface.getText());
        m.writeToFile(currentfile, viewInterface.getText());
    }

    public void newFile() {
    	viewInterface.clear();
        this.file = null;
    }

    public void unsavedChanges() {
        if (file != null) {
            save(file);
        } else {
        	viewInterface.saveAs();
        }
    }

    public static void main(String[] args) {
        Factory f = new Factory(); //instans till factory
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Tryck 1 for grafisk vy. Tryck 2 for konsoll vy");
            int val = input.nextInt();
            ViewInterface v = f.createView(val);
            v.clear(); //tömmer textrutan
            new Controler(v);
           
        } finally {
            input.close(); 
        }
    }  
}