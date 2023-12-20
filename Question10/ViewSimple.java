import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSimple extends View implements ModelListener {

	//instance variables declaration.
	//serves as model.
	//as a subclass of View.
	//only have one instance variable.
	private JLabel label;
	
	//constructor declaration.
	public ViewSimple(FinanceOffice m, ControllerSimple c) {
		super(m, c);
		//register the view with the model
		//using the addListener method of the model.
		m.addListener(this);
		
		//create a frame.
		this.setTitle("View Simple");
		this.setSize(250, 120);
		this.setLocationRelativeTo(null);
		
		//create a label.
		JLabel l = new JLabel("total debt: " + m.totalDebt());
		
		this.add(l);
		
		//let the frame is visible to users.
		this.setVisible(true);
	}
	//method declaration.
	public void update() {
		//updates the text of the label as necessary
		//so that the label always displays the current total amount of debt
		//of all the finance office.
		label.setText("total debt: " + m.totalDebt());
		return;
	}
}
