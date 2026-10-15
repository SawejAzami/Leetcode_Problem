class Solution {
    public int minFlips(int a, int b, int c) {
        int count=0;
        for(int i=0;i<32;i++){
            int aBit=(a>>i) & 1;
            int bBit=(b>>i) & 1;
            int cBit=(c>>i) & 1;
            int aORb_Bit=aBit | bBit;
            if(aORb_Bit==cBit) continue;
            if(cBit==0){
                if(aBit==1 && bBit==1){
                    count+=2;
                }else{
                    count++;
                }
            }else{
                count++;
            }
        }
        return count;
    }
}