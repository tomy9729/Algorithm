//4013. 특이한 자석.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class 특이한_자석_4013 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int K = Integer.parseInt(br.readLine());
			
			//(0,2)-(1,6)
			List<Deque<Integer>> magnet = new ArrayList<>();
			for(int i=0;i<4;i++) {
				magnet.add(new ArrayDeque<>());
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<8;j++) {
					magnet.get(i).addLast(Integer.parseInt(st.nextToken()));
				}
			}
			
			int[][] spin = new int[K][2];
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine()," ");
				spin[k][0] = Integer.parseInt(st.nextToken())-1;
				spin[k][1] = Integer.parseInt(st.nextToken());
				spinMagnut(spin[k], magnet, true, true);
			}

			int answer=0;
			for(int i=0;i<4;i++) {
				if(magnet.get(i).pollFirst()==1) {
					answer += Math.pow(2, i);
				}
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}
	
	static void spinMagnut(int[] magnetData,List<Deque<Integer>> magnet, boolean left, boolean right) {		
		//현재 자석이 다른 자석을 돌리는지 확인
		int leftMagnet = magnetData[0]-1;
		boolean leftCheck = false;
		if(leftMagnet>=0) {
			if(magnet.get(leftMagnet).toString().charAt(7)+magnet.get(magnetData[0]).toString().charAt(19) == 97) {
				//왼쪽 자석 돌리기
				leftCheck=true;
			}
		}
		
		int rightMagnet = magnetData[0]+1;
		boolean rightCheck = false;
		if(rightMagnet<4) {
			if(magnet.get(rightMagnet).toString().charAt(19)+magnet.get(magnetData[0]).toString().charAt(7) == 97) {
				//오른쪽 자석 돌리기
				rightCheck=true;
			}
		}
		
		//현재 자석 돌리기
		if(magnetData[1]==1) {//시계방향
			int temp = magnet.get(magnetData[0]).pollLast();
			magnet.get(magnetData[0]).addFirst(temp);
		}
		else {
			int temp = magnet.get(magnetData[0]).pollFirst();
			magnet.get(magnetData[0]).addLast(temp);
		}
		
		//왼쪽 돌리기
		if(leftCheck && left) {
			spinMagnut(new int[]{leftMagnet, magnetData[1]*(-1)}, magnet,true,false);
		}
		//오른쪽 돌리기
		if(rightCheck && right) {
			spinMagnut(new int[]{rightMagnet, magnetData[1]*(-1)}, magnet,false,true);
		}
		
		
	}
	
}
