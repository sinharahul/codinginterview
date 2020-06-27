package top100interview;

public class WordSearch {
    public static void main(String[] args) {
       WordSearch ws=new WordSearch();
       char[][]board={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(ws.exist(board,"ABCESEEEFS"));
    }
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(word==null || word.trim().equals(""))return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                visited=new boolean[board.length][board[0].length];
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] b,String word,int r, int c,int wpos){
        if(wpos==word.length())return true;
        if(r<0||r>=b.length||c<0|| c>=b[0].length|| visited[r][c])return false;
        if(b[r][c]!=word.charAt(wpos))return false;

        //return dfs(b,word,r,c,wpos+1);
        wpos++;
        visited[r][c]=true;
        return dfs(b,word,r-1,c,wpos)
                ||dfs(b,word,r+1,c,wpos)
                ||dfs(b,word,r,c+1,wpos)
                ||dfs(b,word,r,c-1,wpos);


    }

}
