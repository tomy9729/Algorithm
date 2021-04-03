class Solution {
    public int solution(int[] gift_cards, int[] wants) {
        //gift_cards : 사람들이 가지고 있는 상품권에 적힌 번호
        //wants : 각 사람들이 받고 싶어하는 상품 번호
        //원하는 상품을 받지 못하는 사람의 최솟값 return
        int answer = 0;
        int[] a = new int[10001];
        int[] b = new int[10001];
        for(int i=0;i<gift_cards.length;i++){
            a[gift_cards[i]]++;
            b[wants[i]]++;
        }
        for(int i=0;i<10001;i++){
            if(b[i]>a[i])answer += (b[i]-a[i]);
        }
        return answer;
    }
}
