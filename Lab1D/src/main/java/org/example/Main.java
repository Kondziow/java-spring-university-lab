package org.example;

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    private static final String[] nationalityNames = {"Polska", "Szwecja", "Dania", "Australia"};
    private static final int[] nationalityHeights = {180, 170, 175, 185};

    private static final String[] playerNames = {"Konrad", "Kacper", "Janek", "Michal", "Oskar", "Artur", "Przemek", "Sebastian", "Sergiusz"};

    public static void main(String[] args) throws InterruptedException {

        List<Nationality> nationalityList = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < nationalityHeights.length; i++) {
            Nationality nationality = Nationality.builder().name(nationalityNames[i]).averageHeight(nationalityHeights[i]).build();
            nationalityList.add(nationality);
            for(int j = 0; j < 4; j++) {
                Player player = Player.builder().name(playerNames[random.nextInt(playerNames.length)]).abilities(random.nextInt(100)+1).nationality(nationality).build();
                nationality.getPlayerList().add(player);
            }

        }

        //2----------------------------------------------
        System.out.println("2");
        //nationalityList.forEach(System.out::println);
        nationalityList.forEach(e -> {
            System.out.println(e);  //Writing nationality
            List<Player> tempPlayers = e.getPlayerList();
            tempPlayers.forEach(e2 -> { //Writing every player
                System.out.println("\t" + e2);
            });
        });
        System.out.println("\n\n");

        //3----------------------------------------------
        System.out.println("3");
        Set<Player> playerList = nationalityList.stream()
                .map(Nationality::getPlayerList)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        playerList.forEach(System.out::println);
        System.out.println("\n\n");

        //4----------------------------------------------
        System.out.println("4");
        List<Player> sortedList = playerList.stream()
                .filter(p -> p.getAbilities() >= 50)
                .sorted()
                .toList();

        sortedList.forEach(System.out::println);

        System.out.println("\n\n");

        //5----------------------------------------------
        System.out.println("5");
        List<PlayerDto> dtoList = sortedList.stream()
                .map(e -> new PlayerDto(e.getName(), e.getAbilities(), e.getNationality().getName()))
                .sorted(Comparator.comparing(PlayerDto::getAbilities).reversed().thenComparing(PlayerDto::getName))
                .toList();

        dtoList.forEach(System.out::println);

        System.out.println("\n\n");

        //6----------------------------------------------
        System.out.println("6");
        String fileName = "serializedFile.bin";
        try (FileOutputStream file= new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(file)){

            out.writeObject(nationalityList);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }

        List<Nationality> serializedList;

        try (FileInputStream file = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(file)){

            serializedList = (List<Nationality>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        serializedList.forEach(System.out::println);
        System.out.println("\n\n");

        //7----------------------------------------------
        System.out.println("7");
        for(int i = 0; i < 4; i ++) {
            System.out.println("For " + (i+1) + " thread");
            long startingTime = System.currentTimeMillis();
            ForkJoinPool myThreadPool = new ForkJoinPool(i+1);

            myThreadPool.execute(() -> {
                try {
                    playerList.parallelStream()
                            .forEach(el -> {
                                System.out.println(el + " processing");
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println(el + " processed");
                            });

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    myThreadPool.shutdown();
                }
            });
            myThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println("Execution time: " + (System.currentTimeMillis() - startingTime) + "ms\n");
        }

    }
}