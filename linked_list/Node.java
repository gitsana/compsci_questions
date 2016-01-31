package linked_list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node {
    Node next = null;
    Object data;
    int intdata;

    public Node(Object d) {
        this.data = d;
    }

    public Node(int i, Object data) {
        this.intdata = i;
        this.data = data;
    }

    void appendToTail(Object d) {
        Node endNode = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = endNode;
    }

    void printDetailList() {
        System.out.println("---- PRINTING DETAILED LIST ----");
        Node temp = this;
        while (temp != null) {
            System.out.println(temp + "," + temp.data + "," + temp.next);
            temp = temp.next;
        }
    }

    void printSimpleList() {
        System.out.println("---- PRINTING SIMPLE LIST ----");
        Node temp = this;
        String output = "[";
        while (temp != null) {
            output += temp.data + ", ";
            temp = temp.next;
        }
        output += "]";
        System.out.println(output);
    }

    // Question 1.1 - this one stores data in HashSet (aka "buffer" according to book)
    // should we implement the linked list or use Java built in one? -- build one
    // singly or doubly linked list? -- singly, make doubly with minimal effort
    // object type? generic object
    void removeDupes() {
        Set set = new HashSet<>();
        Node curr = this;
        Node prev = null;

        while (curr.next != null) {
            if (set.contains(curr.data)) {
                prev.next = curr.next;
            }
            else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
        // last element data, n.next is null
        if (set.contains(curr.data)) {
            prev.next = null;
        }
    }

    // Question 1.1 but without the buffer
    // uses a nested while loop
    void removeDupesWithoutHashSet() {
        Node curr = this;
        Node runner = curr;

        while (curr != null) {
            while (runner.next != null) {
                if (curr.data == runner.next.data) {
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            } // inner while

            curr = curr.next;
            runner = curr;
        } // outer while
    } // removeDupesWithoutHashSet

    // Question 2.2 Implement an algorithm to find the kth to last element of a singly linked list
    Object returnKthToLastElement(int k) {

        Node curr = this;
        Map hashMap = new HashMap<>();
        int counter = 0;

        while (curr != null) {
            hashMap.put(counter, curr.data);
            counter++;
            curr = curr.next;
        }
        int x = hashMap.size()-k;
        System.out.println(hashMap);
        return hashMap.get(x);
    }

    // find out length and go back
    Node kthToLastNode(int k) {
        Node runner = this;
        if ((k == 0) || (runner == null))
            return null;

        int listlength = 1; // store list length in here for later
        Node runner2 = this;

        while (runner.next != null) {
            runner = runner.next;
            listlength++;
        }

        if (k > listlength)
            return null;
        else if (k == listlength)
            return runner2;
        else {
            int counter = 1;
            int startvar = ((listlength-k)+1);
            System.out.println("listlen: " + listlength + ", k: " + k + ", startvar: " + startvar);
            while (counter < ((listlength-k)+1)) {
                runner2 = runner2.next;
                counter ++;
                System.out.println("counter: " + counter + ", runner2: " + runner2.data);
            }
            return runner2;
        }
    }

    // two pointer method k spaces apart
    Node kthToLastNodePointerMethod(int k) {
        Node p1 = this;
        Node p2 = this;
        int counter = 1;

        while ((p1.next != null) && (counter < k)){
            p1 = p1.next;
            counter ++;
        }
        // catch edge case if k is greater than length of list, counter and k should be equal at this point
        if (counter < k) {
            return null;
        }

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    // Question 2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node
    void removeMiddleNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    void partitionList(int x) {
        Node runner = this;
        Node list1 = new Node(null);
        Node list2 = new Node(null);

        while (runner != null) {
            if ( (runner.intdata) < x) {
                list1.appendToTail(runner.intdata);
            }
            else {
                list2.appendToTail(runner.intdata);
            }
            runner = runner.next;
        }
    }
}
