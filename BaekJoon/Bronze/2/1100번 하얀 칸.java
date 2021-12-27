//1100번 하얀 칸.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하얀_칸_1100 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	int count=0;
		for(int i=0;i<8;i++) {
			String line = br.readLine();
			for(int j=0;j<8;j++) {
				if((i+j)%2==0 && line.charAt(j)=='F') {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
