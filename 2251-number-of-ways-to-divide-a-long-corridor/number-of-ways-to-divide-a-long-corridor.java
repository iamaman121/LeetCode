class Solution {
    public int numberOfWays(String corridor) {
        List<Integer> seats= new ArrayList<>();
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S') seats.add(i);
        }
        int len= seats.size();
        if(len%2==1 || len==0) return 0;
        long ans=1, curr, mod= (long)(1e9+7);
        for(int i=2;i<len;i+=2){
            curr= seats.get(i)-seats.get(i-1);
            ans= (ans*curr)%mod;
        }
        return (int)ans;
    }
}