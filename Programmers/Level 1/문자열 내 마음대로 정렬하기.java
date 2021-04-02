//Level 1 문자열 내 마음대로 정렬하기.java
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        for(int i=0;i<strings.length-1;i++){ //버블 정렬
            for(int j=i;j<strings.length;j++){
                if((int)strings[i].charAt(n)>(int)strings[j].charAt(n)){//n번째 문자기준으로 정렬
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
                else if(strings[i].charAt(n)==strings[j].charAt(n)){//n번째 문자가 같을 경우
                    if(strings[i].compareTo(strings[j])>0){//사전순으로 정렬
                        String temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                    }
                }
            }
        }
        answer = strings;
        return answer;
    }
}
