//11559번 Puyo Puyo.java
package boj20211224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Puyo_Puyo_11559 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class point{
    	int x;
    	int y;
    	point(int x, int y){
    		this.x=x;
    		this.y=y;
    	}
    }
    
	public static void main(String[] args) throws IOException {
		String[][] field = new String[12][6];
		for(int i=0;i<12;i++) {
			String line = br.readLine();
			for(int j=0;j<6;j++) {
				field[i][j] = line.substring(j,j+1);
			}
		}
		game(field, 0);
	}
	
	static void game(String[][] field, int count) {
		boolean[][] visit = new boolean[12][6];
		boolean check = false;
		//삭제되는 뿌요뿌요 확인
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(!field[i][j].equals(".") && !visit[i][j]) {
					visit = bfs(field, visit, i, j);
				}
				if(!check && visit[i][j]) {
					check = true;
				}
			}
		}
		
		//뿌요뿌요 터짐 + 내려오기
		if(check) {
			//터짐+내려오기
			field=boomDown(visit, field);
			//다음 연쇄 시작
			game(field, count+1);
		}
		//더 이상 터질 뿌요 없음 -> 연쇄 종료
		else {
			System.out.println(count);
			return;
		}
		
	}
	
	static boolean[][] bfs(String[][] field, boolean[][] visit, int i, int j) {
		int[] di = {1,-1,0,0};
		int[] dj = {0,0,1,-1};
		
		boolean[][] visitCopy = new boolean[12][6];
		for(int x=0;x<12;x++) {
			for(int y=0;y<6;y++) {
				visitCopy[x][y] = visit[x][y];
			}
		}
		
		int count=0;
		String color = field[i][j];
		visit[i][j]=true;
		Queue<point> q = new LinkedList<point>(); 
		q.add(new point(i,j));
		
		while(!q.isEmpty()) {
			point now = q.poll();
			count++;
			for(int d=0;d<4;d++) {
				int nextI = now.x+di[d];
				int nextJ = now.y+dj[d];
				if(0<=nextI&&nextI<12&&0<=nextJ&&nextJ<6) {
					if(field[nextI][nextJ].equals(color) && !visit[nextI][nextJ]) {
						visit[nextI][nextJ] = true;
						q.add(new point(nextI, nextJ));
					}
				}
			}
		}
		if(count<4) {
			visit = visitCopy;
		}
		return visit;
	}
	
	static String[][] boomDown(boolean[][] visit, String[][] field) {
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(visit[i][j]) {
					field[i][j]=".";
				}
			}
		}
		
		for(int j=0;j<6;j++) {
			for(int i=11;i>=0;i--) {
				if(!".".equals(field[i][j])) {
					while(i+1<12 && field[i+1][j].equals(".")) {
						field[i+1][j]=field[i][j];
						field[i][j]=".";
						i++;
					}
				}
			}
		}
		return field;
	}
}
