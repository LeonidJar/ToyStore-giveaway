import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ToyStore {

    public static void main(String[] args) throws IOException {
        ArrayList<Toy> toyList = new ArrayList<>();
        ArrayList<Toy> allToys = new ArrayList<>();

        mainMenu(toyList, allToys);
    }

    public static void mainMenu(ArrayList<Toy> toyList, ArrayList<Toy> allToys) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Добавить игрушку");
        System.out.println("2 - Разыграть");
        System.out.println("3 - Выдать призы");
        System.out.println("4 - Выход");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                AddToy(toyList, allToys);
                break;
            case 2:
                roll(toyList, allToys);
                break;
            case 3:
                givePrize(toyList, allToys);
                break;
            case 4:
                System.exit(0);
        }
        scanner.close();
    }

    public static void AddToy (ArrayList<Toy> toyList, ArrayList<Toy> allToys) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id игрушки");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите название игрушки");
        String name = scanner.nextLine();
        System.out.println("Введите количество игрушек");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите вес игрушки");
        int weight = Integer.parseInt(scanner.nextLine());

        toyList.add(new Toy(id, name, amount, weight));


        mainMenu(toyList, allToys);
    }

    public static void roll(ArrayList<Toy> toyList, ArrayList<Toy> allToys) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Toy> toys = new ArrayList<>();

        for (int i = 0; i < toyList.size(); i++) {
            for (int j = 0; j < toyList.get(i).weight; j++) {
                if (toyList.get(i).amount != 0) toys.add(toyList.get(i));
            }
        }

        System.out.println("Сколько игрушек разыграть:");
        int toysAmount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < toysAmount; i++) {
            int prize = new Random().nextInt(toys.size());

            while (toys.get(prize).amount == 0) {
                prize = new Random().nextInt(toys.size());
            } 

            toys.get(prize).amount -= 1;
            allToys.add(toys.get(prize));
        }

        toys.clear();

        mainMenu(toyList, allToys);
    }

    public static void givePrize(ArrayList<Toy> toyList, ArrayList<Toy> allToys) throws IOException {
        FileWriter writer = new FileWriter("Prizes.txt");
        writer.write("Выданыне призы:\n");
        
        for (int i = 0; i < allToys.size(); i++) {
            writer.write(allToys.get(i).getInfo() + "\n");
            System.out.println(allToys.get(i).getInfo());            
        }

        writer.close();

        mainMenu(toyList, allToys);
    }
}