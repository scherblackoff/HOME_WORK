package lesson_7;


import java.util.Scanner;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public void info() {
        System.out.println("Количество еды в тарелке: " + food);
        food = AddFood(food);
        System.out.println("Количество еды в тарелке: " + food);
    }

    public void DecreaseFood(int n, String name) {
        if (n > food) {
            System.out.println(String.format("Количества еды в тарелке не достаточно что бы кот %s наелся, поэтоу он вовсе отказывается от еды",name));
        } else {
            food -= n;
            System.out.println(String.format("Кот %s наелся",name));
        }
    }
    public int AddFood(int food){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Желаете добавить в тарелку еды?");
        String answer = scanner.nextLine();
        if(answer.equals("да")){
            System.out.println("Сколько еды вы желаете добавить в тарелку?");
            int NewFood = scanner.nextInt();
            food = food + NewFood;
            return food;
        }else{
            System.out.println("Котам придется голодать...");
            return food;
        }
    }
}