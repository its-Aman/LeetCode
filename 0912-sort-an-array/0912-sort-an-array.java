class Solution {
    public int[] sortArray(int[] nums) {
        // MergeSort merge = new MergeSort();
        // return merge.sort(nums);
        
        // HeapSort heapSort = new HeapSort();
        // return heapSort.sort(nums);

        CountingSort countingSort = new CountingSort();
        return countingSort.sort(nums);
    }
}

class MergeSort {
    public int[] sort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }
    
    private void mergeSort(int[] nums, int l, int r, int[] temp) {
        if(l >= r) {
            return;
        }
        
        int m = l + ((r - l) >> 1);
        mergeSort(nums, l, m, temp);
        mergeSort(nums, m + 1, r, temp);
        
        merge(nums, l, m, r, temp);
    }
    
    private void merge(int[] nums, int l, int m, int r, int[] temp) {
        int start1 = l, start2 = m + 1, n1 = m - l + 1, n2 = r - m;
        
        for(int i = start1; i < n1 + start1; i++) {
            temp[i] = nums[i];
        }

        for(int i = start2; i < n2 + start2; i++) {
            temp[i] = nums[i];
        }
        
        int i = 0, j = 0, k = l;
        
        while(i < n1 && j < n2) {
            if(temp[start1 + i] <= temp[start2 + j]) {
                nums[k] = temp[start1 + i];
                i++;
            } else {
                nums[k] = temp[start2 + j];                
                j++;
            }
            k++;
        }
        
        while(i < n1) {
            nums[k] = temp[start1 + i];
            i++;
            k++;
        }

        while(j < n2) {
            nums[k] = temp[start2 + j];
            j++;
            k++;
        }
        
    }
}

class HeapSort {
    public int[] sort(int[] nums) {
        heapSort(nums);
        return nums;
    }
    
    private void heapSort(int[] nums) {
        int N = nums.length;
        
        for(int i = N / 2 - 1; i >= 0; i--) {
            heapify(nums, N, i);
        }
        
        for(int i = N - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }
    
    private void heapify(int[] nums, int N, int i) {
        int largest = i, 
            l = 2 * i + 1,
            r = 2 * i + 2;
        
        if(l < N && nums[l] > nums[largest]) {
            largest = l;
        }

        if(r < N && nums[r] > nums[largest]) {
            largest = r;
        }
        
        if(largest != i) {
            swap(nums, i, largest);
            heapify(nums, N, largest);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class CountingSort {
    HashMap<Integer, Integer> cnt;
    int min, max;
    
    public CountingSort() {
        cnt = new HashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
    
    public int[] sort(int[] nums) {
        int N = nums.length;
        
        for(int i = 0; i < N; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }
        
        int idx = 0;
        for(int val = min; val <= max; val++) {
            while(cnt.getOrDefault(val, 0) > 0) {
                nums[idx] = val;
                idx++;
                cnt.put(val, cnt.get(val) - 1);
            }
        }
        return nums;
    }
}