//1103번 게임.java
package boj20211216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임_1103 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int answer=0;
    static boolean check=false;
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] board = new String[N][M];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = line.substring(j,j+1);
			}
		}
		
		int[][] visit = new int[N][M];
		int[][] dp = new int[N][M];
		visit[0][0]=1;
		dfs(0, 0, visit, N, M, board,dp);
		
		if(check)System.out.println(-1);
		else System.out.println(answer-1);
	}
    
    static void dfs(int i, int j, int[][] visit, int N, int M, String[][] board, int[][] dp) {
    	int[] di= {0,0,1,-1};
    	int[] dj = {1,-1,0,0};
    	dp[i][j]=visit[i][j];
    	for(int d=0;d<4;d++) {
    		int n = Integer.parseInt(board[i][j]);
    		int nextI = i+di[d]*n;
    		int nextJ = j+dj[d]*n;
    		
    		if(answer<visit[i][j]+1) {
				answer = visit[i][j]+1;
			}
    		
    		if(0<=nextI&&nextI<N&&0<=nextJ&&nextJ<M) {
    			if(board[nextI][nextJ].equals("H")) {
    				if(answer<visit[i][j]+1) {
    					answer = visit[i][j]+1;
    				}
    			}
    			else if(visit[nextI][nextJ]==0) {
    				if(dp[nextI][nextJ]>visit[i][j])continue;
    				visit[nextI][nextJ] = visit[i][j]+1;
    				dfs(nextI, nextJ, visit, N, M, board,dp);
    				visit[nextI][nextJ] = 0;
    			}
    			else{
    				check=true;
    				return;
    			}
    		}
    		else if(answer<visit[i][j]+1) {
    			answer = visit[i][j]+1;
    		}
    	}
    }
}
