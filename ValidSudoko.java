/*Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
*/

class Solution {
    public boolean checkRow(int i, char[][] board) {
        HashSet<Character> row = new HashSet<>();
        for (char num : board[i]) {
            if (num == '.')
                continue;
            if (row.contains(num))
                return true;
            row.add(num);
        }
        return false;
    }

    public boolean checkColoumn(int i, char[][] board) {
        HashSet<Character> column = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            if (board[j][i] == '.')
                continue;
            if (column.contains(board[j][i]))
                return true;
            column.add(board[j][i]);
        }
        return false;
    }

    public boolean checkBox(int i, char[][] board) {
        HashSet<Character> box = new HashSet<>();
        int startColumn = (i * 3) % 9;
        int startRow = (i / 3) * 3;
        for (int j = startRow; j < startRow + 3; j++) {
            for (int k = startColumn; k < startColumn + 3; k++) {
                if (board[j][k] == '.')
                    continue;
                if (box.contains(board[j][k]))
                    return true;
                box.add(board[j][k]);
            }
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if ((checkRow(i, board)) || (checkColoumn(i, board)) || (checkBox(i, board))) {
                return false;
            }
        }
        return true;
    }
}
