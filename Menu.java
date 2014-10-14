import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
public class Menu extends JPanel {
	private JFrame f;
	private JPanel panel;
	public Menu(){
		f=new JFrame("Spread of Fire");
		panel = new JPanel();
		f.setSize(200,400);
		f.setResizable(false);
		f.setVisible(true);
		f.setLocation(615,5);
		//drawGrid(5,5);
	}

	/*public void drawGrid(int r,int c){
		panel.setLayout(new GridLayout(3,2));
		panel.add(new JButton("Foo"));
		panel.add(new JButton("Foo"));
		panel.add(new JButton("Foo"));
		panel.add(new JButton("Foo"));
		f.add(panel);
	}

	public void paintComponent(Graphics g){
		int w=this.getWidth();
		int h=this.getHeight();
		g.drawLine(0, 0, 0, h); 
		g.drawLine(0, 0, w, 0); 
		g.drawLine(w, 0, w, h); 
		g.drawLine(0, h, w, h); 
	}*/
}