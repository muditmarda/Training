// SList is a generic, singly linked list class which doesn't implement the List interface.
// Each Link object in the list contains a reference to the next element in the list,
// but not the previous one.

public class SList<T> {
    public ListNode<T> head = new ListNode(null);

        @Override
    public String toString(){
        if(head.next == null) return "List be empty!";
        else {
            SListIterator<T> itr = this.iterator();
            StringBuilder s = new StringBuilder();
            s.append("SList: [ ");
            while (itr.hasNext()) {
                s.append(itr.getNext().value + (itr.hasNext() ? ", " : ""));
            }
            return s + " ]";
        }
    }

    public SListIterator<T> iterator(){
        SListIterator<T> itr = new SListIterator<T>(head);
        return itr;
    }

    public SListIterator<T> iterator(ListNode node){
        SListIterator<T> itr = new SListIterator<T>(node);
        return itr;
    }
}
