//1289. 원재의 메모리 복구하기.java
package com.ssafy.webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 원재의_메모리_복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int i=0;i<T;i++) {
			String target = in.readLine();
			char check='0';
			int count=0;
			for(int j=0;j<target.length();j++) {
				if(target.charAt(j)!=check) {
					count++;
					if(check=='0')check='1';
					else check='0';
				}
			}
			sb.append("#").append(i+1).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}
