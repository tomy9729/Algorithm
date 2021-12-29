//17070번 파이프 옮기기 1.java
package boj20211229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프_옮기기1_17070 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int count;
    
    static class point{
    	int i;
    	int j;
    	point(int i, int j){
    		this.i=i;
    		this.j=j;
    	}
		@Override
		public String toString() {
			return "point [i=" + i + ", j=" + j + "]";
		}
    	
    }
    static class pipe{
    	point head;
    	point tail;
    	pipe(point head, point tail){
    		this.head=head;
    		this.tail=tail;
    	}
		@Override
		public String toString() {
			return "pipe [head=" + head + ", tail=" + tail + "]";
		}
    	
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count=0;
		solution(new pipe(new point(1, 2), new point(1, 1)), N, house);
		System.out.println(count);
	}
    
    static void solution(pipe pipe, int N, int[][] house) {
    	if(pipe.head.i==N && pipe.head.j==N) {
    		count++;
    		return;
    	}
    	
    	int[] di = {0,1,1};
    	int[] dj = {1,0,1};
    	boolean[] check = new boolean[3];
    	
    	if(pipe.head.i == pipe.tail.i)check[0]=true;
    	if(pipe.head.j == pipe.tail.j)check[1]=true;
    	if(pipe.head.i-pipe.tail.i==1 && pipe.head.j-pipe.tail.j==1) {
    		check[0]=true;
    		check[1]=true;
    	}
    	check[2]=true;
    	
    	for(int d=0;d<3;d++) {
    		if(!check[d])continue;
    		int i = pipe.head.i+di[d];
    		int j = pipe.head.j+dj[d];
    		if(1<=i&&i<=N&&1<=j&&j<=N) {
    			if(d==2) {
    				if(house[i-1][j]==1 || house[i][j-1]==1) {
    					break;
    				}
    			}
    			if(house[i][j]==0) {
    				solution(new pipe(new point(i, j), pipe.head), N, house);
    			}
    		}
    	}
    }
}
