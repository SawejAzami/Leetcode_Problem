class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean vis[]=new boolean[n];
        vis[0]=true;
        Queue<Integer> q=new LinkedList<>();
        // for(int j=0;j<rooms.get(0).size();j++){
        //     q.add(rooms.get(0).get(j));
        // }
        q.add(0);
        while(q.size()>0){
            int front=q.remove();
            // if(!vis[front]){
            //     for(int j=0;j<rooms.get(front).size();j++){
            //     q.add(rooms.get(front).get(j));
            // }
            // vis[front]=true;
            // }
            for(int j=0;j<rooms.get(front).size();j++){
                if(!vis[rooms.get(front).get(j)]){
                    q.add(rooms.get(front).get(j));
                    vis[rooms.get(front).get(j)]=true;
                }
            }

        }
        for(int i=0;i<n;i++){
            if(vis[i]==false)return false;
        }
        return true;
    }
}