class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int res=0;
        // int count=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> set=new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(nums.get(j));
                // count++;
                res+=set.size()*set.size();
            }
        }
        // System.out.println(count);
        return res;
    }
}