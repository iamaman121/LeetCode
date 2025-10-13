class Solution {
    private int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> freq= new HashMap<>();
        for(int x: deck){
            freq.put(x, freq.getOrDefault(x, 0)+1);
        }
        int ans= 0;
        for(int key: freq.keySet()){
            ans= gcd(ans, freq.get(key));
        }
        return ans>1;
    }
}