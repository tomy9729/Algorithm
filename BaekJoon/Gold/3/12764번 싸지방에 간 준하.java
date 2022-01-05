//12764번 싸지방에 간 준하.java
package boj20220105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 싸지방에_간_준하_12764 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class time implements Comparable<time>{
    	int P;
    	int Q;
    	time(int P, int Q){
    		this.P=P;
    		this.Q=Q;
    	}
		@Override
		public int compareTo(time o) {
			return Integer.compare(this.P, o.P);
		}
    }
    static class computer implements Comparable<computer>{
    	int Q;
    	int index;
    	computer(int Q, int index){
    		this.Q=Q;
    		this.index=index;
    	}
		@Override
		public int compareTo(computer o) {
			return Integer.compare(this.Q, o.Q);
		}
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<time> times = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			times.add(new time(P, Q));
		}
		
		PriorityQueue<computer> comEndTime = new PriorityQueue<>();
		PriorityQueue<Integer> nextCom = new PriorityQueue<>();
		int[] comIndex = new int[100001];
		int comCount=0;
		
		for(int i=0;i<N;i++) {
			while(!comEndTime.isEmpty() && times.peek().P > comEndTime.peek().Q) {
				nextCom.add(comEndTime.poll().index);
			}
			
			if(nextCom.isEmpty()) {
				comEndTime.add(new computer(times.poll().Q, comCount));
				comIndex[comCount]++;
				comCount++;
			}
			else {
				comEndTime.add(new computer(times.poll().Q, nextCom.peek()));
				comIndex[nextCom.poll()]++;
			}
		}
		
		sb.append(comCount+"\n");
		for(int i=0;i<comCount;i++) {
			sb.append(comIndex[i]+" ");
		}
		System.out.println(sb.toString());
	}
}
