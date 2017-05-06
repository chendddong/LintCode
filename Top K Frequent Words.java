// Given a list of words and an integer k, return the top k frequent words in  
// the list.

//  Notice

// You should order the words by the frequency of them in the return list, the
// most frequent one comes first. If two words has the same frequency, the one
// with lower alphabetical order come first.

// ["work", "do", "happy", "good", "this", "this"] 2
// ["this", "do"]

// What we need is a maxHeap for the count
// We are gonna construct this data type using -- string word --, -- int count
// --,

// Example
// Given

// [
//     "yes", "lint", "code",
//     "yes", "code", "baby",
//     "you", "baby", "chrome",
//     "safari", "lint", "code",
//     "body", "lint", "code"
// ]
// for k = 3, return ["code", "lint", "baby"].

// for k = 4, return ["code", "lint", "baby", "yes"],

class Pair {
    String key;
    int value;
    
    Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
}


public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
     
    private Comparator<Pair> WordsComparator = new Comparator<Pair>() {
        public int compare(Pair left, Pair right) {
            if (left.value != right.value) {
                return left.value - right.value;
            }
            return right.key.compareTo(left.key);
        }
    };
    
    public String[] topKFrequentWords(String[] words, int k) {
        if (words == null || words.length == 0 || k > words.length) {
            return new String[0];
        } 
        HashMap<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            if (counter.containsKey(word)) {
                counter.put(word, counter.get(word) + 1);
            } else {
                counter.put(word, 1);
            }


        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k,  WordsComparator);
        for (String word : counter.keySet()) {
            Pair peak = pq.peek();
            Pair newPair = new Pair(word, counter.get(word));
            if (pq.size() < k) {
                pq.add(newPair);
            } else if (WordsComparator.compare(newPair, peak) > 0) {
                pq.poll();
                pq.add(new Pair(word, counter.get(word)));
            }
        }

        String[] result = new String[k];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll().key;
        }

        // reverse
        for (int i = 0; i < index / 2; ++i) {
            String temp = result[i];
            result[i] = result[index - i - 1];
            result[index - i - 1] = temp;
        }

        return result;
    }
}