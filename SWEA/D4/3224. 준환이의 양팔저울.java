//3224. 준환이의 양팔저울.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 준환이의_양팔저울_3234 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static int N;
	static int[] chu;
	static int answer;
	static boolean[] visit;
	static int[] chup;
	static int all;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			chu = new int[N];
			all=0;
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) {
				chu[i] = Integer.parseInt(st.nextToken());
				all+=chu[i];
			}
			answer=0;
			visit=new boolean[N];
			chup=new int[N];
			//scale(0,0,0,all,select);
			chuP(0);
			sb.append("#"+t+" "+answer+"\n");			
		}
		System.out.println(sb.toString());
	}
	public static void chuP(int cnt) {
		if(cnt==N) {
			scale(0,0,0);
			return;
		}
		for(int i=0;i<N;i++) {
			if(visit[i]==false) {
				visit[i]=true;
				chup[cnt]=chu[i];
				chuP(cnt+1);
				visit[i]=false;
			}
		}
	}
	public static void scale(int cnt, int left, int right) {
		if(right>all-right) return;
		if(left<right)return;

		if(cnt==N) {
			answer++;
			return;
		}
		scale(cnt+1,left+chup[cnt],right);//왼쪽 저울로 가는 경우
		scale(cnt+1,left,right+chup[cnt]);//오른쪽 저울로 가는 경우
		
	}
	
	public static int fac(int n) {
		if(n==0)return 1;
		int temp=1;
		for(int i=1;i<=n;i++) {
			temp *= i;
		}
		return temp;
	}
}
