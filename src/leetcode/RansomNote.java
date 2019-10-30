package leetcode;

import java.util.HashMap;

/**
 *
 */
public class RansomNote {
        public boolean canConstruct(String ransomNote, String magazine) {
            HashMap<Character,Integer> countR = new HashMap<>();
            HashMap<Character,Integer> countM = new HashMap<>();
            for(char c : ransomNote.toCharArray()) {
                if(!countR.containsKey(c) ) countR.put(c,1);
                else countR.put(c,countR.get(c) + 1);
            }

            for(char c : magazine.toCharArray()) {
                if(!countM.containsKey(c) ) countM.put(c,1);
                else countM.put(c,countM.get(c) + 1);
            }

            for(char c : ransomNote.toCharArray()){
                if(countM.get(c) == null || countR.get(c) > countM.get(c)) return false;
            }
            return true;
        }
}
