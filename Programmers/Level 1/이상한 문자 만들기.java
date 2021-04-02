//Level 1 이상한 문자 만들기.java
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] word = s.split(" ",-1);//공백을 기준으로 문자열을 나눔
        
        if(s.equals(" "))return s;
        for(int i=0;i<word.length;i++){//각 단어들에 대해서
            for(int j=0;j<word[i].length();j++){
                if((int)word[i].charAt(j)>95 && j%2==0){//짝수번째에 있고 소문자면
                    word[i] = word[i].substring(0,j) + (char)((int)word[i].charAt(j)-32) + word[i].substring(j+1);//대문자로 바꿔줌
                }
                else if((int)word[i].charAt(j)<95 && j%2==1){//홀수번째에 있고 대문자면
                    word[i] = word[i].substring(0,j) + (char)((int)word[i].charAt(j)+32) + word[i].substring(j+1);//소문자로 바꿔줌
                }
            }
            answer += word[i]+' ';
        }
        return answer.substring(0,answer.length()-1);
    }
}
