// Java program to demonstrate
// insert operation in binary
// search tree
/**
 * @author: GeeksforGeeks
 */
class BinarySearchTree<T> {
 
    /* Class containing left
       and right child of current node
     * and key value*/
    // Root of BST
    Node root;
 
    // Constructor
    BinarySearchTree()
    {
         root = null;
    }
 
    
    /** 
     * @param key
     * @param valor
     * @return Node
     */
    // This method mainly calls insertRec()
    Node insert(int key, Association<String,String[]> valor)
    {
         root = insertRec(root, key, valor);
         return root;
    }
 
    
    /** 
     * @param root
     * @param key
     * @param valor
     * @return Node
     */
    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int key, Association<String,String[]> valor)
    {
 
        /* If the tree is empty,
           return a new node */
        if (root == null)
        {
            root = new Node(key, valor);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key, valor);
        else if (key > root.key)
            root.right = insertRec(root.right, key, valor);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    // This method mainly calls InorderRec()
    void inorder()
    {
         inorderRec(root);
    }
 
    
    /** 
     * @param root
     */
    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    
    /** 
     * @param root
     * @param key
     * @return Node
     */
    // A utility function to search a given key in BST
    public Node search(Node root, int key)
    {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root;
    
        // Key is greater than root's key
        if (root.key < key)
        return search(root.right, key);
    
        // Key is smaller than root's key
        return search(root.left, key);
    }

    
    /** 
     * @return Node
     */
    public Node getRoot() {
        return root;
    }
}