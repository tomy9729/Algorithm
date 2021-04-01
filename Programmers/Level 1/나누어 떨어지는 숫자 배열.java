//Level 1 나누어 떨어지는 숫자 배열.java
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = new int[arr.length]; //answer의 최대 길이
        int answer_len = 0; //answer의 길이
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor == 0){ //divisor로 나누어질 때마다
                answer[answer_len] = arr[i];//answer에 추가
                answer_len += 1; //answer의 길이 1 증가
            }
        }
        if(answer_len==0){//answer이 0이라면 
            answer[0] = -1;//-1 추가
            answer_len++;//answer의 길이 1 증가
        }
        answer = Arrays.copyOf(answer,answer_len); //answer을 answer_len만큼 슬라이싱
        Arrays.sort(answer);
        
        return answer;
    }
}
