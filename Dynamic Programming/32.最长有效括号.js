/*
 * @lc app=leetcode.cn id=32 lang=javascript
 *
 * [32] 最长有效括号
 */
/**
 * @param {string} s
 * @return {number}
 */
//动态规划 存储每个位置匹配最长有效括号
var longestValidParentheses = function(s) {
    let arr = [];
    let maxLength = 0, left = 0;
    for(let i = 0; i < s.length; ++i) {
        arr[i] = 0;
        if(s[i] == '(') {
            left++;
            arr[i] = 0;
        }
        if(s[i] == ')' && left > 0) {
            arr[i] = arr[i - 1] + 2;
            left--;
            if(i - arr[i] >= 0) {
                arr[i] += arr[i - arr[i]];
            }
        }
        if(arr[i] > maxLength) {
            maxLength = arr[i];
        }
    }
    return maxLength;
};

