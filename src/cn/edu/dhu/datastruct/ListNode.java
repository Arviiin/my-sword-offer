package cn.edu.dhu.datastruct;

public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }

    public void add(ListNode node) {
        this.next = node;
    }

    public boolean hasListNext() {
        return this.next == null ? false : true;
    }

}
