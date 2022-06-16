//16953번 A->B.java
package boj20211227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A_B_16953 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class num{
    	long num;
    	int count;
    	num(long num, int count){
    		this.num=num;
    		this.count=count;
    	}
    }
    
    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		bfs(A, B);
	}
    
    static void bfs(int A, int B) {
    	Queue<num> q = new LinkedList<num>();
    	q.add(new num(A,1));
    	
    	while(!q.isEmpty()){
    		num now = q.poll();
    		if(now.num==B) {
    			System.out.println(now.count);
    			return;
    		}
    		if(2*now.num<=B)q.add(new num(2*now.num,now.count+1));
    		if(now.num*10+1<=B)q.add(new num(now.num*10+1,now.count+1));
    	}
    	System.out.println(-1);
    }
}
