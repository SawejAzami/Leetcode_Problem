class MapSum {
    class Trie{
        Trie children[]=new Trie[26];
        int val=0;
    }
    Trie root;
    public MapSum() {
        root=new Trie();
    }
    
    public void insert(String key, int val) {
        Trie curr=root;
        for(int i=0;i<key.length();i++){
            int index=key.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index]=new Trie();
            }
            curr=curr.children[index];
            if(key.length()-1==i){
                curr.val=val;
            }
        }
    }
    public void findAll(Trie curr,int index,int arr[]){
        arr[0]+=curr.val;
        for(int i=0;i<26;i++){
            if(curr.children[i]!=null){
                // arr[0]+=curr.val;
                findAll(curr.children[i],index+1,arr);
            }
        }
    }
    
    public int sum(String prefix) {
         Trie curr=root;
        for(int i=0;i<prefix.length();i++){
            int index=prefix.charAt(i)-'a';
             if (curr.children[index] == null) {
                    return 0;
                }
            curr=curr.children[index];
        }
        int arr[]=new int[1];
        findAll(curr,0,arr);
        return arr[0];

    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */