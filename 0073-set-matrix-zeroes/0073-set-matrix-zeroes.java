class Solution {
    int m,n;
    public void setZeroes(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        boolean[] zeroR=new boolean[m];
        boolean[] zeroC=new boolean[n];
        // Set<Integer> zeroR=new HashSet<>();
        // Set<Integer> zeroC=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    // zeroR.add(i);
                    // zeroC.add(j);
                    zeroR[i]=true;
                    zeroC[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // if(zeroR.contains(i) || zeroC.contains(j)) matrix[i][j]=0;
                if(zeroR[i] || zeroC[j]) matrix[i][j]=0;
             }   
        }
    }
}