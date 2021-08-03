//1210. Ladder1.java
package com.ssafy.webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder1 {
	private static int[][] ladder = new int[100][100];
	private static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			br.readLine();
			int destI=0;
			int destJ=0;
			for(int i=0;i<100;i++) {
				String line = br.readLine();
				StringTokenizer st = new StringTokenizer(line," ");
				for(int j=0;j<100;j++) {
					ladder[i][j]=Integer.parseInt(st.nextToken());
					if(ladder[i][j]==2) {
						destI=i;
						destJ=j;
					}
				}
			}
			climbLadder(destI,destJ);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}System.out.println(sb.toString());
	}
	
	public static void climbLadder(int i,int j) {
		if(i==0) {
			answer = j;
			return;
		}
		if(checkRight(i,j)) while(checkRight(i,j)) j++;
		else if(checkLeft(i,j)) while(checkLeft(i,j)) j--;
		climbLadder(i-1,j);
	}
	
	public static boolean inLadder(int i,int j) {
		if(0<=i && i<100 && 0<=j && j<100) return true;
		else return false;
	}
	
	public static boolean checkLeft(int i,int j){
		if(inLadder(i, j-1)) {
			if(ladder[i][j-1]==1) return true;
			else return false;
		}else return false;
	}
	
	public static boolean checkRight(int i,int j){
		if(inLadder(i, j+1)) {
			if(ladder[i][j+1]==1) return true;
			else return false;
		}else return false;
	}
}
