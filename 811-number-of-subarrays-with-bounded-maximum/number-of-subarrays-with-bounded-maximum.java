class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n= nums.length;
        int[] lftMax= new int[n];
        Stack<Integer> stk= new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && nums[stk.peek()]<=nums[i]) stk.pop();
            if(stk.isEmpty()){
                lftMax[i]= -1;
            }
            else{
                lftMax[i]= stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        int[] rgtMax= new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && nums[stk.peek()]<nums[i]) stk.pop();
            if(stk.isEmpty()){
                rgtMax[i]= n;
            }
            else{
                rgtMax[i]= stk.peek();
            }
            stk.push(i);
        }
        int ans= 0;
        for(int i=0;i<n;i++){
            if(nums[i]>=left && nums[i]<=right){
                ans+= (i-lftMax[i])*(rgtMax[i]-i);
            }
        }
        return ans;
    }
}