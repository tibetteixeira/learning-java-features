# Features do Java (7 ao 17)

Este repositório contém um mapeamento das principais características e mudanças nas versões do Java de 8 a 17. O objetivo é fornecer uma visão clara das evoluções e melhorias em cada versão.

## Sumário

- [Java 7](#java-7)
- [Java 8](#java-8)
- [Java 9](#java-9)
- [Java 10](#java-10)
- [Java 11](#java-11)
- [Java 12](#java-12)
- [Java 13](#java-13)
- [Java 14](#java-14)
- [Java 15](#java-15)
- [Java 16](#java-16)
- [Java 17](#java-17)

---

## Java 7
- **Data de Lançamento**: Julho de 2011
- **Principais Features**:
  - **Try-with-resources**: Introduz um novo recurso para gerenciar recursos como streams, conexões e arquivos, que são automaticamente fechados após o uso. Isso reduz a necessidade de blocos `finally` para fechar recursos.
    - **Exemplo**:
      ```java
      try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
          String line;
          while ((line = br.readLine()) != null) {
              System.out.println(line);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
      ```
  - **Multi-catch**: Permite capturar várias exceções em um único bloco `catch`, simplificando o tratamento de múltiplas exceções semelhantes.
    - **Exemplo**:
      ```java
      try {
          // código que pode lançar várias exceções
      } catch (IOException | SQLException e) {
          e.printStackTrace();
      }
      ```
  - **Strings em switch**: Permite usar strings como expressão de caso em instruções `switch`.
    - **Exemplo**:
      ```java
      String day = "Monday";
      switch (day) {
          case "Monday":
              System.out.println("Start of the week");
              break;
          case "Friday":
              System.out.println("End of the week");
              break;
          default:
              System.out.println("Midweek");
              break;
      }
      ```
  - **Binary Literals**: Permite a representação de literais binários com o prefixo `0b` ou `0B`.
    - **Exemplo**:
      ```java
      int binaryValue = 0b1010; // 10 em decimal
      System.out.println(binaryValue); // Output: 10
      ```
  - **Underscores em Literais Numéricos**: Permite o uso de underscores (`_`) em literais numéricos para melhorar a legibilidade.
    - **Exemplo**:
      ```java
      int million = 1_000_000;
      System.out.println(million); // Output: 1000000
      ```
  - **Automatic Resource Management (Try-with-resources)**: Facilita a declaração de múltiplos recursos no bloco `try`, garantindo que todos os recursos sejam fechados corretamente.
    - **Exemplo**:
      ```java
      try (BufferedReader br = new BufferedReader(new FileReader("file.txt"));
           PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))) {
          String line;
          while ((line = br.readLine()) != null) {
              pw.println(line);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
      ```
  - **NIO.2 (Java NIO Update)**: Introduzido como parte do Java 7, o NIO.2 expande a API de NIO (New I/O) com novas funcionalidades para manejo de arquivos e I/O.
    - **Path API**: Introduz a classe `java.nio.file.Path` para representar caminhos de arquivos e diretórios, oferecendo uma maneira mais poderosa e flexível de manipular caminhos de arquivos em comparação com as antigas classes `File` e `FileSystem`.
    - **Files API**: Adiciona a classe `java.nio.file.Files`, que contém métodos estáticos para operações de I/O com arquivos, como leitura e escrita de arquivos, além de outras operações relacionadas a arquivos e diretórios.
    - **Watch Service**: Fornece a classe `java.nio.file.WatchService` para monitorar mudanças em diretórios e arquivos, permitindo a detecção de alterações em tempo real.
    - **File Systems**: Suporte aprimorado para acessar e manipular diferentes sistemas de arquivos, incluindo operações como copiar e mover arquivos entre diretórios e sistemas de arquivos.
## Java 8

- **Data de Lançamento**: Março de 2014
- **Principais Features**:
    - **Expressões Lambda**: Facilita o desenvolvimento funcional com funções como objetos de primeira classe.
    - **Streams API**: Permite processamento de coleções de forma declarativa.
    - **Optional**: Fornece uma forma de representar valores que podem estar ausentes. É uma alternativa ao uso de `null` e ajuda a evitar `NullPointerExceptions`. Permite usar métodos como `ifPresent()`, `orElse()`, e `map()` para manipulação segura de valores.
    - **Default Methods**: Métodos com implementação em interfaces.
    - **Nashorn JavaScript Engine**: Substituição do Rhino, para execução mais eficiente de código JavaScript.
    - **Nova API de Data e Hora**: `java.time`, para substituir as antigas classes `java.util.Date` e `java.util.Calendar`.
    - **Functional Interfaces**: Introduz interfaces funcionais, como `Function`, `Consumer`, `Supplier`, e `Predicate`.


## Java 9

- **Data de Lançamento**: Setembro de 2017
- **Principais Features**:
    - **Módulos Java (Project Jigsaw)**: Introduz a modularização do código com o sistema de módulos.
    - **JShell**: Um REPL (Read-Eval-Print Loop) para testes e desenvolvimento interativo.
    - **API de Processos**: Melhorias no gerenciamento de processos e suas respectivas APIs.
    - **Coleções Imutáveis**: Novos métodos de fábrica para coleções imutáveis.
    - **takeWhile e dropWhile (Preview)**: Métodos para manipulação de fluxos, retornando subsequências de acordo com o predicado fornecido.
    - **Atualizações do try-catch**: Introduz o recurso de múltiplos recursos no bloco `try`, simplificando o gerenciamento de recursos com `try-with-resources`.
    - **Interfaces Privadas**: Adição de métodos privados em interfaces, permitindo a reutilização de código dentro da própria interface.


## Java 10

- **Data de Lançamento**: Março de 2018
- **Principais Features**:
    - **Var**: Introduz a inferência de tipo local para variáveis locais.
    - **Garbage Collector Improvements**: Melhorias no coletor de lixo, especialmente o G1.
    - **Application Class-Data Sharing**: Melhora o tempo de inicialização e o uso de memória.

## Java 11

- **Data de Lançamento**: Setembro de 2018
- **Principais Features**:
    - **API de String**: Novos métodos como `isBlank()`, `lines()`, `strip()`.
    - **Local-Variable Syntax for Lambda Parameters**: Uso do `var` em parâmetros de lambdas.
    - **HTTP Client**: Nova API para simplificar a comunicação HTTP.
    - **Remoção de APIs**: APIs antigas como `Java EE` e `CORBA` foram removidas.
    - **takeWhile e dropWhile**: Esses métodos, introduzidos como preview em Java 9, tornam-se padrão.
    - **Atualizações em Files**:
      - **Métodos em `Files`**: Introduz novos métodos na classe `Files`, como `writeString()` e `readString()`, para simplificar a leitura e escrita de arquivos como strings.
      - **Exemplo**:
        ```java
        Path path = Paths.get("file.txt");
        Files.writeString(path, "Hello, World!");
        String content = Files.readString(path);
        System.out.println(content);
        ```

## Java 12

- **Data de Lançamento**: Março de 2019
- **Principais Features**:
    - **Switch Expressions (Preview)**: Melhoria na sintaxe do switch.
      - **Exemplo**:
          ```java
          String dayOfWeek = "Monday";
          String typeDay = switch (dayOfWeek) {
              case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "business day";
              case "Sunday", "Saturday" -> "weekend";
              default -> "Invalid day: " + dayOfWeek;
          };
          System.out.println(typeDay); // Output: business day
          ```
    - **JVM Constants API**: Nova API para trabalhar com constantes na JVM.
    - **Garbage Collector Improvements**: Melhorias no G1 e suporte para o novo coletor de lixo Shenandoah.
    - **compactNumberFormat**: Nova API para formatação compacta de números. Adiciona suporte à formatação de números em formas compactas, como abreviaturas (`1K`, `1M`, etc.).
      - **Exemplo**:
        ```java
        NumberFormat compact = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(compact.format(12345)); // Output: 12.3K
        ```
    - **fileMismatch**: Novo método na classe `Files` para comparar dois arquivos e determinar se eles são diferentes. Isso pode ser útil para verificar se dois arquivos são idênticos sem ler o conteúdo completo.
      - **Exemplo**:
        ```java
        Path file1 = Paths.get("file1.txt");
        Path file2 = Paths.get("file2.txt");
        long mismatch = Files.mismatch(file1, file2);
        if (mismatch == -1) {
            System.out.println("Os arquivos são idênticos.");
        } else {
            System.out.println("Os arquivos diferem na posição: " + mismatch);
        }
        ```
    - **String Methods**:
      - **`indent()`**: Adiciona uma quantidade especificada de espaços em branco no início de cada linha de uma string.
       - **Exemplo**:
         ```java
         String str = "Hello\nWorld";
         System.out.println(str.indent(4));
         // Output:
         //     Hello
         //     World
         ```
      - **`transform()`**: Permite transformar uma string usando uma função fornecida.
       - **Exemplo**:
         ```java
         String str = "hello";
         String result = str.transform(s -> s.toUpperCase());
         Syst

## Java 13

- **Data de Lançamento**: Setembro de 2019
- **Principais Features**:
    - **Text Blocks (Preview)**: Suporte a blocos de texto multilinha.
    - **Reimplementação do ZGC**: Melhorias na implementação do Z Garbage Collector.
    - **Switch Expressions**: A funcionalidade de switch expressions, introduzida como preview em Java 12, torna-se uma característica padrão. Permite um uso mais conciso e expressivo do switch. Foi adicionada a palavra reservada `yield` para retornar o valor. O `break` foi abolido
      - **Exemplo**:
        ```java
        int dayOfWeek = 2;
        String dayName = switch (dayOfWeek) {
            case 1:
                yield "Sunday";
            case 2:
                yield "Monday";
            case 3:
                yield "Tuesday";
            case 4:
                yield "Wednesday";
            case 5:
                yield "Thursday";
            case 6:
                yield "Friday";
            case 7:
                yield "Saturday";
            default:
                yield "Invalid day: " + dayOfWeek;
        };
        System.out.println(dayName); // Output: Monday
        ```

## Java 14

- **Data de Lançamento**: Março de 2020
- **Principais Features**:
    - **Records (Preview)**: Facilita a criação de classes de dados imutáveis.
    - **Pattern Matching for instanceof (Preview)**: Simplifica a verificação de tipos e conversões.
    - **NVD (Non-Volatile Variables)**: Suporte para variáveis não voláteis.
    - **Text Blocks**: Foi adicionado mais dois caracteres `\ ` e `\s`.
      - `\ `: ignora quebra de linha e é utilizado apenas no final da linha
      - `\s`: utilizado para indicar espaço ao final da linha
    - **NullPointerException**: Introdução de melhorias para diagnosticar e relatar exceções `NullPointerException`, com mensagens mais detalhadas sobre o que causou a exceção, melhorando a depuração.
      - **Exemplo**: Mensagens detalhadas de `NullPointerException` ajudam a identificar a causa do problema, como:
        ```java
        String str = null;
        // Acessar métodos em str causará NullPointerException com uma mensagem mais descritiva
        str.length(); // Mensagem: "Cannot invoke 'length()' because 'str' is null"
        ```

## Java 15

- **Data de Lançamento**: Setembro de 2020
- **Principais Features**:
    - **Text Blocks**: Torna-se um recurso padrão.
    - **Sealed Classes**: Permite controlar quais classes podem estender uma classe ou implementar uma interface.
    - **Hidden Classes**: Suporte para classes ocultas usadas por frameworks e bibliotecas.

## Java 16

- **Data de Lançamento**: Março de 2021
- **Principais Features**:
    - **JEP 394: Pattern Matching for instanceof**: Adoção do pattern matching para `instanceof`.
    - **JEP 395: Records**: Os records tornam-se uma feature padrão.
    - **JEP 396: ZGC (Z Garbage Collector)**: Introduz o suporte para o ZGC no modo de produção.
    - **Classes Baseadas em Valor (Preview)**: Introdução de classes baseadas em valor (também conhecidas como "value classes") como uma funcionalidade preview, oferecendo uma maneira mais eficiente e semântica para definir classes que representam um conjunto de dados. Essas classes são imutáveis e comparáveis por valor.
      - **Exemplo**:
        ```java
        Integer i = new Integer(5); // deprecated
        Double d = 2.1;
        ```

## Java 17

- **Data de Lançamento**: Setembro de 2021
- **Principais Features**:
    - **Sealed Classes**:  A funcionalidade que foi introduzida como preview no Java 15 e aprimorada no Java 16, torna-se uma característica padrão no Java 17.
    - **Pattern Matching for switch (Preview)**: Melhora a sintaxe do switch.
    - **JEP 389: Foreign Function & Memory API (Incubator)**: Introduz APIs para interagir com código nativo e memória fora do heap.
    - **JEP 411: Depreciação da API de `Security Manager`**: Marca a API `Security Manager` como obsoleta e recomenda o uso de alternativas para controle de segurança em Java, refletindo mudanças na abordagem de segurança.

---

Para mais detalhes sobre cada versão e suas mudanças, consulte a [documentação oficial do Java](https://www.java.com/releases/).
