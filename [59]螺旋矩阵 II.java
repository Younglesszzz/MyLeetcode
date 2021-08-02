//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 441 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loop = n / 2;//根据n推算出循环次数
        int startx = 0;
        int starty = 0;
        int offset = 1;//偏移量
        int filler = 1;//填充的数字
        int mid = n / 2;//如果是3，5,...,2n+1这种需要对res[mid][mid]进行特殊处理

        while (loop > 0) {
            //行是x，列是y
            int i = startx;
            int j = starty;

            //上侧→
            for (; j < starty + n - offset; j++) {
                res[startx][j] = filler++;
            }
            //右侧↓
            for (; i < startx + n - offset; i++) {
                res[i][j] = filler++;
            }
            //下侧←
            for (; j > starty; j--) {
                res[i][j] = filler++;
            }
            //左侧↑
            for (; i > startx; i--) {
                res[i][j] = filler++;
            }

            loop--;

            startx++;
            starty++;

            offset += 2;
        }
        if (n % 2 == 1) {
            res[mid][mid] = filler;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
