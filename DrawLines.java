import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawLines extends JPanel {
	
	public int depth = 6; //0 = one triangle, 7 is practical limit
	
	//ORIGINAL POINTS
	public int firstX1 = 50;
	public int firstY1 = 400;
	public int firstX2 = 250;
	public int firstY2 = 50;
	public int firstX3 = 450;
	public int firstY3 = 400;
	
	
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.drawLine(firstX1, firstY1, firstX2, firstY2);
		g.drawLine(firstX2, firstY2, firstX3, firstY3);
		g.drawLine(firstX3, firstY3, firstX1, firstY1);
		sierpinski(g, firstX1, firstY1, firstX2, firstY2, firstX3, firstY3, depth);
	}
	
	public void sierpinski(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int limit){
		if(limit > 0){
			//determines midpoints
			int midx1 = (x1 + x2) / 2; 
			int midy1 = (y1 + y2) / 2;
			int midx2 = (x2 + x3) / 2;
			int midy2 = (y2 + y3) / 2;
			int midx3 = (x1 + x3) / 2;
			int midy3 = (y1 + y3) / 2;
			
			//draws middle upside down triangle
			g.drawLine(midx1, midy1, midx2, midy2);
			g.drawLine(midx1, midy1, midx3, midy3);
			g.drawLine(midx2, midy2, midx3, midy3);
			
			
			
			//recursive calls
			sierpinski(g, midx1, midy1, x2, y2, midx2, midy2, limit - 1);
			sierpinski(g, x1, y1, midx1, midy1, midx3, midy3, limit - 1); 
			sierpinski(g, midx3, midy3, midx2, midy2, x3, y3, limit - 1);
		}
		
		
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Sierpinski's Triangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		frame.setSize(500, 500);
		
		DrawLines panel = new DrawLines();
		frame.add(panel);
		
		frame.setVisible(true);
	}
}
