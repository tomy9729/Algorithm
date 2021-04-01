#Level 1 체육복(java)
import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] delete = new int[0];
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    int add = delete.length;
                    delete = Arrays.copyOf(delete,add+1);
                    delete[add] = lost[i];
                    break;
                }
            }
        }
        for(int i=0;i<delete.length;i++){
            for(int j=0;j<lost.length;j++){
                if(delete[i]==lost[j]){
                    lost[j]=0;
                }
            }
            for(int j=0;j<reserve.length;j++){
                if(delete[i]==reserve[j]){
                    reserve[j]=0;
                }
            }
        }
        
        int lost_count = 0;
        for(int i=0;i<lost.length;i++){
            if(lost[i]!=0){
                lost_count++;
            }
        }
        int stu_num = n - lost_count;
        
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i] != 0 && reserve[j] !=0 && lost[i]-1 == reserve[j]){
                    lost[i] = 0;
                    reserve[j] = 0;
                    stu_num ++;
                }
                else if((lost[i] != 0) && reserve[j] !=0 && (lost[i]+1 == reserve[j])){
                    lost[i] = 0;
                    reserve[j] = 0;
                    stu_num ++;
                } 
            }
        }
        int answer = stu_num;
        return answer;
    }
}
