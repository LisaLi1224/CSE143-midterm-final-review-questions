public class IntTree {
   private IntTreeNode overallRoot;
   
   public boolean hasPathSum(int n) {
      return hasPathSum(n,overallRoot);
   }
   
   private boolean hasPathSum(int n, IntTreeNode root){
      if (root == null) {
         return false;
      }
      if (root.data == n){
         return true;
      } 
      return hasPathSum(n-root.data, root.left) || hasPathSum(n-root.data, root.right);
   }
   
   public void add(IntTree tree2) {
      overallRoot = add(overallRoot, tree2.overallRoot);
   }
   
   public IntTreeNode add(IntTreeNode root1, IntTreeNode root2){
      if (root2 != null) {
         if (root1 == null) {
            root1 = new IntTreeNode(0);
         }
         root1.data = root1.data + root2.data;
         root1.left = add(root1.left, root2.left);
         root1.right = add(root1.right, root2.right);
      }
      return root1;
   }
   
   public boolean hasZeroPath(){
      return hasZeroPath(overallRoot);
   }
   
   private boolean hasZeroPath(IntTreeNode root) {
      if(root == null) {
         return true;
      } else if (root.data == 0) {
         return hasZeroPath(root.left) || hasZeroPath(root.right);
      } 
      return false;
   }
   
//    public void indicateMatching(IntTree other) {
//       overallRoot = indicateMatching(this.overallRoot, other.overallRoot);
//    }
// 
//    private IntTreeNode indicateMatching(IntTreeNode root1, IntTreeNode root2) {
//       if (root1 == null && root2!=null) {
//          root1.data = new IntTreeNode(-1);
//          root1.left = indicateMatching(null, root2.left);
//          root1.right = indicateMatching(null, root2.right);
//          return root1;
//       } else if (root1 != null && root2==null) {
//          root1.data = new IntTreeNode(-2);
//          root1.left = indicateMatching(root1.left, null);
//          root1.right = indicateMatching(root1.right, null);
//          return root1;
//       } else {
//          root1.left = indicateMatching(root1.left, root2.left);
//          root1.right = indicateMatching(root1.right, root2.right);
//          return root1;
//       }
//    }
   
   public void makeFull() {
      overallRoot = makeFull(overallRoot,1);
   }  
   
   private IntTreeNode makeFull(IntTreeNode root, int level) {
      if (root != null) {
         if (root.left == null && root.right != null) {
            root = new IntTreeNode(-level, root, root.right);
            root.left.right = null;
         } else if (root.left != null && root.right == null){
            root = new IntTreeNode(-level, root.left, root);
            root.right.left = null;
         }
         root.left = makeFull(root.left, level+1);
         root.right = makeFull(root.right, level+1);
      
      }
      return root;
   }
      

   public static void main(String[] args) {
      IntTree tree1 = new IntTree("[12 [28 [94 [65] [18]] null] [19 [32 null [72]] null]]");
      tree1.makeFull();
      System.out.print(tree1);
   }
   
   public IntTree() {
        overallRoot = null;
    }

    public IntTree(String s) {
        overallRoot = fromString(new StringBuilder(s.toLowerCase().trim()));
    }

    public IntTreeNode getRoot() {
        return overallRoot;
    }

    public void setRoot(IntTreeNode root) {
        overallRoot = root;
    }

    // post: Prints the numbers in this tree in a pre-order fashion.
    public void print() {
        print(overallRoot);
    }

    private void print(IntTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            print(root.left);
            print(root.right);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof IntTree) {
            IntTree other = (IntTree) o;
            return toString().equals(other.toString());
        } else {
            return false;
        }
    }

    // post: Returns a text representation of the tree.
    public String toString() {
        return toString(overallRoot);
    }

    private String toString(IntTreeNode root) {
        if (root == null) {
            return "null";
        } else if (root.left == null && root.right == null) {
            return "[" + root.data + "]";
        } else {
            return "[" + root.data + " "
                + toString(root.left) + " "
                + toString(root.right) + "]";
        }
    }

    private IntTreeNode fromString(StringBuilder s) {
        String next = nextToken(s);
        if (next.length() == 0 || next.equals("null") || next.equals("/")) {
            return null;
        } else {
            next = next.substring(1, next.length() - 1).trim();  // remove [] from ends
            StringBuilder nextBuilder = new StringBuilder(next);
            String rootStr  = nextToken(nextBuilder);
            int data = Integer.parseInt(rootStr);
            String leftStr  = nextToken(nextBuilder);
            String rightStr = nextToken(nextBuilder);
            return new IntTreeNode(data,
                                   fromString(new StringBuilder(leftStr)),
                                   fromString(new StringBuilder(rightStr)));
        }
    }

    // Returns string representation of next complete node or data value from given buffer.
    private String nextToken(StringBuilder s) {
        while (s.indexOf(" ") == 0) {
            s.deleteCharAt(0);
        }
        if (s.length() == 0) {
            return "";
        }

        int i = 0;
        if (s.charAt(0) == '[' || s.charAt(0) == '(') {
            int depth = 0;
            do {
                if (s.charAt(i) == '[' || s.charAt(i) == '(') {
                    depth++;
                } else if (s.charAt(i) == ']' || s.charAt(i) == ')') {
                    depth--;
                }
                i++;
            } while (i < s.length() && depth > 0);
            if (depth > 0) {
                throw new IllegalArgumentException("missing closing bracket in " + s);
            }
        } else {
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
        }

        String result = s.substring(0, i).trim();
        s.delete(0, i);
        while (s.indexOf(" ") == 0) {
            s.deleteCharAt(0);
        }
        return result;
    }
    
    private static class IntTreeNode {
        public int data; // data stored at this node
        public IntTreeNode left; // reference to left subtree
        public IntTreeNode right; // reference to right subtree

        // Constructs a leaf node with the given data.
        public IntTreeNode(int data) {
            // Hunter: Added constructors after lecture
            // Hunter: Remember to reduce redundancy in constructors
            this(data, null, null);
        }

        // Constructs a leaf or branch node with the given data and links.
        public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}