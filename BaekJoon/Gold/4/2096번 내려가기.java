//2096번 내려가기.java
package boj20211212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내려가기_2096 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> lines = new ArrayList<>();
		
		lines.add(new int[3]);
		for(int i=0;i<N;i++) {
			int[] line = new int[3];
			st = new StringTokenizer(br.readLine()," ");
			line[0] = Integer.parseInt(st.nextToken());
			line[1] = Integer.parseInt(st.nextToken());
			line[2] = Integer.parseInt(st.nextToken());
			lines.add(line);
		}
		
		sb.append(getPoint(N, lines, true)+" "+getPoint(N, lines, false));
		System.out.println(sb.toString());
	}
    
    static int getPoint(int N, ArrayList<int[]> lines, boolean maxOrmin) {
    	//maxOrmin이 true면 최댓값, false면 최솟값
    	int check =1;
    	if(!maxOrmin)check*=-1;
    	ArrayList<int[]> savePoint = new ArrayList<>();
    	
    	savePoint.add(new int[3]);
		for(int i=1;i<=N;i++) {
			int[] point = new int[3];
			if(!maxOrmin)Arrays.fill(point, 100*N);
			savePoint.add(point);
		}
			
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<3;j++) {
				int start = Integer.max(0, j-1);
				int end = Integer.min(j+1, 2);
				for(int l=start;l<=end;l++) {
					if(savePoint.get(i)[l]*check < (savePoint.get(i-1)[j]+lines.get(i)[l])*check) {
						savePoint.get(i)[l] = savePoint.get(i-1)[j]+lines.get(i)[l];
					}
				}
			}
		}
		
		int[] result = savePoint.get(N);
		Arrays.sort(result);
		int answer;
		if(maxOrmin)answer= result[2];
		else answer= result[0];
		return answer;
    }
}
