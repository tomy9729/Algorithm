//1158번 요세푸스 문제.java
package com.ssafy.webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 요세푸스_문제_1158 {
	private static int N;
	private static int K;
	private static LinkedList<Integer> people = new LinkedList<Integer>();
	private static List<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		sb.append("<");
		for(int i=1;i<=N;i++) {
			people.add(i);
		}
		int index=0;
		while(!people.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				index++;
				if(index==people.size())index=0;
			}
			sb.append(people.remove(index)).append(", ");
			if(index==people.size())index=0;
		}
		sb.delete(sb.length()-2, sb.length()).append(">");
		System.out.println(sb.toString());
	}
}
