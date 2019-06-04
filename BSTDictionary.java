/**
  * @author Vadim Yastrebov
 * @version 2017.08.02
 */
public class BSTDictionary <E, K extends Sortable> implements Dictionary<E, K> {
    private BSTNode<E, K> root;

    /**
     * Searches for a node by it's param 'Key'
     * @param key is that param up there
     * @return a found element
     */
    @Override
    public E search(K key) {
        BSTNode<E, K> found = search(root, key);
        if (found.getLeft() != null && key.compareTo(found.getLeft().getKey()) == 0) {
            return found.getLeft().getElement();
        } else if (found.getRight() != null && key.compareTo(found.getRight().getKey()) == 0) {
            return found.getRight().getElement();
        } else {
            return null;
        }
    }

    /**
     * Inserts an element in a tree at a position specified by the key
     * @param key the key
     * @param element the element
     */
    @Override
    public void insert(K key, E element) {
        if (root == null) {
            root = new BSTNode<>(key, element, null, null);
        }
        BSTNode<E, K> found = search(root, key);
        int compare = key.compareTo(found.getKey());
        if (compare < 0 && found.getLeft() == null) {
            found.setLeft(new BSTNode<>(key, element, null, null));
        } else if (compare > 0 && found.getRight() == null) {
            found.setRight(new BSTNode<>(key, element, null, null));
        }
    }

    /**
     * deletes an element from a tree which corresponds to the key
     * @param key search val
     */
    @Override
    public void delete(K key) {
        delete(search(root, key), key);

    }

    /**
     * PRINTS A TREE. BST PLS.
     */
    @Override
    public void printTree() {
        print(root);
        System.out.println();

    }

    /**
     * calls recursive tree accessor to calculate MAX DEPTH
     * @return returns what's written above (recursion in a nutshell)
     */
    @Override
    public int depth() {
        return getDepth(root);
    }

    /**
     * returns max depth of the BST. RECURSIVELY
     * @param current is a pointer to a tree node
     * @return a node for recursive purposes
     */
    private int getDepth(BSTNode<E, K> current) {
        if (current == null) {
            return 0;
        } else {
            return Integer.max(getDepth(current.getLeft()), getDepth(current.getRight())) + 1;  //Good luck Mohamed XDDDD
        }
    }


    /**
     * recursive search
     * @param current is a pointer to a tree node
     * @param key is a key to search
     * @return  a node for recursive purposes
     */
    private BSTNode<E, K> search (BSTNode<E, K> current, K key) {
        if (current == null) {
            return null;
        }
        int compare = key.compareTo(current.getKey());
        if (compare == 0) {
            return current;
        } else if (compare < 0 && current.getLeft() != null) {
            if (key.compareTo(current.getLeft().getKey()) == 0){
                return current;
            }
            return search(current.getLeft(), key);
        } else if (compare > 0 && current.getRight() != null) {
            if (key.compareTo(current.getRight().getKey()) == 0) {
                return current;
            }
            return search(current.getRight(), key);
        }
        return current;
    }

    /**
     * Recruisive methos fro dleetion
     * @param current is a pointer to a tree node
     * @param key key to find
     * @return returns node for recruisive pruposes
     */
    private BSTNode<E, K> delete (BSTNode<E, K> current, K key) {
        if (current == null) {
            return null;
        }
        int compare = key.compareTo(current.getKey());
        if (compare < 0) {
            current.setLeft(delete(current.getLeft(), key));
        } else if (compare > 0) {
            current.setRight(delete(current.getRight(), key));
        } else {
            // if compare == 0
            if (current.getRight() == null) {
                return current.getLeft();
            } else if (current.getLeft() == null) {
                return current.getRight();
            } else {
                //case for 2 children
                BSTNode<E, K> predecessor = deepPredecessor(current.getRight());    //first goes right then recursively goes down left all the way
                current.key = predecessor.getKey();
                current.element = predecessor.getElement();
                current.setRight(delete(current.getRight(), predecessor.getKey()));
            }
        }
        return current;
    }

    /**
     * A method to find inorder (?) predecessor  (RIGHT LEFTMOST). you get the idea.
     * @param current is a reference to a tree node.
     * @return this deepest predecessor node is returned
     */
    private BSTNode<E, K> deepPredecessor (BSTNode<E, K> current) {
        if (current == null) {
            return null;
        } else if (current.getLeft() == null) {
            return current;
        }
        return deepPredecessor(current.getLeft());
    }

    /**
     * InOrder traversal to print a tree. Simple yet effective.
     * @param current is a reference to a tree node.
     */
    private void print (BSTNode<E, K> current) {
        if (current != null) {
            print(current.getLeft());
            System.out.print(current.getElement() + ", ");
            print(current.getRight());
        }
    }
}
