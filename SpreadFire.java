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
    Forest fr;
    public SpreadFire(int areain,double probin,double probtreeborn){
        area=areain;
        prob=probin;
        probtreeborn = probtreeborn;
        fr=new Forest(area,prob,probtreeborn);
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
<<<<<<< HEAD
        int o=0;
        while(o++<1){
            fr.fireSpread();
            print("forest");
=======
        print("forest");
        while(fr.isBurning()){
        print("forest");    
	    fr.fireSpread();
>>>>>>> 5c86470efb556aebe1567ad848f9869f7a02cce2
        }
    }
}