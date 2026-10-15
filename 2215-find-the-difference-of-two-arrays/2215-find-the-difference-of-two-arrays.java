class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Store unique values
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        List<Integer> uniqueToNums1 = new ArrayList<>();
        // Elements only in nums1
        for (int num : set1) {
            if (!set2.contains(num)) {
                uniqueToNums1.add(num);
            }
        }// Elements only in nums2
        List<Integer> uniqueToNums2 = new ArrayList<>();
        for (int num : set2) {
            if (!set1.contains(num)) {
                uniqueToNums2.add(num);
            }
        }//return the combined results
        return Arrays.asList(uniqueToNums1, uniqueToNums2);
    }
}
