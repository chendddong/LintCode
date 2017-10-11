/*
    Create an inverted index with given documents.
    Ensure that data does not include punctuation.
 */

/*
    Given a list of documents with id and content. (class Document)

    [
      {
        "id": 1,
        "content": "This is the content of document 1 it is very short"
      },
      {
        "id": 2,
        "content": "This is the content of document 2 it is very long bilabial bilabial heheh hahaha ..."
      },
    ]

    Return an inverted index (HashMap with key is the word and value is a list of document ids).d

    {
       "This": [1, 2],
       "is": [1, 2],
       ...
    }

 */

/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */

public class Solution {

    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        /* What the results looks like */
        Map<String, List<Integer>> results = new HashMap<String, List<Integer>>
        ();

        for (Document doc : docs) {
            /* Two attributes */
            int id = doc.id;
            String content = doc.content;

            StringBuffer temp = new StringBuffer("");

            int n = content.length(); // String length of that content
            for (int i = 0; i < n; i++) {
                if (content.charAt(i) == ' ') { // Complete one word
                    insert(results, temp.toString(), id);
                    temp = new StringBuffer(""); // Creating new buffer
                } else { // Add chars to the temp until it is a space
                    temp.append(content.charAt(i));
                }
            }

            insert(results, temp.toString(), id); // Modify the result
        }
        return results;
    }

    public void insert(Map<String, List<Integer>> rt, String tmp, int id) {
        if (tmp.equals("") || tmp == null) // Corner case
            return;
            
        if (!rt.containsKey(tmp))
            /* Creating new list for each new word */
            rt.put(tmp, new ArrayList<Integer>());

        int n = rt.get(tmp).size();

        /* Adding the id to that certain word */
        if (n == 0 || rt.get(tmp).get(n - 1) != id) // new word or no duplicate
            rt.get(tmp).add(id);
    }
}