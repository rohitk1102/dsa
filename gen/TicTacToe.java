class TicTacToe {
    public String tictactoe(int[][] moves) {
        int board[][] = new int[3][3];
        for(int i = 0; i < 3; ++i) {
            Arrays.fill(board[i], 0);
        }
        boolean isPlayerA = true;
        int len = moves.length;
        int i = 0;
        while(i < len) {
            int x = moves[i][0];
            int y = moves[i][1];
            board[x][y] = isPlayerA ? 1 : -1;
            if(didPlayerWin(x, y, board)) {
                return isPlayerA ? "A" : "B";
            }
            
            isPlayerA = !isPlayerA;
            ++i;
        }
        return len >= 9 ? "Draw" : "Pending";
    }
    
    private boolean didPlayerWin(int x, int y, int[][] board) {
        boolean hasWonHorizontal = true, hasWonVertical = true, hasWonDiag = false, hasWonRevDiag = false, isDiag = false;
        if(x == y
              || x + y == 2) {
            isDiag = true;
            hasWonDiag = true;
            hasWonRevDiag = true;
            
        }
        int value = board[x][y];
        for(int i = 0; i < 3; ++i) {
            if(board[x][i] != value)
                hasWonHorizontal = false;
            if(board[i][y] != value)
                hasWonVertical = false;
            if(isDiag) {
                if(board[i][i] != value)
                    hasWonDiag = false;
                if(board[i][3 - i - 1] != value)
                    hasWonRevDiag = false;
            }
                
        }
        return hasWonHorizontal || hasWonVertical || hasWonDiag || hasWonRevDiag;
    }
}
