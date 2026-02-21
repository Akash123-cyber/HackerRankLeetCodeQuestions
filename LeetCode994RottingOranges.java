package HackerRankLeetCodeQuestions;
import java.util.Queue;
import java.util.LinkedList;

public class LeetCode994RottingOranges {

    static class Orange{

        int row;
        int col;
        int time;

        Orange(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.time = t;
        }
    }


    static int rottenOranges(int[][] grid){

        int n = grid.length; //row length;
        int m = grid[0].length; //col length;

        Queue<Orange> que = new LinkedList<>();
        int freshCount = 0;

        //first of all look for all the rotten oranges and from these rotten oranges we are going to start 
        // our bfs to traverse over the fresh oranges only (fresh-> grid[row][col] == 1) to achieve this in a way
        // that we don't use extra visited array here we will simply keep change the values at(i,j) coordinates with 2
        // this will mark them as visisted;


        //first of all filling all the source nodes (oranges into our queue)
        for(int i = 0; i< n; i++){

            for(int j = 0; j < m; j++){

                if(grid[i][j] == 2) que.offer(new Orange(i,j,0));

                if(grid[i][j] == 1) freshCount++;
            }
        }

        
        int time = 0;
        int[] drow = {0, -1, 0, 1};
        int[] dcol = {-1, 0, 1, 0};

        //now starting with our multi-source BFS algorithm
        while(!que.isEmpty()){

            Orange o = que.poll();
            int r = o.row;
            int c = o.col;
            int t = o.time;

            time = Math.max(time, t);

            for(int i = 0; i < 4; i++){

                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                //only visit the node (orange) which is fresh
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1){

                    grid[nrow][ncol] = 2;
                    que.offer(new Orange(nrow, ncol, t+1));
                    freshCount--;

                }
            }
        }

        if(freshCount!=0) return -1;

        return time;
    }


    public static void main(String[] args) {

        // Example 1 Input
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        // Printing the grid
        System.out.println("Input Grid:");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        //you are given with oranges in grid where:
        // 2 -> represents a rotten orange
        // 1 -> represent a fresh orange
        // 0 -> represents an empty slot

        //Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
        //you need to find the minimum time (minutes) it will take to rot all the possible 
        // if not possible return -1;

        int result = rottenOranges(grid);

        System.out.println("It took around: "+result+" minutes to rot all the oranges");


    }    
}
