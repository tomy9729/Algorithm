//1202번 보석 도둑.java
package boj20211214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석_도둑_1202 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class dia implements Comparable<dia>{
    	int M;
    	int V;
    	dia(int M, int V){
    		this.M = M;
    		this.V = V;
    	}
		@Override
		public int compareTo(dia o) {
			return Integer.compare(this.M, o.M);
		}
    }
    static class bag implements Comparable<bag>{
    	int C;
    	bag(int C){
    		this.C = C;
    	}
		@Override
		public int compareTo(bag o) {
			return Integer.compare(this.C, o.C);
		}
    }
    
    public static void main(String[] args) throws IOException {
    	long answer = 0;
    	
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dia[] diaes = new dia[N];
		int[] bags = new int[K];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			diaes[i] = new dia(M, V);
		}
		for(int i=0;i<K;i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(diaes);
		Arrays.sort(bags);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int d = 0;
		for(int i=0;i<K;i++) {
			for(int j=d;j<N;j++) {
				if(bags[i] >= diaes[j].M) {
					pq.add(-1*diaes[j].V);
					d++;
				}
				else break;
			}
			if(!pq.isEmpty()) {
				answer+=-1*pq.poll();
			}
		}
		
		System.out.println(answer);
	}
}
