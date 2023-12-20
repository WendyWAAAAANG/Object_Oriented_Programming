import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.*;

public class ViewPay extends View<ControllerPay> {
	//allows the user of the software
	//to pay money to a specific payer.
	//so the debt must increase since the amount of money the user own decrease.

	//instance variable declaration.
	private JTextField t1;
	private JTextField t2;
	
	//constructor declaration.
	public ViewPay(FinanceOffice m, ControllerPay c) {
		//initialize the instance variables.
		super(m, c);
		
		//create a windows.
		this.setTitle("View Pay");
		this.setSize(250, 160);
		this.setLocationRelativeTo(null);
		
		//set the layout manager of the frame.
		GridLayout g = new GridLayout(3,1);
		this.setLayout(g);
		
		//add the components into the windows.
		t1 = new JTextField("Type a payer name here");
		t2 = new JTextField("Type an amount of money here");
		JButton b = new JButton("Pay");
		this.add(t1);
		this.add(t2);
		this.add(b);
		
		//add the listener corresponding to the button.
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//store the input information into strings.
				String name = t1.getText();
				String amount = t2.getText();
				
				//call the pay method with above two arguments.
				String outcome = c.pay(name, amount);
				if(outcome.equals("")) {
					return;
				} else {
					JOptionPane.showMessageDialog(null, outcome);
					return;
				}
			}
		});
		
		//let the frame visible to users.
		this.setVisible(true);
	}
	//method declaration.
	public void update() {
		//the update class does nothing
		//since the VGD class does not graphically display any data from the FO.
		return;
	}
}
