import javax.swing.JFrame;

public abstract class View<T extends Controller> extends JFrame implements ModelListener {

	//instance variables declaration.
	protected FinanceOffice m;
	protected T c;
	
	//constructor declaration.
	public View(FinanceOffice m, T c) {
		//initialize the instance variables.
		this.m = m;
		this.c = c;
		
		//to simplify the code of the next questions.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//method declaration.
	//the update method is abstract.
	public abstract void update();
}
