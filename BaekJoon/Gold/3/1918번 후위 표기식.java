//1918번 후위 표기식.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class 후위_표기식_1918 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		map.put("(", 0);
		map.put("+", 1);
		map.put("-", 1);
		map.put("*", 2);
		map.put("/", 2);
		String cal = br.readLine();
		String answer = change(cal);
		
		System.out.println(answer);
	}
	
	static String change(String cal) {
		Stack<String> symbol = new Stack<>();
		String answer = "";
		for(int i=0;i<cal.length();i++) {
			String now = cal.substring(i,i+1);
			if(now.equals("(")) {
				symbol.add("(");
			}
			else if(now.equals(")")) {
				while(!symbol.peek().equals("(")) {
					answer += symbol.pop();
				}
				symbol.pop();
			}
			else if(now.equals("+") || now.equals("-") || now.equals("*") || now.equals("/")) {
				if(symbol.isEmpty() || map.get(symbol.peek()) < map.get(now)) {
					symbol.add(now);
				}else if(map.get(symbol.peek()) >= map.get(now)) {
					while(!symbol.isEmpty() && map.get(symbol.peek())>=map.get(now)) {
						answer += symbol.pop();
					}
					symbol.add(now);
				}
			}
			else {
				answer += now;
			}
		}
		while(!symbol.isEmpty()) {
			answer += symbol.pop();
		}
		return answer;
	}
}
