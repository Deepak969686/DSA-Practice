class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int maxOverlap=0;
        for(int rowoffset=-n+1;rowoffset<n;rowoffset++){
            for(int coloffset=-n+1;coloffset<n;coloffset++){
                int count=countOverlap(rowoffset,coloffset,img1,img2);
                maxOverlap=Math.max(maxOverlap,count);
            }
        }
        return maxOverlap;
    }
    int countOverlap(int rowoffset,int coloffset,int[][] A,int[][] B){
        int n=A.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int B_i=i+rowoffset;
                int B_j=j+coloffset;
                if(B_i<0 || B_j<0 || B_i>=n || B_j>=n) continue;
                if(A[i][j]==1 && A[i][j]==B[B_i][B_j]) count++;
            }
        }
        return count;
    }
}