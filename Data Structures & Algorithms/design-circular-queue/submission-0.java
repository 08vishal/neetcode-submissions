class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
class MyCircularQueue {
    private int size;
    private ListNode left;
    private ListNode right;

    public MyCircularQueue(int k) {
        this.size = k;
        this.left = new ListNode(0);
        this.right = this.left;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;

        ListNode cur = new ListNode(value);
        if (isEmpty()) {
            left.next = cur;
            right = cur;
        } else {
            right.next = cur;
            right = cur;
        }

        size--;
        return true;
        
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;

        left.next = left.next.next;
        if (left.next == null) right = left;
        size++;
        return true;
    }
    
    public int Front() {
        return isEmpty()? -1: left.next.val;
    }
    
    public int Rear() {
        return isEmpty()? -1 : right.val;
    }
    
    public boolean isEmpty() {
        return left.next == null;
    }
    
    public boolean isFull() {
        return size == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */