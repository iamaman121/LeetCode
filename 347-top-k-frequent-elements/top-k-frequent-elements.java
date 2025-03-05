class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }
        List<List<Integer>> arr = new ArrayList<>();
        for(Integer key: count.keySet()){
            arr.add(new ArrayList<>(Arrays.asList(count.get(key),key)));
        }
        arr.sort((a,b)-> b.get(0)-a.get(0));
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]= arr.get(i).get(1);
        }
        return res;
    }
}