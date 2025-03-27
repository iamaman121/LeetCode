class Solution {
    private int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> freq= new HashMap<>();
        for(int num: deck){
            if(!freq.containsKey(num)) freq.put(num,0);
             freq.put(num,freq.get(num)+1);
        }
        int ans=-1;
        for(int val:freq.values()){
            if(ans!=-1){
                ans= gcd(ans,val);
            }
            else ans= val;
        }
        return ans>=2;
    }
}