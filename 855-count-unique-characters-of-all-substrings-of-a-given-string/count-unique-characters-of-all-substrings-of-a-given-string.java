class Solution {
    public int uniqueLetterString(String s) {
        List<List<Integer>> indexes= new ArrayList<>();
        for(int i=0;i<26;i++) indexes.add(new ArrayList<>());
        for(int i=0;i<s.length();i++){
            indexes.get(s.charAt(i)-'A').add(i);
        }
        int ans=0, left, right;
        List<Integer> temp;
        for(int alp=0;alp<26;alp++){
            temp= indexes.get(alp);
            for(int i=0;i<temp.size();i++){
                //finding the number of substrings in which this char will contribute
                //set left value
                if(i==0){
                    left= temp.get(i)+1;
                }
                else{
                    left= temp.get(i)-temp.get(i-1);
                }
                //set right value
                if(i==temp.size()-1){
                    right= s.length()-temp.get(i);
                }
                else{
                    right= temp.get(i+1)-temp.get(i);
                }
                ans+= left*right;
            }
        }
        return ans;
    }
}