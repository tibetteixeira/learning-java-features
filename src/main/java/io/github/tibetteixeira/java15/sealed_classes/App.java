package io.github.tibetteixeira.java15.sealed_classes;

public class App {

    public static void main(String[] args) {
        new Felino().comer();
        new Lobo().comer();
        new Leao().comer();
        new Gato().comer();
        new Girafa().comer();
    }
}

// classes seladas evitam criação de estruturas sem nexo
// as subclasses de uma classe selada deve declarar um dos tipos: sealed, non-sealed ou final
// non-sealed é o padrão de toda classe hoje
abstract sealed class Carnivoro permits Felino, Lobo {

    public void comer() {
        System.out.println("comendo carne");
    }
}

abstract sealed class Herbivoro permits Girafa {
    public void comer() {
        System.out.println("comendo vegetal");
    }
}

sealed class Felino extends Carnivoro {
    @Override
    public void comer() {
        System.out.println("Felino");
        super.comer();
        System.out.println("---");
    }
}

non-sealed class Lobo extends Carnivoro {
    @Override
    public void comer() {
        System.out.println("Lobo");
        super.comer();
        System.out.println("---");
    }
}

non-sealed class Leao extends Felino {
    @Override
    public void comer() {
        System.out.println("Leao");
        super.comer();
        System.out.println("---");
    }
}

non-sealed class Gato extends Felino {
    @Override
    public void comer() {
        System.out.println("Gato");
        super.comer();
        System.out.println("---");
    }
}

final class Girafa extends Herbivoro {
    @Override
    public void comer() {
        System.out.println("Girafa");
        super.comer();
        System.out.println("---");
    }
}

