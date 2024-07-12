class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        
        for(int i=yellow; i>=1; i--){   //i = yellow의 가로 길이
            
            if(yellow%i != 0){  //가로 세로 나누어 떨어짐 확인
                continue;
            }
            
            
            int x = i + 2;  //가로
            int y = yellow/i + 2;   //세로
            
            // if(x < y){  //가로길이 보다 세로가 크면
            //     break;
            // }
            
            // System.out.println(x + " " + y);
            
            if(x*y-yellow == brown){
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }
        
        return answer;
    }
}