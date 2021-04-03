//Level 1 최대공약수와 최소공배수.java
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(n>m){
            int temp = n;
            n=m;
            m=temp;
        }
        
        int[] u = {m,n,m%n}; //유클리드 호제법을 통해 최대공약수 구하기
        while(u[2] != 0){
            u[0] = u[1];
            u[1] = u[2];
            u[2] = u[0]%u[1];
        }
        answer[0] = u[1];
        answer[1] = n*m/answer[0]; //최대공약수를 통해 최소공배수 구하기
        return answer;
    }
}
