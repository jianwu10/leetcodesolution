/*
 * [380] Insert Delete GetRandom O(1)
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 *
 * algorithms
 * Medium (40.50%)
 * Total Accepted:    73.8K
 * Total Submissions: 182.1K
 * Testcase Example:  '["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]\n[[],[1],[2],[2],[],[1],[2],[]]'
 *
 * Design a data structure that supports all following operations in average
 * O(1) time.
 *
 *
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each
 * element must have the same probability of being returned.
 *
 *
 *
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 *
 *
 */
class RandomizedSet {
  int size;
  Map<Integer, Set<Integer>> indexMap;
  List<Integer> set;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    size = 0;
    indexMap = new HashMap<>();
    set = new ArrayList<>();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (indexMap.containsKey(val)) {
      return false;
    }

    if (size == set.size()) {
      set.add(val);
    } else {
      set.set(size, val);
    }

    Set<Integer> indexSet;
    if (indexMap.containsKey(val)) {
      indexSet = indexMap.get(val);
    } else {
      indexSet = new HashSet<Integer>();
    }

    indexSet.add(size);
    indexMap.put(val, indexSet);
    size++;
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (!indexMap.containsKey(val)) {
      return false;
    }

    Set<Integer> indexSet = indexMap.get(val);
    Iterator<Integer> setIterator = indexSet.iterator();
    int index = setIterator.next();
    indexSet.remove(index);
    if (indexSet.isEmpty()) {
      indexMap.remove(val);
    }

    int lastElement = set.get(size - 1);
    set.set(index, lastElement);
    // update lastElement's indexSet
    Set<Integer> lastSet = indexMap.get(lastElement);
    if (lastSet != null) {
      lastSet.remove(size - 1);
      lastSet.add(index);
    }
    size--;
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int randomIndex = (int) (size * Math.random());
    return set.get(randomIndex);
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
