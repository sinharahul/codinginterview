package amazon;

/**
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {
    int tr;
    int tc;
    boolean[][]visited;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        tr=image.length;
        tc=image[0].length;
        int oc=image[sr][sc];
        visited=new boolean[tr][tc];
        dfs(image,sr,sc,newColor,oc);
        return image;
    }
    void dfs(int[][] image,int sr,int sc,int nc,int oc){
        if(sr<0||sr>=tr||sc<0||sc>=tc||visited[sr][sc] )return;
        visited[sr][sc]=true;
        if(image[sr][sc]!=oc){
        }else {
            image[sr][sc]=nc;
        }
        if(sc-1>=0 && image[sr][sc-1]==oc)
        {
            dfs(image,sr,sc-1,nc,oc);
        }
        if(sc+1 <tc && image[sr][sc+1]==oc){
            dfs(image,sr,sc+1,nc,oc);
        }
        if(sr+1 < tr && image[sr+1][sc]==oc){
            dfs(image,sr+1,sc,nc,oc);
        }
        if(sr-1 >=0 && image[sr-1][sc]==oc) {
            dfs(image,sr-1,sc,nc,oc);
        }
    }
}
