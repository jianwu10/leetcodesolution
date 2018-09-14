/*
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Hard (21.26%)
 * Total Accepted:    201.7K
 * Total Submissions: 948.6K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 *
 *
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 *
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 ); //capacity
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 *
 */
class LRUCache {

    class ListNode {
      int key, value;
      ListNode next;

      public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
      }
    }

    private int size, capacity;
    private ListNode dummy, tail;
    private Map<Integer, ListNode> keyToPrev;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      size = 0;
      dummy = new ListNode(0, 0);
      tail = dummy;
      keyToPrev = new HashMap<Integer, ListNode>();
    }

    // move the current node to tail
    public void moveToTail(int key) {
      if (!keyToPrev.containsKey(key)) {
        return;
      }

      ListNode prev = keyToPrev.get(key);
      ListNode curr = prev.next;

      if (tail == curr) {
        return;
      }

      prev.next = curr.next;
      keyToPrev.put(curr.next.key, prev);

      tail.next = curr;
      keyToPrev.put(curr.key, tail);
      tail = curr;
    }

    public int get(int key) {
      if (!keyToPrev.containsKey(key)) {
        return -1;
      }

      moveToTail(key);
      return tail.value;
    }

    public void put(int key, int value) {
      if (keyToPrev.containsKey(key)) {
        // update the value
        // move the node to tail
        ListNode prev = keyToPrev.get(key);
        prev.next.value = value;
        moveToTail(key);
        return;
      }

      if (size < capacity) {
        size++;
        // add a new node to tail
        ListNode recentNode = new ListNode(key, value);
        tail.next = recentNode;
        keyToPrev.put(key, tail);
        tail = recentNode;
        return;
      }

      // update the first node and move to tail
      ListNode first = dummy.next;
      // remove mapping
      keyToPrev.remove(first.key);
      // update key and value
      first.key = key;
      first.value = value;
      // rebinding
      keyToPrev.put(key, dummy);
      moveToTail(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
