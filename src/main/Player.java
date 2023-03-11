package main;

import java.util.Scanner;

public class Player {

    private static Player instance;
    private final Gender gender;
    private final String name;

    public Player() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your character's name: ");
        System.out.flush();
        this.name = scanner.nextLine();
        System.out.println("Are you a King (1) or a Queen (2) ? ");
        int kingOrQueen = scanner.nextInt();
        this.gender = kingOrQueen == 1 ? Gender.MALE : Gender.FEMALE;
        System.out.println(this.getReignMessage());
    }

    public static Player getInstance() {
        if (instance == null) instance = new Player();
        return instance;
    }

    public String getName() {
        return name;
    }

    public String getReignMessage() {
        return "Long live " + (this.gender == Gender.MALE ? "King " : "Queen ") + this.name;
    }

    private enum Gender {
        MALE, FEMALE
    }
}
