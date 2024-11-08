class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n= arr.length, count;
        HashMap<Integer,Integer> freqOfElem = new HashMap<>();
        for(int i=0;i<n;i++){
            count= 0;
            if(freqOfElem.containsKey(arr[i])){
                count= freqOfElem.get(arr[i]);
            }
            freqOfElem.put(arr[i],count+1);
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int k: freqOfElem.keySet()){
            if(hs.contains(freqOfElem.get(k))){
                return false;
            }
            hs.add(freqOfElem.get(k));
        }
        return true;
    }
}