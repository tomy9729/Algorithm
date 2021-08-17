//1074번 Z.java
package com.ssafy.divedeconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int r;
	static int c;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		while(N>0) {
			int mid = (int)Math.pow(2, N-1);
			if(mid > r && mid > c) {
				result+=0;
			}
			else if(mid > r && mid <= c) {
				result += mid*mid;
				c -= mid;
			}
			else if(mid <= r && mid > c) {
				result += mid*mid*2;
				r -= mid;
			}
			else if(mid <= r && mid <= c) {
				result += mid*mid*3;
				c -= mid;
				r -= mid;
			}
			N--;
		}
		
		System.out.println(result+c+r);
	}
}
