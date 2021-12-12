//2502번 떡 먹는 호랑이.java
package boj20211212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떡_먹는_호랑이_2502 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[31];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=30;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		int A=1;
		int B;
		while(true) {
			if((K-dp[D-3]*A)%dp[D-2]==0) {
				B = (K-dp[D-3]*A)/dp[D-2];
				break;
			}
			A++;
		}
		System.out.println(A);
		System.out.println(B);
	}
}
