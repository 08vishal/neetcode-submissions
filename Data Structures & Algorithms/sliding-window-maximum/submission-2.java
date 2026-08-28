class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;

        Deque<Integer> q = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {

            while (!q.isEmpty() && q.peekFirst() < r - k + 1) {
                q.pollFirst();
            }

            // Remove smaller elements from the back
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[r]) {
                q.pollLast();
            }

            q.addLast(r);

            // Front always contains index of maximum
            if (r >= k - 1) {
                result[index++] = nums[q.peekFirst()];
            }
        }

        return result;
    }
}
