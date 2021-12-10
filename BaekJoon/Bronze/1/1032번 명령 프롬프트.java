//1032번 명령 프롬프트.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 명령_프롬프트_1032 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int size;
		List<String> file = new ArrayList<String>();
		for(int i=0;i<n;i++) {
			file.add(br.readLine());
		}
		String result = file.get(0);
		size = result.length();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<size;j++) {
				if(result.charAt(j)!=file.get(i).charAt(j)) {
					result = result.substring(0,j) + "?" + result.substring(j+1); 
				}
			}
		}
		System.out.println(result);
	}
}
