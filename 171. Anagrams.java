/*
    Given an array of strings, return all groups of strings that are anagrams.
    All inputs will be in lower-case
 */

/*
    Example
    Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

    Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 */


public class Solution {

    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    
    /* 
        Get the hash value of a Offset count array to avoid check every number 
        (It is an Optimization)
    */
    public static final int NUM_LETTERS = 26;
    private int getHash(int[] count) {
        int hash = 0;
        int a = 378551;
        int b = 63689;
        for (int num : count) {
            hash = hash * a + num;
            a *= b;
        }
        return hash;
    }   

    /* Since they are only lower-case letters, just set array length to 26*/
    private static int[] getOffsetArray(String str) {
        int[] count = new int[NUM_LETTERS];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }

    public List<String> anagrams(String[] strs) {

    /* we definitely are gonna need a HashMap for the contains check */
    /* Use a HashNumber instead of comparing the number of offsets on by one */

        ArrayList<String> result = new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer,
        ArrayList<String>>();

        /* 
           Get Offset count arrays for every str in strs,
           Get the hash code for each count array 
           add the str to the Map 
        */
        for (String str : strs) {
            int[] count = getOffsetArray(str);
            int hash = getHash(count);

            /* Initialize the map, or the str can't be added */
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }

            map.get(hash).add(str);
        }

        /* map.values() > 1 means there are anagram pairs */
        for (ArrayList<String> tmp : map.values()) {
            if (tmp.size() > 1) {
                /* We need all the strs in the result */
                result.addAll(tmp);
            }
        }
        return result;
    }
}

/*
    To use a HashCode as a key in the HashMap is brilliant.
    Draw this and white board this later
 */