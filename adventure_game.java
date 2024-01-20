

import java.util.*;

public class adventure_game {

    public static String Name;
    public static int HP;
    public static int maxHP;
    public static int xp;
    public static int atk;
    public static int def;
    public static int lvl;
    public static int potion;
    static Random rand = new Random();
    static Scanner UI = new Scanner(System.in);
    public static int dam = rand.nextInt(6) + 1;
    public static int heal = rand.nextInt(6) + 1;

    public static void room2() {

    }

    public static void StartRoom() throws InterruptedException {
        String input;

        System.out.println("The room is dark and gloomy, it reeks of dead corpses and rotten food,");
        System.out
                .println("You look behind you, the skeleton you recently killed and the damaged map are on the floor");
        System.out.println("the only choice no is to move forward");
        System.out.println("avail commands: forward, heal");
        input = UI.nextLine();
        if (input.equals("heal")) {
            potion = potion - 1;
            HP = maxHP;
            System.out.print("You are now at max HP, HP=" + HP);
            Thread.sleep(2000);
            StartRoom();
        } else if (input.equals("forward")) {
            room2();
        } else {
            System.out.print("Please Choose A Valid Command");
            Thread.sleep(2000);
            StartRoom();
        }
    }

    public static void combatskel() throws InterruptedException {
        int skeldam = rand.nextInt(3) + 1;
        String input;
        int hpskel;
        hpskel = 5;
        if (HP <= 0) {
            gameover();

        }
        if (hpskel <= 0) {
            System.out.println("You Defeated A Skeleton");
            atk = atk + 1;
            def = def + 1;
            maxHP = maxHP + 1;

            System.out.format("You Have Leveled Up! atk is now %d, def is now %d, HP is now %d", atk, def, HP);
            System.out.println("");
            return;
        }
        while (hpskel > 0) {
            input = UI.nextLine();
            if (input.equals("attack")) {
                hpskel = hpskel - dam - atk;
                HP = HP - skeldam;
                System.out.format("You Have Been Hit, Your HP is %d", HP);
                System.out.println("");
                combatskel();

            } else if (input.equals("heal")) {
                if (potion <= 0) {
                    System.out.println("You Do Not Have Enough Potions");
                    combatskel();

                } else {
                    HP = HP + heal;
                    System.out.println("You Have Been Healed");
                    System.out.format("You Have Been Hit, Your HP is %d", HP);
                    System.out.println("");
                    HP = HP - skeldam;
                    Thread.sleep(1200);
                    System.out.format("You Have Been Hit, Your HP is %d", HP);
                    System.out.println("");
                    combatskel();
                }
            }
        }
    }

    public static void combatzombie() throws InterruptedException {
        System.out.println("You Have Encountered a zombie");
        int zombdam = rand.nextInt(3) + 2;
        String input;
        int hpzomb;
        hpzomb = 7;
        if (HP <= 0) {
            gameover();

        }
        if (hpzomb <= 0) {
            System.out.println("You Defeated A Zombie");
            atk = atk + 1;
            def = def + 1;
            maxHP = maxHP + 1;
            System.out.format("You Have Leveled Up! atk is now %d, def is now %d, HP is now %d", atk, def, HP);
            System.out.println("");
            return;
        }
        while (hpzomb > 0) {
            input = UI.nextLine();
            if (input.equals("attack")) {
                hpzomb = hpzomb - dam - atk;
                HP = HP - zombdam;
                System.out.format("You Have Been Hit, Your HP is %d", HP);
                System.out.println("");
                combatzombie();

            } else if (input.equals("heal")) {
                if (potion <= 0) {
                    System.out.println("You Do Not Have Enough Potions");
                    combatzombie();

                } else {
                    HP = HP + heal;
                    System.out.println("You Have Been Healed");
                    System.out.format("You Have Been Hit, Your HP is %d", HP);
                    System.out.println("");
                    HP = HP - zombdam;
                    Thread.sleep(1200);
                    System.out.format("You Have Been Hit, Your HP is %d", HP);
                    System.out.println("");
                    combatzombie();
                }
            }
        }
    }

    public static void gameover() {
        System.out.println(Name + " Died!");
        System.out.println("GAME OVER!");
        System.exit(0); // terminates if lost
    }

    /**
     * @param args
     *            the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        maxHP = 20;
        potion = 3;

        System.out.println("Welcome To Dungeon Maze");
        System.out.println("Please Input Your Name ");
        Name = UI.nextLine();
        System.out.format("%s is a brave adventurer", Name);
        System.out.println("");
        Thread.sleep(3000);
        System.out.println("They were sent on a task to check on one of");
        Thread.sleep(3000);
        System.out.println("the sacred underground shrines of Port Nyanzaru,");
        Thread.sleep(3000);
        System.out.format("but when one of the skeletons knocked off the map %s had,", Name);
        System.out.println("");
        Thread.sleep(3000);
        System.out.println("they had no choice but to try and escape the dungeon");
        Thread.sleep(3000);
        System.out.println("ARE YOU READY BRAVE ADVENTURER");
        HP = maxHP;
        lvl = 1;
        def = 1;
        atk = 1;
        Thread.sleep(5000);
        StartRoom();
    }
}