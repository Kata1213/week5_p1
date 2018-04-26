package practice3;

import java.math.BigDecimal;
import java.util.List;

public class PriceCaculator {
    private BigDecimal total;

    PriceCaculator() {
        this.total = new BigDecimal(0);
    }

    public void calculateLineItems(List<OrderLineItem> orderLineItemList){
        this.total = orderLineItemList.stream().map(OrderLineItem::getPrice).reduce(BigDecimal::add).get();
    }

    public void calculateDiscounts(List<BigDecimal> discounts) {
        this.total = this.total.subtract(discounts.stream().reduce(BigDecimal::add).get());
    }

    public void calculateTax(BigDecimal tax) {
        this.total = this.total.add(this.total.multiply(tax));
    }

    public BigDecimal getTotal() {
        return total;
    }
}
