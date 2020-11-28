import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Personality {
    public static final int PERSONALITY_COUNT = 4;
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream output = new PrintStream(new File("results.txt"));
        Scanner console = new Scanner(System.in);

        intro();
        String file = getFile(console);

        Scanner input = new Scanner(new File(file));

        while (input.hasNextLine()) {
            String name = input.nextLine();
            String answer = input.nextLine();
// fix processing this in one pass
            char[] characters = answer.toCharArray();
            char[] extrovertVsIntrovert = processIntroExtro(characters, 10); // extro vs introvert
            char[] sensationVsIntuition = processOtherPersonalities(characters, 20, 1, 2); // sensation vs iNtuition
            char[] thinkingVsFeeling = processOtherPersonalities(characters, 20, 3, 4); // thinking vs feeling
            char[] judgingVsPerceiving = processOtherPersonalities(characters, 20, 5, 6); // judging versus perceiving

            int[] bPercentage = new int[PERSONALITY_COUNT];

            bPercentage[0] = calcPercent(extrovertVsIntrovert);
            bPercentage[1] = calcPercent(sensationVsIntuition);
            bPercentage[2] = calcPercent(thinkingVsFeeling);
            bPercentage[3] = calcPercent(judgingVsPerceiving);

            char[] personType =  new char[PERSONALITY_COUNT];

            personType[0] = calcPersonality(bPercentage[0], 'E', 'I');
            personType[1] = calcPersonality(bPercentage[1], 'S', 'N');
            personType[2] = calcPersonality(bPercentage[2], 'T', 'F');
            personType[3] = calcPersonality(bPercentage[3], 'J', 'P');

            String pType = new String(personType);

            output.println(name + ": " + Arrays.toString(bPercentage) + " = " + pType);
        }
    }

    public static char calcPersonality(float bPercentage, char type1, char type2) {
        if (bPercentage > 0.5) {
            return type2;
        } else if (bPercentage < 0.5) {
            return type1;
        } else {
            return 'X';
        }
    }

    public static int calcPercent(char[] personalityData) {
        int answerTotal = 0;
        int bTotal = 0;

        for (int i = 0; i < personalityData.length; i++) {
            if (personalityData[i] == 'A' || personalityData[i] == 'a') {
                answerTotal++;
            } else if (personalityData[i] == 'B' || personalityData[i] == 'b') {
                answerTotal++;
                bTotal++;
            }
        }
        int bPercent = bTotal * 100/ answerTotal; // fix
        return bPercent;
    }

    public static char[] processOtherPersonalities(char[] characters, int answerCount, int start1, int start2) {
        char[] personality = new char[answerCount];
        for (int i = 0; i < answerCount; i+=2) {
            personality[i] = characters[(i/2) * 7 + start1];
            personality[i+1] = characters[(i/2) * 7 + start2];
        }
        return personality;
    }

    public static char[] processIntroExtro(char[] answer, int answerCount) {
        char[] introExtro = new char[answerCount];
        for (int i = 0; i < answerCount; i++) {
            introExtro[i] = answer[i * 7];
        }
        return introExtro;
    }


    public static void intro() {
        System.out.println("This program processes a file of answers to the\n" +
                "\n" +
                "Keirsey Temperament Sorter.  It converts the\n" +
                "\n" +
                "various A and B answers for each person into\n" +
                "\n" +
                "a sequence of B-percentages and then into a\n" +
                "\n" +
                "four-letter personality type.");
    }

    public static String getFile(Scanner console) {
        System.out.println("Please enter a file name.");
        return console.nextLine();
    }
}
