//14442번 벽 부수고 이동하기2.java
package boj20211215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기2_14442 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class position{
    	int i;
    	int j;
    	int wall;
    	position(int i, int j, int wall) {
			this.i=i;
			this.j=j;
			this.wall=wall;
		}
    }
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		int[][][] visit = new int[N+1][M+1][K+1];
		
		for(int i=1;i<=N;i++) {
			String line = br.readLine();
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(line.substring(j-1,j));
			}
		}
		
		bfs(map, visit, new position(1, 1, 0),N,M,K);
		int answer = Integer.MAX_VALUE;
		for(int i=0;i<=K;i++) {
			if(visit[N][M][i]!=0 && answer > visit[N][M][i]) {
				answer = visit[N][M][i];
			}
		}
		if(answer==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
    
    static void bfs(int[][]map, int[][][] visit, position start, int N, int M, int K) {
    	int[] di = {1,-1,0,0};
    	int[] dj = {0,0,1,-1};
    	Queue<position> q = new LinkedList<position>();
    	q.add(start);
    	visit[start.i][start.j][start.wall]=1;
    	while(!q.isEmpty()) {
    		position now = q.poll();
    		for(int d=0;d<4;d++) {
    			int i = now.i+di[d];
    			int j = now.j+dj[d];
    			int w = now.wall;
    			
    			if(1<=i && i<=N && 1<=j && j<=M) {
    				if(map[i][j]==0 && visit[i][j][w]==0) {
        				//벽이 아닌 경우
        				visit[i][j][w] = visit[now.i][now.j][now.wall]+1;
        				q.add(new position(i, j, w));
        			}
    				
        			if(map[i][j]==1 && w<K && visit[i][j][w+1]==0) {
        				//벽이지만 부술 수 있는 경우
        				visit[i][j][w+1] = visit[now.i][now.j][now.wall]+1;
        				q.add(new position(i, j, w+1));
        			}
    			}
    		}
    	}
    }
}
