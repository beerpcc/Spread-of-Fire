import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class DrawGrid extends JPanel{
	public void paintComponent(Graphics g){
<<<<<<< HEAD
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
=======
	    super.paintComponent(g);
	    g.setColor(Color.blue);
	   g.fillRect(0,0, 10, 10);
	    
	    
>>>>>>> parent of 08376db... GUI Visualization
	}
}