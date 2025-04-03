class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> twoPtr= new ArrayList<>();
        List<Integer> threePtr= new ArrayList<>();
        List<Integer> FivePtr= new ArrayList<>();
        twoPtr.add(1); threePtr.add(1); FivePtr.add(1); 
        int i=0, j=0, k=0, prev=1;
        while(n-->0){
            prev= Math.min(FivePtr.get(k), Math.min(twoPtr.get(i), threePtr.get(j)));
            while(i<twoPtr.size() && twoPtr.get(i)<=prev) ++i;
            while(j<threePtr.size() && threePtr.get(j)<=prev) ++j;
            while(k<FivePtr.size() && FivePtr.get(k)<=prev) ++k;
            twoPtr.add(prev*2);threePtr.add(prev*3);FivePtr.add(prev*5);
        }
        return prev;
    }
}