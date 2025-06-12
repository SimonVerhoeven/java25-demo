package dev.simonverhoeven.java25demo.finalized.core.scopedvalues;

// JEP 506 - Scoped Values

public class Scoper {
    public final static ScopedValue<String> NAME = ScopedValue.newInstance();

    public static void main() {
        ScopedValue.where(NAME, "Continuum Consulting NV").run(() -> Greeter.greet());
        ScopedValue.where(NAME, "BEJUG").run(() -> Greeter.greet());
    }

}
