// Create a generic, singly linked list class called SList
// without implementing the List interface.
// Each Link object in the list should contain a reference to the next element in the list,
// but not the previous one.
// Create your own SListIterator which does not implement ListIterator.
// The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.
// The only way to insert and remove elements from an SList is through SListIterator.


public class Main {

    public static void main(String args[]){
        SList<Integer> list= new SList<>();
        SListIterator<Integer> itr = list.iterator();

        // Testing
        // The following code demonstrates SList
        System.out.println(list);
        itr.remove();
        itr.add(5);
        System.out.println(list);
        itr.add(10);
        itr.add(2);
        itr.add(28);
        itr.add(14);
        itr.add(83);
        System.out.println(list);
        SListIterator<Integer> itr2 = list.iterator(itr.getHead());
        System.out.println("1. " + itr2.getHead().value);
        System.out.println("2. " + itr2.getCurr().value);
        System.out.println("3. " + itr2.getNext().value);
        System.out.println("4. " + itr2.getCurr().value);
        System.out.println("5. " + itr2.getNext().value);
        System.out.println("6. " + itr2.getCurr().value);
        System.out.println("7. " + itr2.getPrev().value);
        System.out.println("8. " + itr2.getNext().value);
        System.out.println("9. " + itr2.getCurr().value);
        itr2.remove();
        System.out.println(list);
        System.out.println("10. " + itr2.getCurr().value);
        System.out.println("11. " + itr2.getPrev().value);
        itr2.remove();
        System.out.println(list);
        System.out.println("12. " + itr2.getCurr().value);
        System.out.println("13. " + itr2.getPrev().value);
        itr2.remove();
        System.out.println(list);
        System.out.println("14. " + itr2.getCurr().value);
        System.out.println("15. " + itr2.getNext().value);
    }
}
