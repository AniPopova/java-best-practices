package methods.task;

import java.math.BigDecimal;

public class FoodOrderService {

    public void placeOrder(String itemName, BigDecimal itemPrice, int quantity,
                           String deliveryAddress, String specialInstructions,
                           boolean isExpressDelivery, boolean applyDiscount) {
        validateOrder(itemName, itemPrice, quantity, deliveryAddress, specialInstructions, isExpressDelivery, applyDiscount);
        BigDecimal totalAmount = calculateTotalPrice(itemPrice, quantity, isExpressDelivery, applyDiscount);
        initiatePayment(totalAmount);
        initiateProduction(itemName, quantity, deliveryAddress, specialInstructions, isExpressDelivery);
    }

    private void validateOrder(String itemName, BigDecimal itemPrice, int quantity,
                               String deliveryAddress, String specialInstructions,
                               boolean isExpressDelivery, boolean applyDiscount) {
        // implementation skipped for brevity
    }

    private BigDecimal calculateTotalPrice(BigDecimal itemPrice, int quantity, boolean isExpressDelivery, boolean applyDiscount) {
        // implementation skipped for brevity
        return BigDecimal.ONE;
    }

    private void initiatePayment(BigDecimal totalAmount) {
        // implementation skipped for brevity
    }

    private void initiateProduction(String itemName, int quantity,
                                    String deliveryAddress, String specialInstructions,
                                    boolean isExpressDelivery) {
        // implementation skipped for brevity
    }

    record FoodOrder(){

    }
}