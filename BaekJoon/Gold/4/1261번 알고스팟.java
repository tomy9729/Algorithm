//1261번 알고스팟.java
package boj20211215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고스팟_1261 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static class point{
    	int i;
    	int j;
    	point(int i, int j){
    		this.i=i;
    		this.j=j;
    	}
    }
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			String line = br.readLine();
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(line.substring(j-1,j));
			}
		}
		int[][] visit = new int[N+1][M+1];
		bfs(map, visit, N, M);
		System.out.println(visit[N][M]-1);
	}
    
    static void bfs(int[][] map, int[][] visit, int N, int M) {
    	int[] di = {0,0,1,-1};
    	int[] dj = {1,-1,0,0};
    	visit[1][1]=1;
    	Queue<point> q = new LinkedList<point>();
    	q.add(new point(1,1));
    	
    	while(!q.isEmpty()) {
    		point now = q.poll();
    		for(int d=0;d<4;d++) {
    			int i=now.i+di[d];
    			int j=now.j+dj[d];
    			if(1<=i&&i<=N&&1<=j&&j<=M) {
    				if(map[i][j]==0) {
    					if(visit[i][j]==0 || visit[i][j] > visit[now.i][now.j]) {
    						visit[i][j] = visit[now.i][now.j];
    						q.add(new point(i,j));
    					}
    				}
    				else if(map[i][j]==1) {
    					if(visit[i][j]==0 || visit[i][j] > visit[now.i][now.j]+1) {
    						visit[i][j] = visit[now.i][now.j]+1;
    						q.add(new point(i,j));
    					}
    				}
    			}
    		}
    	}
    	
    }
}
