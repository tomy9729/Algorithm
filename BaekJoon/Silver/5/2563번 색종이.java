//2563번 색종이.java
package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_2563 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] paper = new int[101][101];
	static int answer=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		for(int t=0;t<N;t++) {
			int i,j;
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			for(int x=i;x<i+10;x++) {
				for(int y=j;y<j+10;y++) {
					if(x<101 && y<101)paper[x][y]=1;
				}
			}
		}
		
		for(int i=1;i<=100;i++) {
			for(int j=1;j<=100;j++) {
				answer+=paper[i][j];
			}
		}
		System.out.println(answer);
	}
}
