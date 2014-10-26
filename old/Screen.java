import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Color;
import java.util.ArrayList;
public class Screen extends JPanel {
	private JFrame f;
	private JPanel panel;
	private int scw,rowcol;
	private Container contentPane;
	public Screen(){
		f=new JFrame("Spread of Fire");
		scw=600;
		f.setSize(scw,scw+10);
		//f.setResizable(false);
		
	    contentPane = f.getContentPane();
	    JButton btn =new JButton("run");
		btn.setLocation(700,700);
		contentPane.add(btn);
		//f.show();
		        f.setContentPane(contentPane);
	}

	public void drawGrid(int r,int c,ArrayList<ArrayList<Integer>> area){
		//f.repaint();
		//contentPane=new Container();
	   	contentPane.add(new DrawGrid(r,scw,area));
	 	f.setContentPane(contentPane);
	    f.show();
	}
}
