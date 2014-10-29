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
    Forest fr;
    public SpreadFire(int areain,double probin){
        area=areain;
        prob=probin;
        fr=new Forest(area,prob);
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

    public void burn(){
        while(fr.isBurning()){
        print("forest");    
	fr.fireSpread();
        }
    }
}