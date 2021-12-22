//10775번 공항.java
package boj20211222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 공항_10775 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int[] parent = new int[G+1];
		for(int i=0;i<=G;i++) {
			parent[i]=i;
		}
		
		int count=0;
		for(int i=0;i<P;i++) {
			int g = Integer.parseInt(br.readLine());
			int gate = find(g,parent);
			if(gate==0)break;
			count++;
			
			union(gate,gate-1,parent);
		}
		System.out.println(count);
	}
	
	static int find(int x, int[] parent) {
		if(x==parent[x]) {
			return x;
		}
		parent[x] = find(parent[x], parent);
		return parent[x];
	}
	static void union(int x, int y, int[] parent) {
		x = find(x,parent);
		y = find(y,parent);
		if(x!=y) {
			parent[x]=y;
		}
	}
}
