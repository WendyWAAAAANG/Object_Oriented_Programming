import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSimple extends JFrame implements ModelListener {

	//instance variables declaration.
	//serves as model.
	private FinanceOffice m;
	//serves as controller.
	private ControllerSimple c;
	private JLabel label;
	
	//constructor declaration.
	public ViewSimple(FinanceOffice m, ControllerSimple c) {
		this.m = m;
		this.c = c;
		//register the view with the model
		//using the addListener method of the model.
		m.addListener(this);
		
		//create a frame.
		this.setTitle("View Simple");
		this.setSize(250, 120);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
