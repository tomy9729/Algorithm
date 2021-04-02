//Level 1 문자열 내 p와 y의 개수.java
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p_count = 0;
        int y_count = 0;
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'p'){
                p_count++;
            }
            else if(s.charAt(i) == 'y'){
                y_count++;
            }
        }
        if(p_count == 0 && y_count == 0){
            answer = false;
        }
        else if(p_count == y_count){
            answer = true;
        }
        else{
            answer = false;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
