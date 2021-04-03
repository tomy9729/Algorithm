//Level 1 핸드폰 번호 가리기.java
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int i;
        for(i=0;i<phone_number.length()-4;i++){
            answer+='*';
        }
        answer+=phone_number.substring(i,phone_number.length());
        return answer;
    }
}
