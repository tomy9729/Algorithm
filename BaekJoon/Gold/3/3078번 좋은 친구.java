//3078번 좋은 친구.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 좋은_친구_3078 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		friend[] friends = new friend[N];
		
		for(int i=0;i<N;i++) {
			friends[i] = new friend(i, br.readLine().length());
		}
		
		long answer = 0;
		
		Arrays.sort(friends);
		
		Queue<friend> q = new LinkedList<friend>();
		
		//System.out.println(Arrays.toString(friends));
		for(int i=0;i<N;i++) {
			if(q.isEmpty()) {
				q.add(friends[i]);
			}else if(q.peek().name==friends[i].name && friends[i].rank-q.peek().rank <= K) {
				answer += q.size();
				q.add(friends[i]);
			}
			else {
				q.poll();
				i--;
			}
			
		}
		System.out.println(answer);
	}
    
    static class friend implements Comparable<friend>{
    	int rank;
    	int name;
    	
    	friend(int rank, int name) {
			this.rank = rank;
			this.name = name;
		}

		@Override
		public int compareTo(friend o) {
			if(Integer.compare(this.name, o.name)==0) {
				return Integer.compare(this.rank, o.rank);
			}
			return Integer.compare(this.name, o.name);
		}

		@Override
		public String toString() {
			return "friend [rank=" + rank + ", name=" + name + "]";
		}
    	
		
    }
}
