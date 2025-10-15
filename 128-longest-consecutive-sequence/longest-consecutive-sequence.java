class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> cache= new HashSet<>();
        for(int x: nums) cache.add(x);
        int ans= 0;
        for(int x: cache){
            if(cache.contains(x-1)) continue;  // ensures we only start from the beginning of a sequence
            int val= x, count= 0;
            while(cache.contains(val)){
                count++;
                val++;
            }
            if(ans<count) ans= count;
        }
        return ans;
    }
}
