//2473번 세 용액.java
package boj20211221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세_용액_2473 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
    	long[] liquid = new long[N];
    	st = new StringTokenizer(br.readLine()," ");
    	for(int i=0;i<N;i++) {
    		liquid[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(liquid);
    	
    	long result = Long.MAX_VALUE;
    	long answer1=0;
    	long answer2=0;
    	long answer3=0;
    	
    	for(int i=0;i<N-2;i++) {
    		int left = i+1;
    		int right = N-1;
    		while(left<right) {
    			if(Math.abs(liquid[i]+liquid[left]+liquid[right]) < result) {
    				result = Math.abs(liquid[i]+liquid[left]+liquid[right]);
    				answer1 = liquid[i];
    				answer2 = liquid[left];
    				answer3 = liquid[right];
    			}
    			
    			if(Math.abs(liquid[i]+liquid[left+1]+liquid[right]) < Math.abs(liquid[i]+liquid[left]+liquid[right-1])) {
    				left++;
    			}
    			else right--;
    		}
    	}
    	
    	System.out.println(answer1+" "+answer2+" "+answer3);
	}
}
