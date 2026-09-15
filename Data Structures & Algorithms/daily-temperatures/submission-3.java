class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        } 
        int n = temperatures.length;
        
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {  
                int top = stack.pop();
                result[top] = i - top; 
            }

            stack.push(i);
        }

        return result;
    }
}
