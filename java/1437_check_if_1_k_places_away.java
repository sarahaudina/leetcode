class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int space = 0;
        boolean hasFoundFirstOne = false;
        for (int i=0; i<nums.length; i++) {
            if (hasFoundFirstOne && nums[i]==1) {
                if (space<k) {
                    return false;
                }
            }

            if (nums[i]==1) {
                hasFoundFirstOne = true;   
            }

            if (nums[i]==1) {
                space = 0;
            } else {
                space++;
            }
        }

        return true;
    }
}