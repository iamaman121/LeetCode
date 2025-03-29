class Solution {
    public int numberOfWays(String corridor) {
        List<Integer> seatsIdx= new ArrayList<>();
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S') seatsIdx.add(i);
        }
        int len= seatsIdx.size();
        if(len%2==1 || len==0) return 0;
        long res=1, curr, mod= (long)(1e9+7);
        for(int i=2;i<len;i+=2){
            curr= seatsIdx.get(i)-seatsIdx.get(i-1);
            res= (res*curr)%mod;
        }  
        return (int)res;
    }
}