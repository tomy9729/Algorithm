//Level 1 3진법 뒤집기.java
import java.lang.Math;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int x = 0; //3^x
        int square = 1; //3의 square제곱
        while(n>=square*3){
            square *= 3;
            x += 1;
        }
        int[] ternary = new int[x+1]; //3진법의 자릿수
        for(int i=0;i<ternary.length;i++){
            ternary[i] = n/square; //3진법으로 변환 및 저장
            n -= square*ternary[i]; //남은 n
            square /=3;
            answer += Math.pow(3,i)*ternary[i]; //접근하는 순서가 3진법을 뒤집은 것과 같기 때문에 곧바로 10진법으로 변환하여 answer에 더해줌
        }
        return answer;
    }
}
