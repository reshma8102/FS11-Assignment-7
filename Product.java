import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

public class SalesAnalyzer {
    public static void main(String[] args) {
        List<Product> sales = new ArrayList<>();
        sales.add(new Product("laptop", 30.0));
        sales.add(new Product("computer", 70.0));
        sales.add(new Product("Fan", 120.0));
        sales.add(new Product("TV", 90.0));
        sales.add(new Product("Fridge", 180.0));

        Map<String, Double> revenueByRange = new HashMap<>();
        revenueByRange.put("$0-50", 0.0);
        revenueByRange.put("$50-100", 0.0);
        revenueByRange.put("$100-200", 0.0);
        revenueByRange.put("Above $200", 0.0);

        for (Product product : sales) {
            double price = product.getPrice();
            if (price <= 50) {
                revenueByRange.put("$0-50", revenueByRange.get("$0-50") + price);
            } else if (price <= 100) {
                revenueByRange.put("$50-100", revenueByRange.get("$50-100") + price);
            } else if (price <= 200) {
                revenueByRange.put("$100-200", revenueByRange.get("$100-200") + price);
            } else {
                revenueByRange.put("Above $200", revenueByRange.get("Above $200") + price);
            }
        }

        for (Map.Entry<String, Double> entry : revenueByRange.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
