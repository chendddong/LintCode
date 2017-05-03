public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // 每个数只能用一次
        // 要考虑 [1, 1, 2] target = 3;  去看subset 2 的小视频
        //
        List<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length == 0) {
            return results;
        }

        Arrays.sort(num);
        List<Integer> combination = new ArrayList<Integer>();
        int startIndex = 0;
        dfs(results, combination, num, target, startIndex);
        return results;
    }

    private void dfs(List<List<Integer>> results,
                     List<Integer> combination,
                     int[] num,
                     int target,
                     int startIndex) {
        if (target == 0 && !(results.contains(combination))){
            results.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = startIndex; i < num.length; i++) {
            if (target < num[i]) {
                break;
            }
            combination.add(num[i]);
            dfs(results, combination, num, target - num[i], i + 1); 
            //forget the resize()
            combination.remove(combination.size() - 1);
        }
    }

}