//12852번 1로 만들기2.java
package boj20211213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 일로_만들기2_12852 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int answerMin;
    static List<Integer> answerList;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		answerMin = 1000000;
		answerList = new ArrayList<>();
		
		dp[N]=1;
		List<Integer> arr = new ArrayList<>();
		
		bfs(N, arr, dp);
		
		sb.append(answerMin+"\n");
		sb.append(N+" ");
		for(int i=0;i<answerList.size();i++)sb.append(answerList.get(i)+" ");
		System.out.println(sb.toString());
		
	}
    
    static void bfs(int N, List<Integer> arr, int[] dp) {
    	if(N==1) {
    		if(answerMin > arr.size()) {
    			answerMin = arr.size();
    			answerList = new ArrayList<>();
    			for(int i=0;i<arr.size();i++)answerList.add(arr.get(i));
    		}
    		return;
    	}
    	if(N%3==0) {
    		if(dp[N/3]==0 || dp[N/3] > dp[N]+1) {
    			dp[N/3] = dp[N]+1;
    			arr.add(N/3);
    			bfs(N/3, arr, dp);
    			arr.remove(arr.size()-1);
    		}
    	}
    	if(N%2==0) {
    		if(dp[N/2]==0 || dp[N/2] > dp[N]+1) {
    			dp[N/2] = dp[N]+1;
    			arr.add(N/2);
    			bfs(N/2, arr, dp);
    			arr.remove(arr.size()-1);
    		}
    	}
    	if(dp[N-1]==0 || dp[N-1] > dp[N]+1) {
    		dp[N-1] = dp[N]+1;
    		arr.add(N-1);
    		bfs(N-1, arr, dp);
    		arr.remove(arr.size()-1);
    	}
    }
}
