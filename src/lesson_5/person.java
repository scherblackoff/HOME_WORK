package lesson_5;


public class person {
    private String FullName;
    private String Position;
    private String EmailAddress;
    private String PhoneNumber;
    private int Salary;
    private int Age;

    public person(String FullName, String Position, String EmailAddress, String PhoneNumber, int Salary, int Age) {
        this.FullName = FullName;
        this.Position = Position;
        this.EmailAddress = EmailAddress;
        this.PhoneNumber = PhoneNumber;
        this.Salary = Salary;
        this.Age = Age;
        PrintInfo_person(FullName, Position, EmailAddress, PhoneNumber, Salary, Age);
    }

    public void PrintInfo_person(String FullName, String Position, String EmailAddress, String PhoneNumber, int Salary, int Age) {
        if (Age > 40) {
            System.out.println("ФИО : " + this.FullName);
            System.out.println("Должность : " + this.Position);
            System.out.println("Адрес почты : " + this.EmailAddress);
            System.out.println("Телефонный номер : " + this.PhoneNumber);
            System.out.println("Зарплата : " + this.Salary);
            System.out.println("Возвраст : " + this.Age);
            System.out.println();
        }
    }
}
