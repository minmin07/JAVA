import java.awt.*;
import java.awt.event.*;
public class AnCircle extends Frame implements Runnable{
	
	Thread t;
	public AnCircle() {
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
		int i=0;
		try {
			for( int r=10; r<=200; r+=10) {
				g.drawOval(200-i, 200-i, r, r);
				Thread.sleep(500);
				i+=5;
			}
		}catch(InterruptedException e){
			System.out.println("Thread Exiting");
		}
    }
	public static void main(String args[]) {
		AnCircle c= new AnCircle();
		c.setSize(400, 400);
		c.setTitle("Circle Animation");
		c.setVisible(true);
	}
}