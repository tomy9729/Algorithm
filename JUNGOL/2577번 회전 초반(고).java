//2577번 회전 초반(고).java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 회전_초밥_고_2577 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		char[] susies = new char[d+1];
		int nowEat = 0;
		
		int[] plate = new int[N];
		Deque<Integer> q = new ArrayDeque<Integer>();
		for(int i=0;i<N;i++) {
			plate[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0;i<k;i++) {
			int susi = plate[i];
			if(susies[susi]++==0) {
				nowEat++;
			}
			q.add(susi);
		}
		
		for(int i=k;i<N+k;i++) {
			if(susies[c]==0) {
				if(answer < nowEat+1)
					answer = nowEat+1;
			}
			else {
				if(answer < nowEat)
					answer = nowEat;
			}
			
			//전에 먹은 초밥 중 제일 앞에 있는거
			int preSusi = q.poll();
			if(--susies[preSusi]==0) {
				nowEat--;
			}
			//새로 추가되는 초밥
			int susi = plate[(i)%N];
			if(susies[susi]++==0) {
				nowEat++;
			}
			q.add(susi);
		}
		
		System.out.println(answer);
	}
}
