class Solution {
    public int firstUniqChar(String s) {
        int n= s.length(), count;
        char ch;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            ch= s.charAt(i);
            count= 0;
            if(hm.containsKey(ch)){
                count= hm.get(ch);
            }
            hm.put(ch,1+count);
        }
        for(int i=0;i<n;i++){
            if(hm.get(s.charAt(i))==1) return i;
        }
        return -1;
    }
}