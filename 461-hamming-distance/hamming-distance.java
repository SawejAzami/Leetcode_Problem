class Solution {
    public int hammingDistance(int x, int y) {
        int count=0;
        for(int i=31;i>=0;i--){
            int bit1=(x>>i) & 1;
            int bit2=(y>>i) & 1;
            if(bit1!=bit2){
                count++;
            }
        }
        return count;
    }
}