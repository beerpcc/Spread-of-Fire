/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Color;
import java.util.ArrayList;
public class GUI extends JPanel {
	private JFrame frame;
	private JPanel panel;
	private int scw,rowcol;
	private Container contentPane;
	public GUI(){
		frame=new JFrame("Spread of Fire");
		scw=600;
		frame.setSize(scw,scw+10);
	    contentPane = frame.getContentPane();
	    JButton btn =new JButton("run");
		/*btn.setLocation(700,700);
		contentPane.add(btn);*/
		frame.setContentPane(contentPane);
		frame.show();
	}

	public void drawBlock(int r,ArrayList<ArrayList<Integer>> area){
		//f.repaint();
		contentPane.removeAll();
	   	contentPane.add(new Draw(r,scw,area));
	 	frame.setContentPane(contentPane);
	}
}