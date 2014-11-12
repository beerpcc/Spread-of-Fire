/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
import java.util.Iterator;
import java.util.ArrayList;
public class SpreadFire {
    private int area;
    private double prob;
    private double probtreeborn;
    private Forest fr;
    private GUI g;
    private boolean pause;
    public SpreadFire(int areain,double probin,double probtreeborn){
        area=areain;
        prob=probin;
        probtreeborn = probtreeborn;
        fr=new Forest(area,prob,probtreeborn);
        g=new GUI();
        g.setVisible(true);
        pause=false;
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

    /*public void reset(){
        fr.build();
    }

    public void pause(){
        pause=true;
    }

    public void continue(){
        pause=false;
    }
*/
    public void burn(){
        //print("forest");
        g.drawBlock(area,fr.getForest());
        while(fr.isBurning() && !pause){
        //print("forest");  
            delay(10);
            fr.fireSpread();
            g.drawBlock(area,fr.getForest());
        }
    }

    public void step(){
        if(fr.isBurning()){
            fr.fireSpread();
            g.drawBlock(area,fr.getForest());
        }
    }

    public void delay(int ms){
        try{
            Thread.sleep(ms);
        }catch(Exception e){}
    }
}