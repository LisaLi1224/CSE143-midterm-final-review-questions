import java.util.*;

public class Collection {
	public static Map<Integer,String> byAge(Map<String,Integer> map, int min, int max) {
      String result ="";
      Map<Integer,String>mapAge = new HashMap<Integer, String>();
      for (String name: map.keySet()) {
         int age = map.get(name);
         if (age >= min && age <= max) {
            result = mapAge.get(age);
            if (! mapAge.containsKey(age)) {
               mapAge.put(age,name);
               result = name;
            } else {
               result += " and " +name;
               mapAge.put(age,result);
            }
         }
      }
      return mapAge;
	}
   
   public static Set<String> cancelCourse(String course, Map<String,Set<String>> all) {
      Set<String> removeName = new TreeSet<>();
      for (String name:all.keySet()) {
         if (all.get(name).contains(course)) {
            all.get(name).remove(course);
            removeName.add(name);
         
         }
      }
      return removeName;
   }
	
   public static int countInAreaCode(Map<String,String> map, String s){
      Set<String> phone = new HashSet<>();
      if (map.isEmpty()){
         return 0;
      }
      for (String name: map.keySet()) {
         String num = map.get(name);
         if (num.substring(0,3).equals(s)){
            if (! phone.contains(num)) {
               phone.add(num);
            }
         }
      }
      return phone.size();
   }
   
   public static Map<String,Integer> computeTotalCredits(Map<String,Set<String>> enroll, Map<String,Integer> credit) {
      Map<String,Integer> total = new TreeMap<>();
      if (enroll.isEmpty()) {
         return total;
      } else {
         for(String name:enroll.keySet()){
            int score = 0;
            for (String course:enroll.get(name)){
               score = score+credit.get(course);
            }
            total.put(name,score);
         }
      }
      return total;
   }

   public static Map<String, Set<String>> commonHobbies(Map<String, Set<String>> map) {
      Map<String,Set<String>> result = new TreeMap<>();
      for (String name: map.keySet()){
         Set<String> names = new HashSet<>();
         Set<String> hobbies = map.get(name);
         for (String hobby: hobbies){
            if (!result.containsKey(hobby)){
               names.add(name);
               result.put(hobby,names);
            } else {
               result.get(hobby).add(name);
            }
         }
      }
      return result;
   }
   
   
   
	public static void main(String[] args) {
      
   }
}