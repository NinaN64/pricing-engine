package pl.ninan.pricing.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public record ShoppingCart(Customer customer, List<CartItem> items) {

    public ShoppingCart {
        Objects.requireNonNull(customer, "Customer must not be null");
        items = List.copyOf(items);
    }

    public BigDecimal subtotal() {
        BigDecimal sum = BigDecimal.ZERO;
        for (CartItem item : items) {
            sum = sum.add(item.lineTotal());
        }
        return sum;
    }
}