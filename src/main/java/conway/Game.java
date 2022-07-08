package conway;

public class Game {

    private int column;
    private int row;
    private int[][] board;

    public Game(int row, int column){
        this.row = row;
        this.column = column;
        board = new int[row][column];
    }

    private void printBoard(){
        System.out.println("=======");
        for(int y = 0; y < row; y++){
            String line = "|";
            for (int x = 0; x < column; x++){
                if(this.board[y][x] == 0){
                    line = line + ".";
                } else {
                    line = line + "x";
                }
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("=======");
    }
    public void setAlive(int x, int y){
        this.board[x][y] = 1;
    }

    public int getAliveNeighbours(int x, int y){
        int count = 0;
        count += isBorder(x-1, y-1);
        count += isBorder(x, y-1);
        count += isBorder(x+1, y-1);

        count += isBorder(x-1, y);
        count += isBorder(x+1, y);

        count += isBorder(x-1, y+1);
        count += isBorder(x, y+1);
        count += isBorder(x+1, y+1);

        return count;
    }

    private int isBorder(int x, int y) {
        if(x < 0 || x >= row) return 0;
        if(y < 0 || y >= column) return 0;
        return this.board[x][y];
    }

    private void nextGeneration(){
        int[][] newBoard = new int[row][column];
        for(int y = 0; y < row; y++){
            for (int x = 0; x < column; x++){
                int aliveNeighbours = getAliveNeighbours(x,y);
                if(isBorder(x,y) == 1){
                    if(aliveNeighbours < 2 ){
                        newBoard[y][x] = 0;
                    } else if(aliveNeighbours == 2 || aliveNeighbours == 3){
                        newBoard[y][x] = 1;
                    } else if(aliveNeighbours > 3){
                        newBoard[y][x] = 0;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newBoard[x][y] = 1;
                    }
                }
            }
        }
        this.board = newBoard;
    }

    public static void main(String[] args) {
        Game game = new Game(4, 5);
        game.setAlive(2,1);
        game.setAlive(2,2);
        game.setAlive(2,3);
        game.printBoard();
        game.nextGeneration();
        game.printBoard();
    }
}
