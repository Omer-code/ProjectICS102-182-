
public class Worker {

    private String name;
    private int positionX;
    private int positionY;


    //constructor worker that creates the name for the worker:
    public Worker(String workerName) {
        name = workerName;
    }

    public Worker() {
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getPositionX() {
        return positionX;
    }


    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }


    public int getPositionY() {
        return positionY;
    }


    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }


    //a method to initialize the position of the worker:
    public boolean placeWorker(int StartingPositionX, int StartingPositionY, SantoriniGame game1) {
        int value = 0;
        if (StartingPositionX <= 4 && StartingPositionX >= 0 && StartingPositionY <= 4 && StartingPositionY >= 0) {

            String now = getName();

            for (int i=0; i < game1.workers.length; i++) {
                String s = game1.workers[i].getName();
                if (s.equalsIgnoreCase(now)){
                    value = i;
                    break;
                }
            }

            for (int i = 0; i < value; i++) {
                if (game1.workers[i].positionX == StartingPositionX && game1.workers[i].positionY == StartingPositionY)
                    return false;
            }

            positionX = StartingPositionX;
            positionY = StartingPositionY;

            game1.board[positionX][positionY] = getName() + "   ";
            return true;
        }
        return false;
    }

    public boolean move(int newPositionX, int newPositionY, SantoriniGame game) {
        if (Math.abs((positionX) - newPositionX) <= 1 && Math.abs((positionY) - newPositionY) <= 1
                && (newPositionX <= 4 && newPositionX >= 0) && (newPositionY <= 4 && newPositionY >= 0)) {

            if (game.board[newPositionX][newPositionY] .equals("      ")) {
                game.board[newPositionX][newPositionY] = name + "   ";
                game.board[positionX][positionY] = game.board[positionX][positionY].replaceAll(name, "   ");
                positionX = newPositionX;
                positionY = newPositionY;
                return true;
            } else if (game.board[newPositionX][newPositionY].equals("B     ")) {

                game.board[positionX][positionY] = game.board[positionX][positionY].replaceAll(name, "   ");
                game.board[newPositionX][newPositionY] = "B" + name + "  ";
                positionX = newPositionX;
                positionY = newPositionY;
                return true;
            } else if (game.board[newPositionX][newPositionY].equals("BB    ")) {
                if (game.board[positionX][positionY].indexOf("W") == 1 || game.board[positionX][positionY].indexOf("W") == 2) {
                    game.board[positionX][positionY] = game.board[positionX][positionY].replaceAll(name, "   ");
                    game.board[newPositionX][newPositionY] = "BB" + name + " ";
                    positionX = newPositionX;
                    positionY = newPositionY;
                    return true;
                }
            } else if (game.board[newPositionX][newPositionY].equals("BBB   ")) {
                if (game.board[positionX][positionY].indexOf("W") == 2) {
                    game.board[positionX][positionY] = game.board[positionX][positionY].replaceAll(name, "   ");
                    game.board[newPositionX][newPositionY] = "BBB" + name;
                    positionX = newPositionX;
                    positionY = newPositionY;
                    return true;
                }
            } else
                return false;

        }
        return false;
    }

    
    public boolean movablity(int newPositionX, int newPositionY, SantoriniGame game) {
        if (Math.abs((positionX) - newPositionX) <= 1 && Math.abs((positionY) - newPositionY) <= 1
                && (newPositionX <= 4 && newPositionX >= 0) && (newPositionY <= 4 && newPositionY >= 0)) {

            if (game.board[newPositionX][newPositionY].equals("      ") ) {
                 
                return true;
            } else if (game.board[newPositionX][newPositionY].equals("B     ")) {

                 
                return true;
            } else if (game.board[newPositionX][newPositionY].equals("BB    ")) {
                if (game.board[positionX][positionY].indexOf("W") == 1 || game.board[positionX][positionY].indexOf("W") == 2) {
                     
                    return true;
                }
            } else if (game.board[newPositionX][newPositionY].equals("BBB   ")) {
                if (game.board[positionX][positionY].indexOf("W") == 2) {
                    
                    return true;
                }
            } else
                return false;

        }
        return false;
    }

}