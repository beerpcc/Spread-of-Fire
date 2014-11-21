
import java.util.ArrayList;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.border.LineBorder;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Screen extends JFrame {
    private JFrame frame;
    private JButton reset,startstop,step;
    private JTextField probburn,probtree,forestsize,probtreestartburn;
    private JSlider setdelay = new JSlider(1, 20);
    private JComboBox probtreestartburnlabel;
    private JLabel forestsizelabel,probburnlabel,probtreelabel,delayL;
    private Panel rpane,cpane,onepane,twopane,threepane,fourpane,fivepane,sixpane,sevenpane;
    private BorderLayout bl;
    private Draw dr1,dr2;
    private ArrayList<ArrayList<Integer>> lforest,rforest,forest;

    private boolean isstop;
    private Forest fr;
    private int delayinterval;
    public Screen() {
        fr=new Forest(200,0.7,0.1,0.6);
        delayinterval=10;
        init();
        bindEvent();
        isstop=false;
    }

    public void initForest(){
        fr.reConstruct();
    }

    public void init(){
        lforest=new ArrayList<>();
        rforest=new ArrayList<>();
        frame=new JFrame("Spread of Fire");
        frame.setVisible(true);
        rpane=new Panel();
        rpane.setLayout(new GridLayout(10,1));
        cpane=new Panel();
        startstop=new JButton("Start");
        frame.getContentPane().setBackground(new Color(250,250,250));
        frame.setBackground(new Color(250,250,250));
        frame.setResizable(false);
        step=new JButton("Step");
        reset=new JButton("Reset");
        frame.setSize(950,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startstop.setFont(new Font("Segoe Print",Font.BOLD,18));
        startstop.setBackground(Color.BLACK);
        startstop.setForeground(Color.WHITE);

        step.setFont(new Font("Segoe Print",Font.BOLD,18));
        step.setBackground(Color.BLACK);
        step.setForeground(Color.WHITE);

        reset.setFont(new Font("Segoe Print",Font.BOLD,18));
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);

        onepane=new Panel(new FlowLayout(FlowLayout.RIGHT));
        forestsizelabel=new JLabel("Forest size ");
        forestsizelabel.setFont(new Font("Segoe Print",Font.BOLD,18));
        forestsizelabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        forestsize=new JTextField();
        forestsize.setText("200");
        forestsize.setFont(new Font("Segoe Print",Font.BOLD,18));
        forestsize.setColumns(3);
        forestsize.setBackground(new Color(153,255,255));
        onepane.add(forestsizelabel);
        onepane.add(forestsize);

        twopane=new Panel(new FlowLayout(FlowLayout.RIGHT));
        probburnlabel=new JLabel("Burn Probability ");
        probburnlabel.setFont(new Font("Segoe Print",Font.BOLD,18));
        probburn=new JTextField();
        probburn.setText("0.7");
        probburn.setFont(new Font("Segoe Print",Font.BOLD,18));
        probburn.setColumns(3);
        probburn.setBackground(new Color(153,255,255));
        twopane.add(probburnlabel);
        twopane.add(probburn);

        threepane=new Panel(new FlowLayout(FlowLayout.RIGHT));
        probtreelabel=new JLabel("Tree Probability ");
        probtreelabel.setFont(new Font("Segoe Print", Font.BOLD,18));
        probtree=new JTextField();
        probtree.setText("0.6");
        probtree.setFont(new Font("Segoe Print",Font.BOLD,18));
        probtree.setColumns(3);
        probtree.setBackground(new Color(153,255,255));
        threepane.add(probtreelabel);
        threepane.add(probtree);

        fourpane=new Panel(new FlowLayout(FlowLayout.RIGHT));
        probtreestartburnlabel=new JComboBox();
        probtreestartburnlabel.addItem("Start Burn Probability ");
        probtreestartburnlabel.addItem("Random burn point ");
        probtreestartburnlabel.setFont(new Font("Segoe Print",Font.BOLD,18));
        probtreestartburn=new JTextField();
        probtreestartburn.setText("0.1");
        probtreestartburn.setFont(new Font("Segoe Print",Font.BOLD,18));
        probtreestartburn.setColumns(3);
        probtreestartburn.setBackground(new Color(153,255,255));
        fourpane.add(probtreestartburnlabel);
        fourpane.add(probtreestartburn);

        //TODO
        fivepane=new Panel(new FlowLayout(FlowLayout.RIGHT));
        delayL=new JLabel("Delay ");
        delayL.setFont(new Font("Segoe Print",Font.BOLD,18));
        setdelay.setFont(new Font("Segoe Print",Font.BOLD,10));
        setdelay.setMajorTickSpacing(2);
        setdelay.setMinorTickSpacing(20);
        setdelay.setPaintTicks(true);
        setdelay.setPaintLabels(true);
        fivepane.add(delayL);
        fivepane.add(setdelay);
        
        sixpane = new Panel(new FlowLayout(FlowLayout.RIGHT));
        sixpane.add(startstop);
        sixpane.add(step);
        sixpane.add(reset);
        
        bl= new BorderLayout(0, 0);
        frame.getContentPane().setLayout(bl);
        
        //frame.getContentPane().add(button, BorderLayout.PAGE_START);
      
         
        
        /*button = new JButton("Button 3 (LINE_START)");
        frame.getContentPane().add(button, BorderLayout.LINE_START);*/
        
        /*button = new JButton("Long-Named Button 4 (PAGE_END)");
        frame.getContentPane().add(button, BorderLayout.PAGE_END);*/
        rpane.add(onepane);
        rpane.add(twopane);
        rpane.add(threepane);
        rpane.add(fourpane);
        rpane.add(fivepane);
        rpane.add(sixpane);
        frame.getContentPane().add(rpane, BorderLayout.LINE_END);
        frame.repaint();
        frame.revalidate();


    }

    public void bindEvent(){
        //Bind Event
        startstop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                if(startstop.getText().equals("Start")){
                    fr=new Forest(Integer.parseInt(forestsize.getText()),Double.parseDouble(probburn.getText()),Double.parseDouble(probtreestartburn.getText()),Double.parseDouble(probtree.getText()));
                            
                            //fr.assignTree(Double.parseDouble(probtree.getText()));
                            if(probtreestartburnlabel.getSelectedIndex()==0){
                                fr.assignFire(Double.parseDouble(probtreestartburn.getText()));
                            }else{
                                fr.randomStartBurn(Integer.parseInt(probtreestartburn.getText()));
                            }
                    (new Thread(new Runnable(){
                        @Override
                        public void run(){
                            /*fr.setSize(Integer.parseInt(forestsize.getText()));
                            fr.setProbBurn(Double.parseDouble(probburn.getText()));
                            fr.setProbTreeStartBurn(Double.parseDouble(probtreestartburn.getText()));
                            fr.setProbTree(Double.parseDouble(probtree.getText()));
                            fr.reConstruct();*/

                            
                            reset();
                            delayinterval = setdelay.getValue()*10;
                            burn();
                        }
                    })).start();
                    startstop.setText("Stop");
                    step.setEnabled(false);
                }else if(startstop.getText().equals("Stop")){
                    stop();
                    startstop.setText("Continue");
                    step.setEnabled(true);
                }else{
                     (new Thread(new Runnable(){
                        @Override
                        public void run(){
                            isstop=false;
                            burn();
                        }
                    })).start();
                    startstop.setText("Stop");
                    step.setEnabled(false);
                }

            }
        });

        step.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                step();
            }
        });

        reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                reset();
                startstop.setText("Start");
            }
        });

        setdelay.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                delayinterval = setdelay.getValue()*10;
            }
        });
    }

    public void splitForest(ArrayList<ArrayList<Integer>> forest){
        int sz=forest.size()/2;
        lforest.clear();
        rforest.clear();
        for(int i=0;i<forest.size();i++){
            if(i<sz){
                lforest.add(forest.get(i));
            }else{
                rforest.add(forest.get(i));
            }
        }

    }

    public void drawBlock(int r,ArrayList<ArrayList<Integer>> area){
        forest=area;
        splitForest(forest);
        /*dr1= new Draw(r,600,lforest,0);

        dr2= new Draw(r,600,rforest,0);
        cpane.add(dr1);
        cpane.add(dr2);*/
        dr1= new Draw(r,600,area);
        frame.getContentPane().add(dr1, BorderLayout.CENTER);
        /*try{Thread.sleep(10);}catch(Exception e){}
        frame.getContentPane().remove(dr1);*/
    }

    public void reDraw(){
        //splitForest(forest);
        dr1.reDrawBlock();
        //dr2.reDrawBlock();
        frame.revalidate();
    }

     public void print(String type){

        if(type.equals("forest")){
            ArrayList<ArrayList<Integer>> arrlst=fr.getForest();
        }else if(type.equals("probtree")){
            ArrayList<ArrayList<Double>> arrlst=fr.getProbTree();

        }

        for(int i=0;i<fr.getForest().size();i++){
           for(int j=0;j<fr.getForest().get(i).size();j++){
                System.out.print(fr.getForest().get(i).get(j)+" ");
            }
            System.out.println();
            
        }
        System.out.println();
        System.out.println();

    }

    public void reset(){
        //print("forest");
        stop();
        fr.reConstruct();
        drawBlock(fr.getSize(),fr.getForest());
        reDraw();
    }


    public void burn(){
        //print("forest");
        isstop=false;
        drawBlock(fr.getSize(),fr.getForest());
        System.out.println(fr.isBurning());
        while(fr.isBurning() && !isstop){
        //print("forest"); 
            fr.fireSpread(); 
            delay();
            reDraw();
        }
        if(!fr.isBurning()) {startstop.setText("Start");}

    }

    public void stop(){
        isstop=true;
    }



    public void step(){
        if(fr.isBurning()){
            fr.fireSpread();
            reDraw();
        }
    }

    public void delay(){
        try{
            Thread.sleep(delayinterval);
        }catch(Exception e){}
    }










}
