//2605번 줄 세우기.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 줄_세우기_2605 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)num[i]=Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> arr = new LinkedList<>();
		for(int i=0;i<N;i++) {
			arr.add(arr.size()-num[i], i+1);
		}
		for(int i=0;i<N;i++)sb.append(arr.get(i)+" ");
		System.out.println(sb.toString());
	}
}
