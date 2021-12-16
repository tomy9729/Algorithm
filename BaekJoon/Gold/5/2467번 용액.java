//2467번 용액.java
package boj20211216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액_2467 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int N = Integer.parseInt(br.readLine());
    	int[] liquid = new int[N];
    	st = new StringTokenizer(br.readLine()," ");
    	for(int i=0;i<N;i++) {
    		liquid[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int result = 1999999999;
    	int left = 0;
    	int right = N-1;
    	int answer1=0;
    	int answer2=0;
    	
    	while(left<right) {
    		if(Math.abs(liquid[left]+liquid[right]) <= result) {
    			answer1 = liquid[left];
    			answer2 = liquid[right];
    			result=Math.abs(liquid[left]+liquid[right]);
    		}
    		if(Math.abs(liquid[left+1]+liquid[right]) < Math.abs(liquid[left]+liquid[right-1])) {
    			left++;
    		}
    		else right--;
    	}
    	System.out.println(answer1+" "+answer2);
	}
}
