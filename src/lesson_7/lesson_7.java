package lesson_7;

public class lesson_7 {
    public static void main(String[] args) {
        CatsAndPlate();
    }

    public static void CatsAndPlate() {
        Cat[] CatArray = new Cat[5];
        CatArray[0] = new Cat("Cтепа", 40);
        CatArray[1] = new Cat("Федор", 20);
        CatArray[2] = new Cat("Барсик", 25);
        CatArray[3] = new Cat("Усатик", 15);
        CatArray[4] = new Cat("Пушистик", 10);
        Plate Plate_1 = new Plate(100);
        Plate_1.info();
        for (int i = 0; i < CatArray.length; i++) {
            CatArray[i].eat(Plate_1);
        }
        Plate_1.info();
    }
}

