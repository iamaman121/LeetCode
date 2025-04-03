class Solution {
    public int countPairs(List<Integer> arr, int tar) {
        Collections.sort(arr);
        int ans=0, l=0, r=arr.size()-1, sum=0;
        while(l<r){
            sum= arr.get(l)+arr.get(r);
            if(sum>=tar) r--;
            else{
                ans+= (r-l);
                l++;
            }
        }
        return ans;
    }
}