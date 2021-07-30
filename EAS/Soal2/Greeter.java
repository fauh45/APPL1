package Soal2;

public class Greeter {
    Greetings greetings;

    public Greeter() {
        this.greetings = new DefaultGreeting();
    }

    public String greet() {
        return this.greetings.getGreeting();
    }

    public void setFormality(Greetings greetings) {
        this.greetings = greetings;
    }
}
