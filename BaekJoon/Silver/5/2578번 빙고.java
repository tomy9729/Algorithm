//2578번 빙고.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙고_2578 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int[][] bingo = new int[5][5];
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<5;j++) {
				bingo[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int count=0;
		out : for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<5;j++) {
				count++;
				if(checkBingo(bingo,Integer.parseInt(st.nextToken()))) {
					break out;
				}
			}
		}
		System.out.println(count);
		
	}
	public static boolean checkBingo(int[][] bingo, int num) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(bingo[i][j]==num)bingo[i][j]=0;
			}
		}
		
		int b=0;
		for(int i=0;i<5;i++) {
			int temp=0;
			for(int j=0;j<5;j++) {
				temp += bingo[i][j];
			}
			if(temp==0)b++;
		}
		for(int j=0;j<5;j++) {
			int temp=0;
			for(int i=0;i<5;i++) {
				temp += bingo[i][j];
			}
			if(temp==0)b++;
		}
		int temp;
		temp = bingo[0][0]+bingo[1][1]+bingo[2][2]+bingo[3][3]+bingo[4][4];
		if(temp==0)b++;
		temp=0;
		temp = bingo[0][4]+bingo[1][3]+bingo[2][2]+bingo[3][1]+bingo[4][0];
		if(temp==0)b++;
		
		if(b>=3)return true;
		return false;
	}
}
