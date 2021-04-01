//Level 1 k번째수.java
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        for(int n=0;n<commands.length;n++){ // 커맨드들 하나씩 확인
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            
            int[] arr = new int[j-i+1]; //추출한 배열을 저장하는 공간
            for(int m=0,l=i-1;m<arr.length;m++,l++){
                arr[m] = array[l]; //원소 하나씩 추출
            }
            Arrays.sort(arr); //정렬
            
            int add = answer.length;
            answer = Arrays.copyOf(answer,add+1);
            answer[add] = arr[k-1]; //정답 배열에 k번째 숫자 추가
        }
        return answer;
    }
}
