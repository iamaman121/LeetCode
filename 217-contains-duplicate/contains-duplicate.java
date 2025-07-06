class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> store = new HashSet<>();
        for(int num : nums){
            if(store.contains(num)){
                return true;
            }
            store.add(num);
        }
        return false;
    }
}