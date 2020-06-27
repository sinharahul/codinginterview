package lc191;

public class CherryPickup {
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[][] grid={{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        cherryPickup(grid);
        System.out.println(max);
    }
    public static void cherryPickup(int[][] grid) {
       move(grid,0,0,0,0,grid[0].length-1,0,0);
    }
    //check all ppossibilities for robot1
    //check all possibilities for robot 2
    //for each possibility of robot1 try that of 2 and calculate the total
    //if on same square count once
    //if beyond bottom row than return
    private static void move(int[][] grid, int robot1x, int robot1y, int robot2x, int robot2y, int sumrobot1,int sumrobot2,int maxTotal) {
        int h=grid.length-1;int w=grid[0].length-1;
        if(robot1y > h || robot2y > h || robot1x > w || robot2x > w || robot1x < 0 || robot2x < 0 )return ;
        System.out.println(String.format("robot1y:%d,robot1x:%d ",robot1y,robot1x));
        for(int a=-1;a<2;a++) {
            for (int i = -1; i < 2; i++) {
                int sum1 = sumrobot1 + grid[robot1y][robot1x];
                int sum2 = sumrobot2 + grid[robot2y][robot2x];
                if (robot1x == robot1x && robot1y == robot2y) {
                    max=Math.max(max,sum1+sumrobot2);
                    max=Math.max(max,sum2+sumrobot1);
                    move(grid, robot1x + a,robot1y + 1 ,  robot2x + i,robot2y + 1, sum1,
                            sumrobot2, Math.max(sum1, sum2));
                    move(grid, robot1x + a,robot1y + 1, robot2x + i, robot2y + 1,  sumrobot1,
                            sum2, Math.max(sum1, sum2));
                }else {
                    max=Math.max(max,sum1+sum2);
                    move(grid, robot1x + a, robot1y + 1, robot2x + i, robot2y + 1, sum1,
                            sum2, Math.max(sum1, sum2));
                }
            }
        }

    }
}
