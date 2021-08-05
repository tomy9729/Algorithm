//1218. 괄호 짝짓기.java
package com.ssafy.webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_짝짓기_1218 {
	private static int T = 10;
	private static int N;
	private static Stack<Character> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			stack = new Stack<Character>();
			
			for(int i=0;i<N;i++) {
				if(stack.isEmpty()) stack.push(line.charAt(i));
				else {
					if((stack.peek()=='{' && line.charAt(i)=='}')||(stack.peek()=='[' && line.charAt(i)==']')||(stack.peek()=='(' && line.charAt(i)==')')||(stack.peek()=='<' && line.charAt(i)=='>')) 
						stack.pop();
					else stack.push(line.charAt(i));
				}
			}
			sb.append("#").append(t).append(" ");
			if(stack.isEmpty()) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
