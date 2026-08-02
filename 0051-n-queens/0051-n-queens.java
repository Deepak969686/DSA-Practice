class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
        char[][] board=new char[n][n];
       for(char[] rows:board) Arrays.fill(rows,'.');
        solve(0,board);
        return res;
    }
    private void solve (int r,char[][] board){
        if(r==board.length){
            List<String> temp = new ArrayList<>();
            for (char[] row : board) {
                temp.add(new String(row));
            }
            res.add(temp);
            return;
        }
        for(int c=0;c<board[0].length;c++){
            if(isSafe(board,r,c)){
                board[r][c]='Q';
                solve(r+1,board);
                 board[r][c]='.';
            }
           
        }
    }
    private boolean isSafe(char[][] board,int r,int c){
        // check col
        for(int i=r-1;i>=0;i--){
            if(board[i][c]=='Q') return false;
        }
        // diagonal left;
        for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }

        // diagonal right

        for(int i=r-1,j=c+1;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}