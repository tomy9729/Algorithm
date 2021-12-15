//12100번 2048(Easy).java
package boj20211215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Easy2048_12100 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int answer=0;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move(0, board, N);
		System.out.println(answer);
	}
    
    static void move(int count, int[][] board, int N) {
    	//최대 5번 이동
    	if(count==5) {
    		//한 번 합쳐진 블록은 사라지지 않으므로 최댓값은 마지막에만 확인해도 상관없음
    		for(int i=0;i<N;i++) {
        		for(int j=0;j<N;j++) {
        			if(answer < board[i][j]) {
        				answer = board[i][j];
        			}
        		}
        	}
    		return;
    	}
    	
    	//4방향 상하좌우 어디로 이동시킬 것인지
    	int[] di= {1,-1,0,0};
    	int[] dj= {0,0,1,-1};
    	for(int d=0;d<4;d++) {
    		
    		//임시보드로 저장 - 이동 전 보드를 보존하기 위함
    		int[][] tempBoard = new int[N][N];
    		
    		for(int i=0;i<N;i++) {
    			for(int j=0;j<N;j++) {
    				tempBoard[i][j] = board[i][j];
    			}
    		}
    		
    		int k=0;
    		if(di[d]+dj[d]==-1)k=N-1;
    		for(int x=0;x<N;x++) {//각 줄마다 고려, 방향에 따라 가로줄, 세로줄, 방향이 바뀜
    			int[] temp = new int[N];
    			//각 줄만 뺴오기
    			//한줄씩 이동시키기 위해 방향에 따라 한 줄씩 temp배열에 저장
    			for(int y=0;y<N;y++) {
    				temp[y] = tempBoard[(y*di[d]+N+x*dj[d]+k)%N][(y*dj[d]+N+x*di[d]+k)%N];
    			}
    			//각 줄의 이동시키기
    			//이동 후 저장될 temp2 배열
    			int[] temp2=new int[N];
				int index=0;//놓여질 위치
				
				//0을 죄외한 숫자들 한 쪽으로 몰아놓기
				for(int i=0;i<N;i++) {
					if(temp[i]!=0) {
						temp2[index++]=temp[i];
					}
				}
				
				//같은 숫자가 연속되면 합치고, 연속되지 않으면 위치만 이동
				index=0;//다음 숫자가 위치할 index
				for(int i=0;i<N-1;i++) {
					if(temp2[i]==temp2[i+1]) {//연속된 숫자가 같다면
						temp2[index++]=temp2[i++]*2;//index위치에 2배한 값을 두기 + 뒤에 있는 숫자는 이미 합쳐졌으므로 i++
						temp2[i]=0;//뒤에 있는 숫자는 사라졌으므로 0으로 변환
					}
					else if(temp2[i]!=0){//연속되지 않았다면
						temp2[index++]=temp2[i];//위치만 이동
					}
				}
				temp2[index++]=temp2[N-1];//위 반복문에서 고려되지 못한 마지막 배열 위치 조정
				while(index<N) {//나머지는 0으로 채움
					temp2[index++]=0;
				}
    			for(int y=0;y<N;y++) {//temp2는 이동후 배열임 -> tempBoard에 temp2를 저장
    				tempBoard[(y*di[d]+N+x*dj[d]+k)%N][(y*dj[d]+N+x*di[d]+k)%N] = temp2[y];
    			}
    		}
    		//다음 이동으로 진행
    		move(count+1, tempBoard, N);
    	}
    }
    
}
