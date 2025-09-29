class Solution {
    public int nextGreaterElement(int n) {
        char[] num= (n+"").toCharArray();
        int idx= -1;
        for(int i=num.length-2;i>=0;i--){
            if(num[i]<num[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1) return -1;
        int smallesIdx= idx+1;
        for(int i=idx+2;i<num.length;i++){
            if(num[i]>num[idx] && num[i]<=num[smallesIdx]){
                smallesIdx= i;
            }
        }
        swap(num, idx, smallesIdx);
        int sp= idx+1, ep= num.length-1;
        while(sp<ep){
            swap(num, sp, ep);
            sp++; ep--;
        }
        long ans= Long.parseLong(new String(num));
        if(ans>Integer.MAX_VALUE) return -1;
        else return (int)ans;
    }
    private static void swap(char[] num, int i,int j){
        char temp= num[i];
        num[i]= num[j];
        num[j]= temp;
    }
}