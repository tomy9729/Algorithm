//Level 1 콜라츠 추측.java
class Solution {
    public int solution(long num) {
        int count = 0;
        while(true){
            if(num == 1)break;
            count ++;
            if(num%2==0)num /= 2;
            else num = num*3+1;
            
            if(count > 500) return -1; 
        }
        return count;
    }
}
