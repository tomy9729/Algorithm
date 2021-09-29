//4486번 녹색 옷 입은 애가 젤다지?.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색_옷_입은_애가_젤다지_4486 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[][] cave;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t=1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0)break;
			
			cave = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					cave[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] cost = new int[N][N];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					cost[i][j]=2000;
			dijkstra(new point(0,0,0),cost,cave);
			
			sb.append("Problem "+ t++ +": "+(cave[0][0]+cost[N-1][N-1])+"\n");
		}
		System.out.println(sb.toString());
	}
	static void dijkstra(point start, int[][] cost, int[][] cave) {
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		PriorityQueue<point> q = new PriorityQueue<>();
		cost[start.i][start.j]=0;
		q.add(start);
		while(!q.isEmpty()) {
			point now = q.poll();
			if(cost[now.i][now.j]<now.cost) {
				continue;
			}
			for(int d=0;d<4;d++) {
				int nextI = now.i+di[d];
				int nextJ = now.j+dj[d];
				if(0<=nextI && nextI<cost.length && 0<=nextJ && nextJ<cost.length) {
					int nextCost = now.cost+cave[nextI][nextJ];
					if(nextCost < cost[nextI][nextJ]) {
						cost[nextI][nextJ]=nextCost;
						q.add(new point(nextI,nextJ,nextCost));
					}
				}
			}
		}
	}
	static class point implements Comparable<point>{
		int i;
		int j;
		int cost;
		point(int i, int j, int cost){
			this.i=i;
			this.j=j;
			this.cost=cost;
		}
		@Override
		public int compareTo(point o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
}
