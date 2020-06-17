

public class SantoriniGame {
    public String [][] board = new String [5][5];
    public Worker [] workers ;

    public SantoriniGame() {

        for (int r= 0 ; r< board.length;r++) {
            for (int c=0 ; c<board[r].length;c++) {
                board [r][c]="      ";
            }
        }

        workers  =new Worker[4];
        for (int i =0 ; i<workers.length ; i++) {

            workers[i]  = new Worker();
        }

    }




    public boolean build(int x, int y, int i) {

        if (Math.abs(workers[i].getPositionX() - x) <=1 && Math.abs( workers[i].getPositionY() - y ) <= 1
        && x <= 4 && x >= 0 && y <= 4 && y >= 0) {

            if (board[x][y].equals("      ") || board[x][y].equals("B     ")||board[x][y].equals("BB    ") || board[x][y].equals("BBB   ")  ) {


                switch (board[x][y]) {
                    case "      ":
                        board[x][y] = "B     ";
                        return true;
                    case "B     ":
                        board[x][y] = "BB    ";
                        return true;
                    case "BB    ":
                        board[x][y] = "BBB   ";
                        return true;
                    case "BBB   ":
                        board[x][y] = "BBBD  ";
                        return true;

                    default:
                        return false;
                }
            }
            else
                return false;
        }
        else
            return false;
    }


    public boolean hasWon() {
        for (int r= 0 ; r< board.length;r++) {
            for (int c=0 ; c<board[r].length;c++) {
                if (board[r][c].substring(0, 4).equals("BBBW")) {
                        return true;
                }
            }
        }
        return false ;


    }

    public boolean isTrapped() {
    	SantoriniGame game = new SantoriniGame();  
    	game.board = this.board;
    	int trapped=0 ;
    	int p =0;
    	
    	for (int z=0; z<4 ; z++) {
    		int wTrapped =0 ;
     		
    		if (z==2) {p++;trapped=0 ;}
    		int r= workers[z].getPositionX();
			int c = workers[z].getPositionY(); 			 
    		
    				if (r>0 && r<4 && c<4 && c> 0 ) {
    					r = r-1;
    					c= c-1;
    					for (int i =r; i < r+3 ; i++) {
    						for (int j=c; j < c+3 ; j++) {
    							if (!workers[z].movablity(i, j , game)) {
    								wTrapped ++;
    							}
    						}
    					}
    					if (wTrapped ==9) {
    						trapped++;
    					}
    				}
    				else if (r==0 && c<4 && c> 0 ) {
    					System.out.println(" "+workers[z].getName()+ r +c +"" );
    					r = r;
    					c= c-1;
    					
     					
    					for (int i =r; i < r+2 ; i++) {
    						for (int j=c; j < c+3 ; j++) {
    							if (!workers[z].movablity(i, j , game)) {
    								wTrapped ++;
    							}
    						}
    					}
    					if (wTrapped ==6) {
     						trapped++;
    					}
    				}
    				else if (r==4 && c<4 && c> 0 ) {
    					r = r-1;
    					c= c-1;
    					for (int i =r; i < r+2 ; i++) {
    						for (int j=c; j < c+3 ; j++) {
    							if (!workers[z].movablity(i, j , game)) {
    								wTrapped ++;
    							}
    						}
    					}
    					if (wTrapped ==6) {
    						trapped++;
    					}
    				}
    				else if (r>0 && r< 4 && c==0 ) {
    					r = r-1;
    					c= c;
    					for (int i =r; i < r+3 ; i++) {
    						for (int j=c; j < c+3 ; j++) {
    							if (!workers[z].movablity(i, j , game)) {
    								wTrapped ++;
    							}
    						}
    					}
    					if (wTrapped ==6) {
    						trapped++;
    					}
    				}
    				else if (r>0 && r<4 && c==4) {
    					r = r-1;
    					c= c-1;
    					for (int i =r; i < r+3 ; i++) {
    						for (int j=c; j < c+2 ; j++) {
    							if (!workers[z].movablity(i, j , game)) {
    								wTrapped ++;
    							}
    						}
    					}
    					if (wTrapped ==6) {
    						trapped++;
    					}
    				}
    				else if (r==0 && c== 0 ) {
    					r = r;
    					c= c;
    					for (int i =r; i < r+2 ; i++) {
    						for (int j=c; j < c+3 ; j++) {
    							if (!workers[z].movablity(i, j , game)) {
    								wTrapped ++;
    							}
    						}
    					}
    					if (wTrapped ==4) {
    						trapped++;
    					}
    				}
    				else if (r==0 && c== 4 ) {
    					r = r-1;
    					c= c;
    					for (int i =r; i < r+2 ; i++) {
    						for (int j=c; j < c+3 ; j++) {
    							if (!workers[z].movablity(i, j , game)) {
    								wTrapped ++;
    							}
    						}
    					}
    					if (wTrapped ==4) {
    						trapped++;
    					}	
    				}
    				else if (r==4 && c== 0 ) {
    					r = r;
    					c= c-1;
    					for (int i =r; i < r+2 ; i++) {
    						for (int j=c; j < c+3 ; j++) {
    							if (!workers[z].movablity(i, j , game)) {
    								wTrapped ++;
    							}
    						}
    					}
    					if (wTrapped ==4) {
    						trapped++;
    					}
    				}
    				else if (r==4 && c== 4 ) {
    					r = r-1;
    					c= c-1;
    					for (int i =r; i < r+2 ; i++) {
    						for (int j=c; j < c+2 ; j++) {
    							if (!workers[z].movablity(i, j , game)) {
    								wTrapped ++;
    							}
    						}
    					}
    					if (wTrapped ==4) {
    						trapped++;
    					}
    				}			
     	if (trapped ==2 && p==0 ) {
         SantoriniTest.p =1;
    	return true;
    	}else if (trapped ==2 && p==1 ) {
             SantoriniTest.p =0;
        	return true;
        }
    	}
    	
    	return false ; 
    }
    		
    		
    





    public String toString () {
    	String s= "\n---0-------1-------2-------3-------4----\n";
    	
        for (int i=0; i< Santorini.width; i++){
            s += "[";
            for (int j=0; j<Santorini.width-1; j++)
                s += board[i][j] + "][";
            s += board[i][Santorini.width-1]+"] > "+i+"\n";
            s += "----------------------------------------\n";}

       
            return s;
    }

    public void reset() {
    	board = new String [5][5];


        for (int r= 0 ; r< board.length;r++) {
            for (int c=0 ; c<board[r].length;c++) {
                board [r][c]="      ";
            }
        }

        workers  =new Worker[4];
        for (int i =0 ; i<workers.length ; i++) {

            workers[i]  = new Worker();
        }

    	
        

    }

}

