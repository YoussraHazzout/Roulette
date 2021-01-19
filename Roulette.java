import java.util.Random;
import java.util.Scanner;
public class Roulette {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random generator = new Random();
        double startbedrag = 100;
        double bedrag;
        int keuze, win = 0, lose = 0, spin = 0;
        double nummer;
        int rouletteNum;
        double resultaat;
        char antwoord = 'y';
        int resultArr[] = new int[36];
        String nogEenKeer = "";
        boolean speel = true;

        System.out.print("\n―――――――――――――――――――――――――――――――――――――――――――\n");
        System.out.print("♤♥♣♦ Welkom bij het Roulette spel in ons casino! ♦♣♥♤");
        System.out.print("\n―――――――――――――――――――――――――――――――――――――――――――\n");
        System.out.println("Je begint met $100,-");
        for (spin = 0; spin < 10;) {
            System.out.println("Voer een bedrag in:");
            bedrag = keyboard.nextDouble();
            if (bedrag > startbedrag) {
                System.out.println("Zo veel geld heb je helemaal niet!");
                System.out.println("Voer een juist bedrag in:");
                bedrag = keyboard.nextDouble();
            }
            if (bedrag < 1) {
                System.out.println("Je moet wel íets bieden, compadré :)");
                System.out.println("Voer een juist bedrag in:");
                bedrag = keyboard.nextDouble();
                if (bedrag > startbedrag) {
                    System.out.println("Zo veel geld heb je helemaal niet!");
                    System.out.println("Voer een juist bedrag in:");
                    bedrag = keyboard.nextDouble();
                }

            }
            if (startbedrag <= 0) {
                System.out.println("Tijd om naar huis te gaan! Je hebt geen cent meer over....");
                System.out.println("Je wordt het casino uitgezet, je mag terug komen als je weer geld hebt.");
                System.out.println("Doei!");
            }
            System.out.println("0 - Even\n1 - Oneven");
            keuze = -1;
            while (keuze < 0 || keuze > 2) {
                System.out.println("Kies je gok op:");
                keuze = keyboard.nextInt();
            }
            nummer = 0;
            if (keuze == 2) {
                while (nummer < 1 || nummer > 36) {
                    System.out.print("Gok op een nummer tussen de 1 - 36): ");
                    nummer = keyboard.nextInt();
                }
            }
            rouletteNum = generator.nextInt(37);
            spin++;
            System.out.println("Roulette nummer: " + rouletteNum);

            if (keuze == 2) {
                if (rouletteNum == nummer)
                    resultaat = 35;
                else
                    resultaat = 0;
            } else {
                if (rouletteNum == 0 || rouletteNum % 2 != keuze)
                    resultaat = 0;
                else
                    resultaat = 1;
            }

            //Print out game result, win/lose amount
            if (resultaat > 0) {
                win++;
                System.out.println("$$------------------------------------$$");
                System.out.println("Gefeliciteerd, je hebt gewonnen!");
                System.out.println("$$------------------------------------$$");
                System.out.printf("Je hebt dit bedrag gewonnen: $%.2f \n", bedrag);
                System.out.println("");
                System.out.println("Je hebt " + win + "x gewonnen en " + lose + "x verloren");
                System.out.println("Dit is ronde:" + spin);
                System.out.printf("Je huidige portomonee bevat:$%.2f \n", (resultaat + startbedrag + bedrag - 1));
                startbedrag = resultaat * bedrag + startbedrag;


                System.out.println("\nWil je nogmaals spelen? Ja of Nee? ");
                nogEenKeer = keyboard.next();
                if (spin >= 10) {
                    speel = false;}

            } else {
                lose++;
                System.out.println("Aww, je hebt verloren. Volgende keer beter...:(");
                System.out.println("Je verliest:-$" + bedrag);
                System.out.println("Je hebt " + win + "x gewonnen en " + lose + "x verloren");
                System.out.println("Dit is ronde:" + spin );
                System.out.println("Je hebt nog $ " + (startbedrag - bedrag));
                startbedrag = startbedrag - (bedrag);
                if (spin >= 10) {
                    speel=false;
                    System.out.println("Je hebt 10 rondes gespeeld, het is tijd om naar huis te gaan. Doei! :)");
                    break;}
                }
                if (startbedrag <= 0) {
                    System.out.println("Tijd om naar huis te gaan! Je hebt geen cent meer over....");
                    System.out.println("Je wordt het casino uitgezet, je mag terug komen als je weer geld hebt.");
                    System.out.println("Doei!");
                    break;
                }

                System.out.println("\nWil je nogmaals spelen? Ja of Nee? ");
                nogEenKeer = keyboard.next();

                // Doorgaan
                if (nogEenKeer.equals("Ja")) {
                    speel = true;
                }
                // Spel Stoppen
                if (nogEenKeer.equals("Nee")) {
                    speel = false;
                    System.out.println("Bedankt voor het spelen, tot de volgende keer! :)");
                    System.out.println("Je hebt " + spin + " rondes gespeeld");
                    System.out.println("Je gaat naar huis met $" + startbedrag);
                    break;

                }

            }
        }
    }

