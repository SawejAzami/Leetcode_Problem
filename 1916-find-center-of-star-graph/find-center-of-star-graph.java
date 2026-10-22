class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length;
        int arr[]=new int[n+2];
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            arr[u]++;
            arr[v]++;
        }
        int max=0;
        int count=0;
        for(int i=0;i<n+2;i++){
            // System.out.print(arr[i]+" ");
            if(count<arr[i]){
                max=i;
                count=arr[i];
            }
        }
        return max;

    }
}