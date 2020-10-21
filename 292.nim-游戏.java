/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 */

// @lc code=start
class Solution {

  public boolean canWinNim(int n) {
    // 像示例说的 如果有4块石头 那你永远也赢不了比赛
    // 那么8 12 16块的时候 你选择完成之后 对手总能留够4的倍数给你
    return n % 4 != 0;
  }
}
// @lc code=end
