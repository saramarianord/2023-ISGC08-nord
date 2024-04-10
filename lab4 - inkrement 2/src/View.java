
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.*;
import model.DrawingContainer;
import view.DrawingPanel;
public class View {
	 
	private boolean Modified = false;
    private Controler controler;
    private JFrame f;
    private JScrollPane scroll;
    private JPanel bottomPanel;
    private JLabel label1, label2, label3, label5, label7, label8, label9, label10;
    private JTextField lineInput, y1Input, x1Input, widthInput, heightInput;
    private JComboBox<String> figureInput, lineColorInput, fillColorInput;
    private JButton submitButton;
    private String[] colorOptions = {"Black", "Red", "Green", "Blue", "Yellow", "Orange"};
    private DrawingContainer drawingContainer;
    private DrawingPanel drawingPanel;

    public View() {
    
	    controler = new Controler(this, new DrawingContainer());
	    drawingContainer = controler.getDrawingContainer();
	    
	    //Kontruktor för att bygga upp gränssnittet
	    f = new JFrame("Paint");
	    f.setVisible(true);
	    scroll = new JScrollPane();  
	    f.setBackground(Color.WHITE); 	   
	    bottomPanel = new JPanel();
	    bottomPanel.setPreferredSize(new Dimension(f.getWidth(), 120)); // gör bottomPanel responsiv för att få plats med alla fält
	    label1 = new JLabel("Figure");
	    label2 = new JLabel("Linethickness");
	    label3 = new JLabel("y1");
	    y1Input = new JTextField(5);
	    label5 = new JLabel("x1");
	    x1Input = new JTextField(5);
	    label7 = new JLabel("Width");
	    widthInput = new JTextField(5);
	    label8 = new JLabel("Height");
	    heightInput = new JTextField(5);
	    label9 = new JLabel("Linecolor");
	    lineColorInput = new JComboBox<>(colorOptions); 
	    label10 = new JLabel("Fillcolor");
	    fillColorInput = new JComboBox<>(colorOptions); 
	    String[] figureOptions = {"","Circle", "Line", "Rect"};
	    figureInput = new JComboBox<>(figureOptions);
	    lineInput = new JTextField(5);
	    submitButton = new JButton("Submit");
	    drawingPanel = new DrawingPanel(drawingContainer);
	    f.add(scroll, BorderLayout.CENTER);
	    f.add(bottomPanel, BorderLayout.SOUTH);
	    f.add(drawingPanel, BorderLayout.CENTER);
	    f.setSize(1000, 800);
	    bottomPanel.add(label1);
	    bottomPanel.add(figureInput);
	    bottomPanel.add(label2);
	    bottomPanel.add(lineInput);
	    bottomPanel.add(label3);
	    bottomPanel.add(y1Input);
	    bottomPanel.add(label5);
	    bottomPanel.add(x1Input);
	    bottomPanel.add(label7);
	    bottomPanel.add(widthInput);
	    bottomPanel.add(label8);
	    bottomPanel.add(heightInput);
	    bottomPanel.add(label9);
	    bottomPanel.add(lineColorInput);
	    bottomPanel.add(label10);
	    bottomPanel.add(fillColorInput);
	    bottomPanel.add(submitButton);
	    drawingPanel.setBackground(Color.WHITE); 
	
	    
	    //lyssnare som kontrollerar om man valt "line", isåfall döljs "fillcolorinput" alternativet
	    figureInput.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String selectedFigure = (String) figureInput.getSelectedItem();
	            fillColorInput.setEnabled(!selectedFigure.equals("Line"));
	        }
	    });
	
	 
	    
	    //spara innan man stänger.
	    f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	        if (Modified) {
            	            saveAs();
            	        } else {
            	            return; 
            	        }

            	        System.exit(0); 
            	    }
            	});
	    
	  
    
	  //Lyssnare på submit som skickar vidare inputs för att kunna skapa figurerna
	    submitButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int lineThickness = Integer.parseInt(lineInput.getText());
	            int y1 = Integer.parseInt(y1Input.getText());
	            int x1 = Integer.parseInt(x1Input.getText());
	            int width = Integer.parseInt(widthInput.getText());
	            int height = Integer.parseInt(heightInput.getText());
	
	            String selectedFigure = (String) figureInput.getSelectedItem();
	            String selectedLineColor = (String) lineColorInput.getSelectedItem();
	            String selectedFillColor = (String) fillColorInput.getSelectedItem();
	
	            Color colorLine = controler.getColor(selectedLineColor);
	            Color colorFill = controler.getColor(selectedFillColor);
	             
	            if (selectedFigure.equals("Circle")) {
	                controler.createCircle(x1, y1, width, height, lineThickness, colorLine, colorFill);
	            }
	            if (selectedFigure.equals("Line")) {
	                controler.createLine(x1, y1, width, height, lineThickness, colorLine);
	            }
	            if (selectedFigure.equals("Rect")) {
	             controler.createRect(x1, y1, width, height, lineThickness, colorLine, colorFill);
	            }
	        }
	    });
	    
	   //varje gång man startar programmet så anropas openFile som kollar om man har en ritning sparad, isåfall visas den direkt.
	  openFile();
	    
	  
	}
    
    public void openFile() {
    	File f = new File("drawing.dat"); 
    	
    	if(f.exists()) { //om drawing.dat existerar i mappstrukturen så vill vi visa den direkt
    		controler.openDrawingContainer();
    	}
    	
    }
    

    public void saveAs() {
    	String outputPath = "drawing.dat";
	            controler.saveDrawingContainer(drawingContainer, outputPath); //vi vill spara dc och ge den filnamnet "drawing.dat"
	}
    
    //
    public void openDrawing(DrawingContainer dc) {
    	drawingContainer = dc; 
    	updateDrawingPanel();
    }
    
    public void updateDrawingPanel() {
    	Modified = true; //sätter en flagga för att man har lagt till en figur till ens ritning
    	drawingPanel.setDc(drawingContainer); //sätter drawingcontainer till vår drawingpanel (draawingpanel håller i drawingcontainer)
        drawingPanel.repaint(); // h r kan man fylla p  bilden/gor synlig 
        
    }
    
 
}

    