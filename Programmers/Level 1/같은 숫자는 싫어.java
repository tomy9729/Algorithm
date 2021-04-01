//Level 1 같은 숫자는 싫어.java
import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        int[] answer = new int[1000000]; //answer의 크기가 될 수 있는 최댓값 1000000
        answer[0] = arr[0]; //첫 숫자는 무조건 들어감.
        int answer_len = 1; //answer의 길이
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]!=arr[i]){ //앞 숫자와 다른게 나올 때마다
                answer[answer_len] = arr[i]; //answer에 추가
                answer_len++;
            }
        }        
        answer = Arrays.copyOf(answer,answer_len); //answer의 길이만큼 자른다.
        return answer;
    }
}
