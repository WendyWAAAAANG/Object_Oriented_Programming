import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.*;

public class ViewCreate extends View<ControllerCreate> {

	//instance variables declaration.
	private JTextField t1;
	private JTextField t2;
	private JComboBox<String> cb;
	
	//constructor declaration.
	public ViewCreate(FinanceOffice m, ControllerCreate c) {
		//initialize the instance variables in the superclass.
		super(m, c);
		
		//create a frame.
		this.setTitle("View Create");
		this.setSize(250, 200);
		this.setLocationRelativeTo(null);
		
		//add the components into the frame.
		t1 = new JTextField("Type a new payer name here");
		t2 = new JTextField("Type an amount of money here");
		this.add(t1);
		this.add(t2);
		cb = new JComboBox<String>(new String[] {"Student", "Employee", "FacultyMember"});
		this.add(cb);
		JButton b = new JButton("Create");
		this.add(b);
		
		//set the layout manager to the frame.
		GridLayout g = new GridLayout(4, 1);
		this.setLayout(g);
		
		//add the listener corresponding to the button.
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//create two string s to store the input information,
				String name = t1.getText();
				String amount = t2.getText();
				//create an integer to store the selection of users of the type of account,
				int i = cb.getSelectedIndex();
				//call the create method in the controllerCreate.
				String outcome = c.create(name, amount, i);
				if(outcome.contentEquals("")) {
					//which means the operation is implemented successfully.
					return;
				} else {
					//print out the relative message.
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
