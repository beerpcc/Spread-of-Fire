import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
class YAnswers extends JPanel{ 
	YAnswers(){ 
		int rows=10; 
		int cols=10; 
		setLayout(new GridLayout(rows,cols)); 
		boxes[] bx=new boxes[rows*cols]; 
		for(int i=0;i<rows*cols;i++){ 
			bx[i]=new boxes(); 
			if(i%2<1) 
				bx[i].setColor(1); 
			add(bx[i]); 
		} 
	} 
	public static void main(String[] args){ 
		JFrame jf=new JFrame(); 
		jf.setDefaultCloseOperation 
		(JFrame.EXIT_ON_CLOSE); 
		jf.add(new YAnswers()); 
		jf.pack(); 
		jf.setVisible(true); 
	} 
	class boxes extends JPanel 
	implements MouseListener{ 
		boolean clicked=false; 
		int color; 
		boxes(){ 
			color=0; 
			addMouseListener(this); 
		} 
		public void setColor(int color){ 
			this.color=color; 
		} 
		public void paintComponent(Graphics g){ 
			int width=this.getWidth(); 
			int height=this.getHeight(); 
			g.drawLine(0, 0, 0, height); 
			g.drawLine(0, 0, width, 0); 
			g.drawLine(width, 0, width, height); 
			g.drawLine(0, height, width, height); 

			if(clicked){ 
				if(color==1) 
					g.setColor(Color.black); 
				else 
					g.setColor(Color.white); 
				g.fillRect(0, 0, width, height); 
			} 
		} 

		public void mouseExited(MouseEvent me){} 
		public void mouseEntered(MouseEvent me){} 
		public void mouseReleased(MouseEvent me){} 
		public void mousePressed(MouseEvent me){ 
			clicked=true; 
			super.repaint(); 
		} 
		public void mouseClicked(MouseEvent me){} 
	} 

}
