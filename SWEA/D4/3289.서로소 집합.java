//3289.서로소 집합.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로소_집합_3289 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n+1];
			for(int i=1;i<=n;i++)arr[i]=i;
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int o = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(o==0)union(arr,a,b);
				else if(o==1) {
					sb.append(sameSet(arr,a,b));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
    
    public static int findSet(int arr[],int x) {
    	if(x==arr[x]) return x;
    	else return arr[x]=findSet(arr,arr[x]);
    }
    public static void union(int[]arr, int a, int b) {
    	int x = findSet(arr,a);
    	int y = findSet(arr,b); 
    	if(x==y)return;
    	arr[y] = x;
    }
    public static int sameSet(int arr[],int a, int b) {
    	if(findSet(arr,a)==findSet(arr,b))return 1;
    	else return 0;
    }
}
