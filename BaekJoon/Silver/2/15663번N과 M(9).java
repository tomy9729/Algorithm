//15663번N과 M(9).java
package boj20211223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N과M9_15663 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		boolean[] visit = new boolean[N];
		HashSet<String> set = new HashSet<>();
		bt(0, N, M, visit, num, set, "");
		System.out.println(sb.toString());
	}
    
    static void bt(int count, int N, int M, boolean[] visit, int[] num, HashSet<String> set, String now) {
    	if(count==M) {
    		now = now.substring(1);
    		if(!set.contains(now)) {
    			sb.append(now+"\n");
    			set.add(now);
    		}
    	}
    	
    	for(int i=0;i<N;i++) {
    		if(!visit[i]) {
    			visit[i]=true;
    			bt(count+1, N, M, visit, num, set, now+" "+num[i]);
    			visit[i]=false;
    		}
    	}
    }
}
