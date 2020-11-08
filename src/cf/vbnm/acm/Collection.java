package cf.vbnm.acm;

import java.util.Arrays;

public class Collection {
    /*
     * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves，
     *  字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
     * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。
     * 每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，
     * 小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。
     * 请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
     * */
    public static void main(String[] args) {
//        String leaves = "ryyryyyrryyyyyyryryyyyryyrrryryyyryrr"
//                + "yrrrryyyrrryyrrrrryyrryryyryyyyryyrryrryryy";
//        String leaves = "yry";
        String leaves="yyyrrrrrrrryyrrryryyyryyyyryrrryyrrryrryyryryryyrrryyyyyyrrrrryrryryyrr"
                +"rryyyryrrrryyrryrrrryryryrrryyyyyyrrrryryrrrryrryyrrryryyyyryyyyyryrryryrryy"
                +"ryyryryrrrryryrryyyryrrryrrryryyyyyrryyrryrrrryrrrrryrryyyyyrrryryyyryryrrrr"
                +"yrryrryryyyryryryyyrrryryrrryrrrryrryrryryyrrrrryyrrryrrrryyryryryrrryyyyrry"
                +"rryyrrrrrrryyryyrryryrryyrryrrrrryyyyyrrryyrryrrryrrrrrryyryyyrrrrrryryrrryy"
                +"rryyyrrryrrrryyyyryryyyryrryyyyyrrryyyyrrryryyyryyryrryyyyyyyyrryyyyryryyyrr"
                +"ryyryyyyyyrryryrryyryryrrrryryrrrryryyryryryryryryyryyrryyyryrryyryyrryyyrrr"
                +"ryyyyrryrryyrryyyryyyryyrryyyyryyryyrryrryyrryryyyyrrryyyyyyryyyyryryrryyyyr"
                +"yrrrrryrrryrryrryyyyryyryyrrryyyryrrryryyrryyyrryryrryyyryyyyryyyryyryrrryry"
                +"ryryrryryyyyryyryyryyryryrrrrrrryyryryyrryyrryryrryyryyrryyyryyyrrrrryryrryy"
                +"ryyrryyyrryyryryrryrrryyyyyrryyrrrryyyyyyyryyyyrrrryrryyryyryrryyyyryyrrrryr"
                +"rryyrryrrryryrryyrrryyrryyyryyyyyyryyrrrryryyyyryyrryrrryyrryryryryryrryrrry"
                +"yyryyyyryryyrryryryrryyryrrrryyyryryyyrryyrryyyyyyyryrryryyyryyyrrrrryyyyryr"
                +"rryrryryryyrryrrryrryrryryrrrrrryyrryyryryryyryyyrryryryyyyryyryryyyyrrryyyr"
                +"rryrryyyyyrrrryyyrryrrrrryyryyrryryrryryryrryyyrrrrrryyyyrrrryyryyryrrryyryy"
                +"ryrryryyyyrrryyryryryyryyyyryryyyryrryryyrrryyryryryrrrryyryrrryyyyrrrrrrrry"
                +"ryyyyyryyryyyrrryyrrrrryyrrryryyrryrryryyrryrryryryrryyryryrrryrryrrrrrrryyr"
                +"yyrrryyrryyyrrryyyyyryyyrrrrrrryrrrryyyyryyrrrryryrryyrryryrrryrryyrryyyrrrr"
                +"yyyyrryryryrrrryyrryryrrryyrrrryrrrryyryyyyyrrryyyryryryrrrrrrryryyryyrryryy"
                +"rryyrrrrrrryrrrryyrryrrrrrrrryrrrryryryryryyyyyyryyyyyrrrryyyyyyyrryyyyrrryr"
                +"ryryyyryrrrryryrrryyrrryryrrryryyyyyrryrryyryryyyyyrrryrryrryryyryyyryyryyry"
                +"ryyyyyryyryyryrrrryyryyrrryryrrrryrrrrrryyryyrryrryryryyryrrryyyyyrrryyrryyy"
                +"ryrryyyryyyryryryryyyrrryryrrryyrrrrrryyyrryrryrryyrryrryryyryrrrryryyryrrrr"
                +"yyryyyryrrryrrrrrrrrrryrryyyyryyyrrryrrrrryrryrrryyyyryyrrrrryyrrrryyyyyyrrr"
                +"yyrryyryyyrryyyrryyyyrrryyyyyrryryyryyyyryryyyyyrrryryryyrrrryyyryrrrrryyrry"
                +"yryryyyyyrryrrrryyyryyyryrrryrryryyryyyryyyrrrrrrryryrryyyyryyyyyyryyrryyyyy"
                +"yyryrryyrryyrryrrrryryyrrryyyryryrrrrryrryryrrryyyyyyryryryyyryrrryryryyryrr"
                +"yyyryrryyyyrrryyryyyyyryyyrryryyyryyryrryrryrrrrryryyyrrryyyyryyyyyyrryyrryy"
                +"yryyyyrryrryryryyryryrrryrrrryyyyrrryyyyyryyyryrrrryyyyrryyryryrryyyrryyyryy"
                +"rrryyryyryryrrrryryyrrrrrrrrryrryryrryyrrrryyryrrrryyyrrrryyyyyrrryyyyrrryyr"
                +"yrryrrrryyyryrryyyyyrryryryyyyryryrryyyrryyryyyyryyryrryryryyyyyyyryryrrrryr"
                +"yyrryyyrrryyryrrryryyrryryyyyyyrryyryrryyyyyyrryrrryyyyrrryryryyyyyyrrryyrrr"
                +"ryryyyyyyyyrryyyyyryyyyryryyrrryrrryryryrrryryyrryyyyryryyryryyyyyyyyryrrryr"
                +"rrrrryyryrryyyyryyyryyyyrrrryrrryyryryrryyryyrryyyryyryyyryyyrrryyyyrryryyrr"
                +"rrryrrrryyyryyrrryyyyryyryryyryrrryrryryrrrryyrryryrrryyrrrrrryyrrryryrrryrr"
                +"yryryyyrrrrrrrrryyrrrryyryryrryyryyyrryryyyrrrrrrrrryyrryrrrrrrrrryryrrrryyr"
                +"yyryyyyrrryryyryyyyyyyryyyyyyrrryrryryyyrryyryryrrrrryrryrryrryyyyrryryyyrry"
                +"rrrrrryryyryyyyrryrryrrryyyrryyyyryrryryryrrrryyrrryyyyryyyyryryyyrryrryyyyr"
                +"yyyryyyyryryrrrrrrrrryryyryrrryyyyyyyrryyrryyyyyrryrrrrrryyyyrrrryyryyyrrryr"
                +"yyrryryryryryyyrryrryyryrrryyryrrryyryyyrrryrrrrryryyyyryryrryryyrryyyryrrry"
                +"rryyryryyrrrryyyryryryyyyrryyyyyrryrrryyyrrryrrryyyrryyyyrryyyryyyrrryrryyrr"
                +"rryyrrryyryryyyrryrrrryyyyyyyryyrryrrryyryyyyyrrryrrrryryyryyyyryyyryrryyryr"
                +"yyrryyrrryrryyyrryyrryrryyrrrryyrryryyyrryryrryyyyyyyyyryryryyrryrryrrrryyyr"
                +"rrryyrryryrrrrryryyyyyyrryyyyrrryryyryyryryyyyryyrryyyrryyyyrryryyyyyryyryry"
                +"ryrrryryyryyryyyryrrrrrrryrryyrrrryrryyryyrryryyryryryyyryyyyyyyrryyryyrrrry"
                +"yyyyryyyrrryrrrryyyyyyyryyyryrrrrrryryryyrrryryryryrryyrryryyyyyrrryrryyyryy"
                +"yyrryyrrrrryryyrrrrrryryyrrrryryyryrryyyyyyryyrrryryryyrrryyrryyyyyryyyyyrrr"
                +"yyyyrrrryyyrryyyyyrryrryryyrrryryyyyryyrrrryrrryyrryyrryyryyryrrryryyrryyyyr"
                +"ryrrrrrryrrryryyyrrryyrrryrryrryyyyryrryryrryrryrryrryyrryyryryyyyyyyrrrryyy"
                +"rryyyryyyrryyyyrryyryryrryyryyrrrrrryyyryyryyyrrryryyyyryyyrrryryyyryyrrryrryryyyyrryyyrryryryyrryyy"
                +"yyrrryryyrrryryyrryyyyrryyyrryyyrryyryyryyrryrrrryrryrryryyryrryyyrryyryyrrrryyryyyryyyyrryyryyrryyy"
                +"ryrrryyryrryyryrryyrrrrrrrrrrryryyyyrrrryyyyryyyrryryrrrryrrrryyyrrrryyyyryrrrrrrrrryrryrryrrrryryyy"
                +"yyyrryyyrryyryryyryrryrryryrryyyrryrryrryryrrrrrryryyyryyyrrrryrrrrryrrryryryyryyryyyyryyyyrryyyyyry"
                +"yyrryryyryryyryyryryrryryryyryyyryyryyryryrrrryyyrrryrryyrryyryyyrrryryryrrrryryryryryrryyyrryyyyryr"
                +"yryryyyyyryryrrryyyyryyryyrryyyyyryryrrryyyyyyrrrryryyyryyryrrrryryyyyryyyyyrrryryryyrrryrryyyyyyyrr"
                +"yryrrrrrrrryyyyyryryryryyrryrryryyrryrrryrryyryryrrryyyyyyyyrryryyrrryrryyryryrryyyyrrrryryryyrrryyr"
                +"yyryyrrryyyyryrryyyryyyyrryyrrryyryrryryyrryrrrrrrryyyyryrrrryrryrryyyyyyyyrryyryyyrryyryrryyrryrrrr"
                +"yrryrryyryyyryyyyyrryryyryrrryyryyyyyryrrryrryryyryryyryryryryyryyyyyyyyyyrryryyrryyyryryyryryrryyyy"
                +"yyyryrrryrryyyrrryrrryrryryrryyyyyyyryrryyyryyrryrryyyryyyyrryryyrrryryrryryryrryyryrryrryyrryyryyry"
                +"ryrryryyyyyrrryryryyrryyrrrryyyrrrrryyryrryyryryyyyrrryyrrryyryyyryrryrrrryyyryryyryryyryyrrrryyyyry"
                +"ryyrryryryyryyyyyyryyyyyyryryyyryryyyrrryyyyrryryryrrrrryrrryrryrrrrrryyyyyryyrryrryrrrryryryrryryyy"
                +"yryryrrryrrrryrryyyrryryyyrrryryyyrryrryryryyryrryrrryyrryyyrryrryyyrryyyryrryyyrryyrryyrryyrrryryyy"
                +"ryrryrrrrryyyrrryyryyyyyyyrryrryryryrrrryryyrrrryrryyyrryyyryyyryyrrrrrryyryyrryrryryrryyyyryrrryryr"
                +"yrrryyrryyrrrryyyyryryyyyyryyyryyyryyryyrryyryryyyrryryyyyrryyyyryyyyyyyrrrrrrryrryrrryyyyyrrrrryyry"
                +"yyrrrryryyrryyrryryrryyyrryrrryyyrryrryryyyyrryrrryrrrrrryyyyyryrryrryryyrrrryyyryyyyryyryyrryyyrryy"
                +"yrrrryrryryrrrryyyryyrryrryryrryryrryryrrryrrryyryrrrryrrrrrryrrryyryryyryrrryryyrrrryryrryryyyyyyry"
                +"rryyyyrryyyryryrrryryyryyyryrrrrrrryryyryryryryyrryyryyryrryyryyrrryyryyyrryrryyyy"
                +"yryrryrrryyrrryryrrrryyyrrryyyyyryrrrrryryryyryrrryryrryyrryyrrryryrrryryrrryyyryyyyryrryyrryyryrrry"
                +"yyyryrrryrryryyryryyyryryyrryrrryryyyyyyryryrry"
                +"ryyyyyryyryryyyyrrryryyyryyryryryyrrrryyryrryryryryrryyyrrryrrrryyryrryyrryyyyyyryyrryrrrrrrrrryyyyr"
                +"rryyyryryrryrrryyyyyyyyrryyryryyyyyyrrrrryyryyryrryryyyrrryyryryryyyyrrrryyrryyyryrryyyyyyryrryyryrr"
                +"rrrryryrryyyyryyyrrrryyyrrryryrrrryyrrryrryrrryrrrrrrryyryryyryyyryyryyryyyrryryrrryryryrryyyryyyrrryryrryyyyyyyyyrrrrrryryrr"
                +"rrryrrrryryryyryrryyrryyrrryyyryyrrryrrryyrrryrrrrryryyyyyrryyyrryyyrryyyryryryryyryyyyrryrryrryrrrry"
                +"ryrryyyryryrryryrryrrrrryrryyyrryyrrrrryyyyrryyrrryrrrryyrryrryyyyryryrrryyyyrryyryryyyrrryryrrrryyryyryrrrryrrryyrryrryyyyrryrrryyryyyyrryrryryyyrryrryrrryyryryyyyryryrrrrrryrryryyrryrryryryrryrrrrryyryrryyrryyryyryyryyyrrryyryryryryrrryryyyyyryryrrrryyyyrryrryyyrryyryryrrrrryyryyyrryryyyyyyrryyyrrrryyyrryrrryryrrrrrrryryy"
                +"yryrryyrryrryrrrryyryrryyrrryyyyryrryyryyyryyryryrrrrrryyryryyrrryyryyyyyryrrrrrrrrryyrryyyrryryrryrryyryryrrryryrrrryyrrryryrryrrrryryrrryyyyrrryrryrryrryyyrrryyyyryryryryrryyyyryyyrrrryryryrrryyyryyyyrrryyrryyrrrrryrryrrryryrryyryryyryyyyryryryryyyyrrrrryryyryrrryryryrryyyryrryryrrryryrr"
                +"yrryyyyyyyyrrryryyyrryryryyyryryyyrrrryyrryryyyyryyyrrrrrrrryyryrryyryrryyrryryyryyyrrryyyryyrryyryrrryrryrrrryrrryyrryrryyyyryyyrryyyryryryryryryryyryyryryyyyyrrrrryyyyyyyryyyrryyyyyyrryryyyyyyryrryyrrryyyyyyryryrryyyrrrryryrryyryrrrrrrryryyyyyrryyyyrryrrrrrryyyyyyyryyrryryyyyryrrrrryyryyrryrrrrrrrryryyryrryrrryrryrrrryyyrry"
                +"yyrrryyrryryrrryyryyryryyryrryyryyryrryrryrrrrryrrrrryryryrrrryyyrrryyyyyrryryrryrryyrryryyrryryyyryryryryyyrrrryyyrryyryryryyryyyyrrrryrryyyrrryyyyyyryryyryyrrrryryrryyrryyryyrrryyyyyrrryyyyr"
                +"yyyrrrryyryyyryyrryyrryyyyyyrryyyyryryryrryrrrrrryyryryyryrryryyyrrryyyyryrrrryyryrryyrrryryryryyyrrrryrrrrryyyyyryrryyyryyrrrrryyyyyyyryryyyyyyyrrryrryryyrryyyyrrrryyyryrrrrrrrrryyryrrryyryryyyyryyryyrryyyyyyrrryyyyyrryrryryyrrrryyryyrryyryyyyyrrryryyrryrrryryryryyrryyrrryyyryyryyryryrrrryyyryryyryyyrrrrryrrryyryyyyrryyyryrry"
                +"yyrryyyyyryryyryyyryyyrrryyyrrryyyryryyryryyryrrryrrrrryyryrrryrrrryyrrrryyyryyryyyryyryyyyyyyrrrrryyryyyyyyyryrrryrrrrryryrryyrrrrrrryyrryyryyyyyryyyryyrryryrryryyryryyyryryryrrrryyrryryryrryrrrryrryyyyrrrrrrrrrryyyryryyyrrryryyyyyrr"
                +"rrrryryryyyyyyrrryrryyrrrrrrrryyyryrryryryrrryrryyrryyrryyyyyrryyyyryyyyryyrryrrryrryryryrrryrryyrryyryyryyrrryyyyyryyyyryrryrrrryyryyrrrryrrryryyryryryryrryyyyryyrryyrryryrrryyyrryrrrrryrryrrryyyyyrrrrryyryyrrryyyyryrryyyyyyyyryyrryryyyryrryrryrryryyryrrryryrrrrrrryryryyyyyrrrryrrryrryyryryyryryryrryyrrryrryyryryyyyyyyyrrryrrry"
                +"yyyryyyyyyrrrrryyyyyyyyyryrrryryryrryrrrrryyyrrryyrryyyyyyyryyyrryryryrryryryyyrryyyyryyyyryryyyyyrrrryyrrrryyyyrrrrryyryyrryryyyyryrryyyryrryyrrrrryyrrryryyrrrrryyyyyyryrrrryrrryryyryyrryryyrryrrrrryrryyyyryyyyyrryryyyryrryyrrrrryrrryyryyyrryyyyyryyyryrrryryyryyyryryyyrrryrryrrryyyryrrryryyryryyryyryrrrrryrrrryrrrrr"
                +"rryyrrryryryryyryyyryyyrrryyyrrryyyryyrryrrrryyyyrryyryyyyryyryyyyrrrryyyryrrrrryrrryrrryyyrrrryyrrrryyrryyryryyrryrryrrryrrrrryyryryyrrryrrryyrryyyyrrrrrryyrryyryryrrryrryrryryrryyryyyyyrryryyyrryryrrryyyyrryryrrryryyyryyyryyryryyrrryrryyyyrrryyrryrryrrryyyryyyrryrrrryrrrryrryrrrrrrrrrryyrrrryyyyyryryyyyyryryrryyrryyryryrrryyryrr"
                +"yyyyryrrrrrrryyyyyryyyryrryyyrrrrrrryyyrrryrrrrryrrryyryryryryrrryryryyyyyrryyrryryyyryyrryryyyrrrryyyyyyyyryyrrrryryyyyyyryryrrrryrryyryrryryryryyyryyrrrrryyyyrryyrrryryryrryryyyryyrryyyryyryyryryryyyyyrrrrryrrryyrrrrrrrryyryryrryyry"
                +"ryryyrrrrrrrrrrryyyryrryrrrryryyyryyryrryyyryrrryyryrrrrryyyryyyrryrryryyyyrrryyyrrrryyryryyyyyyyrrrryyyrrryyrryrrrryryyyyyyyryryrryryryrryyryyryryyrrrryryyryyryyyyryyryyyrrrrrrrryyrrr";
        Collection ss = new Collection();
        System.out.println(ss.minimumOperations(leaves));
        System.out.println(ss.mySolution(leaves));
    }

    /**
     * @param leaves input String
     * @info dynamic programming, O(n)
     */
    public int minimumOperations(String leaves) {
        int n = leaves.length(), cnt = 0, ans = 0;
        if (leaves.charAt(0) == 'y') ++ans;
        if (leaves.charAt(n - 1) == 'y') ++ans;
        for (int i = 1; i < n - 1; ++i) {
            if (leaves.charAt(i) == 'y') ++cnt;
        }
        if (cnt == 0) return 1 + ans;
        int cur = 0, mx = 0;
        for (int i = 1; i < n - 1; ++i) {
            char ch = leaves.charAt(i);
            if (ch == 'y') {
                ++cur;
            } else {
                if (cur > 0) --cur;
            }
            mx = Math.max(cur, mx);
        }
        return cnt - mx + ans;
    }


    /**
     * @param leaves input String
     * @info a little dp, O(n^3)   T_T
     */
    public int mySolution(String leaves) {
        //counts[0] :left       R
        //counts[1] :middle     Y
        //counts[2] :right      R
        int counts[][] = new int[3][leaves.length()];
        /*
         *
         * */
        for (int[] ints : counts) {
            Arrays.fill(ints, 10000000);
        }
        /*init start*/
        counts[0][0] = (leaves.charAt(0) == 'y') ? 1 : 0;
        counts[2][leaves.length() - 1] = (leaves.charAt(leaves.length() - 1) == 'y') ? 1 : 0;
        //middle
        for (int i = 1; i < leaves.length() - 1; i++) {
            counts[1][i] = (leaves.charAt(i) == 'r') ? 1 : 0;
        }

        //start point , length
//        int[][] middle = new int[leaves.length() - 2][leaves.length() - 2];
        /*init end*/
        //dynamic programming(left and right parts)
        for (int i = 1; i < leaves.length() - 2; i++) {
            //left
            counts[0][i] = (leaves.charAt(i) == 'y') ? counts[0][i - 1] + 1 : counts[0][i - 1];
            counts[2][leaves.length() - i - 1] = (leaves.charAt(leaves.length() - i - 1) == 'y') ?
                    counts[2][leaves.length() - i] + 1 : counts[2][leaves.length() - i];
        }
//        for (int i = 1; i < leaves.length() - 1; i++) {
//            middle[0][leaves.length() - 3] += counts[2][i - 1];
//        }
//        for (int i = 0; i < leaves.length(); i++) {
//            for (int j = middle.length-1; j < leaves.length(); j++) {
//                middle[i][j] += counts[1][j];
//            }
//        }
        int min = 100000000;
        //left part
        for (int leftLength = 0; leftLength < leaves.length() - 2; leftLength++) {
            //right part
            for (int rightLength = 0; rightLength < leaves.length() - 2; rightLength++) {
                int countMiddle = 0;
                for (int k = 0; k < leaves.length() - 2 - leftLength - rightLength; k++) {
                    countMiddle += counts[1][k + leftLength + 1];
                }
                min = Math.min(counts[0][leftLength] + counts[2][leaves.length() - rightLength - 1]
                        + countMiddle, min);
            }
        }

//        for (int i = 0; i < leaves.length()-2; i++) {
//
//        }
        return min;

    }

}