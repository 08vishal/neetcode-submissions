class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) return "";

        int[] tFreq = new int[128];
        int[] windowFreq = new int[128];

        for (char c : t.toCharArray()) tFreq[c]++;
        int left = 0, right = 0, formed = 0;
        int required = t.length();
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq[c]++;

            if (tFreq[c] > 0 && windowFreq[c] <= tFreq[c]) formed++;
            while (formed == required && left <= right) {
                int currentLen = right - left + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    minLeft = left;
                }
                char lChar = s.charAt(left);
                windowFreq[lChar]--;
                if (tFreq[lChar] > 0 && windowFreq[lChar] < tFreq[lChar]) formed--;
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
