class Solution {
    public static void backTrack(int digits[],HashSet<Integer> set,int count,boolean[] used,int num){
        if(count==3){
            if(num%2==0){
                set.add(num);
            }
            return;
        }
        for(int i=0;i<digits.length;i++){
            if(used[i])continue;

            if(count==0 && digits[i]==0)continue;
            used[i]=true;
            backTrack(digits,set,count+1,used,num*10+digits[i]);
            used[i]=false;
        }
    }
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        HashSet<Integer> set=new HashSet<>();
        boolean[] used=new boolean[n];
        backTrack(digits,set,0,used,0);
        return set.size();


    }
}