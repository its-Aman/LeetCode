class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new LinkedList<>();
        int l = 0, h = arr.length - k;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (x - arr[m] > arr[m + k] - x)
                l = m + 1;
            else
                h = m;
        }

        for (int i = l; i < l + k; i++)
            ans.add(arr[i]);

        return ans;
    }
}