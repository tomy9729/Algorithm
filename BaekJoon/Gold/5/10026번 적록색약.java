//10026번 적록색약.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 적록색약_10026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				board[i][j]=line.charAt(j);
			}
		}
		boolean[][] visit = new boolean[N][N];
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					bfs(i,j,board,visit,N);
					count++;
				}
			}
		}
		System.out.print(count+" ");
		
		visit = new boolean[N][N];
		count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					bfs2(i,j,board,visit,N);
					count++;
				}
			}
		}
		System.out.print(count);
	}
    static class point{
    	int i;
    	int j;
    	point(int i, int j){
    		this.i=i;
    		this.j=j;
    	}
    }
    public static void bfs(int i,int j, char[][] board, boolean[][] visit, int N) {
    	int[] dI = {0,0,1,-1};
    	int[] dJ = {1,-1,0,0};
    	
    	visit[i][j]=true;
    	char color = board[i][j];
    	Queue<point> q = new LinkedList<point>();
    	q.add(new point(i,j));
    	while(!q.isEmpty()) {
    		point now = q.poll();
    		for(int d=0;d<4;d++) {
    			int nextI = now.i+dI[d];
    			int nextJ = now.j+dJ[d];
    			if(0<=nextI && nextI<N && 0<=nextJ && nextJ<N) {
    				if(!visit[nextI][nextJ]) {
    					if(board[nextI][nextJ]==color) {
    						visit[nextI][nextJ]=true;
    						q.add(new point(nextI, nextJ));
    					}
    				}
    			}
    		}
    	}
    }
    
    public static void bfs2(int i,int j, char[][] board, boolean[][] visit, int N) {
    	int[] dI = {0,0,1,-1};
    	int[] dJ = {1,-1,0,0};
    	
    	visit[i][j]=true;
    	char color = board[i][j];
    	String colors;
    	if(color=='R' || color=='G') {
    		colors ="RG";
    	}
    	else {
    		colors="BB";
    	}
    	Queue<point> q = new LinkedList<point>();
    	q.add(new point(i,j));
    	while(!q.isEmpty()) {
    		point now = q.poll();
    		for(int d=0;d<4;d++) {
    			int nextI = now.i+dI[d];
    			int nextJ = now.j+dJ[d];
    			if(0<=nextI && nextI<N && 0<=nextJ && nextJ<N) {
    				if(!visit[nextI][nextJ]) {
    					if(colors.charAt(0)==board[nextI][nextJ] || colors.charAt(1)==board[nextI][nextJ]) {
    						visit[nextI][nextJ]=true;
    						q.add(new point(nextI, nextJ));
    					}
    				}
    			}
    		}
    	}
    }
}
