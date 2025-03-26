class Twitter {
    int time;
    Map<Integer, Set<Integer>> follows;
    Map<Integer, Queue<int[]>> userFeed;
    public Twitter() {
        time=0;
        follows= new HashMap<>();
        userFeed= new HashMap<>();
    }
    private void checkUserCanTweet(int userId){
        if(!userFeed.containsKey(userId)){
            userFeed.put(userId, new LinkedList<>());
        }
    }
    public void postTweet(int userId, int tweetId) {
        time++;
        checkUserCanTweet(userId);
        userFeed.get(userId).add(new int[]{time, tweetId});
        if(userFeed.get(userId).size()>10) userFeed.get(userId).remove();
    }
    private void addTweetsToHeap(PriorityQueue<int[]> minHeap, int uid){
        if(userFeed.containsKey(uid)){
            Queue<int[]> q= userFeed.get(uid);
            int sz= q.size();
            while(sz-->0){
                int[] tweet= q.poll();
                minHeap.add(tweet);
                if(minHeap.size()>10) minHeap.remove();
                q.offer(tweet);
            }
        }
    }
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> minHeap= new PriorityQueue<>((a,b)->a[0]-b[0]);
        addTweetsToHeap(minHeap, userId);
        if(follows.containsKey(userId)){
            for(int celebId: follows.get(userId)){
                addTweetsToHeap(minHeap, celebId);
            }
        }
        List<Integer> newsFeed= new ArrayList<>();
        for(int i=0;i<10;i++){
            if(!minHeap.isEmpty()) newsFeed.add(minHeap.remove()[1]);
        }
        Collections.reverse(newsFeed);
        minHeap.clear();
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!follows.containsKey(followerId)){
            follows.put(followerId, new HashSet<>());
        }
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId) && follows.get(followerId).contains(followeeId)){
            follows.get(followerId).remove(followeeId);
        }
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */