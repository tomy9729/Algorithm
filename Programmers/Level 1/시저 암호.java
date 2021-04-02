//Level 1 시저 암호.java
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] c = null;
        c = s.toCharArray(); //문자열을 문자 배열로 변환
        int[] aschi = new int[c.length];//아스키코드
        for(int i=0;i<aschi.length;i++){
            int bigorsmall = 0;//대소문자 구분
            aschi[i] = (int)c[i];//문자 배열을 아스키코드로 변환
            if(aschi[i] >= 65 && aschi[i] <= 90)bigorsmall = 1;//대문자라면 1
            if(aschi[i]!=32){//공백은 아무것도 하지 않음
                aschi[i]+=n;//n만큼 이동
                if(bigorsmall==1 && aschi[i] > 90)aschi[i]-=26;//Z를 넘어가면 26 뺌
                else if(aschi[i] > 122)aschi[i]-=26;//z를 넘어가면 26 뺌
            }
            c[i] = (char)aschi[i];//아스키코드를 다시 문자로 변환
        }
        answer = String.valueOf(c);//문자 배열을 문자열로 변환.
        return answer;
    }
}
