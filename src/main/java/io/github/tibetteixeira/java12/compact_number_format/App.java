package io.github.tibetteixeira.java12.compact_number_format;

import java.text.CompactNumberFormat;
import java.text.NumberFormat;
import java.util.Locale;

import static java.text.NumberFormat.Style.*;
import static java.util.Locale.*;

public class App {

    public static void main(String[] args) {

        NumberFormat nfUKShort = CompactNumberFormat.getCompactNumberInstance(UK, SHORT);
        NumberFormat nfUKLong = CompactNumberFormat.getCompactNumberInstance(UK, LONG);
        NumberFormat nfItalyShort = CompactNumberFormat.getCompactNumberInstance(ITALY, SHORT);
        NumberFormat nfItalyLong = CompactNumberFormat.getCompactNumberInstance(ITALY, LONG);
        NumberFormat nfItalianShort = CompactNumberFormat.getCompactNumberInstance(ITALIAN, SHORT);
        NumberFormat nfItalianLong = CompactNumberFormat.getCompactNumberInstance(ITALIAN, LONG);
        NumberFormat nfBrasilShort = CompactNumberFormat.getCompactNumberInstance(new Locale("pt", "BR"), SHORT);
        NumberFormat nfBrasilLong = CompactNumberFormat.getCompactNumberInstance(new Locale("pt", "BR"), LONG);


        System.out.println("UKShort " + nfUKShort.format(500000));
        System.out.println("UKLong " + nfUKLong.format(500000));
        System.out.println("ItalyShort " + nfItalyShort.format(500000));
        System.out.println("ItalyLong " + nfItalyLong.format(500000));
        System.out.println("ItalianShort " + nfItalianShort.format(500000));
        System.out.println("ItalianLong " + nfItalianLong.format(500000));
        System.out.println("BrasilShort " + nfBrasilShort.format(500000));
        System.out.println("BrasilLong " + nfBrasilLong.format(500000));

    }
}
