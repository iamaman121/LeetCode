class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int[] lalp= new int[26];
        int[] ualp= new int[26];
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(ch>='a' && ch<='z'){
                lalp[ch-'a']++;
            }
            else{
                ualp[ch-'A']++;
            }
        }
        for(int i=0;i<t.length()-1;i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                lalp[ch-'a']--;
            }
            else{
                ualp[ch-'A']--;
            }
        }
        int clft=0, alft=-1, argt=s.length()-1;
        for(int j=t.length()-1;j<s.length();j++){

            char chr = s.charAt(j);
            if(chr>='a' && chr<='z'){
                lalp[chr-'a']--;
            }
            else{
                ualp[chr-'A']--;
            }
            boolean ans = true;
            for(int i=0;i<26;i++){
                if(lalp[i]>0 || ualp[i]>0){
                    ans=false;
                    break;
                }
            }
            while(ans){
                if(j-clft+1<argt-alft+1){
                    alft=clft; argt=j;
                }

                char ch = s.charAt(clft++);
                if(ch>='a' && ch<='z'){
                    lalp[ch-'a']++;
                }
                else{
                    ualp[ch-'A']++;
                }

                for(int i=0;i<26;i++){
                    if(lalp[i]>0 || ualp[i]>0){
                        ans=false;
                        break;
                    }
                }
            }
        }
        return alft==-1?"":s.substring(alft, argt+1);
    }
}