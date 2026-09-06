class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> mp = new HashMap<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            
            if (mp.containsKey(s.charAt(right))) {
                left = Math.max(mp.get(s.charAt(right)) + 1, left);

            }
            mp.put(s.charAt(right), right);
            ans = Math.max(ans, right - left + 1);
        }
        
        return ans;
    }
}
