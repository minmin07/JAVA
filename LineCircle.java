import java.awt.*;
import java.awt.event.*;
import java.math.*;
public class LineCircle extends Frame implements Runnable{
	final static double Pi=3.14;
	Thread t;
	public LineCircle() {
		t= new Thread(this);
		t.start();
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	public void run() {
		repaint();
	}
	public void paint(Graphics g) {
		int x,y;
		try {
			g.fillOval(200, 200,20 ,20);
			for( int t=0; t<=360;t+=10) {
				double angle= toRadian(t);
				x= 210+(int)(Math.cos(angle)*45);
				y= 210-(int)(Math.sin(angle)*45);
				g.drawLine(210, 210, x, y);
				Thread.sleep(200);
			}
			
		}catch(InterruptedException e){
			System.out.println("Thread Exiting");
		}
	}
	public static double toRadian(int angle) {
		double radian= (angle*Pi)/180;
		return radian;
	}
	public static void main(String args[]) {
		LineCircle cl= new LineCircle();
		cl.setTitle("Cirlce line");
		cl.setSize(400, 500);
		cl.setVisible(true);
	}
	

}