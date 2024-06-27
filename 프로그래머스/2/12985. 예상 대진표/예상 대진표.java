class Solution
{
    int nextRound(int value){
        if(value%2 == 0){
            return value/2;
        } else{
            return value/2 + 1;
        }
    }
    
    public int solution(int n, int a, int b)
    {
        int round = 0;
        
        while(a != b){
            round++;
            a = nextRound(a);
            b = nextRound(b);
        }

        return round;
    }
}