class KthLargest {

    PriorityQueue<Integer> pq;
    int queueSize;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        queueSize = k;
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > queueSize) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > queueSize) pq.poll();
        
        return pq.peek();
    }
}
