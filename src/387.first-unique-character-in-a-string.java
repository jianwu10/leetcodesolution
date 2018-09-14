/*
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (47.58%)
 * Total Accepted:    162.2K
 * Total Submissions: 340.8K
 * Testcase Example:  '"leetcode"'
 *
 *
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 *
 *
 *
 * Note: You may assume the string contain only lowercase letters.
 *
 */
class Solution {
  class ListCharNode {
    char key;
    int index;
    ListCharNode next;

    public ListCharNode(char key, int index) {
      this.key = key;
      this.index = index;
      next = null;
    }
  }

  class DataStream {
    ListCharNode dummy, tail;
    Map<Character, ListCharNode> charToPrev;
    Set<Character> duplicates;

    public DataStream() {
      dummy = new ListCharNode('.', 0);
      tail = dummy;
      charToPrev = new HashMap<>();
      duplicates = new HashSet<>();
    }

    public void add(char key, int index) {
      if (duplicates.contains(key)) {
        return;
      }

      if (!charToPrev.containsKey(key)) {
        // It's a new ListCharNode
        // Add it to tail
        ListCharNode newNode = new ListCharNode(key, index);
        tail.next = newNode;
        charToPrev.put(key, tail);
        tail = newNode;
        return;
      }

      // It's a duplicate
      // Remove it from the list
      ListCharNode prev = charToPrev.get(key);
      ListCharNode curr = prev.next;
      if (curr == tail) {
        tail = prev;
      } else {
        charToPrev.put(curr.next.key, prev);
      }

      prev.next = curr.next;
      charToPrev.remove(key);
      duplicates.add(key);
    }
  }
  public int firstUniqChar(String s) {
    if (s == null || s.length() == 0) {
      return -1;
    }

    DataStream ds = new DataStream();
    for (int i = 0; i < s.length(); i++) {
      ds.add(s.charAt(i), i);
    }

    ListCharNode firstNode = ds.dummy.next;
    if (firstNode == null) {
      return -1;
    }

    return firstNode.index;
  }
}
