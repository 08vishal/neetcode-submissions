class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (!stk.isEmpty() && stk.peek() == map.get(c)) stk.pop();
                else return false;
            } else {
                stk.push(c);
            }
        }

        return stk.isEmpty();
    }
}
