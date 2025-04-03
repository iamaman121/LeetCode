class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        List<Integer> twoPtr= new ArrayList<>();
        List<Integer> threePtr= new ArrayList<>();
        List<Integer> FivePtr= new ArrayList<>();
        twoPtr.add(2); threePtr.add(3); FivePtr.add(5); 
        int i=0, j=0, k=0, prev=1;
        for(int cnt=2;cnt<=n;cnt++){
            while(i<twoPtr.size() && twoPtr.get(i)<=prev) ++i;
            while(j<threePtr.size() && threePtr.get(j)<=prev) ++j;
            while(k<FivePtr.size() && FivePtr.get(k)<=prev) ++k;
            prev= Math.min(FivePtr.get(k), Math.min(twoPtr.get(i), threePtr.get(j)));
            twoPtr.add(prev*2);threePtr.add(prev*3);FivePtr.add(prev*5);
            if(cnt==n) return prev;
        }
        return -1;
    }
}