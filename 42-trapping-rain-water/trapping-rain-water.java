class Solution {
    public int trap(int[] height) {
        int n= height.length;
        int[] pmx= new int[n]; pmx[0]= height[0];
        for(int i=1;i<n;i++){
            pmx[i]= Math.max(pmx[i-1], height[i]);
        }
        int[] smx= new int[n]; smx[n-1]= height[n-1];
        for(int i=n-2;i>=0;i--){
            smx[i]= Math.max(smx[i+1], height[i]);
        }
        return calculateTrappedRainWater(n, pmx, smx, height);
    }
    private int calculateTrappedRainWater(int n, int[] pmx, int[] smx, int[] height){
        int amount=0;
        for(int i=1;i<=n-2;i++){
            int contri= Math.min(pmx[i-1], smx[i+1])-height[i];
            if(contri>0) amount+= contri;
        }
        return amount;
    }
}