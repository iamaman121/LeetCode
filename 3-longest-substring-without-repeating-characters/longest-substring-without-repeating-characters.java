class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> cache = new HashSet<>();
        int left=0, ans=0;
        for(int right=0;right<s.length();right++){
            char ch= s.charAt(right);
            while(cache.contains(ch)){
                cache.remove(s.charAt(left++));
            }
            cache.add(ch);
            ans= Math.max(ans,right-left+1);
        }
        return ans;
    }
}