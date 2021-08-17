//정올 1828. 냉장고.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class jungol_1828_냉장고 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static class Chemistry implements Comparable<Chemistry>{
		int x;
		int y;
		Chemistry(int x, int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(Chemistry o) {
			int value = this.x - o.x;
			if(value!=0)return value;
			return this.y-o.y;
		}
		
	}
	static Chemistry[] chemistries;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		chemistries = new Chemistry[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			chemistries[i] = new Chemistry(x,y);
		}
		
		Arrays.sort(chemistries);
		
		int count=1;
		int left=chemistries[0].x;
		int right=chemistries[0].y;
		
		for(int i=1;i<N;i++) {
			if(chemistries[i].x <= right) {
				left = chemistries[i].x;
				right = Math.min(right, chemistries[i].y);
			}
			else {
				count++;
				left = chemistries[i].x;
				right = chemistries[i].y;
			}
		}
		
		System.out.println(count);
	}
}
