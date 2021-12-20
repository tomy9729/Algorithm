//9252번 LCS2.java
package boj20211220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class LCS2_9252 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		String str1 = br.readLine();
		String str2 = br.readLine();
		int[][] arr = new int[str1.length()+1][str2.length()+1];
		
		int index = 1;
		String answer = "";
		
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					arr[i][j] = Math.max(arr[i-1][j-1]+1,Math.max(arr[i-1][j], arr[i][j-1]) );
					
				}
				else {
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		sb.append(arr[str1.length()][str2.length()]+"\n");
		
		Stack<Character> stack = new Stack<>();
		int i =str1.length();
		int j =str2.length();
		while(arr[i][j]>0) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				stack.push(str1.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(arr[i-1][j]>arr[i][j-1]) {
					i--;
				}
				else j--;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	}
}
