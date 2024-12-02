class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j=-1, k=0, n=pushed.length;
        for(int i=0;i<n;i++){
            pushed[j+1] = pushed[i];
            j++;
            while(k<n && j>=0 && popped[k]==pushed[j]){
                j--; k++;
            }
        }
        return j==-1;
    }
}