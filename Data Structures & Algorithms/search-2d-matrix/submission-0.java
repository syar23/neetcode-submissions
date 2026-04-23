class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        return bsearchMatrix(0,rows*cols-1, matrix, target);
    }
    
    private boolean bsearchMatrix(int l, int r, int[][] matrix, int target) {
        if(l>r)
            return false;
        int row = l / matrix[0].length;
        int col = l % matrix[0].length;
        if(matrix[row][col]==target)
            return true;
        return (matrix[row][col]<target) ? bsearchMatrix(l+1,r,matrix, target) : bsearchMatrix(l,r-1,matrix,target);
    }
}