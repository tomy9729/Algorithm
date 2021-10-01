//17143번 낚시왕.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 낚시왕_17143 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int answer=0;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] area = new int[R+2][C+2];
		point king = new point(0,0);
		
		List<shark> sharks = new ArrayList<shark>();
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine()," ");
			point p = new point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharks.add(new shark(p, s, d, z));
		}
		int i=0;
		while(true) {
			i++;
			if(oneSecond(king, R, C, sharks)) {
				break;
			}
//			System.out.println(i);
//			System.out.println(king.j);
//			System.out.println("answer:"+answer);
//			for(int k=0;k<sharks.size();k++)
//				System.out.println(sharks.get(k).toString());
//			System.out.println();
		}
		System.out.println(answer);
	}
	static boolean oneSecond(point king, int R, int C, List<shark> sharks) {
		//낚시왕이 오른쪽으로 한 칸 이동
		king.j+=1;
		//오른쪽 끝으로 오면 종료
		if(king.j==C+1)
			return true;
		
		catchShark(king, sharks);
		moveShark(sharks, R, C);
		return false;
	}
	
	static void catchShark(point king, List<shark> sharks) {
		boolean isCatch = false;
		int index=0;
		int dis=1000;
		//잡을 상어 정하기
		for(int i=0;i<sharks.size();i++) {
			if(sharks.get(i).die)continue;
			if(sharks.get(i).p.j==king.j) {
				if(sharks.get(i).p.i<dis) {
					isCatch = true;
					dis = sharks.get(i).p.i;
					index = i;
				}
			}
		}
		//상어 잡기
		if(isCatch) {
			answer += sharks.get(index).z;
			sharks.get(index).die=true;
		}
	}
	
	static void moveShark(List<shark> sharks, int R, int C) {
		int[] di = {0,-1,1,0,0};
		int[] dj = {0,0,0,1,-1};
		Map<point,Integer> sharkDup = new HashMap<point, Integer>();
		
		for(int index = 0;index<sharks.size();index++) {
			if(sharks.get(index).die)continue;
			point nowShark = sharks.get(index).p;
			int d = sharks.get(index).d;
			int sharkDi = di[d];
			int sharkDj = dj[d];
			for(int move=0;move<sharks.get(index).s;move++) {
				int nextI = nowShark.i+sharkDi;
				int nextJ = nowShark.j+sharkDj;
				if(nextI==0||nextI==R+1||nextJ==0||nextJ==C+1) {
					sharkDi *= -1;
					sharkDj *= -1;
				}
				nowShark.i += sharkDi;
				nowShark.j += sharkDj;
			}
			sharks.get(index).p=nowShark;
			if(sharkDi==-1 && sharkDj==0)sharks.get(index).d=1;
			else if(sharkDi==1 && sharkDj==0)sharks.get(index).d=2;
			else if(sharkDi==0 && sharkDj==1)sharks.get(index).d=3;
			else if(sharkDi==0 && sharkDj==-1)sharks.get(index).d=4;
			
			if(!sharkDup.containsKey(nowShark)) {
				sharkDup.put(nowShark, index);
			}
			else {
				if(sharks.get(sharkDup.get(nowShark)).z > sharks.get(index).z) {
					sharks.get(index).die=true;
				}
				else {
					sharks.get((int)sharkDup.get(nowShark)).die=true;
					sharkDup.remove(nowShark);
					sharkDup.put(nowShark, index);
				}
			}
		}
	}
	
	
	static class point{
		int i;
		int j;
		point(int i, int j) {
			this.i=i;
			this.j=j;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			point other = (point) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "point [i=" + i + ", j=" + j + "]";
		}
		
	}
	static class shark{
		point p;
		boolean die=false;
		int s;
		int d;
		int z;
		shark(point p,int s,int d,int z){
			this.p=p;
			this.s=s;
			this.d=d;
			this.z=z;
		}
		@Override
		public String toString() {
			return "shark [p=" + p + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
	}
}
