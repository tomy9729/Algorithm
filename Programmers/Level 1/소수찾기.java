//Level  1 소수찾기.java
import java.lang.Math;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] prime = new int[n+1];
        prime[0] = 1; //소수가 아니면 1, 소수면 0
        prime[1] = 1;
        
        for(int i=2;i<(int)(Math.sqrt(n)+1);i++){//에라테네스의 체
            int not_prime = i+i; //첫 숫자가 2라면 4부터 소수가 아님
            if(prime[i]==1)continue;
            while(not_prime <= n){
                prime[not_prime]=1;//첫 숫자의 배수들을 전부 소수가 아님
                not_prime +=i;
            }
        }
        for(int i=0;i<prime.length;i++){
            if(prime[i]==0){//prime 배열에서 0인 원소들의 개수 구하기
                answer++;
            }
        }
        return answer;
    }
}
