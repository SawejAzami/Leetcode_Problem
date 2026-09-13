class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums1.length;
        for(int i=0;i<n;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        int m=nums2.length;
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=0;i<m;i++){
            if(map.containsKey(nums2[i])){
                if( map.get(nums2[i])>0){
                    li.add(nums2[i]);
                    map.put(nums2[i],map.getOrDefault(nums2[i],0)-1);
                }
                
            }
        }
        int[] arr = new int[li.size()];

        for (int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
        }
        return arr;
    }
}