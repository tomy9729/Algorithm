//17404번 RGB거리2.java
package boj20211216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리2_17404 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static final int MAX=1000*1000+1;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] RGB = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<3;j++)RGB[i][j]=Integer.parseInt(st.nextToken());
		}
		
		
		int min = MAX;
		
		for(int start=0;start<3;start++) {
			for(int i=0;i<3;i++) {
				//시작하는 집을 start로 고정
				if(start==i)dp[1][i]=RGB[1][i];
				else dp[1][i]=MAX;
			}
			//중간 과정
			for(int i=2;i<=N;i++) {
				dp[i][0] = RGB[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = RGB[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = RGB[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
			}
			//start를 제외한 수 중 가장 작은 수 선택
			for(int i=0;i<3;i++) {
				if(i!=start && min>dp[N][i]) {
					min = dp[N][i];
				}
			}
		}
		System.out.println(min);
		
	}
    
    
}
