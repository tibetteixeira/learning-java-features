package io.github.tibetteixeira.java14.pattern_matching_instanceof;

public class App {

    public static void main(String[] args) {
        Animal animal1 = new Gato();
        Animal animal2 = new Cachorro();

        // Cast implicito das variaveis no uso do instanceOf
        if (animal1 instanceof Gato gato){
            gato.miar();
        }

        if (animal2 instanceof Cachorro cachorro) {
            cachorro.latir();
        }
    }
}

class Animal {

}

class Gato extends Animal {
    public void miar() {
        System.out.println("Miau");
    }
}

class Cachorro extends Animal {
    public void latir() {
        System.out.println("Au Au");
    }
}
