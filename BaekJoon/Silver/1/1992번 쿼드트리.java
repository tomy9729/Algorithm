//1992번 쿼드트리.java
package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쿼드트리_1992 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[][] video;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		String line;
		for(int i=0;i<N;i++) {
			line = br.readLine();
			for(int j=0;j<N;j++) {
				video[i][j] = line.charAt(j)-'0';
			}
		}
		quadtree(video);
		System.out.println(sb.toString());
	}
	public static void quadtree(int[][] video) {
		
		int check=0;
		for(int i=0;i<video.length;i++) {
			for(int j=0;j<video[i].length;j++) {
				check+=video[i][j];
			}
		}
		if(check==0)sb.append(0);
		else if(check==video.length*video.length)sb.append(1);
		else {
			int arr[][][] = new int[4][video.length/2][video.length/2];
			for(int i=0;i<video.length/2;i++) {
				for(int j=0;j<video.length/2;j++) {
					arr[0][i][j] = video[i][j];
				}
			}
			for(int i=0;i<video.length/2;i++) {
				for(int j=video.length/2;j<video.length;j++) {
					arr[1][i][j%(video.length/2)] = video[i][j];
				}
			}
			for(int i=video.length/2;i<video.length;i++) {
				for(int j=0;j<video.length/2;j++) {
					arr[2][i%(video.length/2)][j] = video[i][j];
				}
			}
			for(int i=video.length/2;i<video.length;i++) {
				for(int j=video.length/2;j<video.length;j++) {
					arr[3][i%(video.length/2)][j%(video.length/2)] = video[i][j];
				}
			}
			sb.append("(");
			quadtree(arr[0]);
			quadtree(arr[1]);
			quadtree(arr[2]);
			quadtree(arr[3]);
			sb.append(")");
		}
		
	}
}
