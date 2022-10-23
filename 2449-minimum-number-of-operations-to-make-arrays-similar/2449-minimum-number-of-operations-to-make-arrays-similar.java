class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        long ans = 0;
        List<Integer> oddN = new ArrayList<>(), evenN = new ArrayList<>();
        List<Integer> oddT = new ArrayList<>(), evenT = new ArrayList<>();

        Arrays.sort(nums);
        Arrays.sort(target);

        for (int num : nums)
            if (num % 2 == 0) evenN.add(num);
            else oddN.add(num);

        for (int _target : target)
            if (_target % 2 == 0) evenT.add(_target);
            else oddT.add(_target);

        for (int i = 0; i < oddN.size(); i++)
            ans += Math.max(oddN.get(i) - oddT.get(i), 0) / 2;

        for (int i = 0; i < evenN.size(); i++)
            ans += Math.max(evenN.get(i) - evenT.get(i), 0) / 2;

        return ans;
    }
}