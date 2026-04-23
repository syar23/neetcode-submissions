class Solution {
    public void setZeroes(int[][] matrix) {

        /*Simple safe method (O(m+n) space)
            Keep two arrays:
            rowZero[m], colZero[n].
            Scan matrix → whenever you see a 0, mark rowZero[i] = true and colZero[j] = true.
            After scan, re-walk matrix → if rowZero[i] or colZero[j] is true, set cell to 0.
            This works but uses O(m+n) extra memory.
        */

        /*
        Instead of creating those two arrays, notice:
    We already have a grid of m rows and n cols.
    We can use the first row and the first column themselves as the marker arrays.
    Step A — Detect if first row/col themselves need to be zeroed
    Why? Because we’re about to use them as markers and overwrite them. We need to remember their original state.
    row0Zero = true if any element in the first row is 0.
    col0Zero = true if any element in the first column is 0.
    Step B — Use first row and col as markers
    Now scan the rest of the matrix (i=1..m-1, j=1..n-1):
    If matrix[i][j] == 0, then mark:
    matrix[i][0] = 0 → "row i should be zeroed"
    matrix[0][j] = 0 → "col j should be zeroed"
    This is exactly what our rowZero and colZero arrays would have done — but stored in the first row/col themselves.
    Step C — Zero the inner part
    Now scan again (i=1..m-1, j=1..n-1):
    If matrix[i][0] == 0 OR matrix[0][j] == 0, set matrix[i][j] = 0.
    Step D — Finally fix first row and first col
    If row0Zero was true → zero entire row 0.
    If col0Zero was true → zero entire column 0.
*/

int m = matrix.length, n = matrix[0].length;

        boolean row0Zero = false, col0Zero = false;

        // Check first row
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) { row0Zero = true; break; }
        // Check first column
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) { col0Zero = true; break; }

        // Use first row/col as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // mark row i
                    matrix[0][j] = 0;  // mark col j
                }
            }
        }

        // Zero inner cells based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero first row if needed
        if (row0Zero) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        // Zero first column if needed
        if (col0Zero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}
