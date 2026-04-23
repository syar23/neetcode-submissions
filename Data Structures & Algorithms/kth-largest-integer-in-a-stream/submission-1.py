class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        
        self.minHeap, self.k = nums, k
        #right now it is only an array
        #now we convert it into min heap
        heapq.heapify(self.minHeap)
        while len(self.minHeap) > k :
            heapq.heappop(self.minHeap)

    def add(self, val: int) -> int:
        heapq.heappush(self.minHeap, val)
        if len(self.minHeap) > self.k:
            heapq.heappop(self.minHeap)
        return self.minHeap[0]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)