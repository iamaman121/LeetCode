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
        // if(!celebFollowers.containsKey(userId)) return;
        // for(int fId: celebFollowers.get(userId)){
        //     checkUserCanTweet(fId);
        //     userFeed.get(fId).add(tweetId);
        // }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap= new PriorityQueue<>((a,b)->b[0]-a[0]);
        if(userFeed.containsKey(userId)){
            Queue<int[]> q= userFeed.get(userId);
            int sz= q.size();
            while(sz-->0){
                int[] tweet= q.poll();
                maxHeap.add(tweet);
                q.offer(tweet);
            }
        }
        if(follows.containsKey(userId)){
            for(int celebId: follows.get(userId)){
                if(userFeed.containsKey(celebId)){
                    Queue<int[]> q= userFeed.get(celebId);
                    int sz= q.size();
                    while(sz-->0){
                        int[] tweet= q.poll();
                        maxHeap.add(tweet);
                        q.offer(tweet);
                    }
                }
            }
        }
        List<Integer> newsFeed= new ArrayList<>();
        for(int i=0;i<10;i++){
            if(!maxHeap.isEmpty()) newsFeed.add(maxHeap.remove()[1]);
        }
        maxHeap.clear();
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