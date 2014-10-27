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
public class SpreadFire {
    private int area;
    private int prob;
    Forest fr;
    public SpreadFire(int areain,int probin){
        area=areain;
        prob=probin;
        fr=new Forest(area,prob);
    }

    public void print(String type){
        for(int i=0;i<fr.get("forest").size();i++){
           for(int j=0;j<fr.get("forest").get(i).size();j++){
                System.out.print(fr.get("forest").get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}