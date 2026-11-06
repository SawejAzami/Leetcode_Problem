class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int arr[]=new int[255];
        // int len=s.length();
        // int start=0;
        // int ans=0;
        // if(len<1)return 0;
        // for(int i=0;i<len;i++){
        //     char c=s.charAt(i);
        //     int intVal=c;
        //     if(arr[intVal]==0){
        //         arr[intVal]+=1;
        //     }else{
        //         while(s.charAt(start)!=c){
        //             char ch=s.charAt(start);
        //             int intVal1=ch;
        //             arr[intVal1]=0;
        //             start++;

        //         }
        //         start++;
        //     }
        //     int curr=i+1-start;
        //     if(ans<curr){
        //         ans=curr;
        //     }
        // }
        // return ans;


        // another method by arpita

        HashSet<Character> hash=new HashSet<>();
        int len=s.length();
        int l=0;
        int max=0;
        for(int r=0;r<len;r++){
            char ch=s.charAt(r);
            while(l<r && hash.contains(s.charAt(r))){
                hash.remove(s.charAt(l));
                l++;
            }
            int curr=r-l+1;
            if(curr>max){
                max=curr;
            }
            hash.add(ch);
        }
        return max;
    }
}