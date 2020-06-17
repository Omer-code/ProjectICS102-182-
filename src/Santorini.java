import java.util.Scanner;


public class Santorini {

    public static final int width = 5;
    public static final int w4 = 4;
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        String[] players = new String[2];
        int p=0;

        SantoriniGame game = new SantoriniGame();

        for (int i=0; i<2; i++){
            System.out.printf("Please enter the name of player the %d:\n", i+1);
            players[i] = kb.next();
        }
        for (int i=0; i<4; i++){
            System.out.println("Enter the name of the worker: ");
            String name = kb.next();
            name = name.toUpperCase();
            game.workers[i].setName(name);
            int x, y;
            System.out.println("Enter positions: ");
            x = kb.nextInt();
            y = kb.nextInt();
            while(!game.workers[i].placeWorker(x,y,game)){
                System.out.println("Error!! enter new positons for the worker: ");
                x = kb.nextInt();
                y = kb.nextInt();
            }
        }


        System.out.println(game);
        do {
            int movex, movey, buildx, buildy, con=0, start=0, stop=2;
            String mworker;

            System.out.printf("%s, please select the worker you want to move:\n", players[p%2]);

            mworker = kb.next();
            if (p%2 == 1){
                start=2;
                stop=w4;
            }

            int i=0;
            for (i=start; i<stop && con==0; i++)
                if (game.workers[i].getName().equalsIgnoreCase(mworker.toUpperCase()))
                    con = 1;
            while (con ==0){
                System.out.println("The worker selection is not valid, try again.");
                mworker = kb.next();
                for (i=start; i<stop && con==0; i++)
                    if (game.workers[i].getName().equalsIgnoreCase(mworker.toUpperCase()))
                        con = 1;
            }

            System.out.println("now enter the new position of the worker you selected: ");
            movex = kb.nextInt();
            movey = kb.nextInt();

            while (!game.workers[i-1].move(movex, movey, game)){
                System.out.println("This move is not legal, try again.");
                movex = kb.nextInt();
                movey = kb.nextInt();
            }

            System.out.println("The worker has been moved successfully!");
            System.out.println("Where do you want to build?");
            buildx = kb.nextInt();
            buildy = kb.nextInt();

            while (!game.build(buildx, buildy, i-1)){
                System.out.println("The build action could not be completed, try again.");
                buildx = kb.nextInt();
                buildy = kb.nextInt();
            }

            System.out.println("The build action is successful!");
            System.out.println(game);
            p++;

        }while (!(game.hasWon()) /* (!game.isTrapped(p))|| kb.hasNextLine()*/ );

        if (game.hasWon() /*|| !(game.isTrapped(p))*/)
            System.out.printf("Congratulations %s!! You WON!", players[(p+1)%2]);



    }
}