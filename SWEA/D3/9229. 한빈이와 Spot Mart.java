//9229. 한빈이와 Spot Mart.java
package com.saffy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한빈이와_Spot_Mart_9229 {
	private static int T;
	private static int N;
	private static int M;
	private static int[] a;
	private static int[] snack=new int[2];
	private static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
        	line = br.readLine();
        	st = new StringTokenizer(line, " ");
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	a = new int[N];
        	line = br.readLine();
        	st = new StringTokenizer(line, " ");
        	for(int i=0;i<N;i++) {
        		a[i]=Integer.parseInt(st.nextToken());
        	}
        	max=-1;
        	C(0,0);
        	sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
	}
	public static void C(int cnt,int start) {
		if(cnt==2) {
			int temp = snack[0]+snack[1];
			if(temp > max && temp <= M)max=temp;
			return;
		}
		for(int i=start;i<N;i++) {
			snack[cnt]=a[i];
			C(cnt+1,i+1);
		}
	}
}	
