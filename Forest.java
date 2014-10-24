import java.util.Random;

public class Forest {

    private int[][] forest;
    private int prob = 0;
    Random ran;
    int random;
    public Forest(int size) {
        this.prob = prob;
        forest = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || j == 0 || i == forest.length - 1 || j == forest.length - 1) {
                    forest[i][j] = 0;
                } else if (i == forest.length / 2 && j == forest.length / 2) {
                    forest[i][j] = 2;
                } else {
                    forest[i][j] = 1;
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

    public int randomProb() {
        random = ran.nextInt(100) + 1;
        return random;
    }

    public void fireSpread() {
        for (int i = 1; i < forest.length-1; i++) {
            for (int j = 1; j < forest[i].length-1; j++) {
                if (forest[i][j] == 2) {
                    if(forest[i+1][j] == 1 && randomProb() < prob){
                    forest[i+1][j] = 2;
                    }
                    if(forest[i-1][j] == 1 && randomProb() < prob){
                    forest[i-1][j] =2;
                    }if(forest[i][j+1] == 1 && randomProb() < prob){
                        forest[i][j+1] = 2;
                    }if(forest[i][j-1] == 1 && randomProb() < prob){
                        forest[i][j-1] = 2;
                    }
                }
            }
        }
    }
}
