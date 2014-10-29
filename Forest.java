import java.util.ArrayList;
public class Forest {
    private ArrayList<ArrayList<Double>> probtree=new ArrayList<>();
    private ArrayList<ArrayList<Integer>> forest=new ArrayList<>();
    private ArrayList<Integer> tmpburni;//store burnning point i 
    private ArrayList<Integer> tmpburnj;//store burnning point j tmpburni.add(30);
    private double prob = 0;
    private double size = 0 ;
    double random;
    public Forest(int size,double prob) {
        tmpburni=new ArrayList<>();
        tmpburnj=new ArrayList<>();
        this.size = size;
        this.prob = prob;
        for (int i = 0; i < size; i++) {
        ArrayList<Double> tmpProb=new ArrayList<>();
        ArrayList<Integer> tmpForest=new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if(i == 0 || j == 0 || i == size - 1 || j == size - 1) {
                    //border
                    tmpForest.add(0);
                    tmpProb.add(randomProb());
                    
                }/*else if (i == size / 2 && j == size / 2) {
                    //assign center point is burning
                    tmpForest.add(2);
                    tmpburni.add(i);
                    tmpburnj.add(j);
                    tmpProb.add(randomProb());
                }*/else { 
                    //normal tree
                    tmpForest.add(1);
                    tmpProb.add(randomProb());
                }
            }
            probtree.add(tmpProb);
            forest.add(tmpForest);
        }
        randomStartBurn(2);
    }

    private void randomStartBurn(int c){
        // 0 0 0 0
        // 0 1 1 0
        // 0 1 1 0
        // 0 0 0 0
        for(int k=0;k<c;k++){
            double range = ((size-2) - 1) + 1;     
            int i=(int)(Math.random() * range) + 1;//between 1 to size-2
            int j=(int)(Math.random() * range) + 1;//
            forest.get(i).set(j,2);
        }

    }

    public boolean isBurning(){
        // if(tmpburni.size()!=0) return true;
         //   return false;
        return tmpburni.size()!=0;
    }

    public ArrayList<ArrayList<Integer>> getForest(){
        return forest;
    }

    public ArrayList<ArrayList<Double>> getProbTree(){
        return probtree;
    }

    public double randomProb() {
        random = Math.random();
        return random;
    }

    public void fireSpread() {
        ArrayList<Integer> tmpi=new ArrayList<>();
        ArrayList<Integer> tmpj=new ArrayList<>();
        for (int k = 0; k < tmpburni.size(); k++) {
            //for (int j = 1; j < forest.get(i).size()-1; j++) {
               // if (forest.get(i).get(j) == 2) {
                    int i=tmpburni.get(k);
                    int j=tmpburnj.get(k);

                    //RIGHT
                    if(forest.get(i+1).get(j) == 1 && probtree.get(i+1).get(j) < prob){
                        forest.get(i+1).set(j,2);//set burn to 2
                        tmpi.add(i+1);
                        tmpj.add(j);
                    }

                    //LEFT
                    if(forest.get(i-1).get(j) == 1 && probtree.get(i-1).get(j) < prob){
                        forest.get(i-1).set(j,2);
                        tmpi.add(i-1);
                        tmpj.add(j);
                    }

                    //TOP
                    if(forest.get(i).get(j+1) == 1 && probtree.get(i).get(j+1) < prob){
                        forest.get(i).set(j+1,2);
                        tmpi.add(i);
                        tmpj.add(j+1);
                    }

                    //BOTTOM
                    if(forest.get(i).get(j-1) == 1 && probtree.get(i).get(j-1) < prob){
                        forest.get(i).set(j-1,2);
                        tmpi.add(i);
                        tmpj.add(j-1);
                    }
                    //SET old 2 to 0
                    forest.get(i).set(j,0);
                //}
                
            //}
        }
        //assign new arraylist of point that has 2
        tmpburni=tmpi;
        tmpburnj=tmpj;


    }
}
