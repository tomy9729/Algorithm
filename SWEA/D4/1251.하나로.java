//1251.하나로.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하나로_1251 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			long[] I = new long[N];
			long[] J = new long[N];
			boolean[] visited = new boolean[N];
			double[] minEdge = new double[N];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) I[i] = Long.parseLong(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				J[j] = Long.parseLong(st.nextToken());
				minEdge[j] = Long.MAX_VALUE;
			}
			
			double E = Double.parseDouble(br.readLine());
			double result=0;
			minEdge[0]=0;
			result = prim(N,visited,minEdge,E,I,J,result);
			sb.append("#"+t+" "+Math.round(result)+"\n");
		}
		System.out.println(sb.toString());
	}
    public static double prim(int N,boolean[] visited, double[] minEdge,double E,long I[],long J[] ,double result) {
    	for(int i=0;i<N;i++) {
    		double min = Double.MAX_VALUE;
        	int minVertex = -1;
        	for(int j=0;j<N;j++) {
        		if(!visited[j] && min>minEdge[j]) {
        			min = minEdge[j];
        			minVertex = j;
        		}
        	}
        	visited[minVertex]=true;
        	result += min;
        	
        	for(int j=0;j<N;j++) {
        		double L = (I[minVertex]-I[j])*(I[minVertex]-I[j])+(J[minVertex]-J[j])*(J[minVertex]-J[j]);
        		if(!visited[j] && minEdge[j]>(E*L)) {
        			minEdge[j]=E*L;
        		}
        	}
    	}
    	return result;
    }
}
