import java.awt.Color;
import model.Circle;
import model.DrawingContainer;
import model.Line;
import model.Rect;
import view.DrawingUtil;

public class Controler {

    private View view;
    private DrawingContainer drawingContainer;
   Model model = new Model();

    public Controler(View view, DrawingContainer drawingContainer) {
        this.view = view;
        this.drawingContainer = drawingContainer;
       
        
    }
   
	Color getColor(String colorName) {
        switch (colorName) {
            case "Black":
                return Color.BLACK;
            case "Red":
                return Color.RED;
            case "Green":
                return Color.GREEN;
            case "Blue":
                return Color.BLUE;
            case "Yellow":
                return Color.YELLOW;
            case "Orange":
                return Color.ORANGE;
            default:
                return null;
        }
    }

    public DrawingContainer getDrawingContainer() {
        return drawingContainer;
    }

    public void createCircle(int x1, int y1, int width, int height, int lineThickness, Color selectedLineColor,
            Color selectedFillColor) {
        DrawingUtil da = new DrawingUtil(); //Den inneh�ller de delar som neh�vs f�r att kunna skapa en cirkel
        Circle c = new Circle(da, x1, y1, width, height, lineThickness, selectedLineColor, selectedFillColor);
        drawingContainer.add(c);  // l�gg till den skapade cikeln i drawingContainer.
        view.updateDrawingPanel();
    }


	public void createLine(int x1, int y1, int width, int height, int lineThickness, Color selectedLineColor) {
		 DrawingUtil da = new DrawingUtil();
		 Line l=new Line(da, x1, y1, width, height, lineThickness, selectedLineColor);
	        drawingContainer.add(l);  // l gg till cikeln i v r drawingContainer.
	        view.updateDrawingPanel();
		
	}

	public void createRect(int x1, int y1, int width, int height, int lineThickness, Color selectedLineColor,
            Color selectedFillColor) {
		 DrawingUtil da = new DrawingUtil();
		 Rect r=new Rect(da, x1, y1, width, height, lineThickness, selectedLineColor, selectedFillColor );
	        drawingContainer.add(r);  // l gg till cikeln i v r drawingContainer.
	        view.updateDrawingPanel();
		
	}
   
	 public void saveDrawingContainer(DrawingContainer drawingContainer, String outputPath) {
	        model.saveFile(drawingContainer, outputPath);

	    }
	 
	 
	 public void openDrawingContainer() {
		 
		 drawingContainer = model.openFile("drawing.dat"); //vi vill �pnna filen "drawing.dat". drawingcontainer == resultatet fr�n openfile i model
		 view.openDrawing(drawingContainer); //anropar opendrawing och skickar med dc
	 }
    
    public static void main(String[] args) {
        new View();
    }
}

