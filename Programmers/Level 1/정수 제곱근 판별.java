//Level 1 정수 제곱근 판별.java
import java.lang.Math;
class Solution {
    public long solution(long n) {
        long answer = 0;
        if(Math.sqrt(n)==(long)Math.sqrt(n)){
            answer = (long)(Math.sqrt(n)+1)*(long)(Math.sqrt(n)+1);
        }
        else answer=-1;
        return answer;
    }
}
