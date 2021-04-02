//Level 1 자연수 뒤집어 배열로 만들기.java
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        
        while(n != 0){ 
            list.add((int)(n%10));//10으로 나눈 나머지를 리스트에 추가
            n /= 10;
        }
        
        Integer[] temp = {};
        temp = list.toArray(new Integer[list.size()]); //arraylist를 배열로 변환
        answer = Arrays.stream(temp).mapToInt(Integer::intValue).toArray(); //integer를 int로 변환
        return answer;
    }
}
