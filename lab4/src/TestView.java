import java.awt.Color;
import java.util.Scanner;
import javax.swing.JFrame;
import model.*;
import view.*;

// composite och facade, genom att vi har tagit hans paket in i v�rat program
public class TestView {
	Model model = new Model();
	
	public static void main(String[] args) {
		
		TestView testView = new TestView();
		Scanner input = new Scanner(System.in);
		  System.out.println("Tryck 1 for att lasa. Tryck 2 for att skapa");
		  
          int val = input.nextInt();
          
          if(val== 1) {
        	  testView.lasa();
          }
          if(val== 2) {
        	  testView.skapa();
          }
          input.close();
	}
	
	public void lasa() {
		Scanner input = new Scanner(System.in);
		System.out.println("Vilken fil vill du oppna?");
		String filename = input.next();
		input.close();
		DrawingContainer dc= model.openFile(filename); //anropa funktionen med filnamnet och l�gger inh�llet i drawingcontainer.
		//skapar jframe och l�gger till den �ppnade filens inneh�ll 
		JFrame j=new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		DrawingPanel dp = new DrawingPanel(dc); //l�gger drawingcontainer i drawingpanel
		j.add(dp); 
		j.setSize(500, 500); // t�nd
		j.setVisible(true); // gr�nssnitt
	}
	
	public void skapa() {
		Scanner input = new Scanner(System.in);
		//skapar frame och ritar
		JFrame j=new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		DrawingContainer dc=new DrawingContainer(); 
		DrawingUtil da=new DrawingUtil();	
		Line l=new Line(da,3,3,50,50,1,Color.RED);  											
		Circle c=new Circle(da,20,20,80,80,1,Color.BLUE,null);
		Circle c2=new Circle(da,150,150,50,250,20,Color.BLUE, Color.CYAN); 
		Rect r=new Rect(da,320,200,80,80,5,Color.GREEN,Color.PINK);
		dc.add(l);   
		dc.add(c);
		dc.add(c2);
		dc.add(r);
		//lagt till alla val till min ritning
		
		//v�lj vad du vill d�pa filen
		System.out.println("skriv namn: ");
		String filename = input.next();
		
		 model.saveFile(dc, filename); //Anropa v�r funktion med ritningen och filnamnet
		 input.close();
		 // l�gg till ritningen och t�nd gr�nssnitt
		DrawingPanel dp = new DrawingPanel(dc);  
		dp.setBackground(Color.WHITE);  
		j.add(dp);
		j.setSize(500, 500); 
		j.setVisible(true); 
}
}