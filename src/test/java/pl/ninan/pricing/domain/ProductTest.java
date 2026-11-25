package pl.ninan.pricing.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProductTest {

    @Test
    void createsProductWithValidData() {
        Product product = new Product(UUID.randomUUID(), "Laptop", new BigDecimal("10.00"));

        assertThat(product.name()).isEqualTo("Laptop");
        assertThat(product.price()).isEqualByComparingTo("10.00");
    }

    @Test
    void allowsZeroPrice() {
        Product product = new Product(UUID.randomUUID(), "Gift", BigDecimal.ZERO);

        assertThat(product.price()).isEqualByComparingTo("0");
    }

    @Test
    void rejectsNegativePrice() {
        assertThatThrownBy(() -> new Product(UUID.randomUUID(), "Laptop", new BigDecimal("-1")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void rejectsNullName() {
        assertThatThrownBy(() -> new Product(UUID.randomUUID(), null, BigDecimal.TEN))
                .isInstanceOf(NullPointerException.class);
    }
}