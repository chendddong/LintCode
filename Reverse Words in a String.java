// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// public class Solution {
//     /**
//      * @param s : A string
//      * @return : A string
//      */
//      // input is string output is also a string
//      // test cases:
//      // "the sky is bule" -> "blue is the sky"
//      // "" -> ""
//      // null -> null
     
//      // run time
     
//     public String reverseWords(String s) {
//         ArrayList<String> list = new ArrayList<String>();
//         // scan once and stroe those words in the ArrayList
//         //
//         int len = s.length();
//         int[] countSpaceIndex = new int[len];
//         for (int i = 0; i < len; i++) {
//             if (s.charAt(i) == ' ') {
//                 countSpaceIndex[i]++;
//             }
//         }

//         // for (Integer num : countSpaceIndex) {
//         //     System.out.print(num + " , ");


//         // }
//         // System.out.println("");
//         // the      sky is blue
//         int start = 0;
//         int i = 0;
//         for (i = 0; i < len; i++) {

//             if (countSpaceIndex[i] == 1) {
//                 if (start < i && countSpaceIndex[start] == 0) {
//                     // System.out.println(start + " -- " + i);
//                     String str = s.substring(start, i);
//                     // System.out.println(str);

//                     list.add(str);
//                     start = i + 1;

//                 } else {
//                     start++;
//                 }

//             }

//         }
        
//         if (start == len - 1) {
//             String last = s.substring(len, len);
//             // System.out.println("Last String " + last);
//             list.add(last);
//         } else {
//             String last = s.substring(start, len);
//             // System.out.println("Last String " + last);
//             list.add(last);
//         }

        

//         Collections.reverse(list);

//         // for (String str : list) {
//         //     System.out.print(" --- " + str + " , " + " --- ");
//         // }

//         StringBuilder sb =  new StringBuilder();

//         for (String word : list) {
//             sb.append(word);
//             sb.append(" ");
//         }

//         String result = sb.toString();
//         int newLen = result.length();
//         result = result.substring(0, newLen - 1);
//         return result;
//     }
// }

/*
Something's wrong with the code and can not be solved...
and it took too long
*/

// Solution by jiuzhang

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // s.split("\\s+");
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = array.length - 1; i >= 0; --i) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }

        //remove the last " "
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}