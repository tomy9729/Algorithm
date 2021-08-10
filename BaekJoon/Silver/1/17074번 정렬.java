//17074번 정렬.java
package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정렬_17074 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr;
	
	public static int solution() {
		int hill=0;
		int index=0;
		for(int i=0;i<N-1;i++) {
			if(arr[i]>arr[i+1]) {
				index = i;
				hill++;
			}
		}
		if(hill==0)return N;
		if(hill==1) {
			if(index==0) {
				if(arr[index]<=arr[index+2])return 2;
				return 1;
			}
			if(index==N-2) {
				if(arr[index-1]<=arr[index+1])return 2;
				return 1;
			}
			int c=0;
			if(arr[index-1]<=arr[index+1])c++;
			if(arr[index]<=arr[index+2])c++;
			return c;
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution());
	}
}
