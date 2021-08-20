//1223. 계산기.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 계산기2_1223 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static int N;
	static String line; 	
	static int answer;
	static Stack<Integer> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T=10;
		for(int t=1;t<=10;t++) {
			N = Integer.parseInt(br.readLine());
			line = br.readLine();
			stack = new Stack<>();
			answer=0;
			
			for(int i=0;i<N;i++) {
				if(line.charAt(i)=='*') {
					stack.push((stack.pop()*(line.charAt(i+1)-'0')));
					i++;
				}
				else if('0'<=line.charAt(i) && line.charAt(i)<='9') {
					stack.push(line.charAt(i)-'0');
				}
			}
			while(!stack.isEmpty()) {
				answer+=stack.pop();
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
}
