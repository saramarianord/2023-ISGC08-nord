package laboration2;

import java.io.File;

public interface ViewInterface {

	//https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/javax/swing/JFileChooser.html
	void chooseFile();

	void showFile(String file);

	File save();

	void saveAs();

	public void clear();

	String getText();
	
	void closeFile();

}