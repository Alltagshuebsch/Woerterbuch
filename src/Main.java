import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Erstellt das Wörterbuch und legt Mock-Daten an
        Woerterbuch<String, String> woerterbuch = erzeugeEintraege();
        String input;


        while (true) {
            mainmenu();
            input = s.nextLine();

            /**
             * Man kann die Einträge aus dem Wörterbuch nicht als Boolean-Werte auswerten,
             * da ein nicht vorhandener Wert nicht false ist, sondern null.
             * woerterbuch.isEmpty(input) führt zur NullPointerException,
             * ist aber in diesem Projekt ein erwarteter Zustand.
             * */
            if (woerterbuch.get(input) != null) {
                String puffer = new String(input);
                System.out.println(puffer + ": " + woerterbuch.get(puffer));
                System.out.println("<1> Nächster Begriff");
                System.out.println("<2> Diesen Begriff löschen");
                System.out.println("<0> Programm beenden");

                if (s.nextLine().equals("1")) {
                    System.out.println("Geben Sie den Begriff ein:");
                    input = s.nextLine();
                } else if (s.nextLine().equals("2")) {
                    woerterbuch.remove(input);
                    System.out.println("Der Begriff wurde erfolgreich gelöscht.");
                }
            } else if (woerterbuch.get(input) == null)//Sonst das
            {
                String puffer = new String(input);
                System.out.println("Keinen Eintrag zu " + input + " gefunden!");
                System.out.println("<1> Nächster Begriff");
                System.out.println("<2> Eintrag zu " + input + " anlegen");
                System.out.println("<0> Programm beenden");

                if (s.nextLine().equals("1")) {
                    System.out.println("Geben Sie den Begriff ein:");
                    input = s.nextLine();
                } else if (s.nextLine().equals("2")) {
                    System.out.println("Geben Sie eine Beschreibung für " +puffer+ " ein.");
                    input = s.nextLine();
                    woerterbuch.put(puffer, input);
                    System.out.printf("Die Beschreibung wurde erfolgreich gespeichert.");
                }
            }

            if (input.equals("0")) System.exit(0);
        }
    }


    private static Woerterbuch<String, String> erzeugeEintraege() {
        //Beispieldaten von Bing Copilot erstellt
        Woerterbuch<String, String> woerterbuch = new Woerterbuch<>(10);
        woerterbuch.put("Elefant", "Das größte Landsäugetier, bekannt für seine Intelligenz und sein gutes Gedächtnis.");
        woerterbuch.put("Löwe", "Der 'König der Tiere', ein mächtiger und majestätischer Raubkatze.");
        woerterbuch.put("Känguru", "Ein Beuteltier aus Australien, das für seine starken Sprünge bekannt ist.");
        woerterbuch.put("Pinguin", "Ein flugunfähiger Vogel, der geschickt schwimmt und in kalten Regionen lebt.");
        woerterbuch.put("Giraffe", "Das höchste Tier der Welt, bekannt für seinen langen Hals und elegante Bewegungen.");
        woerterbuch.put("Delfin", "Ein intelligentes und verspieltes Meeressäugetier mit einem ausgeprägten Sozialverhalten.");
        woerterbuch.put("Fuchs", "Ein schlaues und anpassungsfähiges Tier, bekannt für seine roten Fell und scharfen Sinne.");
        woerterbuch.put("Adler", "Ein majestätischer Vogel mit scharfem Blick und beeindruckender Flugfähigkeit.");
        woerterbuch.put("Tiger", "Eine kraftvolle Raubkatze mit auffälligem gestreiftem Fell.");
        woerterbuch.put("Wolf", "Ein soziales Raubtier, das oft in Rudeln lebt und für seine Zusammenarbeit bekannt ist.");

        return woerterbuch;
    }


    private static void mainmenu() {
        System.out.println("-------------------------------------------------------");
        System.out.println("----------------------Woerterbuch----------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("Willkommen beim Wörterbuch!");
        System.out.println("Nach welchem Wort möchten Sie suchen?");
        System.out.println("Geben Sie die <0> ein, um das Programm zu Beenden");
    }

}

