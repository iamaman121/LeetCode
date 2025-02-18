class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> cache = new HashSet<>();
        for(int x:nums){
            if(cache.contains(x)) return true;
            cache.add(x);
        }
        return false;
    }
}