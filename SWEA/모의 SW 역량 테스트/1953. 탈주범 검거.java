//1953. 탈주범 검거.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범_검거_1953 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] tunnel = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					tunnel[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] visit = new int[N][M];
			bfs(new point(R,C), tunnel, visit);
			
			int count=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(visit[i][j]<=L && visit[i][j]!=0 && tunnel[i][j]!=0)count++;
				}
			}
			sb.append("#"+t+" "+count+"\n");
			
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(point start, int[][] tunnel, int[][] visit) {
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		Map<Integer, int[]> map = new HashMap<>();
		map.put(1, new int[] {0,1,2,3});
		map.put(2, new int[] {2,3});
		map.put(3, new int[] {0,1});
		map.put(4, new int[] {0,3});
		map.put(5, new int[] {0,2});
		map.put(6, new int[] {1,2});
		map.put(7, new int[] {1,3});
		
		visit[start.i][start.j]=1;
		Queue<point> q = new LinkedList<point>();
		q.add(start);
		while(!q.isEmpty()) {
			point now = q.poll();
			int D = tunnel[now.i][now.j];
			for(int d=0;d<map.get(D).length;d++) {
				int nextI = now.i+di[map.get(D)[d]];
				int nextJ = now.j+dj[map.get(D)[d]];
				if(0<=nextI&&nextI<tunnel.length&&0<=nextJ&&nextJ<tunnel[0].length) {
					
					//구조물이 있는가 + 처음 방문하는가
					if(tunnel[nextI][nextJ]!=0 && visit[nextI][nextJ]==0) {
						//연결되어 있는가
						boolean check = false;
						int to = tunnel[nextI][nextJ];
						int nextD;
						if(map.get(D)[d]==0)nextD=1;
						else if(map.get(D)[d]==1)nextD=0;
						else if(map.get(D)[d]==2)nextD=3;
						else nextD=2;
						
						for(int k=0;k<map.get(to).length;k++) {
							if(map.get(to)[k]==nextD)
								check=true;
						}
						
						if(check){
							visit[nextI][nextJ]=visit[now.i][now.j]+1;
							q.add(new point(nextI,nextJ));
						}
					}
				}
			}
		}
	}
	
	static class point{
		int i;
		int j;
		point(int i, int j){
			this.i=i;
			this.j=j;
		}
	}
}
