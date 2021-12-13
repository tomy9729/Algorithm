//2166번 다각형의 면적.java
package boj20211213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다각형의_면적_2166 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		point[] points = new point[N+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			points[i] = new point(x, y);
		}
		points[N] = points[0];
		
		double two = 2.0;
		double sumX=0.0;
		double sumY=0.0;
		for(int i=0;i<N;i++) {
			sumX+= points[i].x*points[i+1].y;
			sumY+= points[i+1].x*points[i].y;
		}
		System.out.printf("%.1f",Math.abs(sumX-sumY)/two);
	}
    
    static class point{
    	double x;
    	double y;
    	point(double x, double y ){
    		this.x=x;
    		this.y=y;
    	}
    }
}
