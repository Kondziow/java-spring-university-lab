package org.example.initializer;

import org.example.entities.Nationality;
import org.example.entities.Player;
import org.example.repositories.NationalityRepository;
import org.example.repositories.PlayerRepository;
import org.example.services.NationalityService;
import org.example.services.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class AppRunner implements CommandLineRunner {

    private final NationalityService nationalityService;
    private final PlayerService playerService;

    public AppRunner(NationalityService nationalityService, PlayerService playerService) {
        this.nationalityService = nationalityService;
        this.playerService = playerService;
    }

    @Transactional
    @Override
    public void run(String... args) {
        System.out.println("WITAJ");
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while(!exit) {
            showMenu();
            switch (scanner.nextInt()) {
                case(1) -> printNationalities();
                case(2) -> printPlayers();
                case(3) -> printAllData();
                case(4) -> addPlayer();
                case(5) -> deletePlayer();
                default -> exit = true;
            }
        }
        System.out.println("Koncze dzialanie programu");
    }

    @Transactional
    public void deletePlayer() {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = playerService.findAll();
        System.out.println("Wybierz zawodnika (1-" + players.size() + ")");
        printPlayers();
        int playerNumber = scanner.nextInt();

        playerService.deleteById(players.get(playerNumber-1).getId());
    }

    @Transactional
    public void printAllData() {
        List<Nationality> nationalities = nationalityService.findAll();

        for(Nationality nationality : nationalities){
            System.out.println(nationality);
            List<Player> players = nationality.getPlayerList();
            for(Player player : players) {
                System.out.println("\t" + player);
            }
        }
    }

    @Transactional
    public void addPlayer() {
        Scanner scanner = new Scanner(System.in);
        List<Nationality> nationalities = nationalityService.findAll();
        System.out.println("Wybierz narodowosc (1-" + nationalities.size() + ")");
        printNationalities();
        int nationalityNumber = scanner.nextInt();
        System.out.println("Podaj imie zawodnika:");
        String playerName = scanner.next();
        System.out.println("Podaj poziom umiejetnosci zawodnika:");
        int playerAbilities = scanner.nextInt();

        Nationality nationality = nationalities.get(nationalityNumber-1);

        Player player = Player.builder()
                .id(UUID.randomUUID())
                .name(playerName)
                .abilities(playerAbilities)
                .nationality(nationality)
                .build();
        Player savedPlayer = playerService.save(player);
        nationality.getPlayerList().add(savedPlayer);
    }

    private void printNationalities() {
        int i = 1;
        for(Nationality n : nationalityService.findAll()){
            System.out.println(i + ") " + n);
            i++;
        }
    }

    private void printPlayers() {
        int i = 1;
        for(Player p : playerService.findAll()){
            System.out.println(i + ") " + p);
            i++;
        }
    }

    private void showMenu() {
        System.out.println("1. Wypisz narodowości");
        System.out.println("2. Wypisz zawodników");
        System.out.println("3. Wypisz wszystkie encje");
        System.out.println("4. Dodaj zawodnika");
        System.out.println("5. Usun zawodnika");
        System.out.println("6. Wyjdz");
    }
}
