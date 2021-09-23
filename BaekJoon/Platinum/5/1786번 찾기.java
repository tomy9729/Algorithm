//1786번 찾기.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 찾기_1786 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] pi;
	static String T;
	static String P;
	static int result;
	public static void main(String[] args) throws IOException {
		T = br.readLine();
		P = br.readLine();
		pi = new int[P.length()];
		getPi();
		KMP();
		
		
	}
	static void getPi() {
		int j = 0;
		for (int i = 1; i < P.length(); i++) {
			// 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
			while(j > 0 && P.charAt(i) != P.charAt(j)){
				j = pi[j - 1];
			}
			// 맞는 경우
			if(P.charAt(i) == P.charAt(j)) {
				//i길이 문자열의 공통 길이는 j의 위치 + 1
				pi[i] = ++j;
			}
		}
	}
	
	static void KMP() {
		int j = 0;
		for (int i = 0; i < T.length(); i++) {
			// 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
			while(j > 0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			// 맞는 경우
			if(T.charAt(i) == P.charAt(j)) {
				if(j == P.length() - 1) {
					sb.append(i-j+1+" ");
					result++;
					j=pi[j];
				}
				//맞았지만 패턴이 끝나지 않았다면 j를 하나 증가
				else
					++j;
			}
		}
		System.out.println(result);
		System.out.println(sb.toString());
	}
}
