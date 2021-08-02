//1244번 스위치 켜고 끄기.java
package com.ssafy.daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스위치_켜고_끄기_1244 {
	private static int n;
	private static List<Integer> switches = new ArrayList();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line," ");
		switches.add(-1);
		for(int i=0;i<n;i++) {
			switches.add(Integer.parseInt(st.nextToken()));
		}
		int studentNum = Integer.parseInt(br.readLine());
		for(int i=0;i<studentNum;i++) {
			line = br.readLine();
			st = new StringTokenizer(line," ");
			int sex = Integer.parseInt(st.nextToken());
			int switchNum = Integer.parseInt(st.nextToken());
			
			if(sex==1) {
				boy(switchNum);
			}
			else {
				girl(switchNum,switchNum);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<switches.size();i++) {
			sb.append(switches.get(i)+" ");
			if(i%20==0)sb.append("\n");
		}
		System.out.print(sb.toString());
		
	}
	
	public static void boy(int num) {
		int temp = num;
		while(num<=n) {
			if(switches.get(num)==0)switches.set(num, 1);
			else switches.set(num, 0);
			
			num += temp;
		}
	}
	public static void girl(int numleft, int numright) {
		if(numleft==-1 || numright == n+1) {
			return;
		}
		if(switches.get(numleft)!=switches.get(numright)) {
			return;
		}
		if(switches.get(numleft)==switches.get(numright)) {
			if(switches.get(numleft)==0) {
				switches.set(numleft, 1);
				switches.set(numright, 1);
			}
			else {
				switches.set(numleft, 0);
				switches.set(numright, 0);
			}
			girl(numleft-1,numright+1);
		}
		
	}
}
