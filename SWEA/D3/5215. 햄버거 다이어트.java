//5215. 햄버거 다이어트.java
package com.saffy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거_다이어트_5215 {
	private static int T;
	private static int N;
	private static int L;
	private static int[][] item;
	private static int[][] hamburger;
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
        	line = br.readLine();
        	st = new StringTokenizer(line," ");
        	N = Integer.parseInt(st.nextToken());
        	L = Integer.parseInt(st.nextToken());
        	item = new int[N+1][2];
        	hamburger = new int[N+1][L+1];
        	for(int i=1;i<=N;i++) {
        		line = br.readLine();
            	st = new StringTokenizer(line," ");
            	item[i][1] = Integer.parseInt(st.nextToken());
            	item[i][0] = Integer.parseInt(st.nextToken());
        	}
            for(int i=1;i<=N;i++)
            {
                int weight = item[i][0], val=item[i][1];
                for(int j=0;j<=L;j++)
                {
                    if(j<item[i][0]) hamburger[i][j]=hamburger[i-1][j];
                    else hamburger[i][j]=(hamburger[i-1][j] > hamburger[i-1][j-weight]+val) ? hamburger[i-1][j] : hamburger[i-1][j-weight]+val;
                 }
            }
            sb.append("#").append(t).append(" ").append(hamburger[N][L]).append("\n");
        }
        System.out.println(sb.toString());
	}
}
