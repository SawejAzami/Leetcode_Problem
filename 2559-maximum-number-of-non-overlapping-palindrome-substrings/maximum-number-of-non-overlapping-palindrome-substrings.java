class Solution {
    public int maxPalindromes(String s, int k) {
        int  n=s.length();
        int count=0;
        if(k==1)return n;
        int prev=-1;
        for(int i=0;i<n-1;i++){
            // odd substring
            int odd=i;
            int odd2=i;
            boolean flag=true;
            while( flag && (odd2>prev && odd<n) && s.charAt(odd)==s.charAt(odd2) ){
                
                // System.out.print(i+" "+odd2+" "+odd+",odd ");
                if((odd-odd2+1)>=k){
                    count++;
                    i=odd;
                    prev=i;
                    flag=false;
                    // System.out.print(" found ");
                    break;
                }
                odd++;
                odd2--;
            }
            // even substring
            int even2=i;
            int even=i+1;
            
            while( flag && (even2>prev && even<n) && s.charAt(even2)==s.charAt(even) ){
                
                // System.out.print(i+" "+even2+" "+even+",even ");
                if((even-even2+1)>=k){
                    count++;
                    i=even;
                    prev=i;
                    // System.out.print(" found ");
                    break;
                }
                even2--;
                even++;
            }
            // System.out.println();
        }
        return count;
    }
}