import java.util.*;

public class StackandQueue {
   public static void sortPairs(Stack<Integer> s){
        Queue<Integer> q = new LinkedList<Integer>();
        
        while (!s.isEmpty()){
           q.add(s.pop());
        }
        
        int size = q.size();
        
        while(q.size() > 2 ){
           if (size % 2 == 1){
              s.push(q.remove());
           }
           int first = q.remove();
           int second = q.remove();
           if (first < second){
              s.push(second);
              s.push(first);
           } else {
              s.push(first);
              s.push(second);
           } 
        }
        
        while (!s.isEmpty()){
           q.add(s.pop());
        }
        
        while (!q.isEmpty()){
           s.push(q.remove());
        }
    }
    
    public static void separate(Queue<String> q){
      Stack<String> s = new Stack<>();
      int size = q.size();
      for (int i = 0; i< size; i++){
         String word = q.remove();
         int length = word.length();
         if (length == 3 || length == 2){
            q.add(word);
         } else {
            s.push(word);
         } 
      }
      int size1 = q.size();
      for (int i = 0; i < size1;i++){
         String word = q.remove();
         int length = word.length();
         if (length == 3){
            q.add(word);
         } else {
            s.push(word);
         }
      }
      while (!q.isEmpty()){
         s.push(q.remove());
      }
      while (!s.isEmpty()){
         q.add(s.pop());
      }
      while (!q.isEmpty()){
         s.push(q.remove());
      }
      while (!s.isEmpty()){
         q.add(s.pop());
      }
    }
    
    public static void expand(Stack<Integer> s1, Stack<Integer> s2){
      if (s1.size() != s2.size()){
         throw new IllegalArgumentException();
      }
      Queue<Integer> q =new LinkedList<>();
      while(!s1.isEmpty()){
         int count = s2.pop();
         int num = s1.pop();
         q.add(count);
         for (int i = 0; i<count; i++){
            q.add(num);
         }
      }
      while(!q.isEmpty()){
         int count = q.remove();
         s2.push(count);
         for(int i = 0; i<count; i++){
            s1.push(q.remove());
         }
      }
      while(!s1.isEmpty()){
         q.add(s1.pop());
      }
      while(!q.isEmpty()){
         s1.push(q.remove());
      }
      while(!s2.isEmpty()){
         q.add(s2.pop());
      }
      while(!q.isEmpty()){
         s2.push(q.remove());
      }
      
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(4);
        s1.push(5);
        s1.push(6);
        s2.push(1);
        s2.push(2);
        s2.push(3);
        expand(s1,s2);
        System.out.print(s1);
        System.out.print(s2);
    }
}