//Level 1 하샤드 수.java
class Solution {
    public boolean solution(int x) {
        int n = x;
        int sum = 0;
        while(n!=0){
            sum += n%10;
            n /= 10;
        }
        if(x%sum==0) return true;
        else return false;
    }
}
