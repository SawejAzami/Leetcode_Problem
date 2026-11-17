class Solution {
    public String longestCommonPrefix(String[] strs) {
        // int n=strs.length;
        // String str="";
        // boolean flag=false;
        // char c;
        // String ch=strs[0];
        // for(int i=0;i<ch.length();i++){
        //     c=ch.charAt(i);
        //     for(int j=1;j<n;j++){
        //         String ab=strs[j];
        //         if(i<ab.length()  && c==ab.charAt(i)){
        //         continue;
        //         }
        //         else{
        //             flag=true;
        //             break;
        //         }
        //     }
        //     if(flag==true){
        //         break;
        //     }
        //     str=str+c;
        // }
        // return str;

        // method 2
        //  sort array then compare first and last string
        int n=strs.length;
        Arrays.sort(strs);
        String a=strs[0];
        String b=strs[n-1];
        StringBuilder w=new StringBuilder();
        int len=Math.min(a.length(),b.length());
        int i=0;
        while(i<len && a.charAt(i)==b.charAt(i)){
            w.append(a.charAt(i));
            i++;
        }
        return w.toString();
    }
}