class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length, mlcs=0;
        if(n==0) return 0;
        HashSet<Integer> store = new HashSet<>();
        for(int i=0;i<n;i++){
            store.add(nums[i]);
        }
        for(int num: store){
            if(store.contains(num-1)) continue;
            int clcs=1, val=num+1;
            while(store.contains(val)){
                ++clcs;
                ++val;
            }
            if(clcs>mlcs) mlcs = clcs;
        }
        return mlcs;
    }
}