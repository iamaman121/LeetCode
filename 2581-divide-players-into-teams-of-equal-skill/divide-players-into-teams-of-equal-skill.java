class Solution {
    public long dividePlayers(int[] skills) {
        Arrays.sort(skills);
        int lo=0, hi= skills.length-1, psum=skills[0]+skills[hi], sum;
        long ans= 0;
        while(lo<hi){
            sum= skills[lo]+skills[hi];
            if(psum!=sum) return -1;
            ans+= (long)(skills[lo]*skills[hi]);
            lo++; hi--;
        }
        return ans;
    }
}