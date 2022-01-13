//1593번 문자 해독.java
package boj20220113;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 문자_해독_1593 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int g = Integer.parseInt(st.nextToken());
		int sLength = Integer.parseInt(st.nextToken());
		String W = br.readLine();
		String S = br.readLine();
		
		int count=0;
		int answer=0;
		HashMap<Character, Integer> max = new HashMap<>();
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<g;i++) {
			Character c = new Character(W.charAt(i));
			if(map.containsKey(c)) {
				max.put(c, max.get(c)+1);
			}
			else {
				max.put(c, 1);
				map.put(c, 0);
			}
		}
		
		Character head;
		Character tail;
		
		for(int i=0;i<sLength;i++) {
			if(i<g) {
				tail = new Character(S.charAt(i));
				if(map.containsKey(tail)) {
					count++;
					map.put(tail, map.get(tail)+1);
				}
			}
			else {
				//head삭제
				head = new Character(S.charAt(i-g));
				if(map.containsKey(head)) {
					count--;
					map.put(head, map.get(head)-1);
				}
				//tail추가
				tail = new Character(S.charAt(i));
				if(map.containsKey(tail)) {
					count++;
					map.put(tail, map.get(tail)+1);
				}
			}
			if(count==g) {
				boolean check = true;
				for(Character c : max.keySet()) {
					if(max.get(c)!=map.get(c)) {
						check=false;
						break;
					}
				}
				if(check) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}	
}
