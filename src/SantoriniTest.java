import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SantoriniTest {

    // public static final int width = 5;
    public static final int w4 = 4;
    public static int p=0;
    public static void main(String[] args) throws FileNotFoundException {
    	try {
        FileInputStream inputStream = new FileInputStream("test.txt");
        // Scanner kb = new Scanner(System.in);
        boolean flag=true;
        Scanner input = new Scanner(inputStream);
        while(flag) {
        String [] players = new String[2];
        


        SantoriniGame game = new SantoriniGame();
        for (int i=0; i<2; i++){
            players[i] = input.next();
            System.out.printf("The name of Player %d is: "+players[i], i+1);
            System.out.println();
        }
        for (int i=0; i<w4; i++){
            String name = input.next();
            name = name.toUpperCase();
            game.workers[i].setName(name);
            int x, y;
            x = input.nextInt();
            y = input.nextInt();
            while(!game.workers[i].placeWorker(x,y,game)) {
                System.out.print("Error!! enter new positons for the worker: ");
                x = input.nextInt();
                y = input.nextInt();
            }
        }

        System.out.println(game);
        do {
            int movex, movey, buildx, buildy, con=0, start=0, stop=2;

            String mworker;
            mworker = input.next();
            System.out.printf("%s,The Worker you want to move is :"+mworker+"\n", players[p%2]);
            if (p%2 == 1){
                start=2;
                stop=w4;
            }

            int i = 0;
            for (i=start; i<stop && con==0; i++)
                if (game.workers[i].getName().equalsIgnoreCase(mworker))
                    con = 1;
            while (con ==0){
                System.out.println("The worker selection is not valid, try again.");
                mworker = input.next();
                for (i=start; i<stop && con==0; i++)
                    if (game.workers[i].getName().equalsIgnoreCase(mworker))
                        con = 1;
            }

            
            movex = input.nextInt();
            movey = input.nextInt();
            System.out.println("the new position of the worker you selected is : "+movex+"  "+movey);
            i--;
            while (!game.workers[i].move(movex, movey, game)){
                System.out.println("This move is not legal, try again.");
                movex = input.nextInt();
                movey = input.nextInt();
            }

            System.out.println(game);
            System.out.println("The worker has been moved successfully!");
            if (game.hasWon() || (game.isTrapped())) {
            System.out.printf("Congratulations %s!! You WON!\n", players[(p)%2]);
            break;
            }
            buildx = input.nextInt();
            buildy = input.nextInt();
            System.out.println("Bulding position is :"+buildx+"  "+buildy);

            while (!game.build(buildx, buildy, i)){
                System.out.println("The build action could not be completed, try again.");
                buildx = input.nextInt();
                buildy = input.nextInt();
                
            }
            System.out.println("The build action is successful!");
            p++;
            System.out.println(game);
            
            
        }while (!(game.hasWon()) && input.hasNext()  || !(game.isTrapped()) );
        
            
            System.out.printf("If you want to reset th game say yes :");
            Scanner in =new Scanner(System.in);
            String answer=in.next();
            if(answer.equalsIgnoreCase("yes")) {
            	game.reset();
            	
            System.out.printf("game has been reseted");
            }else {
            	System.out.printf("the game has ended,thank you for playing");
            	flag=false;
            }
            while(input.hasNextInt()) {
            	input.next();
            }
            
        }
    	}catch(InputMismatchException e){
    		System.out.println("Your input is invalid");
    	}
    }
    
}