public class LinkedIntList {
   private ListNode front;
   
   public static void main(String[] args) {
      ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
      ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
      
      System.out.println(mergeTwoLists(list1,list2));
   }
   
   public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       final ListNode root = new ListNode();
       ListNode prev = root;
       while (list1 != null && list2 != null) {
           if(list1.data < list2.data) {
               prev.next = list1;
               list1 = list1.next;
           } else {
               prev.next = list2;               
               list2 = list2.next;
           }
           prev = prev.next;
       }
       prev.next = list1 != null ? list1 : list2;
       return root.next;
   }
  
   public void add(IntTree other) {
      overallRoot = add(overallRoot, other.overallRoot); 
   }
     
   private IntTreeNode add(IntTreeNode root1, IntTreeNode root2) { 
      if (root2 != null) {
         if (root1 == null) {
            root1 = new IntTreeNode(0);
            root1.data += root2.data;
            root1.left = add(root1.left, root2.left); 
            root1.right = add(root1.right, root2.right);
         }
         return root1;
      }
   }
   
   public void removeAll(int n) {
      if (front != null) {
         if (front.data == n) {
            front = front.next;
         }
         ListNode curr = front;
         while (curr!=null &&curr.next != null) {
            if (curr.next.data == n){
               curr.next = curr.next.next;
               curr = curr.next;
            } else {
               curr = curr.next;
            }
         }
      }  
   }   
   
   public void reverse3() {
      if (front != null && front.next != null && front.next.next != null) {
         ListNode temp = front;
         front = front.next.next;
         ListNode temp2 = front.next; 
         front.next = temp.next; 
         temp.next.next = temp; 
         temp.next = temp2;
         while (temp.next != null && temp.next.next != null && temp.next.next.next != null) {
            temp2 = temp.next;
            temp.next = temp.next.next.next; 
            temp = temp2;
            temp2 = temp.next.next.next; 
            temp.next.next.next = temp.next; 
            temp.next.next = temp; 
            temp.next = temp2;
         } 
      }
   }

   public void rearrange() {
      if (front != null && front.next != null) {
         ListNode current = front.next;
         while (current != null && current.next != null) {
            ListNode temp = current.next;
            current.next = current.next.next;
            temp.next = front;
            front = temp;
            current = current.next;
         }
      }
   }
   
   public LinkedIntList removeEvens() {
      LinkedIntList result = new LinkedIntList();
      if (front != null) {
         result.front = front;
         front = front.next;
         ListNode curr1 = front;
         ListNode curr2 = result.front;
         front = curr1;
         while (curr1 != null && curr1.next != null) {
            curr2.next = curr1.next;
            curr2 = curr2.next;  
            curr1.next = curr1.next.next;
            curr1 = curr1.next;
                       
         }
      }
      return result;
   }
   
   public void  doubleList(){
      if (front != null) {
         ListNode half2 = new ListNode(front.data);
         ListNode curr = front;
         ListNode back = half2;
         while(curr.next != null) {
            curr = curr.next;
            back.next = new ListNode(curr.data);
            back = back.next;
            
         }
         curr.next = half2;
      }
   
   }
   
   public void reverse() {
      ListNode prev = null;
      while (front != null) {
         ListNode current = front.next;
         front.next = prev;
         prev = front;
         front = current;
      }
      front = prev;
   
   }
   
   public void rotate3() {
      if (front != null && front.next != null && front.next.next != null) {
         ListNode curr1 = front;
         ListNode temp = curr1.next;
         front = temp;
         curr1.next = curr1.next.next.next;
         temp = temp.next;
         temp.next = curr1;
         while(curr1 !=null && curr1.next != null) {
            temp = temp.next.next;
            ListNode temp1 = temp.next;
            curr1.next = temp1;
            temp.next = temp.next.next.next;
            temp1.next.next = temp;
            curr1=temp;
         }
      }
   }
   
   public void weave(LinkedIntList other) { 
      if (front == null) {
         front = other.front;
      } else if (other.front != null) {
         ListNode current1 = front;
         ListNode current2 = other.front;
         while (current1.next != null && current2.next != null) {
            ListNode temp = current1.next; 
            current1.next = current2; 
            current2 = current2.next; 
            current1.next.next = temp; 
            current1 = temp;
         }
         if (current1.next == null) {
// we know curr2 might have more list, just attach it at end current1.next = current2;
         } else {
// there is one node left in curr2, weave it in current2.next = current1.next;
            current1.next = current2;
         } 
      }
      other.front = null;
   }
   
   public void mergeFrom(LinkedIntList other) {
    if (other.front != null) {
        if (front == null) {
            front = other.front;
        } else {
            ListNode current1 = front;
            ListNode current2 = other.front;

            if (front.data <= other.front.data) {
                current1 = current1.next;
            } else {
                front = other.front;
                current2 = current2.next;
            }

            ListNode current3 = front;
            while (current1 != null && current2 != null) {
                if (current1.data <= current2.data) {
                    current3.next = current1;
                    current1 = current1.next;
                } else {
                    current3.next = current2;
                    current2 = current2.next;
                }
                current3 = current3.next;
            }

            if (current1 != null) {
                current3.next = current1;
            } else {
                current3.next = current2;
            }
        }
        other.front = null;
    }
   }
    

   public void weave(LinkedIntList other) {
      if (other.front != null) {
         if (front != null) {
            ListNode curr1 = front.next;
            ListNode curr2 = other.front;
            ListNode curr3 = front;
            while (curr1 != null && curr2 != null) {
               curr3.next = curr2;
               curr2 = curr2.next;
               curr3 = curr3.next;
               curr3.next = curr1;
               curr1 = curr1.next;
               curr3 = curr3.next;
            }
            if (curr1 == null && curr2 != null) {
               curr3.next = curr2;
            } else if (curr1 != null && curr2 == null) {
               curr3.next = curr1;
            }
         }
      }
      other.front = null;
   }
   
   public LinkedIntList(int... elements) {
      if (elements.length > 0){
         front = new ListNode(elements[0]);
         ListNode current = front;
         for (int i = 1; i <elements.length;i++){
            current.next = new ListNode(elements[i]);
            current = current.next;
         }
      }
   
   }
   
   public String toString() {
        if (front == null) {
            return "[]";
        } else {
            ListNode current = front;
            String result = "[";
            while (current.next != null) {
                result += current.data + ", ";
                current = current.next;
            }
            result += current.data + "]";
            return result;
        }
    }  
   
   private static class ListNode {
      public int data;
      public ListNode next;
   
      public ListNode() {
         this(0, null);
      }
   
      public ListNode(int data) {
         this(data,null);
      }
   
      public ListNode(int data, ListNode next) {
         this.data = data;
         this.next = next;
      }
   }
}


