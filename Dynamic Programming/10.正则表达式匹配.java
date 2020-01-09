/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null) return false;
        int sIndex=0, pIndex=0;
        return matchCore(s,sIndex,p,pIndex); 
    }
    
    // 粘自网上
    // 用递归|| 考虑情况下所有可能
    public boolean matchCore(String s,int sIndex,String p,int pIndex){
        if(sIndex==s.length() && pIndex==p.length()) return true;//匹配到结尾了，匹配成功
        if(sIndex <s.length() &&  pIndex==p.length()) return false;//p先结束，匹配失败
        //模式的第2个是*,分两种情况：第一个能/不能匹配上 
        if(pIndex+1<p.length() && p.charAt(pIndex+1)=='*'){
            //第一个匹配上了（字符相同或者和‘.’匹配），分三种情况
            //① sIndex+1：继续用*匹配下一个 ② sIndex+1,pIndex+2：结束*匹配，判断下一个字符 ③pIndex+2：当*前面的字符没有出现过
            if((sIndex < s.length() && p.charAt(pIndex)==s.charAt(sIndex))||(sIndex <s.length() && p.charAt(pIndex)=='.')){
                // 后面两个或考虑的是=='.'的情况
                return matchCore(s,sIndex+1,p,pIndex) || matchCore(s,sIndex+1,p,pIndex+2) || matchCore(s,sIndex,p,pIndex+2);
            }else{//第一个匹配不上，认为其没出现过，判断下面的
                return matchCore(s,sIndex,p,pIndex+2);
            }
        }else{//模式的第二个不是*，匹配上就下一个，匹配不上就结束
             if((sIndex < s.length() && p.charAt(pIndex)==s.charAt(sIndex))||(sIndex < s.length() && p.charAt(pIndex)=='.')){
                 return matchCore(s,sIndex+1,p,pIndex+1);
             }else{
                 return false;
             }
        }
    }

    public boolean myMethod(String s, String p) {
        // 若p能完全匹配s 则返回true
        // 双指针
        // 每次传入一个s的字符和两个p的字符进行匹配
        // aaa匹配 a*a或者a*aa 临界解决复杂 //
        int index = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (index >= p.length()) {
                return false;
            }
            char p1 = p.charAt(index);
            char p2;
            try {
                // 获取p的第二个字符
                p2 = p.charAt(index + 1);
            } catch (Exception exception) {
                p2 = ' ';
            }

            if(p.length() > index) {
                if (c != p1 && p2 == '*' && p1 != '.') {
                    // x*匹配 排除.*
                    index = index + 2;
                    i--;
                } else if (c != p1 && p1 != '.') {
                    // 不匹配
                    return false;
                } else if ((c == p1 || p1 == '.') && p2 != '*') {
                    index++;
                }
                // 若x匹配x* 则什么都不做
            } else {
                index++;
            }

            if (i == s.length() - 1) {
                if (p2 == '*' && index != p.length() - 2) {
                    return false;
                } else if (p2 != '*' && index != p.length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

