import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Color;
public class Screen extends JPanel {
	private JFrame f;
	private JPanel panel;
	public Screen(int w,int h){
		f=new JFrame("Spread of Fire");
		f.setSize(600,600);
		f.setResizable(false);
		drawGrid(w,h);
		f.setLocation(5,5);
		//f.show();
	}

	public void drawGrid(int r,int c){
	    Container contentPane = f.getContentPane();
	    contentPane.add(new DrawGrid());
	 
	    f.show();
	}
}
