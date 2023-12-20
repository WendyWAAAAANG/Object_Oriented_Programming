import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class HistoryPanel extends JPanel {

	//instance variable declaration.
	private FinanceOffice f;
	
	//constructor declaration.
	public HistoryPanel(FinanceOffice f) {
		//initialize the instance variable.
		this.f = f;
	}
	//methods declaration.
	@Override
	protected void paintComponent(Graphics g) {
		//we must clean the panel before drawing on it.
		super.paintComponent(g);
		
		//draw graphically how the total amount of debt of all
		//the payers of the finance office changes over time.
		int min = historyMin(f.getHistory());
		int range = historyRange(f.getHistory());
		int maxX = getWidth() - 1;
		int maxY = getHeight() - 1;
		int zero = maxY + min* maxY / range;
		//set the color of the horizontal axis.
		//draw the line between the point (0, zero) and the point (maxX, zero).
		//represents the horizontal "zero" axis.
		g.setColor(Color.BLUE);
		g.drawLine(0, zero, maxX, zero);
		//set the color of the line of data.
		//Draw red lines between all the points (x, y).
		g.setColor(Color.RED);
		//if the number of account is only one
		//then we only draw a point.
		int x0 = 0;
		int y0 = zero - 0 * maxY / range;
		if(f.getHistory().size() == 1) {
			g.drawRect(x0, y0, 1, 1);
			repaint();
		} else {
			for(int i = 1; i < f.getHistory().size(); i++) {
				//set the x and y of all data.
				int x = 10 * i;
				int y = zero - f.getHistory().get(i) * maxY / range;
				//draw the line between two points.
				g.drawLine(10 * (i - 1), zero - f.getHistory().get(i - 1) * maxY / range, x, y);
				repaint();
			}
		}
		return;
	}
	private int historyRange(ArrayList<Integer> ints) {
		//return the result of the difference between max and min.
		//declare a local variable to store the difference.
		int diff = this.historyMax(ints) - this.historyMin(ints);
		if(diff < 200) {
			//if the diff is strictly less than 200,
			//return 200 as the result.
			return 200;
		}
		//otherwise, return the diff directly.
		return diff;
	}
	private int historyMax(ArrayList<Integer> ints) {
		//return the maximum number of the arrayList.
		//declare a integer to store the maximum number of the arrayList.
		
		/*
		int max = ints.get(0);
		for(int i = 1; i < ints.size(); i++) {
			if(max > ints.get(i)){
				//which means the current elements is larger than max.
				//we need to change the value of max.
				max = ints.get(i);
			} else {
				//which means the current elements is not larger than max.
				//we will do nothing but scan the next element.
				continue;
			}
		}
		return max;
		*/
		
		int max = Collections.max(ints);
		return max;
	}
	private int historyMin(ArrayList<Integer> ints) {
		
		/*
		
		//return the minimum number of the arrayList.
		//declare a integer to store the minimum number of the arrayList.
		int min = ints.get(0);
		for(int i = 1; i < ints.size(); i++) {
			if(min < ints.get(i)){
				//which means the current elements is smaller than min.
				//we need to change the value of min.
				min = ints.get(i);
			} else {
				//which means the current elements is larger than min.
				//we will do nothing but scan the next element.
				continue;
			}
		}
		return min;
		
		*/
		
		int min = Collections.min(ints);
		return min;
	}
}
