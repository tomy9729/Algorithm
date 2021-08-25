//16236번 아기상어.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] area = new int[N][N];
		int babyI = 0;
		int babyJ = 0;
		int babySize = 2;
		int babyEat = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j]==9) {
					babyI = i;
					babyJ = j;
				}
			}
		}
		boolean visit[][] = new boolean[N][N];
		int time=0;
		
		while(true) {
			visit = new boolean[N][N];
			List<fish> fishes = bfs(area,visit,babyI,babyJ,babySize,N);
			area[babyI][babyJ]=0;
			if(fishes.isEmpty()) {
				break;
			}
			
			Collections.sort(fishes);
			fish babyEatFish = fishes.get(0);
			time += babyEatFish.time;
			area[babyEatFish.i][babyEatFish.j]=0;
			babyI=babyEatFish.i;
			babyJ=babyEatFish.j;
			area[babyI][babyJ]=9;
			babyEat++;
			if(babyEat==babySize) {
				babySize++;
				babyEat=0;
			}
		}
		System.out.println(time);
	}
    static class fish implements Comparable<fish>{
    	int i;
    	int j;
    	int time;
    	fish(int i, int j, int time){
    		this.i = i;
    		this.j = j;
    		this.time = time;
    	}
    	@Override
    	public int compareTo(fish o) {
    		int value = Integer.compare(this.i, o.i);
    		if(value!=0)return value;
    		return Integer.compare(this.j, o.j);
    	}
    }
    public static List<fish> bfs(int[][] area,boolean[][] visit, int babyI, int babyJ, int babySize, int n){
    	List<fish> eatFish = new ArrayList<fish>();
    	int[] dI = {0,0,1,-1};
    	int[] dJ = {1,-1,0,0};
    	visit[babyI][babyJ] = true;
    	Queue<fish> q = new LinkedList<fish>();
    	q.add(new fish(babyI,babyJ,0));
    	while(!q.isEmpty()) {
    		fish now = q.poll();
    		for(int index=0;index<4;index++) {
    			int nextI = now.i+dI[index];
    			int nextJ = now.j+dJ[index];
    			
    			if(0<=nextI && nextI<n && 0<=nextJ && nextJ<n) {
    				if(visit[nextI][nextJ]==false && 0<=area[nextI][nextJ] && area[nextI][nextJ]<=babySize) {
    					visit[nextI][nextJ]=true;
    					q.add(new fish(nextI,nextJ,now.time+1));
    					if(1<= area[nextI][nextJ] && area[nextI][nextJ]<babySize) {
    						if(eatFish.isEmpty() || eatFish.get(eatFish.size()-1).time == now.time+1) {
    							eatFish.add(new fish(nextI,nextJ,now.time+1));
    						}
    						else return eatFish;
    					}
    				}
    			}
    		}
    	}
    	return eatFish;
    }
}
