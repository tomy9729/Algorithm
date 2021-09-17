//14502번 연구소.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int[][] mapTemp;
	static int answer=0;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mapTemp = new int[N][M];
		List<point> zero = new ArrayList<point>();
		List<point> virus = new ArrayList<point>();
		int val = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				val = Integer.parseInt(st.nextToken());
				if(val==0)zero.add(new point(i,j));
				else if(val==1)map[i][j]=1;
				else {
					virus.add(new point(i,j));
					map[i][j]=2;
				}
			}
		}
		
		int[] select = new int[3];
		selectPoint(0,0,zero,virus,select);
		System.out.println(answer);
	}
	public static void selectPoint(int start, int count, List<point> zero, List<point> virus,int[] select) {
		if(count==3) {
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[0].length;j++) {
					mapTemp[i][j] = map[i][j];
				}
			}
			boolean[][] visit = new boolean[map.length][map[0].length];
			for(int i=0;i<3;i++) {
				mapTemp[zero.get(select[i]).i][zero.get(select[i]).j]=1;
			}
			for(int i=0;i<virus.size();i++) {
				bfs(mapTemp,virus.get(i),visit);
			}
			
			int cnt=0;
			for(int i=0;i<mapTemp.length;i++) {
				for(int j=0;j<mapTemp[0].length;j++) {
					if(mapTemp[i][j]==0)cnt++;
				}
			}
						
			if(answer<cnt)answer = cnt;
			return;
		}
		for(int i=start;i<zero.size();i++) {
			select[count]=i;
			selectPoint(i+1,count+1,zero,virus,select);
		}
	}
	
	public static void bfs(int[][] mapTemp, point start, boolean[][] visit) {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		Queue<point> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			point now = q.poll();
			for(int d=0;d<4;d++) {
				point next = new point(now.i+dx[d], now.j+dy[d]);
				if(0<= next.i && next.i<mapTemp.length && 0<=next.j && next.j < mapTemp[0].length) {
					if(mapTemp[next.i][next.j]==0) {
						if(!visit[next.i][next.j]) {
							mapTemp[next.i][next.j]=2;
							q.add(next);
							visit[next.i][next.j]=true;
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
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			return "point [i=" + i + ", j=" + j + "]";
		}
	}
}
