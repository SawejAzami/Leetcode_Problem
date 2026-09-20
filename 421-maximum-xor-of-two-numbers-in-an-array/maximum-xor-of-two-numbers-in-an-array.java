class Solution {
    class Trie{
        Trie zero;
        Trie one;
        int val;
    }
    Trie root=new Trie();
    public void buildTrie(int n){
        Trie curr=root;
        int num=n;
        for(int i=31;i>=0;i--){
            int bit=(n>>i) & 1;
            if(bit==1){
                if(curr.one==null){
                    curr.one=new Trie();
                }
                curr=curr.one;
            }else{
                if(curr.zero==null){
                    curr.zero=new Trie();
                }
                curr=curr.zero;
            }
        }
        curr.val=num;
        // System.out.print(curr.val+" ");
    }
    public int findMaxXOR(int n){
        
        Trie curr=root;
        for(int i=31;i>=0;i--){
            int bit=(n>>i) & 1;
            if(bit==0){
                if(curr.one!=null){
                    curr=curr.one;
                }
                else{
                    curr=curr.zero;
                }
            }else{
                if(curr.zero!=null){
                    curr=curr.zero;
                }
                else{
                    curr=curr.one;
                }
            }
        }
        return curr.val;
    }
    public int findMaximumXOR(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int val:nums){
            buildTrie(val);
        }
        for(int val:nums){
            int res=findMaxXOR(val);
            // System.out.println(res);
            max=Math.max(max,val^res);
        }
        return max;

    }
}