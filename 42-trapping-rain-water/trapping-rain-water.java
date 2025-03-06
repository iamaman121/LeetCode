class Solution {
    public int trap(int[] ht) {
        int left=0, right=ht.length-1;
        int trappedWater=0, lftMax=ht[left], rgtMax=ht[right];
        while(left<right){
            if(ht[left]<ht[right]){
                lftMax= Math.max(lftMax,ht[left]);
                trappedWater+= lftMax-ht[left++];
            }
            else{
                rgtMax= Math.max(rgtMax,ht[right]);
                trappedWater+= rgtMax-ht[right--];
            }
        }
        return trappedWater;
    }
}
