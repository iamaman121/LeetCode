class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap= new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1]-(a[0]*a[0]+a[1]*a[1])));
        for(int i=0;i<points.length;i++){
            maxHeap.add(points[i]);
            if(i<k) continue;
            maxHeap.remove();
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i]= maxHeap.poll();
        }
        return ans;
    }
}