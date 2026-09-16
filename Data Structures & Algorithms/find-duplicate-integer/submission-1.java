class Solution {
    public int findDuplicate(int[] nums) {
        for (int num: nums) {
            if (nums[Math.abs(num) - 1] < 0) return Math.abs(num);
            nums[Math.abs(num) - 1] *= -1;
        }

        return -1;
    }
}
