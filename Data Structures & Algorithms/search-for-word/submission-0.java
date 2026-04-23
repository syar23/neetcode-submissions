class Solution {
    private int ROWS,COLS;
    private Set<Pair<Integer,Integer>> path = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++) {
                if(dfs(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    //i is index of word
    public boolean dfs(char[][]board, String word, int r, int c, int index) {
        if(index == word.length())
            return true;
        if(r< 0 || c <0 || r>=ROWS || c >= COLS || board[r][c]!=word.charAt(index)|| path.contains(new Pair<>(r,c)))
            return false;
        path.add(new Pair<>(r,c));
        boolean res = dfs(board,word,r+1,c,index+1) ||
                      dfs(board,word,r-1,c,index+1) ||
                      dfs(board,word,r,c+1,index+1) ||
                      dfs(board,word,r,c-1,index+1);
        path.remove(new Pair<>(r,c));
        return res;
    }
}
