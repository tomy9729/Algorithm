//Level 1 폰켓몬.java
import java.util.Arrays;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums); //nums의 최댓값을 구하기위해 정렬 : 폰켓몬 종료의 수를 알기 위함
        int[] kind = new int[nums[nums.length-1]];//폰켓몬 종류만큼 kind 크기 설정
        
        for(int i=0;i<nums.length;i++){
            kind[nums[i]-1]++; //각 종류마다 폰켓몬이 몇마리 있는지 확인
        }
        
        int kind_nums = 0;
        for(int i=0;i<kind.length;i++){
            if(kind[i]!=0){
                kind_nums++; //존재하는 폰켓몬의 종류 수 확인
            }
        }
        
        if(nums.length/2 > kind_nums){//폰켓몬의 종류보다 가져가는 폰켓몬의 수가 많으면
            answer = kind_nums;//폰켓몬의 종류 모두 가져갈 수 있음
        }
        else{
            answer=nums.length/2;
        }
        
        return answer;
    }
}
