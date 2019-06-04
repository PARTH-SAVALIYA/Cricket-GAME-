package dream11;

import java.io.IOException;

public class Main {

    static int toss;
    static int choose;
    static int i_run;
    static int a_run;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        IndiaBat i = new IndiaBat();
        AustraliaBat a = new AustraliaBat();
        team t = new team();
        System.out.println("                                          MATCH IS STARTING....   \n");

            System.out.println("INADIA TEAM                                                            AUSTRALIA TEAM ");        
        for (int j = 0; j < 11; j++) {
            System.out.println(t.firstteam[j]+"                                                        "+t.secondteam[j]);
        }
        System.out.println("\n");
        
        toss = i.rendomgenerater(1, 2);;
        choose = a.rendomgenerater(1, 2);;
        switch (toss) {
            case 1:
                System.out.print("INDIA WON THE TOSS ");
                switch (choose) {
                    case 1:
                        System.out.println("AND CHOOSE BAT FIRST");
                        System.out.println("\n");
                        i.start();
                        i.join();
                        i_run = i.run;
                        a.start();
                        a.join();
                        break;
                    case 2:
                        System.out.println("AND CHOOSE BALL FIRST");
                        System.out.println("\n");
                        a.start();
                        a.join();
                        a_run = a.run;
                        i.start();
                        i.join();
                        break;
                }
                break;
            case 2:
                System.out.print("Australia Win The Toss");
                switch (choose) {
                    case 1:
                        System.out.println("AND CHOOSE BAT FIRST");
                        System.out.println("\n");
                        a.start();
                        a.join();
                        a_run = a.run;
                        i.start();
                        i.join();
                        break;
                    case 2:
                        System.out.println("AND CHOOSE BALL FIRST");
                        System.out.println("\n");
                        i.start();
                        i.join();
                        i_run = i.run;
                        a.start();
                        a.join();
                        break;
                }
                break;
        }

    }

}
