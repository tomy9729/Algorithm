//Level 1 두 정수 사이의 합.java
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a > b){ //swap
            int temp = a;
            a = b;
            b = temp;
        }
        for(int i = a;i<=b;i++){
            answer += i;
        }
        return answer;
    }
}
