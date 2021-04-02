//Level 1 정수 내림차순으로 배치하기.java
import java.util.Arrays;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String temp = ""+n;
        int[] nums = new int[temp.length()]; //각 자릿수들을 저장할 배열
        int index = 0;
        while(n != 0){
            nums[index] = (int)(n%10); //각 자릿수들 저장
            n /= 10;
            index++;
        }
        Arrays.sort(nums); //오름차순으로 정렬
        String num = ""; //역순으로 저장될 문자열
        for(int i=0;i<nums.length;i++){
            num += nums[nums.length-i-1]; //역순으로 string에 저장
        }
        answer = Long.parseLong(num); //string을 long으로 변환
        return answer;
    }
}
