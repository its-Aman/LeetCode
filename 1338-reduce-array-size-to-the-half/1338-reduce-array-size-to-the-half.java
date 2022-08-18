class Solution {

    public int minSetSize(int[] arr) {

		int N = arr.length, min = 1000000, max = 0;

		for (int val : arr) {
			min = Math.min(val, min);
			max = Math.max(val, max);
		}

		int[] count = new int[max - min + 1];

		for (int val : arr)
			count[val - min] += 1;

		int[] bucket = new int[N + 1];

		for (int cnt : count)
			if (cnt != 0)
				bucket[cnt] += 1;

		int sum = 0, size = 0, half = N >> 1;

		for (int i = N; i > 0; i--) {
			while (bucket[i]-- != 0) {
				sum += i;
				size += 1;

				if (sum >= half)
					return size;
			}
		}

		return -1;
	}

}