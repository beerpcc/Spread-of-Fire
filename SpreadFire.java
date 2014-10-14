import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
public class SpreadFire{
	private double prob=0.7;
	private int areaunit=50;
	private ArrayList<ArrayList<Integer>> area;
	private ArrayList<ArrayList<Double>> probTree;
	private ArrayList<Integer> burningi;
	private ArrayList<Integer> burningj;
	public SpreadFire(){
		burningi=new ArrayList<>();
		burningj=new ArrayList<>();
		area=new ArrayList<ArrayList<Integer>>();
		probTree=new ArrayList<ArrayList<Double>>();
	}

	public void init(){
		initArea();
		run();
		//print();
	}

	private void run(){
		randStartPoint();
		for(int i=0;i<80;i++){
			burn();
			print();
			System.out.println("-----------------------------");
		}
	}

	private void initArea(){
		for(int i=0;i<areaunit;i++){
			ArrayList<Integer> tmp=new ArrayList<>();
			ArrayList<Double> tmpProb=new ArrayList<>();
			for(int j=0;j<areaunit;j++){
				if(i==0 || j==0 || i==areaunit-1 || j==areaunit-1){
					tmp.add(0);
					tmpProb.add(Math.random());
				}else{
					tmp.add(1);
					tmpProb.add(Math.random());
				}
				
			}
			area.add(tmp);
			probTree.add(tmpProb);
		}
	}

	private void randStartPoint(){
		int range=((areaunit-2)-1)+1;
		area.get((int)((Math.random()*range)+1)).set((int)((Math.random()*range)+1),2);
	}

	public void print(){
		for (int i=0;i<area.size();i++ ) {
			for(int j=0;j<area.size();j++){
				System.out.print(area.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

	/**
	*To get Burning point
	*
	**/
	public void getBurning(){
		burningi.clear();
		burningj.clear();
		for(int i=1;i<areaunit-1;i++){
			for(int j=1;j<areaunit-1;j++){
				if(area.get(i).get(j)==2){
					burningi.add(i);
					burningj.add(j);
				}
			}
		}
	}



	public void burn(){
		getBurning();
		int i,j;
		for(int k=0 ;k<burningi.size();k++){
			i=burningi.get(k);
			j=burningj.get(k);
				if(area.get(i-1).get(j)==1){
					if(probTree.get(i-1).get(j)<prob){
						area.get(i-1).set(j,2);
					}
				}

				if(area.get(i+1).get(j)==1){
					if(probTree.get(i+1).get(j)<prob){
						area.get(i+1).set(j,2);
					}
				}

				if(area.get(i).get(j-1)==1){
					if(probTree.get(i).get(j-1)<prob){
						area.get(i).set(j-1,2);
					}
				}

				if(area.get(i).get(j+1)==1){
					if(probTree.get(i).get(j+1)<prob){
						area.get(i).set(j+1,2);
					}
				}
				//burn complete then set to 0
				area.get(i).set(j,0);
			
		}
	}

}