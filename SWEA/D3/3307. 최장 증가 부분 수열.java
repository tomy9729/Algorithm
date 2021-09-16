//3307. 최장 증가 부분 수열.java
package webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최장_증가_부분_수열_3307 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	 public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			int[] dp = new int[N+1];
			int answer=1;
			st = new StringTokenizer(br.readLine()," ");
			
			for(int i=1;i<=N;i++)arr[i] = Integer.parseInt(st.nextToken());
			
			for(int i=1;i<=N;i++) {
				dp[i]=1;
				for(int j=1;j<i;j++) {
					if(arr[j]<arr[i] && dp[i]<dp[j]+1) {
						dp[i] = dp[j]+1;
					}
				}
				if(dp[i]>answer)answer=dp[i];
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
}
