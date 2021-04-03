//Level 1 제일 작은 수 제거하기.java
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length == 1){ //arr의 길이가 1이면
            answer = new int[1];
            answer[0] = -1; //[-1] 반환
            return answer;
        }
        answer = new int[arr.length-1];
        int min_index = 0;
        int min = 2147483646;
        for(int i=0;i<arr.length;i++){ //arr에서 최솟값 찾기
            if(arr[i]<min){
                min = arr[i];
                min_index = i;
            }
        }
        //최솟값 앞뒤로 배열 자르기
        int[] answer_1 = Arrays.copyOfRange(arr,0,min_index);
        int[] answer_2 = Arrays.copyOfRange(arr,min_index+1,arr.length);
        //자른 배열 두개 합치기
        for(int i=0;i<answer_1.length;i++){
            answer[i] = answer_1[i];
        }
        for(int i=0;i<answer_2.length;i++){
            answer[i+answer_1.length] = answer_2[i];
        }
        return answer;
    }
}
