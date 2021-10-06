//4014. 활주로 건설.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 활주로_건설_4014 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int[][] map1 = new int[N][N];
			int[][] map2 = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int temp = Integer.parseInt(st.nextToken());
					map1[i][j] = temp;
					map2[j][i] = temp;
				}
			}
			
			int answer = 0;
			for(int i=0;i<N;i++) {
				if(can(map1[i],X)) {
					answer++;
				}
				if(can(map2[i],X)) {
					answer++;
				}
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean can(int[] road, int X) {
		List<length> ls = new ArrayList<length>();
		int s=0;
		int h=road[0];
		
		for(int i=0;i<road.length;i++) {
			if(road[i]!=h) {
				ls.add(new length(s, i, h));
				s = i;
				h = road[i];
			}
			
			if(i == road.length-1) {
				ls.add(new length(s, i+1, h));
			}
		}
		
		for(int i=0;i<ls.size()-1;i++) {
			if(ls.get(i).height == ls.get(i+1).height+1 && ls.get(i+1).len>=X) {
				ls.get(i+1).len -= X;
			}
			else if(ls.get(i).height+1 == ls.get(i+1).height && ls.get(i).len>=X) {
				ls.get(i).len -= X;
			}
			else return false;
		}
		return true;
	}
	static class length{
		int start;
		int end;
		int len;
		int height;
		length(int start, int end, int height){
			this.start = start;
			this.end = end;
			this.len = end-start;
			this.height = height;
		}
		@Override
		public String toString() {
			return "length [start=" + start + ", end=" + end + ", height=" + height + "]";
		}
		
		
	}
}
