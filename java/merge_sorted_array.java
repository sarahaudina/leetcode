// Intuition: since the arrays already sorted, the last item in the final array will be either the last item in nums1 before the empty positions, and the last item in nums2. We can use this strategy while iterating the arrays from rare to the front, and mark the index of the values that have been placed to the right position. 

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // m & n each will be the index of the arrays which currently being compared
        m = m-1;
        n = n-1;
        // iterat through the arrays by reducing the current index until 0
        while (m>=0 || n>=0) {
            // if n reach 0 means all items in nums2 already placed, so now continue to iterate through only the nums1, or if not finished iterating any of the arrays, compare current values of both arrays. place the higher value to the last available position in destination array.
            if (n<0 || (m>=0 && (nums1[m] >= nums2[n]))) {
                nums1[m + n + 1] = nums1[m];
                m--;
            } else {
                nums1[m + n + 1] = nums2[n];
                n--;
            }
        }
    }
}