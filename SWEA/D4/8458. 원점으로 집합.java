//8458. 원점으로 집합.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 원점으로_집합_8458 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			point[] points = new point[N];
			for(int n=0;n<N;n++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				points[n] = new point(i,j);
			}
			solution(points,t);
		}
		System.out.println(sb.toString());
	}
	static void solution(point[] points, int t) {
		int odd=0;
		int even=0;
		int max=0;
		for(int i=0;i<points.length;i++) {
			if(max<points[i].dis)max=points[i].dis;
			if(points[i].dis%2==0)even++;
			else odd++;
		}
		if(odd!=0 && even!=0) {
			sb.append("#"+t+" "+-1+"\n");
			return;
		}
		
		int moveCount=0;
		int i=0;
		while(true) {
			moveCount += i;
			if(moveCount>=max && (moveCount-max)%2==0) {
				sb.append("#"+t+" "+i+"\n");
				break;
			}
			i++;
		}
		
	}
	static class point{
		int i;
		int j;
		int dis;
		point(int i, int j){
			this.i=i;
			this.j=j;
			this.dis=Math.abs(i)+Math.abs(j);
		}
	}
}
