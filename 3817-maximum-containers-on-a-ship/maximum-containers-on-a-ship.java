class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        maxWeight= Math.min(maxWeight, n*n*w);
        return maxWeight/w;
    }
}