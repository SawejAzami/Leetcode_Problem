class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        // long xXORa=0;
        // long xXORb=0;

        // for(long i=49;i>=n;i--){
        //     long a_ith_bit=(a>>i)&1;
        //     long b_ith_bit=(b>>i)&1;
        //     if(a_ith_bit==1){
        //         xXORb^=(1L<<i);
        //     }
        //     if(b_ith_bit==1){
        //         xXORa^=(1L<<i);
        //     }
        // }

        // for(long i=n-1;i>=0;i--){
        //     long a_ith_bit=(a>>i)&1;
        //     long b_ith_bit=(b>>i)&1;

        //     if (a_ith_bit == b_ith_bit) {
        //         if (a_ith_bit == 0) {
        //             xXORa |= (1L << i);
        //             xXORb |= (1L << i);
        //         }
        //         continue;
        //     }
        //     if(xXORa>xXORb){
        //          xXORb^=(1L<<i);
        //     }else{
        //         xXORa^=(1L<<i);
        //     }
        // }
        // // System.out.println(xXORa+"  "+xXORb);
        // xXORa=xXORa%1000000007;
        // xXORb=xXORb%1000000007;
        // return (int)(xXORa*xXORb)%1000000007;



        // 
        int M = 1000000007;
         long xXora = 0;
        long xXorb = 0;

        for (long i = 49; i >= n; i--) {
            boolean aset = ((a >> i) & 1 )> 0; //Finding the ith bit of a
            boolean bset = ((b >> i) & 1) > 0; //Finding the ith bit of b

            if (aset)
                xXora ^= (1L << i);
            if (bset)
                xXorb ^= (1L << i);
        }

        for (long i = n - 1; i >= 0; i--) {
            boolean aset = (a & (1L << i)) > 0;
            boolean bset = (b & (1L << i)) > 0;

            // If both ith bit of a and b are the same
            if (aset == bset) {
                xXora ^= (1L << i);
                xXorb ^= (1L << i);
                continue;
            }

            if (xXora > xXorb) {
                xXorb ^= (1L << i);
            } else {
                xXora ^= (1L << i);
            }
        }

        xXora %= M;
        xXorb %= M;
        return (int) ((xXora * xXorb) % M);

    }
}