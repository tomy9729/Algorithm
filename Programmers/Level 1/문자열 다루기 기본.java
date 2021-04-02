//Level 1 문자열 다루기 기본.java
class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6){ //문자열의 길이가 4도 아니고 6도 아니면 false
            return false;
        }
        for(int i=0;i<s.length();i++){//문자열의 각 문자들 확인
            if(!Character.isDigit(s.charAt(i))){//숫자가 아니면
                return false;//바로 false
            }
        }
        return answer;
    }
}
