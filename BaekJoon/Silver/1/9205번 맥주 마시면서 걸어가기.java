//9205번 맥주 마시면서 걸어가기.java
package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 맥주_마시면서_걸어가기_9205 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static boolean check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			//맥주를 파는 편의점의 개수
			int n = Integer.parseInt(br.readLine());
			point[] points = new point[n+3];
			int[][] d = new int[n+3][n+3];
			for(int i=1;i<n+3;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				points[i] = new point(x,y);
			}
			for(int i=1;i<n+3;i++) {
				for(int j=1;j<n+3;j++) {
					if(i==j)continue;
					d[i][j] = Math.abs(points[i].x-points[j].x) + Math.abs(points[i].y-points[j].y);
					if(d[i][j]>1000)d[i][j] = 9999999;
				}
			}
			
			for(int k=1;k<n+3;k++) {//경유
				for(int i=1;i<n+3;i++) {//출발
					for(int j=1;j<n+3;j++) {//도착
						d[i][j] = Math.min(d[i][k]+d[k][j], d[i][j]);
					}
				}
			}
						
//			boolean[] visit = new boolean[n+3];
//			visit[1]=true;
//			check = false;
//			dfs(1,d,visit);
//			if(check)sb.append("happy\n");
//			else sb.append("sad\n");
			
			if(d[1][n+2]!=9999999)sb.append("happy\n");
			else sb.append("sad\n");
			
			
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int now, int[][] d, boolean[] visit) {
		if(check)return;
		if(now == d.length-1) {
			check = true;
			return;
		}
		
		for(int i=1;i<d.length;i++) {
			if(!visit[i]) {
				if(d[now][i]<=1000) {
					visit[i]=true;
					dfs(i,d,visit);
				}
			}
		}
	}
	static class point{
		int x;
		int y;
		point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
