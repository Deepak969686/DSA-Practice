class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null && nums.length < 4) return result;
        Arrays.sort(nums);  
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;

                int l = j + 1;
                int k = nums.length - 1;

                while (l < k) {
                   long sum =(long) nums[i] + nums[j] + nums[l] + nums[k];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[k]));
                        l++;
                        k--;
                        while (l < k && nums[l] == nums[l - 1]) l++;  
                        while (l < k && nums[k] == nums[k + 1]) k--;  
                    } else if (sum < target) {
                        l++; 
                    } else {
                        k--;  
                    }
                }
            }
        }
        return result;
    }
}
