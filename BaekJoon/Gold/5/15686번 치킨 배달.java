//15686번 치킨 배달.java
package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨_배달_15686 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb; 
    
    static int N;
    static int M;
    static List<chicken> c = new ArrayList<chicken>();
    static List<home> h = new ArrayList<home>();
    static int[] p;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				String temp = st.nextToken();
				if(temp.equals("1")) {
					h.add(new home(i,j));
				}
				if(temp.equals("2")) {
					c.add(new chicken(i, j));
				}
			}
		}
		
		int chickenDistance = Integer.MAX_VALUE;
		for(int r=1;r<=M;r++) {
			//최대 M개 까지 치킨집 고르기
			p = new int[c.size()];
			for(int i=c.size()-1;i>=c.size()-r;i--)p[i]=1;
			//치킨집 i개일 때 치킨 거리
			do {
				//현재 선택한 치킨집에 대한 치킨 거리
				int nowchickenDistance = 0;
				for(int i=0;i<h.size();i++) {
					//각 집에서의 치킨 거리
					int hI = h.get(i).i;
					int hJ = h.get(i).j;
					int homechickenDistance=Integer.MAX_VALUE;
					for(int j=0;j<c.size();j++) {
						int cI = c.get(j).i;
						int cJ = c.get(j).j;
						if(p[j]==1) {
							int temp = Math.abs(hI-cI)+Math.abs(hJ-cJ);
							homechickenDistance = Math.min(homechickenDistance, temp);
						}
					}
					nowchickenDistance += homechickenDistance;
				}
				chickenDistance = Math.min(chickenDistance, nowchickenDistance);
			}while(np(p));
		}
		System.out.println(chickenDistance);
		
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

class chicken{
	int i;
	int j;
	chicken(int i, int j){
		this.i = i;
		this.j = j;
	}
}
class home{
	int i;
	int j;
	home(int i, int j){
		this.i = i;
		this.j = j;
	}
}

