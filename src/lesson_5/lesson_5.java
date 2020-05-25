package lesson_5;

public class lesson_5 {
    static public void main(String[] args) {
        DoData();
    }

        public static void DoData() {
            person[] PersonArray = new person[5];
            PersonArray[0] = new person("Щербаков Артем Михайлович", "Программист", "artem@mailbox.com", "89235678940", 30000, 30);
            PersonArray[1] = new person("Антонов Никита Олегович", "Инжинер", "nikita@mailbox.com", "89567897654", 40000, 40);
            PersonArray[2] = new person("Второв Арсений Анатольевич", "Врач", "senya@mailbox.com", "89564567464", 50000, 50);
            PersonArray[3] = new person("Шаталов Константин Петрович", "Экономист", "kostya3@mailbox.com", "89547896090", 60000, 60);
            PersonArray[4] = new person("Орешкин Олег Михайлович", "Таксист", "oleg4@mailbox.com", "89434403000", 70000, 70);
        }
}

