//17135번 캐슬 디펜스.java
package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 캐슬_디펜스_17135 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb; 
    
    static int N;
    static int M;
    static int D;
    
    static List<enemy> e = new ArrayList<enemy>();
    static List<archer> a = new ArrayList<archer>();
    static int p[];
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		List<enemy> eCopy = new ArrayList<enemy>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				if(st.nextToken().equals("1")) {
					e.add(new enemy(i, j));
					eCopy.add(new enemy(i, j));
				}
			}
		}
		
		p = new int[M];
		for(int i=M-1;i>=M-3;i--) {
			p[i]=1; //조합
		}
		
		do {//각각 궁수의 자리 -> 제거할 수 있는 적의 수를 구해야함
			int nowDieEnemyCount=0;
			a = new ArrayList<archer>();//궁수 위치 초기화
			e = new ArrayList<enemy>();//적 위치 초기화
			//e에 eCopy를 깊은 복사
			for(int i=0;i<eCopy.size();i++) e.add(new enemy(eCopy.get(i).i, eCopy.get(i).j));
			
			for(int i=0;i<M;i++) {
				if(p[i]==1) {//궁수의 위치 (N,i)
					a.add(new archer(N, i));
				}
			}//궁수 리스트에 궁수들 넣어줌
			
			//격자판에 적이 아무도 없을 때까지 수행
			while(!e.isEmpty()) {
				//제거할 수 있는 적의 수 구하기
				List<enemy> nowDie = new ArrayList<enemy>();
				for(int archerNum = 0;archerNum<3;archerNum++) {
					//죽일 수 있는 적 선택
					int minDis=Integer.MAX_VALUE;
					int eNum=-1;//죽이는 적의 번호
					int eLeft=M;//죽이는 적의 j좌표
					for(int enemyNum = 0;enemyNum<e.size();enemyNum++) {
						int dis = Math.abs(a.get(archerNum).i-e.get(enemyNum).i)+Math.abs(a.get(archerNum).j-e.get(enemyNum).j);
						if(dis<=D) {
							if(dis<minDis) {
								minDis = dis;
								eNum=enemyNum;
								eLeft = e.get(enemyNum).j;
							}
							else if(dis == minDis) {
								if(e.get(enemyNum).j < eLeft) {
									minDis = dis;
									eNum=enemyNum;
									eLeft = e.get(enemyNum).j;
								}
							}
						}
					}
					//죽이겔 될 적 선택 완료
					if(eNum!=-1) {
						nowDie.add(e.get(eNum));
					}
				}
				//적 죽이기
				for(int i=0;i<nowDie.size();i++) {
					for(int j=0;j<e.size();j++) {
						if(nowDie.get(i).i==e.get(j).i && nowDie.get(i).j==e.get(j).j) {
							e.remove(j);
							nowDieEnemyCount++;
						}
					}
				}
				//궁수 공격 완료 후 적들 한칸씩 아래로
				for(int i=0;i<e.size();i++) {
					if(e.get(i).i+1==N) {
						e.remove(i);
						i--;
					}
					else {
						e.get(i).i += 1;
					}
				}
			}
			answer = Math.max(answer, nowDieEnemyCount);
		}while(np(p));
		
		System.out.println(answer);
	}
	private static boolean np(int[] numbers) {
		int N = numbers.length;
		int i=N-1;
		while(i>0 && numbers[i-1]>=numbers[i])--i;
		
		if(i==0)return false;
		
		int j=N-1;
		while(numbers[i-1]>=numbers[j])--j;
		
		swap(numbers, i-1,j);
		
		int k=N-1;
		while(i<k) {
			swap(numbers,i++,k--);
		}
		
		return true;
	}
	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
}

class enemy{
	int i;
	int j;
	enemy(int i, int j){
		this.i = i;
		this.j = j;
	}
}
class archer{
	int i;
	int j;
	archer(int i, int j){
		this.i = i;
		this.j = j;
	}
}
