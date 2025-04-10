class Solution {
    public int maxProduct(int[] nums) {
        int pmax= 0, pmin= 0, cmax, cmin, ans=nums[0] ;
        for(int num: nums){
            if(num>0){
                cmax=pmax*num;
                cmin=pmin*num;
                if(cmax==0) cmax= num;
            }
            else if(num<0){
                cmax= pmin*num;
                cmin= pmax*num;
                if(cmin==0) cmin= num;
            }
            else{
                if(ans<0) ans=0;
                cmax=0; cmin=0;
            }
            if(cmax>0 && ans<cmax) ans= cmax;
            pmin= cmin; pmax= cmax;
        }
        return ans;
    }
}