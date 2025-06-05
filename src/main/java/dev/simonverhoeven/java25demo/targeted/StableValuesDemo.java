package dev.simonverhoeven.java25demo.targeted;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Supplier;

/// JEP-502: Stable Values (Preview)

public class StableValuesDemo {

    // We defer the initialization, it'll be initialized at-most once and is immutable.
    // This enables constant-folding.
    private final Supplier<Integer> meaningOfLife = StableValue.supplier(() -> 42);
    private final List<BigDecimal> numbers = StableValue.list(42, BigDecimal::valueOf);

    Integer getMeaningOfLife() {
        // The constant is computed on the first get invocation
        return meaningOfLife.get();
    }

    List<BigDecimal> getNumbers() {
        // the constant computation is deferred to the first .get(index) or similar.
        return numbers;
    }
}