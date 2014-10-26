

public class Forest {
    private double[][] probtree;
    private int[][] forest;
    private double prob = 0;
    double random;
    public Forest(int size,double prob) {
        this.prob = prob;
        forest = new int[size][size];
        probtree = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || j == 0 || i == forest.length - 1 || j == forest.length - 1) {
                    forest[i][j] = 0;
                    probtree[i][j] = randomProb();
                    
                } else if (i == forest.length / 2 && j == forest.length / 2) {
                    forest[i][j] = 2;
                    probtree[i][j] = randomProb();
                } else { 
                    forest[i][j] = 1;
                    probtree[i][j] = randomProb();
                }
            }
        }
    }

    public void printArr() {
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[i].length; j++) {
                System.out.print(forest[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void printProb(){
                for (int i = 0; i < probtree.length; i++) {
            for (int j = 0; j < probtree[i].length; j++) {
                System.out.print(probtree[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    public double randomProb() {
        random = Math.random();
        return random;
    }

    public void fireSpread() {
        for (int i = 1; i < forest.length-1; i++) {
            for (int j = 1; j < forest[i].length-1; j++) {
                if (forest[i][j] == 2) {
                    if(forest[i+1][j] == 1 && probtree[i+1][j] < prob){
                    forest[i+1][j] = 2;
                    
                    break;
                    }
                    if(forest[i-1][j] == 1 && probtree[i-1][j] < prob){
                    forest[i-1][j] =2;
                    break;
                    }if(forest[i][j+1] == 1 && probtree[i][j+1] < prob){
                        forest[i][j+1] = 2;
                        break;
                    }if(forest[i][j-1] == 1 && probtree[i][j-1] < prob){
                        forest[i][j-1] = 2;
                        break;
                    }
                }
                
            }
        }
    }
}
