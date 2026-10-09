class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int insertion=0;
        int rightneeded=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(rightneeded%2==1){
                    insertion++;
                    rightneeded--;
                }
                rightneeded+=2;
            }else{
                rightneeded--;
                if(rightneeded<0){
                    insertion++;
                    rightneeded=1;
                }
            }
        }
        return insertion+rightneeded;
    }
}