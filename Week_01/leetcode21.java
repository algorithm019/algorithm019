class leetcode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // l1 is empty,return l2
        if(l1 == null ) return l2;
        //l2 is empty, return l1
        if(l2 == null) return l1;
        ListNode dummyHead = new ListNode(-99);
        ListNode ptr =dummyHead;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                ptr.next = l1;
                l1=l1.next;
                ptr=ptr.next;
            }else{
                ptr.next =l2;
                l2=l2.next;
                ptr=ptr.next;
            }
        }
        //合并完以后可能还有一个没有合并完的，最多一个，所以就指向未完的链表
        ptr.next = l1 == null ? l2 : l1;
        return dummyHead.next;
        
    }
}