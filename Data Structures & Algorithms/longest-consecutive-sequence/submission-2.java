class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);

        int longest = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int l = 1;
                while (set.contains(n + l)) l++;
                longest = Math.max(longest, l);
            }
        }

        return longest;
    }
}
