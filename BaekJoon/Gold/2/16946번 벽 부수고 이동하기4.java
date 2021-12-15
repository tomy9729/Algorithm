//16946번 벽 부수고 이동하기4.java
package boj20211215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기4_16946 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Integer> hmap = new HashMap<>();
    static int groupId =1;
    
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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(line.substring(j,j+1));
			}
		}
		
		int[][] visit=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0 && visit[i][j]==0) {
					bfs(new point(i,j), map, visit, N, M);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					sb.append(0);
				}
				else {
					sb.append(getCount(new point(i,j), visit, N, M));
				}
			}
			sb.append("\n");
		}
		
//		System.out.println(Arrays.toString(visit[0]));
//		System.out.println(Arrays.toString(visit[1]));
//		System.out.println(Arrays.toString(visit[2]));
//		System.out.println(Arrays.toString(visit[3]));
		System.out.println(sb.toString());		
		
	}
    
    static int getCount(point p, int[][] visit, int N, int M) {
    	int[] di = {0,0,1,-1};
    	int[] dj = {1,-1,0,0};
    	int count=1;
    	HashSet<Integer> hset = new HashSet<>();
    	
    	for(int d=0;d<4;d++) {
    		int i=p.i+di[d];
    		int j=p.j+dj[d];
    		if(0<=i && i<N && 0<=j && j<M && visit[i][j]!=0) {
    			if(!hset.contains(visit[i][j])) {
    				count+=hmap.get(visit[i][j]);
    				hset.add(visit[i][j]);
    			}
    		}
    	}
    	return count%10;
    }
    
    static void bfs(point start, int[][] map, int[][] visit, int N, int M) {
    	int[] di = {0,0,1,-1};
    	int[] dj = {1,-1,0,0};
    	int count=0;
    	Queue<point> q = new LinkedList<point>();
    	q.add(start);
    	visit[start.i][start.j]=groupId;
    	
    	while(!q.isEmpty()) {
    		point now = q.poll();
    		count++;
    		for(int d=0;d<4;d++) {
    			int i = now.i+di[d];
    			int j = now.j+dj[d];
    			if(0<=i && i<N && 0<=j && j<M) {
    				if(visit[i][j]==0 && map[i][j]==0) {
    					visit[i][j]=groupId;
    					q.add(new point(i,j));
    				}
    			}
    		}
    	}
    	
    	hmap.put(groupId++, count);
    }
}
