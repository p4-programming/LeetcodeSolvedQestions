class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        this.backTrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backTrack(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < candidates.length; ++i) {
            if(i > start && candidates[i] == candidates[i - 1])
                continue;

            if(candidates[i] > target)
                break;

            curr.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}