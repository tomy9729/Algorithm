//17472번 다리 만들기2.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class 다리_만들기2_17472 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//섬들 구하기
		List<island> islands = new ArrayList<island>();
		boolean[][] visit = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visit[i][j] && map[i][j]==1) {
					bfs(new point(i,j), map, visit, islands);
				}
			}
		}
		
		List<edge> edges = new ArrayList<>();
		//간선들 구하기
		for(int l1=0;l1<islands.size();l1++) {
			for(int l2=0;l2<islands.size();l2++) {
				if(l1!=l2) {
					for(point p1 : islands.get(l1).points) {
						for(point p2 : islands.get(l2).points) {
							boolean check = true;
							if(p1.i == p2.i) {
								int a,b;
								if(p1.j > p2.j) {
									a=p2.j;
									b=p1.j;
								}
								else {
									a=p1.j;
									b=p2.j;
								}
								int count=0;
								for(int x=a+1;x<b;x++) {
									if(map[p1.i][x]==1) {
										check=false;
										break;
									}
									count++;
								}
									
								if(check && count>=2)
									edges.add(new edge(l1,l2,count));
							}
							check=true;
							if(p1.j == p2.j) {
								int a,b;
								if(p1.i > p2.i) {
									a=p2.i;
									b=p1.i;
								}
								else {
									a=p1.i;
									b=p2.i;
								}
								int count=0;
								for(int x=a+1;x<b;x++) {
									if(map[x][p1.j]==1) {
										check=false;
										break;
									}
									count++;
								}
								if(check && count>=2)
									edges.add(new edge(l1,l2,count));
							}
						}
					}
				}
			}
		}
		
		boolean[][] isLink = new boolean[islands.size()][islands.size()];
		Collections.sort(edges);

		int from;
		int to;
		for(int i=0;i<edges.size();i++) {
			from = edges.get(i).from;
			to = edges.get(i).to;
			if(!isLink[from][to]) {
				isLink[from][to] = true;
			}
			else {
				edges.remove(i);
				i--;
			}
		}
		
		//최소 스패닝
		//정점 : 섬 islands
		//간선 : 다리 edges
		int answer=0;
		int count=0;
		PriorityQueue<edge> pq = new PriorityQueue<>();
		boolean[] visits = new boolean[islands.size()];
		pq.add(new edge(0,0,0));
		while(!pq.isEmpty()) {
			edge now = pq.poll();
						
			if(visits[now.to])continue;
			visits[now.to]=true;
			answer += now.distance;
			count++;
			if(count==islands.size())break;
			
			for(edge next : edges) {
				if(next.from == now.to) {
					if(visits[next.to])continue;
					pq.add(next);
				}
			}
		}
		
		if(answer==0 || count < islands.size())System.out.println(-1);
		else System.out.println(answer);
	}
	
		
	public static void bfs(point start, int[][] map, boolean[][] visit,List<island> islands) {
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		island newIsland = new island();
		Queue<point> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			point now = q.poll();
			newIsland.points.add(new point(now.i,now.j));
			for(int d=0;d<4;d++) {
				point next = new point(now.i+di[d],now.j+dj[d]);
				if(0<=next.i&&next.i<map.length&&0<=next.j&&next.j<map[0].length) {
					if(map[next.i][next.j]==1) {
						if(!visit[next.i][next.j]) {
							visit[next.i][next.j]=true;
							q.add(new point(next.i,next.j));
							
						}
					}
				}
			}
		}
		islands.add(newIsland);
	}
	
	
	static class island{
		List<point> points = new ArrayList<>();
		List<edge> edges = new ArrayList<>();
				
	}
	static class edge implements Comparable<edge>{
		int from;
		int to;
		int distance;
		edge(int from,int to,int distacne){
			this.from = from;
			this.to =to;
			this.distance=distacne;
		}
		
		@Override
		public int compareTo(edge o) {
			return Integer.compare(this.distance, o.distance);
		}
		
		@Override
		public String toString() {
			return "edge [from=" + from + ", to=" + to + ", distance=" + distance + "]";
		}
		
	}
	static class point{
		int i;
		int j;
		point(int i,int j){
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			return "point [i=" + i + ", j=" + j + "]";
		}
		
	}
}
