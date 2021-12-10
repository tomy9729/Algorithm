//15654번 N과 M(5).java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M5_15654 {
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
		backtracking(num, N, M, 0, new int[N], new boolean[N]);
		System.out.println(sb.toString());
	}
    static void backtracking(int[] num, int N, int M,int count, int[] arr, boolean[] visit) {
    	if(count==M) {
    		for(int i=0;i<M;i++)sb.append(arr[i]+" ");
    		sb.append("\n");
    		return;
    	}
    	for(int i=0;i<N;i++) {
    		if(!visit[i]) {
    			visit[i]=true;
    			arr[count] = num[i];
    			backtracking(num, N, M, count+1, arr, visit);
    			visit[i]=false;
    		}
    	}
    }
}
