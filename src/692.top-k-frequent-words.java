/*
 * [692] Top K Frequent Words
 *
 * https://leetcode.com/problems/top-k-frequent-words/description/
 *
 * algorithms
 * Medium (42.36%)
 * Total Accepted:    31.2K
 * Total Submissions: 73.5K
 * Testcase Example:  '["i", "love", "leetcode", "i", "love", "coding"]\n2'
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two
 * words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 *
 * Example 1:
 *
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * ⁠   Note that "i" comes before "love" due to a lower alphabetical order.
 *
 *
 *
 * Example 2:
 *
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is",
 * "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent
 * words,
 * ⁠   with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 *
 *
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 *
 *
 *
 * Follow up:
 *
 * Try to solve it in O(n log k) time and O(n) extra space.
 *
 *
 */
class Solution {

  class Pair {
    String val;
    int count;

    public Pair(String val, int count) {
      this.val = val;
      this.count = count;
    }
  }

  private Comparator<Pair> pairComparator = new Comparator<Pair>() {
    public int compare(Pair A, Pair B) {
      if (A.count != B.count) {
        return A.count - B.count;
      }
      return B.val.compareTo(A.val);
    }
  };

  public List<String> topKFrequent(String[] words, int k) {
    if (words == null || words.length == 0 || k <= 0) {
      return new ArrayList<String>();
    }

    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      if (map.containsKey(word)) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
    }

    Queue<Pair> minHeap = new PriorityQueue<>(pairComparator);
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      Pair newPair = new Pair(entry.getKey(), entry.getValue());
      minHeap.offer(newPair);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    List<String> results = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      results.add(minHeap.poll().val);
    }

    Collections.reverse(results);

    return results;

  }
}
