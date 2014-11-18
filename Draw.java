/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public class Draw extends JPanel{
	private ArrayList<ArrayList<Integer>> forest;
	private int rowcol;
	private int screenwidth;
	private int blocksize;
	private boolean init;
	public Draw(int rc,int scw,ArrayList<ArrayList<Integer>> f){
		rowcol=rc;
		screenwidth=scw;
		forest=f;
		blocksize=screenwidth/rowcol;
		rowcol*=blocksize;
		init=false;
	}

	public Draw(boolean init){
		this.init=init;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(!init){
		    for (int i=0,l=0;i<rowcol ;i+=blocksize,l++ ) {
		    	for (int j=0,m=0;j<rowcol ;j+=blocksize,m++ ) {
		    		g.setColor(getColor(forest.get(l).get(m)));
		   			g.fillRect(i,j, blocksize, blocksize);
		    	}
		    }
		}else{
			g.setColor(Color.green);
			g.fillRect(blocksize,blocksize, screenwidth-blocksize,  screenwidth-blocksize);
		}
	}

	private Color getColor(int num){
		/*if(i==1){return Color.green;}
		else if(i==2){return Color.red;}
		else{return Color.yellow;}*/
		return num==1 ? Color.green : (num==2 ? Color.red : Color.yellow);
	}
}