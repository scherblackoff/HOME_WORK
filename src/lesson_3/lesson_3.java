package lesson_3;

import java.util.Arrays;
import java.util.Scanner;

public class lesson_3 {
    public static void main(String[] args) {
        GuessTheNumber();
        GuessTheWord();
    }
    //1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
// При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
// После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    public static void GuessTheNumber() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int MysteryNumber = (int) (Math.random() * 10);
            System.out.println("Я загадал число. Попробуй угадать!\nУ тебя только 3 попытки.");
            System.out.print("Загаданное число:");
            for (int i = 1; i < 4; i++) {
                int EstimatedNumber = scanner.nextInt();
                if (EstimatedNumber == MysteryNumber) {
                    System.out.println("Да ты крут!\nПопыток понадобилось для того, чтобы угадать число: " + i);
                    break;
                }
                if (EstimatedNumber < MysteryNumber) {
                    System.out.print("Загаданное число больше.\n Попыток осталось: " + (3 - i) + "\nЗагаданное число:");
                }
                if (EstimatedNumber > MysteryNumber) {
                    System.out.print("Загаданное число меньше.\nПопыток осталось: " + (3 - i)+"\nЗагаданное число:");
                }
                if (EstimatedNumber < 0 | EstimatedNumber > 10) {
                    System.out.print("Твое число не входит в интервал загаданного числа. Будь внимательнее.\n Попыток осталось: " + (3 - i)+"\nЗагаданное число:");
                }
            }
            System.out.println("Желаешь помериться со мной уровнем IQ ещё? 1 – да / 0 – нет»(1 – повторить, 0 – нет)");
            int answer = scanner.nextInt();
            if(answer != 1){
                break;
            }
        }
        scanner.close();
    }
    //2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
// "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
// "pear", "pepper", "pineapple", "pumpkin", "potato"}; При запуске программы компьютер загадывает слово, запрашивает
// ответ у пользователя,сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не
// угадано, компьютер показывает буквы которые стоят на своих местах.
    public static void GuessTheWord () {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String MysteryWord = words[(int) (Math.random()* words.length)];
        System.out.println("Привет! \nВ отличии от предыдущей игры я загадал случайное слово, попробуй отгадай его.\nНа этот раз попыток не будет, отгадывай хоть до потери пульса.\nЕсли захочешь закончить игру, напиши в консоль close");
        while(true){
            System.out.print("Загаданное слово:");
            String EstimatedWord = scanner.nextLine();
            if (EstimatedWord.equals("close")){
                break;
            }
            if(MysteryWord.equals(EstimatedWord)){
                System.out.println("Ты угадал! Поздравляю!");
            }if(!MysteryWord.equals(EstimatedWord)){
                System.out.println("Не получилось, но не огорчайся.Ограничений по попыткам нет.Дам тебе подсказку.");
                char[] podskaska = new char[15];
                for(int i = 0 ; i < 15 ; i++ ){
                    if (i < MysteryWord.length() && i < EstimatedWord.length() && MysteryWord.charAt(i) == EstimatedWord.charAt(i)) {
                        podskaska[i]=MysteryWord.charAt(i);
                    }else{
                        podskaska[i] = '#';
                    }
                }
                System.out.println("Вместо решеток встают буквы, которые совпали у слова, которое я загадал, и слова, которое ты только что ввел в консоль.");
                System.out.println(Arrays.toString(podskaska));
                System.out.println("Попробуй еще раз.");
            }
        }
        scanner.close();
    }
}

