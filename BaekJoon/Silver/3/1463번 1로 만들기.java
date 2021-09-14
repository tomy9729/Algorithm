//1463번 1로 만들기.java
package webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일로_만들기_1463 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1000001];
		dp[0]=-1;
		for(int i=1;i<N+1;i++) {
			if(dp[i]==0 || dp[i-1]+1 < dp[i]) {
				dp[i]=dp[i-1]+1;
			}
			if(i*2<1000001){
				if(dp[i*2]==0 || dp[i]+1 < dp[i*2])dp[i*2]=dp[i]+1;
			}
			if(i*3<1000001){
				if(dp[i*3]==0)dp[i*3]=dp[i]+1;
			}
		}
		//for(int i=0;i<N+1;i++)System.out.print(i+":"+dp[i]+" \n");
		
		System.out.println(dp[N]);
	}
}
