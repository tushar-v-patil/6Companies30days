/*
Que12: https://practice.geeksforgeeks.org/problems/squares-in-nn-chessboard1801/1
*/
class Solution {
    static Long squaresInChessBoard(Long N) {
        // Sum(1*1 + 2*2 + ... + n * n)
        return N * (N+1) * (2 * N + 1) / 6;
    }
}
