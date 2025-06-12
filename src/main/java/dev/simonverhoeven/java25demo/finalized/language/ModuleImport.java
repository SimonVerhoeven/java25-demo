package dev.simonverhoeven.java25demo.finalized.language;

import module java.base;

import static java.lang.System.out;

/// JEP 511: Module Import Declarations

public class ModuleImport {

    public static void main(String[] args) {
        List<String> elements = List.of("One", "two", "THREE");
        elements.stream().map(String::toUpperCase).forEach(out::println);
    }
}
