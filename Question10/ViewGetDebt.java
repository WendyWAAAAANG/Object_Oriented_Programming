import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.*;

public class ViewGetDebt extends View<ControllerGetDebt> {
	//allow user of the software to check how much debt a specific payer has.
	
	//instance variable declaration.
	private JTextField t;
	
	//constructor declaration.
	public ViewGetDebt(FinanceOffice m, ControllerGetDebt c) {
		//initialize the superclass instance variables.
		super(m, c);
		
		//create a frame.
		this.setTitle("View Debt");
		this.setSize(250, 120);
		this.setLocationRelativeTo(null);
		
		//add the text field and button.
		t = new JTextField("Type a payer name here");
		JButton b = new JButton("Tell me the debt");
		this.add(t);
		this.add(b);
		GridLayout g = new GridLayout(2, 1);
		this.setLayout(g);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//read the name of the payer.
				//use getDebt method to get the amount of the input person.
				String name = t.getText();
				JOptionPane.showMessageDialog(null, c.getDebt(name));
				//the update class does nothing
				//since the VGD class does not graphically display any data from the FO.
				update();
				return;
			}
		});
		
		//let the frame visible to users.
		this.setVisible(true);
	}
	//method override
	@Override
	public void update() {
		//the update class does nothing
		//since the VGD class does not graphically display any data from the FO.
		return;
	}
}
