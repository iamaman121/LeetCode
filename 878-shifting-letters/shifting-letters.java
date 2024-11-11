class Solution {
    public String shiftingLetters(String s, int[] sft) {
        int n = sft.length;
        for(int i=n-2;i>=0;i--){
            sft[i]+= sft[i+1];
            if(sft[i]>=26) sft[i]= sft[i]%26;
        }
        char[] str = s.toCharArray();
        for(int i=0;i<n;i++){
            int val = str[i] - 97;
            val = (val+sft[i])%26;
            str[i] = (char)(97+val);
        }
        return "".valueOf(str);
    }
}