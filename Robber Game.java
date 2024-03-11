import java.util.*;
public class Main {
    static class map{
        char[][] Tmap;
        map(){
            Tmap = new char [][]{
                    {'A', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', '_'},
                    {'_', '_', '_', '_', '_', 'R'},
            };
        }
        void printMap(){
            for(int i = 0; i < Tmap.length; i++){
                System.out.print("\n| ");
                for(int j = 0; j < Tmap.length; j++){
                    System.out.print(""+Tmap[i][j]+" ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
    public static int[] currentRobberPosition(char[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                if(map[i][j] == 'R'){
                    int[] currentPos = new int[2];
                    currentPos[0] = i;
                    currentPos[1] = j;
                    return currentPos;
                }
            }
        }
        return null;
    }
    static class game{
        map gameMap;
        int currentAPX = 0;
        int currentAPY = 0;
        int currentRPX = 5;
        int currentRPY = 5;
        game(){
            gameMap = new map();
        }
        void catchThem(){
            int blockaid = 5;// this will block the robber to corner then in a smaller area set by the agent
            int turn = 1;
            System.out.println("Turn 0:");
            gameMap.printMap();
            do{
                System.out.println("\nTurn "+ turn+ ":");
                turn++;
                //agent moves towards the robber first
                for(int i = 0; i < 2; i++){// The agent gets two moves if it moves diagnally then that counts as two moves
                    if(currentAPX < currentRPX && currentAPY < currentRPY){
                        if(blockaid != 0 && i == 0){ //on turn one the agents puts down a blockaid from where it moved from
                            gameMap.Tmap[currentAPX][currentAPY] = 'B';
                            blockaid--;
                        }else{
                            gameMap.Tmap[currentAPX][currentAPY] = '_';
                        }
                            currentAPX++;
                            currentAPY++;
                            gameMap.Tmap[currentAPX][currentAPY] = 'A';
                            i = 2;
                    }else if(currentAPX > currentRPX && currentAPY > currentRPY){
                        if(blockaid != 0 && i == 0){
                            gameMap.Tmap[currentAPX][currentAPY] = 'B';
                            blockaid--;
                        }else{
                            gameMap.Tmap[currentAPX][currentAPY] = '_';
                        }
                        currentAPX--;
                        currentAPY--;
                        gameMap.Tmap[currentAPX][currentAPY] = 'A';
                        i = 2;
                    }else if(currentAPX > currentRPX && currentAPY < currentRPY) {
                        if (blockaid != 0 && i == 0) {
                            gameMap.Tmap[currentAPX][currentAPY] = 'B';
                            blockaid--;
                        } else {
                            gameMap.Tmap[currentAPX][currentAPY] = '_';
                        }
                        currentAPX--;
                        currentAPY++;
                        gameMap.Tmap[currentAPX][currentAPY] = 'A';
                        i = 2;
                    }else if(currentAPX < currentRPX && currentAPY > currentRPY) {
                        if (blockaid != 0 && i == 0) {
                            gameMap.Tmap[currentAPX][currentAPY] = 'B';
                            blockaid--;
                        } else {
                            gameMap.Tmap[currentAPX][currentAPY] = '_';
                        }
                        currentAPX++;
                        currentAPY--;
                        gameMap.Tmap[currentAPX][currentAPY] = 'A';
                        i = 2;
                    }else if(currentAPX < currentRPX && currentAPY == currentRPY){
                        if(blockaid != 0 && i == 0){
                            gameMap.Tmap[currentAPX][currentAPY] = 'B';
                            blockaid--;
                        }else{
                            gameMap.Tmap[currentAPX][currentAPY] = '_';
                        }
                        currentAPX++;
                        gameMap.Tmap[currentAPX][currentAPY] = 'A';
                    }else if(currentAPX > currentRPX && currentAPY == currentRPY){
                        if(blockaid != 0 && i == 0){
                            gameMap.Tmap[currentAPX][currentAPY] = 'B';
                            blockaid--;
                        }else{
                            gameMap.Tmap[currentAPX][currentAPY] = '_';
                        }
                        currentAPY++;
                        gameMap.Tmap[currentAPX][currentAPY] = 'A';
                    }else if(currentAPX == currentRPX && currentAPY > currentRPY){
                        if(blockaid != 0 && i == 0){
                            gameMap.Tmap[currentAPX][currentAPY] = 'B';
                            blockaid--;
                        }else{
                            gameMap.Tmap[currentAPX][currentAPY] = '_';
                        }
                        currentAPY--;
                        gameMap.Tmap[currentAPX][currentAPY] = 'A';
                    }else if(currentAPX == currentRPX && currentAPY < currentRPY) {
                        if (blockaid != 0 && i == 0) {
                            gameMap.Tmap[currentAPX][currentAPY] = 'B';
                            blockaid--;
                        } else {
                            gameMap.Tmap[currentAPX][currentAPY] = '_';
                        }
                        currentAPY++;
                        gameMap.Tmap[currentAPX][currentAPY] = 'A';
                    }
                    if(currentAPX == currentRPX && currentAPY == currentRPY){
                        i = 3;
                    }
                }

                if(currentAPX == currentRPX && currentAPY == currentRPY){
                    System.out.println("Robber has been caught at "+currentAPX+", "+currentAPY+".");
                    for(int i = 0; i < gameMap.Tmap.length; i++){
                        for(int j = 0; j < gameMap.Tmap.length; j++){
                            if(gameMap.Tmap[i][j] == 'R'){
                                gameMap.Tmap[i][j] = '_';
                            }
                        }
                    }
                }else{
                    boolean up = true;// These variables are used so the robber doesnt move into backwards after making a movement
                    boolean down = true;
                    boolean left = true;
                    boolean right = true;
                    for(int i = 0; i <= 5; i++){
                        Random rand = new Random(); // the robber randomly generates a number for each movement potential and moves a certain direction based on the number
                        int newPosition = rand.nextInt(4);
                        if(newPosition == 0){
                            if(currentRPY-1 >= 0 && up == true){
                                if(gameMap.Tmap[currentRPX][currentRPY-1] == '_'){
                                    gameMap.Tmap[currentRPX][currentRPY] = '_';
                                    currentRPY--;
                                    gameMap.Tmap[currentRPX][currentRPY] = 'R';
                                    down = false;
                                    up = true;
                                    left = true;
                                    right = true;
                                }
                            }
                        }else if(newPosition == 1){
                            if(currentRPX+1 <= 5 && left == true){
                                if(gameMap.Tmap[currentRPX+1][currentRPY] == '_'){
                                    gameMap.Tmap[currentRPX][currentRPY] = '_';
                                    currentRPX++;
                                    gameMap.Tmap[currentRPX][currentRPY] = 'R';
                                    up = true;
                                    down = true;
                                    left = true;
                                    right = false;
                                }
                            }
                        }else if(newPosition == 2){
                            if(currentRPY+1 <= 5 && down == true){
                                if(gameMap.Tmap[currentRPX][currentRPY+1] == '_'){
                                    gameMap.Tmap[currentRPX][currentRPY] = '_';
                                    currentRPY++;
                                    gameMap.Tmap[currentRPX][currentRPY] = 'R';
                                    up = false;
                                    down = true;
                                    left = true;
                                    right = true;
                                }
                            }
                        }else if(newPosition == 3){
                            if(currentRPX-1 >= 0 && right == true){
                                if(gameMap.Tmap[currentRPX-1][currentRPY] == '_'){
                                    gameMap.Tmap[currentRPX][currentRPY] = '_';
                                    currentRPX--;
                                    gameMap.Tmap[currentRPX][currentRPY] = 'R';
                                    up = true;
                                    down = true;
                                    left = false;
                                    right = true;
                                }
                            }
                        }else{
                            if(gameMap.Tmap[currentRPX][currentRPY-1] == '_' && currentRPY != 0){
                                gameMap.Tmap[currentRPX][currentRPY] = '_';
                                currentRPY--;
                                gameMap.Tmap[currentRPX][currentRPY] = 'R';
                            }else if(gameMap.Tmap[currentRPX+1][currentRPY] == '_' && currentRPX != 5){
                                gameMap.Tmap[currentRPX][currentRPY] = '_';
                                currentRPX++;
                                gameMap.Tmap[currentRPX][currentRPY] = 'R';
                            }else if(gameMap.Tmap[currentRPX][currentRPY+1] == '_' && currentRPY != 5){
                                gameMap.Tmap[currentRPX][currentRPY] = '_';
                                currentRPY++;
                                gameMap.Tmap[currentRPX][currentRPY+1] = 'R';
                            }else if(gameMap.Tmap[currentRPX-1][currentRPY] == '_' && currentRPX != 0){
                                gameMap.Tmap[currentRPX][currentRPY] = '_';
                                currentRPX--;
                                gameMap.Tmap[currentRPX][currentRPY] = 'R';
                            }
                        }
                    }
                }
                gameMap.printMap();

            }while(currentRobberPosition(gameMap.Tmap) != null);
        }
    }
    public static void main(String[] args) {
        game AIagent = new game();
        AIagent.catchThem();
    }
}
