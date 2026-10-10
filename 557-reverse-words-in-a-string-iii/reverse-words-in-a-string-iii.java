class Solution {
    public String reverseWords(String s) {
        String words[]=s.split(" ");
        String res="";
        for(int i=0;i<words.length;i++){
            String w=words[i];
            if(i==words.length-1){
                res+=new StringBuilder(w).reverse().toString();
            }else{
                res+=new StringBuilder(w).reverse().toString()+" ";
            }
        }
        return res;

    }
}