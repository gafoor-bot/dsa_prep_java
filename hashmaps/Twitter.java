import java.util.*;

/*Link: https://neetcode.io/problems/design-twitter-feed/question
 * Design a simplified Twitter where users can post tweets, follow/unfollow others,
 * and retrieve the 10 most recent tweets in their news feed.
 */
public class Twitter {

    // Global counter to timestamp tweets in reverse order
    private int count;

    // Maps userId -> List of tweets. Each tweet is an int[]{time, tweetId}
    private Map<Integer, List<int[]>> tweetMap;

    // Maps userId -> Set of followeeIds (users they follow)
    private Map<Integer, Set<Integer>> followMap;

    /** 
     * Initialize the Twitter data structures.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    /**
     * Post a new tweet.
     * Time Complexity: O(1) to append tweet
     * Space Complexity: O(1) per tweet stored
     */
    public void postTweet(int userId, int tweetId) {
        // Initialize tweet list if user has no tweets yet
        tweetMap.putIfAbsent(userId, new ArrayList<>());

        // Add tweet with current timestamp (negative count for max-heap simulation)
        tweetMap.get(userId).add(new int[]{count--, tweetId});
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Tweets from the user and all followed users are included.
     * Time Complexity: O(N log K), where N = total tweets from all followees,
     *                 K = number of followees (heap size <= K)
     * Space Complexity: O(K), for the heap storing the most recent tweets of each followee
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        // Min-heap to get tweets by most recent timestamp (smallest count first)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Ensure the user follows themselves
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        // Add the most recent tweet of each followee to the heap
        for (int followeeId : followMap.get(userId)) {
            List<int[]> tweets = tweetMap.get(followeeId);
            if (tweets != null && !tweets.isEmpty()) {
                int index = tweets.size() - 1;  // Most recent tweet index
                int[] tweet = tweets.get(index);

                // Heap entry: {time, tweetId, userId, indexInList}
                minHeap.offer(new int[]{
                        tweet[0],
                        tweet[1],
                        followeeId,
                        index
                });
            }
        }

        // Extract up to 10 most recent tweets
        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] curr = minHeap.poll();
            res.add(curr[1]);

            int index = curr[3];
            int followeeId = curr[2];

            // If there are older tweets from this followee, add next one to heap
            if (index > 0) {
                int[] tweet = tweetMap.get(followeeId).get(index - 1);
                minHeap.offer(new int[]{
                        tweet[0],
                        tweet[1],
                        followeeId,
                        index - 1
                });
            }
        }

        return res;
    }

    /**
     * Follower follows a followee.
     * Time Complexity: O(1)
     * Space Complexity: O(1) per followee added
     */
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee (cannot unfollow themselves).
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followerId != followeeId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}