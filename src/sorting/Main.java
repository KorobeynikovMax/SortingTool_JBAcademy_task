package sorting;

import java.util.*;

public class Main {

    private static String sortingType = "natural";

    public static void main(final String[] args) {
        if (args.length > 0) {
            Boolean flag = false;
            for (String s : args) {
                if ("-sortIntegers".equals(s))
                {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                inputInteger();
            }
            else if ("-dataType".equals(args[0])) {
                if ("long".equals(args[1]))
                    inputLong();
                else if ("line".equals(args[1]))
                    inputLine();
                else if ("word".equals(args[1]))
                    inputWord();
            }
        }
    }

    public static void inputInteger() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> arrayList = new ArrayList<>();
        long n = 0;

        while (scanner.hasNextLong()) {
            n++;
            arrayList.add(scanner.nextLong());
            Collections.sort(arrayList);
        }
        scanner.close();
        System.out.print("Total numbers: ");
        System.out.println(n);
        System.out.print("Sorted data: ");
        for (Long x : arrayList) {
            System.out.print(x + " ");
        }
    }

    public static void inputLong() {
        Scanner scanner = new Scanner(System.in);
        long max = 0;
        int n = 0;
        int freq = 0;

        while (scanner.hasNextLong()) {
            n++;
            long number = scanner.nextLong();
            if (n == 1) {
                max = number;
            }
            if (max == number)
                freq++;
            else if (number > max) {
                max = number;
                freq = 1;
            }
        }
        scanner.close();
        System.out.print("Total numbers: ");
        System.out.println(n);
        System.out.print("The greatest number: ");
        System.out.println(max + " (" + freq + " time(s), " +
                (int)((double)freq / n * 100) + "%).");
    }

    public static void inputWord() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        String longestWord = "";
        int freq = 0;
        ArrayList<String> list = new ArrayList();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] wordsInLine = list.get(i).split(" ");
            for (int j = 0; j < wordsInLine.length; j++) {
                if (!wordsInLine[j].isEmpty())
                    words.add(wordsInLine[j]);
            }
        }
        if (words.size() > 0 )
            longestWord = words.get(0);
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() == longestWord.length()) {
                freq++;
            } else if (words.get(i).length() > longestWord.length()) {
                longestWord = words.get(i);
                freq = 1;
            }
        }
        scanner.close();
        System.out.println("Total words: " + words.size() + ".");
        System.out.print("The longest word: " + longestWord);
        System.out.println(" (" + freq + " time(s), " +
                (int)((double)freq / words.size() * 100) + "%).");
    }

    public static void inputLine() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        String longestLine = "";
        int freq = 0;
        ArrayList<String> list = new ArrayList();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
            if (n == 0)
                longestLine = list.get(n);
            if (longestLine.length() == list.get(n).length()) {
                freq++;
            } else if (longestLine.length() < list.get(n).length()) {
                longestLine = list.get(n);
                freq = 1;
            }
            n++;
        }
        scanner.close();

        System.out.println("Total lines: " + n + ".");
        System.out.println("The longest line:\n" + longestLine);
        System.out.println("(" + freq + " time(s), " +
                (int)((double)freq / n * 100) + "%).");
    }
}

