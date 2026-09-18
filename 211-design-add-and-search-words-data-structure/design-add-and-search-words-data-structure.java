class WordDictionary {

    class Node{
            Node children[]=new Node[26];
            boolean isEnd;
        }
    Node root;

    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int index = ch - 'a';
            if(curr.children[index]==null){
                curr.children[index]=new Node();
                
            }
            curr=curr.children[index];
        }
        curr.isEnd=true;
    }

    private boolean dfs(Node curr, String word, int index) {

        // Entire word has been processed
        if (index == word.length()) {
            return curr.isEnd;
        }

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {

            int childIndex = ch - 'a';

            if (curr.children[childIndex] == null) {
                return false;
            }

            return dfs(curr.children[childIndex], word, index + 1);
        }

        // '.' -> try all possible characters
        for (int i = 0; i < 26; i++) {

            if (curr.children[i] != null) {

                if (dfs(curr.children[i], word, index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    public boolean search(String word) {
       return dfs(root, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */