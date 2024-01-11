
public class PolyDataLinkedList<T extends Comparable<T>> {
    private PolydataNode<T> First;
    private PolydataNode<T> Last;
    private int length;

    public PolyDataLinkedList() {
        First = Last = null;
        length = 0;
    }
    public boolean isEmpty() {
        return First == null || length == 0;
    }
    public PolydataNode<T> GetFirst() {
        return First;
    }
    public void InsertFirst(T coeff , T power) {
        PolydataNode<T> newnode = new PolydataNode<>(coeff,power);
        if(isEmpty()) {
            First = Last = newnode;
            newnode.next = null;
        }else {
            newnode.next = First;
            First = newnode;
        }
        length++;
    }

    public void Add(T coeff , T power) {
        PolydataNode<T> newnode = new PolydataNode<>(coeff, power);
        if(isEmpty()) {
            First = Last = newnode;
            newnode.next = null;
        }else {
            Last.next = newnode;
            newnode.next = null;
            Last = newnode;
        }
        length++;
    }

    public void InsertAt(T coeff , T power , int pos) {
        if(pos < 0 || pos > length) {
            System.out.println("the given position is out of range");
            return;
        }else {
            PolydataNode<T> newnode = new PolydataNode<>(coeff,power);
            if(pos == 0)
                InsertFirst(coeff,power);
            else if(pos == length)
                Add(coeff,power);
            else {
                PolydataNode<T> current = First;
                for(int i = 1 ; i<pos ; i++) {
                    current = current.next;
                }
                newnode.next = current.next;
                current.next = newnode;
            }
        }
        length++;
    }

    public PolydataNode<T> getFirst() {
        return First;
    }
    public PolydataNode<T> getLast() {
        return Last;
    }
    public void print() {
        PolydataNode<T> current = First;
        StringBuilder Linked = new StringBuilder();
        int counter = 0;
        while(current != null) {
            if(counter == length-1)
                Linked.append("[").append(current.Coeff).append("|").append(current.Power).append("]");
            else
                Linked.append("[").append(current.Coeff).append("|").append(current.Power).append("]").append("---");
            current = current.next;
            counter++;
        }
        System.out.println(Linked);
    }

    public int size() {
        return length;
    }

}
