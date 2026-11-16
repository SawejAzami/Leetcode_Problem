class Solution {
    public String sum(String s,int k){
        String newStr="";
        int sum=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            sum+=s.charAt(i)-'0';
            j++;
            if(j==k){
                newStr+=String.valueOf(sum);
                sum=0;
                j=0;
            }
            // System.out.println(newStr+" "+sum+" "+i);
        }
        // System.out.println(newStr);
        if(j>0){
            newStr+=String.valueOf(sum);
        }
        // System.out.println(newStr+" "+sum);
        if(newStr.length()>k){
           return sum(newStr,k);
        }
        return newStr;
    }
    public String digitSum(String s, int k) {
        if(s.length()<=k)return s;
        return sum(s,k);
    }
}