class Solution {
    public int gcdOfOddEvenSums(int n) {int sumOdd = 0;
        int sumEven = 0;
        int currOdd = 1;
        for(int i=0; i<n; i++){
            sumOdd += currOdd;
            currOdd += 2;
        }
        int currEven = 2;
        for(int i=0; i<n; i++){
            sumEven += currEven;
            currEven += 2;
        }
        return findGCD(sumOdd, sumEven);
    }
    
    private int findGCD(int a, int b) {
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}