class Solution {
    class Trie{
        Trie zero;
        Trie one;
        int val=0;
    }
    public Trie root=new Trie();
    public void insert(int num){
        Trie curr=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(bit==0){
                if(curr.zero==null){
                    curr.zero=new Trie();
                }
                curr=curr.zero;
            }else{
                if(curr.one==null){
                    curr.one=new Trie();
                }
                curr=curr.one;
            }
        }
        curr.val=num;
    }
    public int find(int num){
        Trie curr=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
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
    public int maximumStrongPairXor(int[] nums) {
        int res=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(Math.abs(nums[i]-nums[j])<=Math.min(nums[i],nums[j])){
                    res=Math.max(res,nums[i]^nums[j]);
                }
            }
        }
        return res;
    }
}