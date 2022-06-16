//2021은 무엇이 특별할까?.java
package boj20211231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		boolean[] prime = new boolean[10501];
		List<Integer> primeNum = new ArrayList<Integer>();
		
		//false면 소수
		for(int i=2;i*i<=10500;i++) {
			if(!prime[i]) {
				primeNum.add(i);
				for(int j=i*i;j<=10500;j+=i) {
					prime[j]=true;
				}
			}
		}
		
		for(int i=0;i<primeNum.size()-1;i++) {
			int num = primeNum.get(i)*primeNum.get(i+1);
			if(num > N) {
				System.out.println(num);
				break;
			}
		}
	}
}
