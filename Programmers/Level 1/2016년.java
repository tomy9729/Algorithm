//Level 1 2016년.java
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int days = 0; //모든 날짜수
        for(int i=1; i<a;i++){ //모든 달에 대해서 해당 달 이전까지의 날들 (5월이면 4월까지 더하기)
            if(i == 2){ //윤년
                days +=29;
            }
            else if((i<=7 && i%2 == 1)||(i>=8 && i%2 == 0)){ //31일까지 있는 달들
                days+=31;
            }
            else if((i<=7 && i%2 == 0)||(i>=8 && i%2 == 1)){//30일까지 있는 달들
                days+= 30;
            }
        }
        days += b; //며칠을 더해줌
        switch(days%7){ //모든 날들을 7로 나눠준 나머지에 따라 요일이 결정됨
            case 0 : answer = "THU"; break;
            case 1 : answer = "FRI"; break;
            case 2 : answer = "SAT"; break;
            case 3 : answer = "SUN"; break;
            case 4 : answer = "MON"; break;
            case 5 : answer = "TUE"; break;
            case 6 : answer = "WED"; break;
        }
        return answer;
    }
}
