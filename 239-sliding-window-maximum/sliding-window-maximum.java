class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n= nums.length;
        int[] op= new int[n-k+1];
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peek()<=i-k){
                dq.poll();
            } 
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                op[i-k+1]= nums[dq.peek()];
            }
        }
        return op;
    }
}