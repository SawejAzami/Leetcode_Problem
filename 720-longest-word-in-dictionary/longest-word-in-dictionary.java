class Solution {
    class Trie{
        Trie children[]=new Trie[26];
        boolean isEnd=false;
    }
    Trie root=new Trie();
    public  void addWord(String word){
        Trie curr=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index]=new Trie();
            }
            curr=curr.children[index];
        }
        curr.isEnd=true;
    }
    public  String ans="";
    public  void longWord(Trie curr,StringBuilder str){
        for(int i=0;i<26;i++){
            if(curr.children[i]!=null && curr.children[i].isEnd){
                str.append((char)(i+'a'));
                // System.out.println(i);
                if(ans.length()<str.length()){
                    ans=str.toString();
                }
                longWord(curr.children[i],str);
                str.deleteCharAt(str.length()-1);
            }
        }
    }
    public String longestWord(String[] words) {
        for(int i=0;i<words.length;i++){
            addWord(words[i]);
        }
        StringBuilder str=new StringBuilder();
        Trie curr=root;
        longWord(curr,str);
        return ans;
    }
}