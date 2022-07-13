public class Recursive {
   
   public static String commonChars (String s1, String s2) {
      if (s1.length() != s2.length()) {
         throw new IllegalArgumentException();
      }
      if (s1.length() == 0) {
         return s1;
      } else if (s1.length() == 1) {
         if (!s1.equals(s2)) {
            return ".";
         } else {
            return s1;
         }
      } else {
         char firsts1 = s1.charAt(0);
         char firsts2 = s2.charAt(0);
         if (firsts1 == firsts2) {
            return firsts1 + commonChars(s1.substring(1),s2.substring(1));
         } else {
            return "." + commonChars(s1.substring(1),s2.substring(1));
         }
      }
   }
   
   public static void countToBy(int n, int m) {
      if (m < 1 || n < 1) {
         throw new IllegalArgumentException();
      } else if (m > n) {
         System.out.print(n);
      } else if (m == n) {
         System.out.print(n);
      } else {
         countToBy(n - m, m);
         System.out.print(", " + n);
      }
   
   }
   
   
     
   public static String collapseSequences (String s, char c) {
      if (s.length() == 0) {
         return s;
      }
      if (s.length() == 1) {
         return s;
      } else {
         char first = s.charAt(0);
         char second = s.charAt(1);
         if (first == c && first == second) {
            return collapseSequences(s.substring(1), c);
         } else {
            return first + collapseSequences(s.substring(1), c);
         }
      }
   }
   
   public static Integer digitMatch(int num1, int num2) {
      if (num1 < 0 || num2 < 0) {
         throw new IllegalArgumentException();
      }
      if (num1 / 10 == 0 || num2 / 10 == 0) {
         if (num1 == num2 % 10 || num2 == num1 % 10) {
            return 1;
         } else {
            return 0;
         }
      } else {
         int num1digit = num1 % 10;
         int num2digit = num2 % 10;
         if (num1digit == num2digit) {
            return 1 + digitMatch(num1 / 10, num2 / 10);
         } else {
            return digitMatch(num1 / 10, num2 / 10);
         }
      }
   }
   
   public static boolean sameDashes(String s1, String s2){
      if (s1 == null || s2 == null || s1.length() != s2.length()){
         throw new IllegalArgumentException();
      }
      if (! s1.contains("-") && ! s2.contains("-")){
         return true;
      } 
      char letter1 = s1.charAt(0);
      char letter2 = s2.charAt(0);
      if (letter1 != '-' && letter2 == '-'){
         return false;
      } else if (letter1 == '-' && letter2 != '-'){
         return false;
      } else {
         return sameDashes(s1.substring(1),s2.substring(1));
      }
      
   
   }
   
   public static int digitProduct(int n){
      if (n==0){
         throw new IllegalArgumentException();
      }
      if(n<0){
         return -digitProduct(-n);
      } else if (n==1){
         return 1;
      } else if (n < 10){
         return n;
      } else {
         if (n%10 != 0 ){
            return digitProduct(n/10)*(n%10);
         }else {
            return digitProduct(n/10)*1;
         }
      }
   
   }
   
   public static String groupChars(String s){
      if (s.length() == 0){
         return "*";
      } else if (s.length() == 1 || s.length() == 2){
         return "[" + s + "]";
      } else {
         return "("+s.charAt(0)+groupChars(s.substring(1,s.length()-1))+s.charAt(s.length()-1)+")";
      }
   
   }
   
   public static int indexOf(String s1, String s2){
      if (s2.length()>s1.length()){
         return -1;
      }
      return indexOf(s1,s2,0);
   }
   
   private static int indexOf(String s1, String s2, int index){
      if (s1.length() - s2.length() < index){
         return -1;
      }
      if (s1.substring(index,index+s2.length()).equals(s2)){
         return index;
      } else {
         return indexOf(s1, s2, index + 1);
      }
   }
   
   public static boolean isPalindrome(String s){
      if (s.length() == 0){
         return true;
      } else if (s.length()==1){
         return true;
      } else if (s.charAt(0)==s.charAt(s.length()-1)){
         return isPalindrome(s.substring(1,s.length()-1));
      } else {
         return false;
      }
   
   }
   
   public static boolean isReversal(String S1, String S2){
      String s1 = S1.toLowerCase();
      String s2 = S2.toLowerCase();
      if (s1.length() != s2.length()){
         return false;
      }
      if (s1.length()==0){
         return true;
      } else if (s1.charAt(0)==s2.charAt(s2.length()-1)){
         return isReversal(s1.substring(1),s2.substring(0,s2.length()-1));
      } else {
         return false;
      }
   }
   
   public static boolean isSorted(int n){
      if (n/10==0) {
         return true;
      } else if (n<0){
         return isSorted(-n);
      } else if ((n/10)%10 <= n%10){
         return isSorted(n/10);
      } else {
         return false;
      }
   }
   
   public static int largestDigit(int n){
      if (n==0){
         return 0;
      } else if (n<0){
         return largestDigit(-n);
      } else {
         int digit = n%10;
         int max = largestDigit(n/10);
         return Math.max(digit, max);
      }
   }
   
   public static int maxDigits(int n1, int n2){
      if (n1<0 || n2<0){
         throw new IllegalArgumentException();
      }
      if (n1/10 == 0 && n2/10 == 0){
         if (n1>n2){
            return n1;
         } else {
            return n2;
         }
      } else if (n2 == 0 && n1 !=0){
         return n1;
      } else if (n1 == 0 && n2 != 0){
         return n2;
      } else if (n1 % 10 > n2 % 10){
         return 10*maxDigits(n1/10,n2/10)+(n1%10);
      } else {
         return 10* maxDigits(n1 / 10, n2 / 10)+(n2 % 10);
      }
    
   }
   
   public static void mirrorString(String s){
      if (s.isEmpty()){
         System.out.print("");
      } else if (s.length()==1){
         System.out.print(s);
      } else {
         System.out.print(s.charAt(0));
         mirrorString(s.substring(1));
         System.out.print(s.charAt(0));
      }
   }
   
   public static String moveToEnd(String s, char c){
      if (s.length()==0){
         return "";
      } else if (s.charAt(0)==c){
            return moveToEnd(s.substring(1),c) + s.charAt(0);
      } else {
            return s.charAt(0) + moveToEnd(s.substring(1),c);
      }
   }   
   
   public static int nthFromEnd(int num, int n){
      if (num<0 || n<0){
         throw new IllegalArgumentException();
      }
      if (num == 0){
         return 0;
      } else if (n==0){
         return num % 10;
      } else {
         return nthFromEnd(num/10,n-1);
      }
   
   }
   public static void main(String[] args) {
      System.out.print(nthFromEnd(56,2));
   }
}