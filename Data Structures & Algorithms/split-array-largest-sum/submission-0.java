class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        for (int num: nums) {
            left = Math.max(num, left);
            right += num;
        }

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (canSplit(nums, k, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    private boolean canSplit(int[] nums, int k, int largest) {
        int sub = 0;
        int currSum = 0;
        for (int num: nums) {
            currSum += num;
            if (currSum > largest) {
                sub++;
                if (sub + 1 > k) return false;
                currSum = num;
            }
        }

        return true;
    }
}