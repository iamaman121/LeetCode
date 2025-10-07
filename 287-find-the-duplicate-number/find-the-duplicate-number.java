class Solution {
    public int findDuplicate(int[] nums) {
        int n= nums.length, i= 0;
        while(i<n){
            int correctIndex= nums[i];
            if(nums[i]!= nums[correctIndex]){
                int temp= nums[i];
                nums[i]= nums[correctIndex];
                nums[correctIndex]= temp;
            }
            else i++;
        }
        // List<Integer> ans= new ArrayList<>();
        // for(i=0;i<n;i++){
        //     if(nums[i]!=i){
        //         ans.add(i+1);
        //     }
        // }
        return nums[0];
    }
}