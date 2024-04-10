 import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import model.*;
import view.*;

public class Model {
	
	DrawingContainer dc;

	public Model() {
	}
	
		public DrawingContainer openFile(String filename) {
			
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
				dc = (DrawingContainer) ois.readObject();
				System.out.println("du har öppnat filen: " + filename);
				ois.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return dc;
		}
		
	
	public void saveFile(DrawingContainer dc, String filename) {
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(dc);
			oos.close();
			System.out.println("painting saved!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		new Model();
	

	}

}