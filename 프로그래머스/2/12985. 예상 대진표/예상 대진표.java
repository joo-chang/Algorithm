class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        // 2로 나눈 몫이 다음라운드 몇번째 참가자가 되는지 나오는데
        // a, b를 2로 나눈 몫이 같아질 때의 라운드를 반환하면 된다.
        
        // n 은 어디다 쓰지
        // 1  12    12 34 56
        // 1 5
        // 1 2
        
        while(true){
            a++;
            b++; 
            a = a/2;
            b = b/2;
            
            if(a == b) return ++answer;
            else answer++;
        }

    }
}