import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {
    // private int[] nums;

    // public NumArray(int[] nums) {
    //     this.nums = nums;
    // }
    
    // public int sumRange(int i, int j) {
    //     int sum = 0;
    //     for (int k = i; k <= j; k++) {
    //         sum += nums[k];
    //     }
    //     return sum;
    // }

    // 使用缓存的解法 空间换时间
    private int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    // sumRange(i, j) = sumRange(0, j) - sumRange(0, i)   sums[0]=0方便计算
    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

