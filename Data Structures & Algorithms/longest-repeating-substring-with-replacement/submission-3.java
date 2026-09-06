class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        HashMap<Character, Integer> count = new HashMap<>();

        int left = 0;
        int maxF = 0;

        for (int right = 0; right < s.length(); right++) {

            char startC = s.charAt(left);
            char endC = s.charAt(right);

            count.put(endC, count.getOrDefault(endC, 0) + 1);

            maxF = Math.max(maxF, count.get(endC));
            while (right - left + 1 > k + maxF) {
                count.put(startC, count.get(startC) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
