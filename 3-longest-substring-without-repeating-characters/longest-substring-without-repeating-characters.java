class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> indexOfCharacter = new HashMap<>();
        int left=0, ans=0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if(indexOfCharacter.containsKey(ch)){
                int index = indexOfCharacter.get(ch);
                while(left<=index){
                    indexOfCharacter.remove(s.charAt(left));
                    left++;
                }
            }
            indexOfCharacter.put(ch,right);
            ans= Math.max(ans,right-left+1);
        }
        return ans;
    }
}