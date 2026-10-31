class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);  
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );
        for (int num : map.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue)
                                   .toArray();
    }
}
