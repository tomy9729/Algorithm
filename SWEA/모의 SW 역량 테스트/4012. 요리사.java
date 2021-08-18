//4012. 요리사.java
package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 요리사_4012 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static int N;
	static int[][] synergy;
	static int answer; 
	static int[] select;
	static List<int[]> food;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			select = new int[N/2];
			food = new ArrayList<int[]>();
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Com(0,0);
			for(int k=0;k<food.size()/2;k++) {
				int[] A = food.get(k);
				int[] B = food.get(food.size()-k-1);
				int a=0;
				int b=0;
				for(int i=0;i<N/2;i++) {
					for(int j=0;j<N/2;j++) {
						a+=synergy[A[i]][A[j]];
						b+=synergy[B[i]][B[j]];
					}
				}
				answer = Math.min(answer, Math.abs(a-b));
			}
			
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void Com(int start, int size) {
		if(size==N/2) {
			int[] temp = select.clone();
			food.add(temp);
			return;
		}
		for(int i=start;i<N;i++) {
			select[size] = i;
			Com(i+1,size+1);
		}
	}

}
