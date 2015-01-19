

public class Game {

    private Player [][] players;
    
    public Game(int gameDimension){
        initGame(gameDimension);
    }

    private void initGame(int gameDimension) {
        players = new Player[gameDimension][gameDimension];
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players[i].length; j++) {
                players[i][j] = new NullPlayer();
            }
        }
    }

    public int getFreeGameCellCount(){
        int freeCellCount = 0;
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players[i].length; j++) {
                if(players[i][j] instanceof NullPlayer)
                    freeCellCount++;
            }
        }
        return freeCellCount;
    }
    
    public void play(Player player, String gameCell) {
        int [] gameCellIndex = getGameCell(gameCell);
        int lineIndex = gameCellIndex[0];
        int columnIndex = gameCellIndex[1];
        if(players[lineIndex][columnIndex] instanceof NullPlayer){
            players[lineIndex][columnIndex] = player;
        }else{
            throw new BoxAlreadySelectedException();
        }
    }

    private int[] getGameCell(String gameCell) {
        String [] gameCellElements = gameCell.split("x");
        int [] gameCellIndex = {Integer.valueOf(gameCellElements[0]), 
                                Integer.valueOf(gameCellElements[1])};
        return gameCellIndex;
    }
}
