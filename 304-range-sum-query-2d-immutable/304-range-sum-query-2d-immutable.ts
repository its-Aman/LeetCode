class NumMatrix {
    private _m:number[][];
    private dp: number[][];

    constructor(matrix: number[][]) {
      this._m = matrix;
      this.buildDP();
      
      console.log(this.dp);
    }
    
    private buildDP(){
      const M = this._m.length,
            N = this._m[0].length;
      
      this.dp = Array.from(new Array(M + 1), () => Array(N + 1).fill(0));
      
      for(let i = 0; i < M; i++)
        for(let j = 0; j < N; j++)
          this.dp[i + 1][j + 1] = this.dp[i + 1][j] + this.dp[i][j + 1] + this._m[i][j] - this.dp[i][j];
    }
    
    sumRegion(row1: number, col1: number, row2: number, col2: number): number {
      return this.dp[row2 + 1][col2 + 1] - this.dp[row1][col2 + 1] - this.dp[row2 + 1][col1] + this.dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */