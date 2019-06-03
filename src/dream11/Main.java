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
        
        
        
        toss = i.rendomgenerater(1, 2);
        choose = i.rendomgenerater(1, 2);
        switch (1) {
            case 1:
                System.out.print("India Win The Toss   ");
                switch (2) {
                    case 1:
                        System.out.println("And Choose Bat First");
                        i.start();
                        i.join();
                        i_run = i.run;
                        a.start();
                        a.join();
                        break;
                    case 2:
                        System.out.println("And Choose Ball First");
                        a.start();
                        a.join();
                        a_run = a.run;
                        i.start();
                        i.join();
                        break;
                }
                break;
//            case 2:
//                System.out.print("Australia Win The Toss");
//                switch (choose) {
//                    case 1:
//                        System.out.println("And Choose Bat First");
//                        a.start();
//                        a.join();
//                        i.start();
//                        i.join();
//                        break;
//                    case 2:
//                        System.out.println("And Choose Ball First");
//                        i.start();
//                        i.join();
//                        a.start();
//                        a.join();
//                        break;
//                }
//                break;
        }

    }

}
