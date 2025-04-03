class Solution {
    public int uniqueLetterString(String s) {
        List<List<Integer>> indexes= new ArrayList<>();
        for(int i=0;i<26;i++) indexes.add(new ArrayList<>());
        for(int i=0;i<s.length();i++){
            indexes.get(s.charAt(i)-'A').add(i);
        }
        int[] ptr= new int[26];
        int ans=0;
        List<Integer> temp;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<26;j++){
                temp= indexes.get(j);
                if(temp.size()==0) continue;
                else if(ptr[j]==temp.size()-1){
                    ans+= s.length()-temp.get(ptr[j]);
                }
                else if(ptr[j]<temp.size()-1){
                    ans+= temp.get(ptr[j]+1)-temp.get(ptr[j]);
                }
            }
            ptr[s.charAt(i)-'A']++;
        }
        return ans;
    }
}