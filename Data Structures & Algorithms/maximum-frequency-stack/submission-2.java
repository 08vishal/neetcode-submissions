class FreqStack {

    private Map<Integer, Integer> count;
    private List<Stack<Integer>> stack;

    public FreqStack() {
        count = new HashMap<>();
        stack = new ArrayList<>();  
        stack.add(new Stack<>());
    }
    
    public void push(int val) {
        int valCount = count.getOrDefault(val, 0) + 1;
        count.put(val, valCount);
        if (valCount == stack.size()) {
            stack.add(new Stack<>());
        }

        stack.get(valCount).push(val);
    }
    
    public int pop() {
        Stack<Integer> topStack = stack.get(stack.size() - 1);
        int res = topStack.pop();
        count.put(res, count.get(res) - 1);
        if (topStack.isEmpty()) {
            stack.remove(stack.size() - 1);
        }

        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */