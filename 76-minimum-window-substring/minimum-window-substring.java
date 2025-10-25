class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int sp=0, ep=0, lenT= t.length();
        int asp=-1, aep= -1, count= 0;
        int hms[]= new int[256];
        int hmt[]= new int[256];
        for(char ch: t.toCharArray()){
            hmt[ch]++;
        }
        for(ep=0;ep<s.length();ep++){
            char ch= s.charAt(ep);
            hms[ch]++;
            if(hms[ch]<=hmt[ch]) ++count;
            char ch2= s.charAt(sp);
            while(hms[ch2]>hmt[ch2]){
                hms[ch2]--; sp++;
                if(sp>ep) break;
                ch2= s.charAt(sp);
            }
            if(count==lenT){
                if((asp==-1 && aep==-1) || ep-sp<aep-asp){
                    asp= sp; aep= ep;
                }
                hms[ch2]--; sp++; count--;
            }
        }
        if(asp==-1) return "";
        return s.substring(asp, aep+1);
    }
}