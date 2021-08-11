//17406번 배열 돌리기4.java
package com.ssafy.webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열_돌리기_4_17406 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String line;
	static StringTokenizer st;
	
	private static int N;
	private static int M;
	private static int K;
	private static int[][] arr;
	private static int[][] arrCopy;
	private static int r;
	private static int c;
	private static int s;
	private static int[] dI= {1,0,-1,0};
	private static int[] dJ= {0,1,0,-1};
	private static int[][] operation;
	private static int answer = Integer.MAX_VALUE;
	private static boolean[] isSelected;
	private static int[] permutation;
	
	public static void move(int r, int c, int s) {
		for(int count=0;count<s;count++) {
			int i=r-s-1+count;
			int j=c-s-1+count;
			int start=arr[i][j];
			int d=0;
			while(d<4) {
				int nextI = i+dI[d];
				int nextJ = j+dJ[d];
				if(r-s-1+count<=nextI && nextI<r+s-count && c-s-1+count<=nextJ && nextJ<c+s-count) {
					arr[i][j]=arr[nextI][nextJ];
					i = nextI;
					j = nextJ;
				}
				else d++;
			}
			arr[r-s-1+count][c-s-1+count+1] = start;
		}
	}
	public static int arrValue(int[][] arr) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			int temp=0;
			for(int j=0;j<arr[i].length;j++) {
				temp+=arr[i][j];
			}
			if(temp<min)min=temp;
		}
		return min;
	}
	public static void permutation(int cnt) {
		if(cnt==K) {
			for(int i=0;i<N;i++) {
				arr[i] = arrCopy[i].clone();
			}
			for(int i=0;i<K;i++) {
				r = operation[permutation[i]][0];
				c = operation[permutation[i]][1];
				s = operation[permutation[i]][2];
				move(r,c,s);
			}
			
			int temp = arrValue(arr);
			if(answer>temp)answer=temp;
			return;
		}
		for(int i=0;i<K;i++) {
			if(isSelected[i]==false) {
				isSelected[i]=true;
				permutation[cnt]=i;
				permutation(cnt+1);
				isSelected[i]=false;
				permutation[cnt]=0;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		line = br.readLine();
		st = new StringTokenizer(line, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		arrCopy = new int[N][M];
		operation = new int[K][3];
		isSelected = new boolean[K];
		permutation = new int[K];
		
		for(int i=0;i<N;i++) {
			line = br.readLine();
			st = new StringTokenizer(line, " ");
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				
			}
		}
		for(int i=0;i<N;i++) {
			arrCopy[i] = arr[i].clone();
		}
		
		for(int k=0;k<K;k++) {
			line = br.readLine();
			st = new StringTokenizer(line, " ");
			
			
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			operation[k][0]=r;
			operation[k][1]=c;
			operation[k][2]=s;
		}
		permutation(0);
		
		System.out.println(answer);
	}
}
