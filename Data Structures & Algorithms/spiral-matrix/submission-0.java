class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
/*Maintain pointers:
top (first unvisited row), bottom (last unvisited row),
left (first unvisited col), right (last unvisited col).
Peel the matrix layer by layer:
go left→right on top, then top++
go top→bottom on right, then right--
if top <= bottom, go right→left on bottom, then bottom--
if left <= right, go bottom→top on left, then left++
Repeat while top <= bottom && left <= right.*/

        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;

        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // 1) left -> right
            for (int c = left; c <= right; c++) 
                ans.add(matrix[top][c]);
            top++;
            // 2) top -> bottom
            for (int r = top; r <= bottom; r++) 
                ans.add(matrix[r][right]);
            right--;
            // 3) right -> left (check row still valid)
            if (top <= bottom) {
                for (int c = right; c >= left; c--) ans.add(matrix[bottom][c]);
                bottom--;
            }
            // 4) bottom -> top (check col still valid)
            if (left <= right) {
                for (int r = bottom; r >= top; r--) ans.add(matrix[r][left]);
                left++;
            }
        }
        return ans;
    }
}

