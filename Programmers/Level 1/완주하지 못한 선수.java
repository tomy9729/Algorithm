//Level 1 완주하지 못한 선수.java
import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        //참여 participant, 완주 completion
        String answer = "";
        HashMap<String,Integer> result = new HashMap<String,Integer>(); //해시 맵
        for(int i =0;i<participant.length;i++){ //모든 참가 선수를 해시에 넣는다
            if(result.containsKey(participant[i])){//만약 해시에 이미 있다면
                result.put(participant[i],result.get(participant[i])+1);//동명이인이므로 한명추가
            }
            else{
                result.put(participant[i],1);//만약 해시에 없다면 추가
            }
        }
        for(int i=0;i<completion.length;i++){//모든 완주한 선수에 대해서
            result.put(completion[i],result.get(completion[i])-1);//완주한 사람은 참가자의 value에서 1씩 빼준다
            if(result.get(completion[i])==0){//만약 value가 0이라면 그 이름을 가진 사람은 모두 완주한 것이므로
                result.remove(completion[i]);//해시 맵에서 삭제한다.
            }
        }
        
        answer = result.keySet().iterator().next();//해시에 남아있는 오직 하나의 key,value
        return answer;
    }
}
