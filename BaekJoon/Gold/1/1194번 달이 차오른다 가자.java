//1194번 달이 차오른다 가자.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이_차오른다_가자_1194 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int answer = -1;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] maze = new char[N][M];
		point start = new point(0,0,0,0);
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				maze[i][j]=line.charAt(j);
				if(maze[i][j]=='0') {
					start = new point(i,j,0,0);
					maze[i][j]='.';
				}
			}
		}
		
		boolean[][][] visit = new boolean[N][M][64];
		bfs(start, visit, maze, N, M);
		System.out.println(answer);
	}
	
	static void bfs(point start, boolean[][][] visit, char[][] maze, int N, int M) {
		int[] di= {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		Queue<point> q = new LinkedList<point>();
		q.add(start);
		
		while(!q.isEmpty()) {
			point now = q.poll();
			for(int d=0;d<4;d++) {
				int nextI = now.i+di[d];
				int nextJ = now.j+dj[d];
				
				if(0>nextI || nextI>=N || 0>nextJ || nextJ>=M)continue;//범위 벗어나면
				if(maze[nextI][nextJ]=='#')continue;//벽이면 
				if(visit[nextI][nextJ][now.key])continue;//이미 방문했으면
				
				//빈곳인 경우
				if(maze[nextI][nextJ]=='.') {
					visit[nextI][nextJ][now.key] = true;
					q.add(new point(nextI,nextJ,now.key,now.dis+1));
				}
				//열쇠가 있는 경우
				else if(0<=maze[nextI][nextJ]-'a' && maze[nextI][nextJ]-'a'<=7) {
					int nextKey = (1<<(maze[nextI][nextJ]-'a')) | now.key;
					if(!visit[nextI][nextJ][nextKey]) {
						visit[nextI][nextJ][nextKey] = true;
						q.add(new point(nextI,nextJ,nextKey,now.dis+1));
					}
				}
				//문이 있는 경우
				else if(0<=maze[nextI][nextJ]-'A' && maze[nextI][nextJ]-'A'<=7) {
					if(((1<<(maze[nextI][nextJ]-'A'))&now.key)>0) {
						visit[nextI][nextJ][now.key] = true;
						q.add(new point(nextI,nextJ,now.key,now.dis+1));
					}
				}
				//도착
				else if(maze[nextI][nextJ]=='1') {
					answer = now.dis+1;
					return;
				}
			}
		}
	}
	
	static class point{
		int i;
		int j;
		int key;
		int dis;
		point(int i, int j,int key, int dis){
			this.i=i;
			this.j=j;
			this.key=key;
			this.dis=dis;
		}
	}
}
