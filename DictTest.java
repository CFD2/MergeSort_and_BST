/**
 * @author Vadim Yastrebov
 * @version 09 August, 2017
 */
public class DictTest {

    public static void main(String[] args){
        BSTDictionary<String, SortableString> dict1 = new BSTDictionary<String, SortableString>();

        dict1.insert(new SortableString("CA"), "CA");
        dict1.insert(new SortableString("BA"), "BA");
        dict1.insert(new SortableString("AC"), "AC");
        dict1.insert(new SortableString("AA"), "AA");
        dict1.insert(new SortableString("BB"), "BB");
        dict1.insert(new SortableString("BC"), "BC");
        dict1.insert(new SortableString("CC"), "CC");
        dict1.insert(new SortableString("CB"), "CB");
        dict1.insert(new SortableString("AB"), "AB");



        System.out.print("============== Given tree ==============\n");
        dict1.printTree();
        System.out.println("Depth of the tree: " + dict1.depth() + "\n");

        dict1.delete(new SortableString("AB"));
        System.out.print("Tree after remove AB: ");
        dict1.printTree();

        dict1.delete(new SortableString("CC"));
        System.out.print("Tree after remove CC: ");
        dict1.printTree();

        dict1.delete(new SortableString("AA"));
        System.out.print("Tree after remove AA: ");
        dict1.printTree();

        dict1.delete(new SortableString("BA"));
        System.out.print("Tree after remove BA: ");
        dict1.printTree();

        dict1.delete(new SortableString("CA"));
        System.out.print("Tree after remove CA: ");
        dict1.printTree();

        System.out.println("Depth of the tree: " + dict1.depth() + " after removal.");

        dict1.insert(new SortableString("AB"), "AB");
        dict1.insert(new SortableString("CC"), "CC");
        dict1.insert(new SortableString("AA"), "AA");
        dict1.insert(new SortableString("BA"), "BA");
        dict1.insert(new SortableString("CA"), "CA");

        System.out.println("\nDepth of the tree: " + dict1.depth() + " after add.");
        dict1.printTree();
        System.out.println();

        System.out.println("Searching for: BB \tFound: " + dict1.search(new SortableString("BB")));
        System.out.println("Searching for: BA \tFound: " + dict1.search(new SortableString("BA")));
        System.out.println("Searching for: AA \tFound: " + dict1.search(new SortableString("AA")));
        System.out.println("Searching for: CC \tFound: " + dict1.search(new SortableString("CC")));
        System.out.println("Searching for: AK \tFound: " + dict1.search(new SortableString("AK")));
    }
}
