package laboration2;

public class Factory {
	ViewInterface console;
	
	public ViewInterface createView(int val) {
		if (val==1) {
			return new Gui();
		}
		else {
			return new ConsoleView();
		}
	}
}
