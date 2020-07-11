import database.Slip;
import database.SlipDao;
import http.SlipDto;
import net.bytebuddy.asm.Advice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static AdviceService adviceService;

    public Menu(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    public static void displayMenu() {
        boolean continuing = true;

        while (continuing) {
            System.out.println("Advice Book");
            System.out.println("wbierz jedną z opcji:");
            System.out.println("1) Wylosuj cytat.");
            System.out.println("2) Wyszukaj cytat");
            System.out.println("3) Moje cytaty");
            System.out.println("0) Zakończ"); //eksport cytatów, wyświetlanie, usuwanie

            int nextInt = -1;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                nextInt = scanner.nextInt();
            }
            switch (nextInt) {

                case 0: {
                    continuing = false;
                    break;
                }
                case 1: {
                    SlipDto randomAdvice = adviceService.getRandomAdvice();
                    String advice = randomAdvice.getAdvice();
                    adviceService.saveAdvise(randomAdvice);
                    System.out.println("******Cytat dla Ciebie******");
                    System.out.println(advice);
                    System.out.println("***********************");
                    break;
                }
                case 2: {
                    System.out.println("W toku");
                    break;
                }
                case 3: {
                    List<Slip> allAdvice = adviceService.getAllAdvice();
                    System.out.println(Arrays.toString(allAdvice.toArray()));
                    MenuCase3(allAdvice);
                    break;
                }
            }
        }
    }

    private static void MenuCase3(List<Slip> allAdvice) {

        boolean development = true;
        while (development) {
            System.out.println();
            System.out.println("New Menu");
            System.out.println("Wybierz jedną z opcji: ");
            System.out.println("1. Wyświetl ulubione cytaty");
            System.out.println("2. Usuń cytat z ulubionych");
            System.out.println("0. Zakończ - Powrót do poprzedniego menu");
            int nextInt = -1;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                nextInt = scanner.nextInt();
            }


            switch (nextInt) {
                case 0: {
                    development = false;
                    break;
                }
                case 1: {
                    System.out.println();
                    System.out.println("ulubione cytaty");
                    System.out.println(Arrays.toString(allAdvice.toArray()));
                    break;
                }
                case 2: {
                    System.out.println();
                    System.out.println("usuwanie cytatu - prosze podać ID");
                   long deleteId = scanner.nextInt(); //wywołaj metodę usuń w SlipDao z parametrem ID

                    if (adviceService.deleteID(deleteId)) {
                        System.out.println("Cytat został usunięty."); //dalej widać po ponownym wyświetleniu cytatów
                    } else {
                        System.out.println("nie można usunąć cytatu");
                        break;
                    }



                }

            case -1: {
                System.out.println("Wpisz liczbę");
                break;
            }
            default: {
                System.out.println("Wpisz inny numer.");
            }
        }
    }
}
}

