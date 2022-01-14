//17609번 회문.java
package boj20220114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회문_17609 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			String str = br.readLine();
			int head=0;
			int tail=str.length()-1;
			int answer=0;
			while(head<tail) {
				//System.out.println(head+" "+tail+":"+answer);
				if(str.charAt(head)==str.charAt(tail)) {
					head++;
					tail--;
				}
				else if(isPalindrome(str.substring(head+1,tail+1))) {
					answer = 1;
					break;
				}
				else if(isPalindrome(str.substring(head,tail))) {
					answer = 1;
					break;
				}
				else {
					answer=2;
					break;
				}
				
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());
	}
    static public boolean isPalindrome(String str) {
    	int head =0;
    	int tail =str.length()-1;
    	
    	while(head<tail) {
    		if(str.charAt(head)==str.charAt(tail)) {
				head++;
				tail--;
			}
    		else return false;
    	}
    	return true;
    }
}
