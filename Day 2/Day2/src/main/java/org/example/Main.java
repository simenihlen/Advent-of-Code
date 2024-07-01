package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        //Summer antall linjer som tillater 12 røde kuber, 13 grønne kuber og 14 blåe kuber
        List<String> listOfStrings = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("C:/Users/Bruker/Code/Advent of Code/Day 2/Day2/src/main/resources/strings.txt"));

        String line = br.readLine();

        while(line != null){
            listOfStrings.add(line);
            line = br.readLine();
        }

        br.close();

        String[] array = listOfStrings.toArray(new String[0]);

        int redCubes = 12;
        int greenCubes = 13;
        int blueCubes = 14;

        List<Integer> possibleGames = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            if (isPossible(array[i], redCubes, greenCubes, blueCubes)){
                possibleGames.add(i + 1);
            }
        }

        int sum = possibleGames.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Games that would have been possible: " + possibleGames);
        System.out.println("Sum of IDs of possible games: " + sum);

    }

    private static boolean isPossible(String game, int redCubes, int greenCubes, int blueCubes){
//        String[] sets = game.split(";");
//
//        for (String set : sets){
//            String[] cubes = set.trim().split(", ");
//            int redCount = 0, greenCount = 0, blueCount = 0;
//
//            for (String cube : cubes){
//                int count = Integer.parseInt(cube.split("")[0]);
//                String color = cube.split(" ")[1];
//
//                if (color.equals("red")){
//                    redCount += count;
//                } else if (color.equals("green")){
//                    greenCount += count;
//                } else if (color.equals("blue")){
//                    blueCount += count;
//                }
//            }
//            if (redCount > redCubes || greenCount > greenCubes || blueCount > blueCubes){
//                return false;
//            }
//            redCubes -= redCount;
//            greenCubes -= greenCount;
//            blueCubes -= blueCount;
//        }
//
//        return true;
        Pattern pattern = Pattern.compile("(\\d+)\\s(\\w+)");
        Matcher matcher = pattern.matcher(game);

        while (matcher.find()){
            int count = Integer.parseInt(matcher.group(1));
            String color = matcher.group(2);

            if (color.equals("red")){
                redCubes -= count;
            } else if (color.equals("green")){
                greenCubes -= count;
            } else if (color.equals("blue")){
                blueCubes -= count;
            }

            if (redCubes < 0 || greenCubes < 0 || blueCubes < 0){
                return false;
            }
        }

        return true;
    }
}