import java.util.ArrayList;
public class Forest {
    private ArrayList<ArrayList<Double>> probtree=new ArrayList<>();
    private ArrayList<ArrayList<Integer>> forest=new ArrayList<>();
    private double prob = 0;
    double random;
    public Forest(int size,double prob) {
        this.prob = prob;
        for (int i = 0; i < size; i++) {
        ArrayList<Double> tmpProb=new ArrayList<>();
        ArrayList<Integer> tmpForest=new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (i == 0 || j == 0 || i == forest.size() - 1 || j == forest.size() - 1) {
                    //border
                    tmpForest.add(0);
                    tmpProb.add(randomProb());
                    
                } else if (i == forest.size() / 2 && j == forest.size() / 2) {
                    //assign center point is burning
                    tmpForest.add(2);
                    tmpProb.add(randomProb());
                } else { 
                    //normal tree
                    tmpForest.add(1);
                    tmpProb.add(randomProb());
                }
            }
            probtree.add(tmpProb);
            forest.add(tmpForest);
        }
    }

    public ArrayList get(String type){
        if(type.equals("forest")){
            return forest;
        }else if(type.equals("forest")){
            return probtree;
        }
    }

   /* public void printArr() {
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                System.out.print(forest.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public void printProb(){
                for (int i = 0; i < probtree.size(); i++) {
            for (int j = 0; j < probtree.get(i).size(); j++) {
                System.out.print(probtree.get(i).get(j) + " ");
            }
            System.out.println();
        }
        
    }*/

    //for get i j in arraylist
   /* public int getNum(int i,int j){

    }*/

    public double randomProb() {
        random = Math.random();
        return random;
    }

    public void fireSpread() {

        for (int i = 1; i < forest.size()-1; i++) {
            for (int j = 1; j < forest.get(i).size()-1; j++) {
                if (forest.get(i).get(j) == 2) {

                    if(forest.get(i+1).get(j) == 1 && probtree.get(i+1).get(j) < prob){
                        forest.get(i+1).set(j,2);
                    }

                    if(forest.get(i-1).get(j) == 1 && probtree.get(i-1).get(j) < prob){
                        forest.get(i-1).set(j,2);
                    }

                    if(forest.get(i).get(j+1) == 1 && probtree.get(i).get(j+1) < prob){
                        forest.get(i).set(j+1,2);
                    }

                    if(forest.get(i).get(j-1) == 1 && probtree.get(i).get(j-1) < prob){
                        forest.get(i).set(j-1,2);
                    }
                }
                
            }
        }
    }
}
