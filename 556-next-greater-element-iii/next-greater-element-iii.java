class Solution {
    public int nextGreaterElement(int n) {
        int nod= 0, m= n;
        while(m>0){
            m/=10;
            nod++;
        }
        int[] arr= new int[nod];
        m= n;
        for(int i=nod-1;i>=0;i--){
            arr[i]= m%10;
            m/=10;
        }
        boolean f= false;
        for(int i= nod-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                f= true;
                int j= i+1;
                for(int k= i+2;k<nod;k++){
                    if(arr[k]>arr[i] && arr[k]<arr[j]){
                        j= k;
                    }
                }
                int temp= arr[i];
                arr[i]= arr[j];
                arr[j]= temp;
                Arrays.sort(arr, i+1, nod);
                break;
            }
        }
        if(f){
            long ans=0;
            for(int a: arr){
                ans= ans*10+a;
            }
            if(ans>(long)Integer.MAX_VALUE) return -1;
            return (int)ans;
        }
        else return -1;
    }
}