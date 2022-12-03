class Twitter {

    private Map<Integer, Integer> tweetVsUser = new HashMap<>();
    private Map<Integer, Set<Integer>> usersVsFollowees = new HashMap<>();
    LinkedList<Integer> tweets = new LinkedList<>();

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.addFirst(tweetId);
        tweetVsUser.put(tweetId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        for (int tweet : tweets) {
            if (feed.size() >= 10)
                return feed;
            if (tweetVsUser.get(tweet).equals(userId) || usersVsFollowees.getOrDefault(userId, new HashSet<>()).contains(tweetVsUser.get(tweet))) {
                feed.add(tweet);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        usersVsFollowees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        usersVsFollowees.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}

/**
class Twitter {
    private static int timestamp = 0;
    private Map<Integer, User> userMap = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        userMap.computeIfAbsent(userId, k -> new User(userId)).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new LinkedList<>();

        if (!userMap.containsKey(userId))
            return feed;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>(users.size(), (t1, t2) -> t2.time - t1.time);

        for (int user : users) {
            Tweet tweetHead = userMap.get(user).head;
            if (tweetHead != null)
                priorityQueue.add(tweetHead);
        }

        while (!priorityQueue.isEmpty() && feed.size() < 10) {
            Tweet tweet = priorityQueue.poll();
            feed.add(tweet.id);
            if (tweet.next != null)
                priorityQueue.add(tweet.next);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId))
            userMap.put(followerId, new User(followerId));

        if (!userMap.containsKey(followeeId))
            userMap.put(followeeId, new User(followeeId));

        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId)
            return;

        userMap.get(followerId).unfollow(followeeId);
    }

    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timestamp++;
            next = null;
        }
    }

    private class User {
        public int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            this.follow(id);
            head = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = head;
            head = tweet;
        }
    }
}
*/