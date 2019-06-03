package dream11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IndiaBat extends Thread {
    
    team t = new team();                                        // for playing team
    Random random = new Random();                               // to generate random number
    public int run = 0;                                                // total inning    
    int i;                                                      // ball count
    int j = 60;                                                 // total ball of match 
    int m = 0;                                                  // wicket
    int k = 0;                                                  // new player come for strike
    int wicket = 0;                                             // end is wicket    
    String player1 = t.firstteam[k];                            // first player                
    String player2 = t.firstteam[k + 1];                        // second player
    String striker = player1;                                   // player on strike    
    int first = 0;                                              // striker player run count
    int second = 0;                                             // non striker player run count
    int wide = 0;                                               // extra run
    int over = 0;                                               // total over
    int z = 1;                                                  // first ball of over should not be wide
    Map<String, Integer> map = new LinkedHashMap();             // to record all player run
    HashSet<String> b_wicket = new LinkedHashSet();
    Map<String, Integer> w_count = new HashMap();

    String bowler[] = new String[2];

    void runs() throws InterruptedException {
        for (int l = 6; l < 11; l++) {
            w_count.put(t.secondteam[l], 0);
        }

        bowler[0] = bowler();
        System.out.print("Opener  '" + player1 + "' & '" + player2 + "'          " + "Opener Bowler is '" + bowler[0] + "'  \n");

        for (i = 1; i <= j + 1; i++) {
            System.out.print("ball no. = " + (i) + "   ");
            int x = rendomgenerater(1, 7);
            if (z == i && x == 6) {
                for (int l = 0; l < 5; l++) {
                    x = rendomgenerater(1, 7);
                    if (x != 6) {
                        break;
                    }
                }
            }

            switch (x) {

                case 1:
                    single();
                    break;
                case 2:
                    doubly();
                    break;
                case 3:
                    triple();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    six();
                    break;
                case 6:
                    wide++;
                    i--;
                    wide();
                    break;
                case 7:
                    wicket++;
                    System.out.print("wicket = " + wicket + "  ");
                    int count = w_count.get(bowler[0]);
                    w_count.replace(bowler[0], count + 1);
                    wicket();
                    break;
            }
            if (wicket == 10 || i == 60) {
                System.out.println("match is over");
                break;
            }
            if (i % 6 == 0) {
                System.out.println("--------------------------   Over Completed    --------------------------------");
                z = i + 1;
                over++;
                String fbowler = bowler[0];
                bowler[1] = bowler();
                if (fbowler == bowler[1]) {
                    do {
                        bowler[1] = bowler();
                    } while (fbowler == bowler[1]);
                }
                System.out.println("New Bowler Is " + bowler[1]);
                bowler[0] = bowler[1];

            }

            if (run > Main.a_run + 1) {
                System.out.println("\n\n ************   INDIA WIN   ************");
                break;
            }

        }
        if (wicket < 10) {
            player1 = "*" + player1;
            player2 = "*" + player2;
        }

        map.put(player1, first);
        map.put(player2, second);
        System.out.println("\n");
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " _______________________________________ " + m.getValue());
        }
        System.out.println("\n\n\n");
        for (Map.Entry m : w_count.entrySet()) {
            System.out.println(m.getKey() + "  - - - - - - - - - - - - - - - - - - " + m.getValue());
        }
        System.out.println("RUN (" + run + ")          " + "EXTRA (" + wide + ")         " + "WICKET (" + wicket + ")");
        if (run < Main.a_run + 1) {
            System.out.println("******** AUSTRALIA WIN *************");
        }else if(run == Main.a_run){
            System.out.println("*********** IT'S DRAW ****************");
        }
    }

    public void single() throws InterruptedException {
        run++;
        if (striker == player1) {
            first++;
            System.out.println("run = " + 1 + "by " + striker);
            striker = player2;
        } else {
            second++;
            System.out.println("run = " + 1 + "by " + striker);
            striker = player1;
        }
        Thread.sleep(200);
    }

    public void doubly() throws InterruptedException {
        run = run + 2;
        if (striker == player1) {
            first = first + 2;
            striker = player1;
        } else {
            second = second + 2;
            striker = player2;
        }
        Thread.sleep(200);
        System.out.println("run = " + 2 + "by " + striker);

    }

    public void triple() throws InterruptedException {
        run = run + 3;
        if (striker == player1) {
            first = first + 3;
            System.out.println("run = " + 3 + "by " + striker);
            striker = player2;
        } else {
            second = second + 3;
            System.out.println("run = " + 3 + "by " + striker);
            striker = player1;
        }
        Thread.sleep(200);
    }

    public void four() throws InterruptedException {
        run = run + 4;
        if (striker == player1) {
            first = first + 4;
            striker = player1;
        } else {
            second = second + 4;
            striker = player2;
        }
        Thread.sleep(200);
        System.out.println("run = " + 4 + "by " + striker);
    }

    public void six() throws InterruptedException {
        run = run + 6;
        if (striker == player1) {
            first = first + 6;
            striker = player1;
        } else {
            second = second + 6;
            striker = player2;
        }
        Thread.sleep(200);
        System.out.println("run = " + 6 + "by " + striker);
    }

    public void wide() throws InterruptedException {
        j++;
        run++;
        switch (rendomgenerater(1, 3)) {
            case 1:
                System.out.println("NOBALL");
                break;
            case 2:
                System.out.println("WIDE");
                break;
        }
    }

    public void wicket() {

        int newplayer;
        switch (1) {
            case 1:
                if (wicket == 10) {
                    break;
                }
                switch (rendomgenerater(1, 6)) {
                    case 1:
                        System.out.print(striker + "is out (bold) ");
                        break;
                    case 2:
                        System.out.print(striker + "is out (catch) ");
                        break;
                    case 3:
                        System.out.print(striker + "is out (lbw) ");
                        break;
                    case 4:
                        System.out.print(striker + " out (stumping by A.Carey) ");
                        break;
                    case 5:
                        System.out.print(striker + " out (runout) ");
                        break;
                }
                if (m == 0) {
                    k = k + 2;
                    newplayer = k;
                } else {
                    k = k + 1;
                    newplayer = k;
                }
                if (striker == player1) {
                    System.out.print(" with " + first + " run");
                    map.put(striker, first);
                    player1 = t.firstteam[newplayer];
                    first = 0;
                } else {
                    System.out.print(" with " + second + " run");
                    map.put(striker, second);
                    player2 = t.firstteam[newplayer];
                    second = 0;
                }
                String player = t.firstteam[newplayer];
                m++;
                System.out.println("-------->' " + player + " ' come for strike");
                striker = player;
                break;
        }
    }

    public int rendomgenerater(int starting, int ending) {
        int number = starting + random.nextInt((ending + 1) - starting);
        return number;
    }

    public String bowler() {
        String bowler = t.secondteam[rendomgenerater(6, 10)];
        return bowler;
    }

    @Override
    public void run() {
        try {
            runs();
        } catch (InterruptedException ex) {
            Logger.getLogger(IndiaBat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
