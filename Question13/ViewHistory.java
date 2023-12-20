
public class ViewHistory extends View<ControllerHistory> {
	//to keep track of how the total amount of debt of all the payers
	//of the finance office changes over time.
	
	//constructor declaration.
	public ViewHistory(FinanceOffice m, ControllerHistory c) {
		//initialize the instance variables in the superclass.
		super(m, c);
		
		//create a frame.
		this.setTitle("View History");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		
		//only a HistoryPanel object, nothing else.
		HistoryPanel h = new HistoryPanel(m);
		this.add(h);
		
		//let the frame visible to users.
		this.setVisible(true);
	}
	//method declaration.
	public void update() {
		//force swing to redraw everything every time the model changes.
		repaint();
		return;
	}

}
