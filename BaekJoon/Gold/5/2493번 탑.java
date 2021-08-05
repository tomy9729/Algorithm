//2493번 탑.java
package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] top = new int[N+1];
		int[] signal = new int[N+1];
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line," ");
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=1;i<=N;i++) {
			top[i]=Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) {
				stack.push(i);
				signal[i]=0;
			}
			else {
				if(top[stack.peek()]<top[i]) {
					while(true) {
						if(stack.isEmpty())break;
						if(top[stack.peek()]>=top[i])break;
						if(top[stack.peek()]<top[i]) {
							stack.pop();
						}
					}
					if(stack.isEmpty()) {
						signal[i]=0;
						stack.push(i);
					}
					else {
						signal[i]=stack.peek();
						stack.push(i);
					}
				}
				else {
					signal[i]=stack.peek();
					stack.push(i);
				}
			}
			sb.append(signal[i]).append(" ");
		}
		System.out.println(sb.toString());
		
	}
}
