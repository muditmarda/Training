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
