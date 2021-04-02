//Level 1 약수의 합.java
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<n+1;i++){//1부터 n까지 모둔 수에 대하여
            if(n%i==0){//나눠지면
                answer+=i;//약수
            }
        }
        return answer;
    }
}
