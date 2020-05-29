package lesson_6;


public abstract class Animal {
    protected String WhatAnimal;
    protected String name;
    protected double Jump;
    protected int Run;
    protected double CanAnimalJump;
    protected int CanAnimalRun;

    public void AnimalInfo() {
        System.out.println(String.format("Животное: %s", this.WhatAnimal));
    }

    public void NameInfo() {
        System.out.println(String.format("Имя: %s", this.name));
    }

    protected void JumpInfo() {
        if (Jump <= CanAnimalJump) {
            System.out.println(String.format("%s пропрыгал %s [м]", this.name, this.Jump));
        }
        System.out.println(String.format("%s не может столько пропрыгать", this.WhatAnimal));
    }

    protected void RunInfo() {
        if (Run <= CanAnimalRun) {
            System.out.println(String.format("%s прообежал %s [м]", this.name, this.Run));
        }
        System.out.println(String.format("%s не может столько пробежать", this.WhatAnimal));
    }
}
