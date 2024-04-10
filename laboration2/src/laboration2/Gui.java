package laboration2;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Gui implements ViewInterface {
    private JFrame f;
    private JMenuBar mb;
    private JTextArea text;
    private JMenu arkiv;
    private JMenuItem choice1, choice2, choice3, choice4, choice5;
    private JScrollPane scroll;
    private File currentFile;
    private Controler controler;
    
  
    public Gui() {
    	
    	controler = new Controler(this);
        f = new JFrame("TextEditor");
        f.setVisible(true);
        mb = new JMenuBar();
        arkiv = new JMenu("File");
        choice1 = new JMenuItem("Open");
        choice2 = new JMenuItem("New File");
        choice3 = new JMenuItem("Save As");
        choice4 = new JMenuItem("Save");
        choice5 = new JMenuItem("Exit");
        arkiv.add(choice1);
        arkiv.add(choice2);
        arkiv.add(choice3);
        arkiv.add(choice4);
        arkiv.addSeparator();
        arkiv.add(choice5);
        text = new JTextArea();
        scroll = new JScrollPane(text);
        mb.add(arkiv);
        choice1.addActionListener(controler);
        choice2.addActionListener(controler);
        choice3.addActionListener(controler);
        choice4.addActionListener(controler);
        choice5.addActionListener(controler);
        f.setJMenuBar(mb);
        f.add(scroll);
        f.setSize(200, 200);
       
        
    }
    

    //https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/javax/swing/JFileChooser.html
	 @Override
	public void chooseFile() {
	        JFileChooser chosenFile = new JFileChooser("d:" + File.separator + "Java-program");
	        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files (*.txt)", "txt");
	        chosenFile.setFileFilter(filter);

	        int returnValue = chosenFile.showOpenDialog(null);
	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	           
	        	currentFile = chosenFile.getSelectedFile();
	            controler.goToOpen(currentFile);
	        }
	    }


    @Override
	public void showFile(String file) {
        text.setText(file); 
        f.setTitle("TextEditor - " + currentFile);
    }
    

	@Override
	public File save() {
		
		return currentFile;
	
	}
	


	@Override
	public void saveAs() {
	
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));
	    int selectedFile = fileChooser.showSaveDialog(null);
	    
	
	    if (selectedFile == JFileChooser.APPROVE_OPTION) {
	        currentFile = fileChooser.getSelectedFile();
	        currentFile = new File(currentFile.getAbsolutePath() + ".txt");
	        controler.save(currentFile);
	        f.setTitle("TextEditor - " + currentFile);
	    }
	}

    @Override
	public void clear() {
        text.setText("");
        currentFile = null;
        f.setTitle("TextEditor");
    }

    
    @Override
	public String getText() {
    	
    	return text.getText();
    	   
    }
    
    public void closeFile() {
	      
        System.exit(0);
    	
	 }
    
}


