class Solution {
    int n;
    int MOD = 1_000_000_007;

    private int getIntFromChar(char ch) {
        return ch != 'S' ? ch - '0' : 0;
    }

    private boolean isValid(int i, int j, List<String> board) {
        return i >= 0 && i < n && j >= 0 && j < n && board.get(i).charAt(j) != 'X';
    }

    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();

        int[][] dpScore = new int[n][n];
        int[][] dpPaths = new int[n][n];

        dpScore[0][0] = 0;
        dpPaths[0][0] = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                char ch = board.get(i).charAt(j);

                if (ch == 'E') continue;
                if (ch == 'X') continue;

                int upScore = 0, upPaths = 0;
                int leftScore = 0, leftPaths = 0;
                int diagScore = 0, diagPaths = 0;

                if (isValid(i - 1, j, board)) {
                    upScore = dpScore[i - 1][j];
                    upPaths = dpPaths[i - 1][j];
                    if (upPaths > 0)
                        upScore += getIntFromChar(ch);
                }

                if (isValid(i, j - 1, board)) {
                    leftScore = dpScore[i][j - 1];
                    leftPaths = dpPaths[i][j - 1];
                    if (leftPaths > 0)
                        leftScore += getIntFromChar(ch);
                }

                if (isValid(i - 1, j - 1, board)) {
                    diagScore = dpScore[i - 1][j - 1];
                    diagPaths = dpPaths[i - 1][j - 1];
                    if (diagPaths > 0)
                        diagScore += getIntFromChar(ch);
                }

                int bestScore, bestPaths;

                if (upScore == leftScore && leftScore == diagScore) {
                    bestScore = upScore;
                    bestPaths = upPaths + leftPaths + diagPaths;
                } else if (upScore == leftScore) {
                    bestScore = upScore;
                    bestPaths = upPaths + leftPaths;

                    if (diagScore > bestScore || (diagScore == bestScore && diagPaths > bestPaths)) {
                        bestScore = diagScore;
                        bestPaths = diagPaths;
                    }
                } else if (leftScore == diagScore) {
                    bestScore = leftScore;
                    bestPaths = leftPaths + diagPaths;

                    if (upScore > bestScore || (upScore == bestScore && upPaths > bestPaths)) {
                        bestScore = upScore;
                        bestPaths = upPaths;
                    }
                } else {
                    bestScore = upScore;
                    bestPaths = upPaths;

                    if (leftScore > bestScore || (leftScore == bestScore && leftPaths > bestPaths)) {
                        bestScore = leftScore;
                        bestPaths = leftPaths;
                    }

                    if (diagScore > bestScore || (diagScore == bestScore && diagPaths > bestPaths)) {
                        bestScore = diagScore;
                        bestPaths = diagPaths;
                    }
                }

                dpScore[i][j] = bestScore;
                dpPaths[i][j] = (int) ((long) bestPaths % MOD);
            }
        }

        return new int[]{dpScore[n - 1][n - 1], dpPaths[n - 1][n - 1]};
    }
}
// class Solution {
//     int n;
//     int MOD = 1_000_000_007;
//     int[][] dpScore;
//     int[][] dpPaths;
//     public int[] pathsWithMaxScore(List<String> board) {
//         n=board.size();
//         dpScore = new int[n][n];
//         dpPaths = new int[n][n];
//         for (int[] row : dpScore) Arrays.fill(row, -1);
//         int[] res=solve(n-1,n-1,board);
//         return new int[]{res[0], res[1]};
//     }

//     private int[] solve(int i, int j, List<String> board){
//         char here = board.get(i).charAt(j);
//         if(here=='E') return new int[]{0,1};
//         if(here=='X') return new int[]{0,0};
//         if (dpScore[i][j] != -1)
//             return new int[]{dpScore[i][j], dpPaths[i][j]};
//         int upScore = 0,   upPaths = 0;
//         int leftScore = 0, leftPaths = 0;
//         int diagScore = 0, diagPaths = 0;
//         char ch = here;

//         // up
//         if(isValid(i-1,j,board)){
//             int[] r = solve(i - 1, j, board);
//             upScore=r[0];
//             upPaths=r[1];
//             if (upPaths > 0) upScore += getIntFromChar(ch);
//         }
//         // left
//         if(isValid(i,j-1,board)){
//             int[] r=solve(i,j-1,board);
//             leftScore=r[0];
//             leftPaths=r[1];
//             if (leftPaths > 0) leftScore += getIntFromChar(ch);
//         }
//         // diagnal
//         if(isValid(i-1,j-1,board)){
//             int[] r=solve(i-1,j-1,board);
//             diagScore=r[0];
//             diagPaths=r[1];
//             if (diagPaths > 0) diagScore += getIntFromChar(ch);
//         }

//         int bestScore,bestPaths;
//         if(upScore==leftScore && leftScore==diagScore){
//             bestScore = upScore;
//             bestPaths = upPaths + leftPaths + diagPaths;
//         } else if(upScore==leftScore){
//             bestScore=upScore;
//             bestPaths=upPaths+leftPaths;
//             if(diagScore>bestScore || (diagScore == bestScore && diagPaths > bestPaths)){
//                 bestScore=diagScore;
//                 bestPaths=diagPaths;
//             }
//         } else if(leftScore==diagScore){
//             bestScore=leftScore;
//             bestPaths=diagPaths+leftPaths;
//             if(upScore>bestScore || (upScore == bestScore && upPaths > bestPaths)){
//                 bestScore=upScore;
//                 bestPaths=upPaths;
//             }
//         } else{
//             bestScore = upScore; bestPaths = upPaths;
//             if (leftScore > bestScore || (leftScore == bestScore && leftPaths > bestPaths)) {
//                 bestScore = leftScore; bestPaths = leftPaths;
//             }
//             if (diagScore > bestScore || (diagScore == bestScore && diagPaths > bestPaths)) {
//                 bestScore = diagScore; bestPaths = diagPaths;
//             }
//         }
//         dpScore[i][j] = bestScore;
//         dpPaths[i][j] = (int)(((long) bestPaths) % MOD);

//         return new int[]{dpScore[i][j],dpPaths[i][j]};
//     }

//     private boolean isValid(int i, int j, List<String> board) {
//         return i >= 0 && i < n && j >= 0 && j < n && board.get(i).charAt(j) != 'X';
//     }

//     private int getIntFromChar(char ch) {
//         return ch != 'S' ? ch - '0' : 0;
//     }

// }

// class Solution {

//     int n;
//     int MOD = 1_000_000_007;

//     int[][] dpScore;
//     int[][] dpPaths;

//     int[][] dir = {{-1, 0}, {0, -1}, {-1, -1}};

//     public int[] pathsWithMaxScore(List<String> board) {

//         n = board.size();

//         dpScore = new int[n][n];
//         dpPaths = new int[n][n];

//         for (int[] row : dpScore) {
//             Arrays.fill(row, -1);
//         }

//         return solve(n - 1, n - 1, board);
//     }

//     private int[] solve(int i, int j, List<String> board) {

//         if (i < 0 || j < 0)
//             return new int[]{0, 0};

//         char ch = board.get(i).charAt(j);

//         if (ch == 'X')
//             return new int[]{0, 0};

//         if (ch == 'E')
//             return new int[]{0, 1};

//         if (dpScore[i][j] != -1)
//             return new int[]{dpScore[i][j], dpPaths[i][j]};

//         int maxScore = -1;
//         int paths = 0;

//         for (int[] d : dir) {

//             int ni = i + d[0];
//             int nj = j + d[1];

//             if (!isValid(ni, nj, board))
//                 continue;

//             int[] res = solve(ni, nj, board);

//             if (res[1] == 0)
//                 continue;

//             int score = res[0] + getValue(ch);

//             if (score > maxScore) {
//                 maxScore = score;
//                 paths = res[1];
//             } else if (score == maxScore) {
//                 paths = (paths + res[1]) % MOD;
//             }
//         }

//         if (maxScore == -1) {
//             dpScore[i][j] = 0;
//             dpPaths[i][j] = 0;
//         } else {
//             dpScore[i][j] = maxScore;
//             dpPaths[i][j] = paths;
//         }

//         return new int[]{dpScore[i][j], dpPaths[i][j]};
//     }

//     private boolean isValid(int i, int j, List<String> board) {
//         return i >= 0 && j >= 0 &&
//                i < n && j < n &&
//                board.get(i).charAt(j) != 'X';
//     }

//     private int getValue(char ch) {
//         if (ch == 'S' || ch == 'E')
//             return 0;
//         return ch - '0';
//     }
// }