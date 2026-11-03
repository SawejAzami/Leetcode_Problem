class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int inDegree[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            inDegree[prerequisites[i][0]]++;
        }

        int graph[][]=new int[numCourses][numCourses];
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]][prerequisites[i][0]]=1;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int row=q.remove();
            for(int col=0;col<numCourses;col++){
                int val=graph[row][col];
                if(val==1){
                    if(inDegree[col]!=0){
                        inDegree[col]--;
                        if(inDegree[col]==0){
                            q.add(col);
                        }
                    }
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]!=0)return false;
        }
        return true;
        

            
        
    }
}