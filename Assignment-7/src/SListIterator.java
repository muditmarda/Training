public class SListIterator<T> {
    private ListNode head, curr , prev;
    public SListIterator(ListNode node){
        curr = node;
        head = node;
    }
    boolean hasNext(){
        if (curr.next == null)
            return false;
        else
            return true;
    }

    public ListNode getNext() {
        if(hasNext()) {
            prev = curr;
            curr = curr.next;
            return curr;
        }
        return null;
    }

    public void add(T t){
        ListNode node;
        if(hasNext()) {
            node = new ListNode(t, curr.next);
        }
        else {
            node = new ListNode(t, null);
        }
        curr.next = node;
        prev = curr;
        curr = curr.next;
    }

    public ListNode getCurr() {
        return curr;
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode getPrev() {
        return prev;
    }

    void remove(){
        if (curr.value == null)
            System.out.println("List is empty. Cannot remove anything.");
        else if (curr.next == null) {
            prev.next = null;
            curr = prev;
        }
        else {
            prev.next = curr.next;
            curr = prev;
        }
        prev = null;
        ListNode temp = getHead();
        while(temp != curr){
            prev = temp;
            temp = temp.next;
        }
    }
}
