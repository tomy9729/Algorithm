//4386번 별자리 만들기.java
package boj20211222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 별자리_만들기_4386 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class edge implements Comparable<edge>{
    	int from;
    	int to;
    	double val;
    	edge(int from, int to, double val){
    		this.from = from;
    		this.to = to;
    		this.val = val;
    	}
    	
		@Override
		public String toString() {
			return "edge [from=" + from + ", to=" + to + ", val=" + val + "]";
		}

		@Override
		public int compareTo(edge o) {
			return Double.compare(this.val, o.val);
		}
    	
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] parent = new int[n+1];
		double[][] node = new double[n+1][2];
		List<edge> edges = new ArrayList<edge>();
		
		for(int i=1;i<=n;i++) {
			parent[i]=i;
			st = new StringTokenizer(br.readLine()," ");
			node[i][0] = Double.parseDouble(st.nextToken());
			node[i][1] = Double.parseDouble(st.nextToken());
		}
		for(int i=1;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				double val = Math.sqrt((node[i][0]-node[j][0])*(node[i][0]-node[j][0])+(node[i][1]-node[j][1])*(node[i][1]-node[j][1]));
				edges.add(new edge(i, j, val));
			}
		}
		Collections.sort(edges);
		
		double answer=0;
		for(int i=0;i<edges.size();i++) {
			int from = find(edges.get(i).from, parent);
			int to = find(edges.get(i).to, parent);
			if(from!=to) {
				answer += edges.get(i).val;
				union(from, to, parent);
			}
		}
		System.out.println(answer);
	}
	
	static int find(int x, int[] parent) {
		if(x==parent[x]) {
			return x;
		}
		parent[x] = find(parent[x],parent);
		return parent[x];
	}
	
	static void union(int x, int y, int[] parent) {
		x = find(x, parent);
		y = find(y, parent);
		if(x>y)parent[x]=y;
		else parent[y]=x;
	}
}
