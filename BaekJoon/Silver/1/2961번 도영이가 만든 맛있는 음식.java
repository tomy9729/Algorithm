//2961번 도영이가 만든 맛있는 음식.java
package com.ssafy.webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가_만든_맛있는_음식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static long S;
    static long B;
    static long answer=Long.MAX_VALUE;
    static long[][] material;
    static int[] p;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		material = new long[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			material[i][0] = Long.parseLong(st.nextToken());
			material[i][1] = Long.parseLong(st.nextToken());
		}
		for(int r=1;r<=N;r++) {
			
			p = new int[N];
			for(int i=N-1;i>=N-r;i--)p[i]=1;
			
			do {
				S=1;
				B=0;
				for(int i=0;i<N;i++) {
					if(p[i]==1) {
						S *= material[i][0];
						B += material[i][1];
					}
				}
				long temp = (S<B) ? B-S : S-B;
				if(temp<answer)answer=temp;
			}while(np(p));
		}
		System.out.println(answer);
	}
	
	private static boolean np(int[] numbers) {
		int N = numbers.length;
		int i=N-1;
		while(i>0 && numbers[i-1]>=numbers[i])--i;
		
		if(i==0)return false;
		
		int j=N-1;
		while(numbers[i-1]>=numbers[j])--j;
		
		swap(numbers, i-1,j);
		
		int k=N-1;
		while(i<k) {
			swap(numbers,i++,k--);
		}
		
		return true;
	}
	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
