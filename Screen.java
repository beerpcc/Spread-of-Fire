/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author win8
 */
import java.util.ArrayList;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
public class Screen extends javax.swing.JFrame {
    private JFrame frame;
    private JButton reset,startstop,step;
    private JTextField probburn,probtree,forestsize,probtreestartburn;
    private JLabel forestsizelabel,probburnlabel,probtreelabel,probtreestartburnlabel;
    private JComboBox delay;
    private Panel lpane,rpane,cpane,onepane,twopane,threepane,fourpane;
    private BorderLayout bl;
    private Draw dr1,dr2;
    private ArrayList<ArrayList<Integer>> lforest,rforest,forest;

    private boolean isstop;
    private Forest fr;
    public Screen() {
        fr=new Forest(600,0.8,0.1,0.8);
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
        lpane=new Panel();
        rpane=new Panel();
        cpane=new Panel();
        startstop=new JButton("Start");
        step=new JButton("Step");
        reset=new JButton("Reset");
        frame.setSize(850,645);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rpane.setPreferredSize(new Dimension(200, 0));

        onepane=new Panel();
        forestsizelabel=new JLabel("Forest size ");
        forestsizelabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        forestsize=new JTextField();
        forestsize.setColumns(5);
        onepane.add(forestsizelabel);
        onepane.add(forestsize);

        twopane=new Panel();
        probburnlabel=new JLabel("Burn Probability ");
        probburn=new JTextField();
        probburn.setColumns(5);
        twopane.add(probburnlabel);
        twopane.add(probburn);

        threepane=new Panel();
        probtreelabel=new JLabel("Tree Probability ");
        probtree=new JTextField();
        probtree.setColumns(5);
        threepane.add(probtreelabel);
        threepane.add(probtree);

        fourpane=new Panel();
        probtreestartburnlabel=new JLabel("Start Burn Probability ");
        probtreestartburn=new JTextField();
        probtreestartburn.setColumns(5);
        fourpane.add(probtreestartburnlabel);
        fourpane.add(probtreestartburn);


        bl= new BorderLayout(0, 0);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        //frame.getContentPane().add(button, BorderLayout.PAGE_START);
      
         
        
        /*button = new JButton("Button 3 (LINE_START)");
        frame.getContentPane().add(button, BorderLayout.LINE_START);*/
        
        /*button = new JButton("Long-Named Button 4 (PAGE_END)");
        frame.getContentPane().add(button, BorderLayout.PAGE_END);*/
        rpane.add(onepane);
        rpane.add(twopane);
        rpane.add(threepane);
        rpane.add(fourpane);
        rpane.add(startstop);
        rpane.add(step);
        rpane.add(reset);
        frame.getContentPane().add(rpane, BorderLayout.LINE_END);
        frame.repaint();
        frame.revalidate();


    }

    public void bindEvent(){
        //Bind Event
        startstop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                if(startstop.getText().equals("Start")){
                    (new Thread(new Runnable(){
                        @Override
                        public void run(){
                            /*fr.setSize(Integer.parseInt(forestsize.getText()));
                            fr.setProbBurn(Double.parseDouble(probburn.getText()));
                            fr.setProbTreeStartBurn(Double.parseDouble(probtreestartburn.getText()));
                            fr.setProbTree(Double.parseDouble(probtree.getText()));*/
                            initForest();
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
        dr1= new Draw(r,600,area,0);
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
        startstop.setText("Start");
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
            delay(5);
            reDraw();
        }
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

    public void delay(int ms){
        try{
            Thread.sleep(ms);
        }catch(Exception e){}
    }










}
