/*
Que3: https://practice.geeksforgeeks.org/problems/rotate-by-90-degree0356/1/
*/
class GFG
{
    static void rotate(int matrix[][]) 
    {
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i = 0; i < n; i++){
            int r1 = 0, r2 = n-1;
            while(r1 <= r2){
                int temp = matrix[r1][i];
                matrix[r1][i] = matrix[r2][i];
                matrix[r2][i] = temp;
                r1++; r2--;
            }
        }
    }
}
