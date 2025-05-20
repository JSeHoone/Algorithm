class Solution {
    public int solution(int n) {        

        int count = 0;

        for(int i = 1 ; i*(i+1)<=2*n ; i++){
            if((i%2!=0 && n%i==0) || (i%2==0 && n%i==i/2)) count++;
            System.out.print(i);
        }
        return count;
    }
}