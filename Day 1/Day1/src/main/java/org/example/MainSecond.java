package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Trengte ikke å bruke en json fil. Jeg prøvde bare på noe nytt.
public class MainSecond {
    public static void main(String[] args) throws IOException {
        //Definerer en List
        List<String> listOfStrings = new ArrayList<String>();

        //Bruker BufferedReader for å kunne lese en .txt fil
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/Bruker/Code/Advent of Code/Day 1/Day1/src/main/resources/strings.txt"));

        //Vi legger til linjer fra .txt filen inn i en String variabel
        String line = br.readLine();

        while (line != null) {
            listOfStrings.add(line);
            line = br.readLine();
        }

        br.close();

        String[] array = listOfStrings.toArray(new String[0]);

        //Vi definerer en int for totalsummen
        int totalCalib = 0;

        //Begynner å gå gjennom hvert element i listen
        for (String s : array) {
            //Vi trenger variabler for å legge til første og siste tall i linjen
            int firstDigit = 0, lastDigit = 0;

            //Her får vi første karkter som er en Digit og legger den til firstDigit
            for (char ch : s.toCharArray()){
                if (Character.isDigit(ch)){
                    firstDigit = Character.getNumericValue(ch);
                    break;
                } else {
                    firstDigit = convertLetterToDigit(ch);
                    if (firstDigit != 0){
                        break;
                    }
                }
            }

            //Her får vi tak i siste Digit og legger den til i lastDigit
            for (int i = s.length() - 1; i >= 0; i--) {
                if (Character.isDigit(s.charAt(i))){
                    lastDigit = Character.getNumericValue(s.charAt(i));
                    break;
                } else {
                    lastDigit = convertLetterToDigit(s.charAt(i));
                    if (lastDigit != 0){
                        break;
                    }
                }
            }

            //Vi bruker "* 10" ettersom at vi vil at f.eks 1+2=12 != 3
            int calibValue = firstDigit * 10 + lastDigit;
            totalCalib += calibValue;
        }

        System.out.println(totalCalib);
    }

    private static boolean isWordDigit(char ch){
        return ch == 'o' || ch == 't' || ch == 'r' || ch == 'f' || ch == 'i' || ch == 's' || ch == 'e' || ch == 'g' || ch == 'n';
    }

    private static int convertLetterToDigit(char ch){
        switch (ch){
            case 'o':
                return 1;
            case 't':
                return 2;
            case 'r':
                return 3;
            case 'f':
                return 4;
            case 'v':
                return 5;
            case 's':
                return 6;
            case 'i':
                return 7;
            case 'e':
                return 8;
            case 'n':
                return 9;
            default:
                return 0;
        }
    }
}