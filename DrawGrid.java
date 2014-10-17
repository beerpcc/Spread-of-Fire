import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
public class DrawGrid extends JPanel{
	private int rowcol;
	private int screenwh;
	private int i;
	private int rsize;
	private ArrayList<ArrayList<Integer>> area;
	public DrawGrid(int rc,int scw,ArrayList<ArrayList<Integer>> a){
		rowcol=rc;
		screenwh=scw;
		area=a;
		i=0;
		rsize=screenwh/rowcol;
		rowcol*=rsize;
	}
	@Override
	public void paintComponent(Graphics g){
		    super.paintComponent(g);
		    for (int i=0,l=0;i<rowcol ;i+=rsize,l++ ) {
		    	for (int j=0,m=0;j<rowcol ;j+=rsize,m++ ) {
		    		g.setColor(getColor(area.get(l).get(m)));
		   			g.fillRect(i,j, rsize, rsize);
		    		//System.out.println(j);
		    		//sizej++;
		    	}
		    	//sizei++;
		    }
	}

	public Color getColor(int i){

		if(i==1){return Color.green;}
		else if(i==2){return Color.red;}
		else{return Color.yellow;}
	}
}