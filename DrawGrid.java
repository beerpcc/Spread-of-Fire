import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class DrawGrid extends JPanel{
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    g.setColor(Color.blue);
	   g.fillRect(0,0, 10, 10);
	    
	    
	}
}