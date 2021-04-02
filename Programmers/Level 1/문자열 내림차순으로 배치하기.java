//Level 1 문자열 내림차순으로 배치하기.java
import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] s_char = null;
        s_char = s.toCharArray(); //문자열을 문자 배열로
        int[] s_char_num = new int[s_char.length];
        for(int i=0;i<s_char_num.length;i++){ //문자배열을 아스키코드 배열로
            s_char_num[i] = (int)s_char[i];
        }
        Arrays.sort(s_char_num); //아스키코드 배열을 오름차순으로 정렬
        for(int i=0;i<s_char_num.length;i++){//아스키코드 배열을 문자배열 역순으로 저장
            s_char[i] = (char)s_char_num[s_char_num.length-i-1];
        }
        answer = String.valueOf(s_char); //문자 배열을 string으로
        return answer;
    }
}
