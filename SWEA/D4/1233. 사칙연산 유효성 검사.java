//1233. 사칙연산 유효성 검사.java
package com.ssafy.webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사칙연산_유효성_검사_1233 {
	private static int T=10;
	private static int N;
	private static int lastIndex;
	private static String[] nodes;
	private static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			lastIndex = 0;
			nodes = new String[N+1];
			
			String line;
			StringTokenizer st;
			for(int i=1;i<=N;i++) {
				line = br.readLine();
				st = new StringTokenizer(line," ");
				st.nextToken();
				nodes[i]=st.nextToken();
				lastIndex++;
			}
			answer=1;
			dfsByPostOrder();
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
	public static void dfsByPostOrder() {
		dfsByPostOrder(1);		
	}
	private static void dfsByPostOrder(int current) {
		if(current*2<=lastIndex) {
			if(isInteger(nodes[current]))answer=0;
			dfsByPostOrder(current*2);
		}
		if(current*2+1<=lastIndex) {
			if(isInteger(nodes[current]))answer=0;
			dfsByPostOrder(current*2+1);
		}
		if(current*2>lastIndex && !isInteger(nodes[current])) answer=0;
	}
	
	private static boolean isInteger(String num) {
		for(int i=0;i<num.length();i++) {
			if(!Character.isDigit(num.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
