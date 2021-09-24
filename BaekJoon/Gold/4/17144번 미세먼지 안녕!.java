//17144번 미세먼지 안녕!.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지_안녕_17144 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] house = new int[R][C];
		List<Integer> air = new ArrayList<>();
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<C;j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
				if(house[i][j]==-1)air.add(i);
			}
		}
		
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		for(int t=0;t<T;t++) {
			Queue<point> q = new LinkedList<point>();
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(house[i][j]>0) {
						q.add(new point(i,j));
					}
				}
			}

			//미세먼지 확산
			int[][] addDust = new int[R][C];
			while(!q.isEmpty()) {
				point now = q.poll();
				int dust = house[now.i][now.j]/5;
				int spreadCount = 0;
				
				for(int d=0;d<4;d++) {
					point next = new point(now.i+di[d],now.j+dj[d]);
					if(0<=next.i && next.i<R && 0<=next.j && next.j<C) {
						if(house[next.i][next.j]!=-1) {
							addDust[next.i][next.j]+=dust;
							spreadCount++;
						}
					}
				}
				addDust[now.i][now.j] -= dust*spreadCount;
			}
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					house[i][j] += addDust[i][j];
				}
			}
			
			
			//공기청정기 
			int airI;
			int airJ;
			//반시계
			airI = air.get(0);
			airJ = 0;
			
			for(;airI>=0;airI--) {
				if(house[airI][airJ]==-1)continue;
				if(house[airI+1][airJ]==-1)house[airI][airJ]=0;
				else {
					house[airI+1][airJ]=house[airI][airJ];
				}
			}
			airI +=1;
			
			for(;airJ<C;airJ++) {
				if(house[airI][airJ]==-1 || airJ==0)continue;
				if(house[airI][airJ-1]==-1)house[airI][airJ]=0;
				else {
					house[airI][airJ-1]=house[airI][airJ];
				}
			}
			
			airI+=1;
			airJ-=1;
			for(;airI<=air.get(0);airI++) {
				house[airI-1][airJ]=house[airI][airJ];
			}
			airI-=1;
			airJ-=1;
			for(;airJ>=1;airJ--) {
				house[airI][airJ+1]=house[airI][airJ];
				if(airJ==1)house[airI][airJ]=0;
			}
			//시계
			airI = air.get(1);
			airJ = 0;
			for(;airI<R;airI++) {
				if(house[airI][airJ]==-1)continue;
				if(house[airI-1][airJ]==-1)house[airI][airJ]=0;
				else {
					house[airI-1][airJ]=house[airI][airJ];
				}
			}
			
			airI-=1;
			for(;airJ<C;airJ++) {
				if(house[airI][airJ]==-1 || airJ==0)continue;
				if(house[airI][airJ-1]==-1)house[airI][airJ]=0;
				else {
					house[airI][airJ-1]=house[airI][airJ];
				}
			}
			
			airI-=1;
			airJ-=1;
			for(;airI>=air.get(1);airI--) {
				house[airI+1][airJ]=house[airI][airJ];
			}
			
			airI+=1;
			airJ-=1;
			for(;airJ>=1;airJ--) {
				house[airI][airJ+1]=house[airI][airJ];
				if(airJ==1)house[airI][airJ]=0;
			}
		}
		
		//남아있는 미세먼지의 양
		int answer = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				answer += house[i][j];
			}
		}
		answer+=2;
		System.out.println(answer);
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
