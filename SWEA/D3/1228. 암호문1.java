//1228. 암호문1.java
package com.saffy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 암호문1_1228 {
	private static int T=10;
	private static int N;
	private static int instructorNum;
	private static LinkedList<Integer> secret;
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        StringTokenizer st;
        StringTokenizer st2;
        for(int t=1;t<=T;t++) {
        	secret = new LinkedList<>();
        	N = Integer.parseInt(br.readLine());
        	line = br.readLine();
        	st = new StringTokenizer(line," ");
        	for(int i=0;i<N;i++) {
        		secret.addLast(Integer.parseInt(st.nextToken()));
        	}
        	instructorNum = Integer.parseInt(br.readLine());
        	line = br.readLine();
        	st = new StringTokenizer(line,"I");
        	for(int i=0;i<instructorNum;i++) {
        		st2 = new StringTokenizer(st.nextToken()," ");
        		int x = Integer.parseInt(st2.nextToken());
        		int y = Integer.parseInt(st2.nextToken());
        		for(int j=0;j<y;j++) {
        			secret.add(x++, Integer.parseInt(st2.nextToken()));
        		}
        	}
        	sb.append("#").append(t).append(" ");
        	for(int i=0;i<10;i++) {
        		sb.append(secret.get(i)).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb.toString());
	}
}
