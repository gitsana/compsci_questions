package linked_list;

public class Main {

    public static void main(String[] args) {

//        Node myNode1 = new Node(77);
//        myNode1.appendToTail(10);
//        myNode1.appendToTail(15);
//        myNode1.appendToTail(77);
//        myNode1.appendToTail(10);
//
//        myNode1.printDetailList();
//        myNode1.printSimpleList();
//
//        Node myNode2 = myNode1;
//
//        myNode2.printDetailList();
//        myNode2.printSimpleList();
//        myNode2.appendToTail(400);
//
//        System.out.println("\n*** Node 1 *** ");
//
//        myNode1.printDetailList();
//        myNode1.printSimpleList();
//
//        System.out.println("\n*** Node 2*** ");
//
//        myNode2.printDetailList();
//        myNode2.printSimpleList();
//
////        myNode1.removeDupes();
//        myNode1.removeDupesWithoutHashSet();
//        System.out.println("\n*** DUPES REMOVED *** ");
//        myNode1.printSimpleList();
//        myNode2.printDetailList();

        Node fruitList = new Node("apple");
        fruitList.appendToTail("banana");
        fruitList.appendToTail("banana");
        fruitList.appendToTail("orange");
        fruitList.appendToTail("orange");
        fruitList.appendToTail("blueberry");
        fruitList.appendToTail("rasperry");
        fruitList.appendToTail("strawberry");
        fruitList.appendToTail("pomogranet");
        fruitList.appendToTail("pomelo");

        fruitList.printSimpleList();

        fruitList.removeDupesWithoutHashSet();

        fruitList.printSimpleList();

        System.out.println("\nkth to last element:");
        System.out.println(fruitList.returnKthToLastElement(1));
        System.out.println(fruitList.kthToLastNode(2).data);
//        fruitList.printDetailList();
        System.out.println(fruitList.kthToLastNodePointerMethod(7).data);
        fruitList.printSimpleList();

        Node x = fruitList;
        while (x.data != "rasperry") {
            x = x.next;
        }
        System.out.println("x.data: " + x.data);
        fruitList.removeMiddleNode(x);
        fruitList.printSimpleList();
    }
}
