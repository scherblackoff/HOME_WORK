package lesson_6;

public class Dog extends Animal {
    private int Swim;

    public Dog(String name, int Jump, int Swim, int Run) {
        this.CanAnimalJump = 0.5;
        this.CanAnimalRun = 500;
        this.WhatAnimal = "Собака";
        this.name = name;
        this.Jump = Jump;
        this.Run = Run;
        this.Swim = Swim;
    }

    public void SwimInfo() {
        if (Swim <= 10) {
            System.out.println(String.format("%s проплыл %s [м]", this.name, this.Swim));
        }
        System.out.println(String.format("%s не сможет столько проплыть.", WhatAnimal));
    }
}
