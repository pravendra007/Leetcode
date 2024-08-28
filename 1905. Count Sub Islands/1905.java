import java.util.*;
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count =0 ;
        int m = grid1.length;
        int n = grid1[0].length;
        boolean visited[][] = new boolean[m][n];
        int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1 && visited[i][j]==false){
                    Queue<int[]> q = new LinkedList<>();
                    boolean flag=false;
                    q.add(new int[]{i,j});

                    while(!q.isEmpty()){
                        int curr[] = q.remove();
                        if(grid1[curr[0]][curr[1]]==0)
                        flag=true;

                        for(int dir[]: dirs){
                            int x = curr[0]+dir[0];
                            int y = curr[1]+dir[1];
                            if(x<0||y<0||x>=m||y>=n||grid2[x][y]==0||visited[x][y])
                            continue;

                            visited[x][y] = true;
                            q.add(new int[]{x,y});
                        }
                    }
                    if(!flag)
                    count++;
                }
            }
        }
        return count;
    }
}