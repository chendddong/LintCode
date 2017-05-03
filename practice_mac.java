public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // key: number value: index

        for (int i = 0; i < numbers.length; i++) {
            int index = i + 1;
            int leftOver = target - numbers[i];
            if (map.containKey(leftOver)) {
                int[] result = {index, map.get(leftOver)};
                Arrays.sort(result);
                return result;
            }

            map.putIfAbsent(leftOver, index);
        }
    }
}