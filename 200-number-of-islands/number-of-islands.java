class Solution {
    class Vertex{
        int a;
        int b;
        Vertex(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public void bfs(int i,int j,char grid[][],int dp[][]){
        Queue<Vertex> q=new LinkedList<>();
        q.add(new Vertex(i,j));
        while(!q.isEmpty()){
            Vertex v=q.remove();
            int a=v.a;
            int b=v.b;
            if(a>0){
                if(dp[a-1][b]!=1 && grid[a-1][b]=='1'){
                    dp[a-1][b]=1;
                    q.add(new Vertex(a-1,b));
                }
            }
            if(b>0){
                if(dp[a][b-1]!=1 && grid[a][b-1]=='1'){
                    dp[a][b-1]=1;
                    q.add(new Vertex(a,b-1));
                }
            }
            if(a<grid.length-1){
                if(dp[a+1][b]!=1 && grid[a+1][b]=='1'){
                    dp[a+1][b]=1;
                    q.add(new Vertex(a+1,b));
                }
            }
            if(b<grid[0].length-1){
                if(dp[a][b+1]!=1 && grid[a][b+1]=='1'){
                    dp[a][b+1]=1;
                    q.add(new Vertex(a,b+1));
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && dp[i][j]==0){
                    bfs(i,j,grid,dp);
                    count++;
                }
            }
        }
        return count;
    }
}