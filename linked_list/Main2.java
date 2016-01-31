package linked_list;

public class Main2 {

    public static class NodeObj {
        NodeObj next = null;
        int data;

        public NodeObj() {
        }

        public NodeObj(int d) {
            this.data = d;
        }

        void appendDataToTail(int d) {
            NodeObj runner = this;
            NodeObj newNode = new NodeObj(d);

            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }

        void appendNodeToTail(NodeObj newNode) {
            NodeObj runner = this;

            if (runner == null) {
                runner.next = newNode;
            }
            else{
                while (runner.next != null) {
                    runner = runner.next;
                }
                runner.next = newNode;
            }
        }

        void printSimpelList() {
            System.out.println("*** Printing a simple list ***");
            NodeObj runner = this;
            while (runner != null) {
                System.out.println(runner.data + " || " + runner + " => " + runner.next);
                runner = runner.next;
            }
            System.out.println("********************");
        }

        void partitionList(int partitionVal) {
            NodeObj list1 = new NodeObj();
            NodeObj list2 = new NodeObj();
            NodeObj runner = this;

            while (runner != null) {
                if (runner.data < partitionVal) {
                    list1.appendDataToTail(runner.data);
                }
                else {
                    list2.appendDataToTail(runner.data);
                }
                runner = runner.next;
            }
            list1.appendNodeToTail(list2);
        }
    }
    public static void main(String[] args) {

        NodeObj mylist = new NodeObj(17);
        mylist.appendDataToTail(3);
        mylist.appendDataToTail(4);
        mylist.appendDataToTail(5);
        mylist.appendDataToTail(88);

        NodeObj node1 = new NodeObj(333);
        mylist.appendNodeToTail(node1);

        mylist.printSimpelList();

        mylist.partitionList(5);
        mylist.printSimpelList();
        System.out.println(mylist);

    }
}
