class Solution {
    class Trie{
        Trie children[]=new Trie[26];
        boolean isEnd=false;
    }
    public Trie root=new Trie();
    public void addWord(String word){
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
     public void search(
        int i,
        int j,
        char[][] board,
        int m,
        int n,
        Trie curr,
        boolean[][] visited,
        StringBuilder str,
        List<String> li
    ) {

        // Boundary condition
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        // Already used
        if (visited[i][j]) {
            return;
        }

        int index = board[i][j] - 'a';

        // Current character doesn't exist in Trie
        if (curr.children[index] == null) {
            return;
        }

        // Move in Trie
        Trie node = curr.children[index];

        // Add character
        str.append(board[i][j]);

        // Mark visited
        visited[i][j] = true;

        // Found a word
        if (node.isEnd) {
            li.add(str.toString());
            node.isEnd = false; // avoid duplicate words
        }

        // Explore 4 directions
        search(i + 1, j, board, m, n, node, visited, str, li);
        search(i - 1, j, board, m, n, node, visited, str, li);
        search(i, j + 1, board, m, n, node, visited, str, li);
        search(i, j - 1, board, m, n, node, visited, str, li);

        // Backtracking
        visited[i][j] = false;

        str.deleteCharAt(str.length() - 1);
    }
    public List<String> findWords(char[][] board, String[] words) {

         List<String> li = new ArrayList<>();

        int m = board.length;
        int n = board[0].length;

        // Build Trie
        for (String word : words) {
            addWord(word);
        }

        boolean[][] visited = new boolean[m][n];

        StringBuilder str = new StringBuilder();

        // Start DFS from EVERY cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                search(
                    i,
                    j,
                    board,
                    m,
                    n,
                    root,
                    visited,
                    str,
                    li
                );
            }
        }

        return li;
    }
}