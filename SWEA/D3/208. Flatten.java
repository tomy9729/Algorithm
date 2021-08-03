//1208. Flatten.java
package com.ssafy.webex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Flatten {
	private static int dumpCount;
	//private static List<Integer> box; 
	private static int maxNum;
	private static int maxIndex;
	private static int minNum;
	private static int minIndex;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=10;i++) {
			dumpCount = Integer.parseInt(br.readLine());
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line," ");
			List<Integer> box = new ArrayList<>();
			
			for(int j=0;j<100;j++) {
				box.add(Integer.parseInt(st.nextToken()));
			}
			
			while(dumpCount-- >=0) {
				maxNum=0;
				maxIndex=0;
				minNum=101;
				minIndex=0;
				for(int j=0;j<100;j++) {
					if(box.get(j)>maxNum) {
						maxNum = box.get(j);
						maxIndex = j;
					}
					if(box.get(j)<minNum) {
						minNum = box.get(j);
						minIndex = j;
					}
				}
				//if(dumpCount==0)break;
				if(maxNum-minNum==0 || maxNum-minNum==1)break;
				box.set(maxIndex, maxNum-1);
				box.set(minIndex, minNum+1);
			}
			sb.append("#").append(i).append(" ").append(maxNum-minNum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
