package io.github.tibetteixeira.java14.records;

public class App {

    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(300, 200);
        System.out.println(retangulo.altura() + " " + retangulo.largura());
        System.out.println(retangulo.area());
        Retangulo.imprimir();
    }
}



// não pode extender e nem ser extendido
// não pode incluir variável de instancia
// todos os atributos sao definidos como private e final
// permite implementar interfaces
// permite metodos estaticos
record Retangulo(double largura, double altura) implements Figura2D {

    @Override
    public double area() {
        return largura * altura;
    }

    public static void imprimir() {
        System.out.println("Retangulo");
    }
}

interface Figura2D {
    public double area();
}
