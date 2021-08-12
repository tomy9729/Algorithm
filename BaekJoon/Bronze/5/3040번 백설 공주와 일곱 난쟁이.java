//3040번 백설 공주와 일곱 난쟁이.java
package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백설공주와_일곱난쟁이_3040 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb; 
    
    static int[] smurf = new int[9];
    static int all = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int i=0;i<smurf.length;i++) {
			smurf[i] = Integer.parseInt(br.readLine());
			all += smurf[i];
		}
		
		int[] p = new int[9];
		for(int i=8;i>=7;i--)p[i]=1;
		do {
			sb = new StringBuilder();
			int temp=0;
			for(int i=0;i<9;i++) {
				if(p[i]==1) {
					temp += smurf[i];
				}
				else sb.append(smurf[i]+"\n");
			}
			if(all-temp==100) {
				System.out.println(sb.toString());
				break;
			}
		}while(np(p));
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
