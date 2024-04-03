import java.util.*;

class House {
    private double price;
    private double squareFootage;

    public House(double price, double squareFootage) {
        this.price = price;
        this.squareFootage = squareFootage;
    }

    public double getPrice() {
        return price;
    }

    public double getSquareFootage() {
        return squareFootage;
    }
}

public class HousingAnalyzer {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();
        houses.add(new House(150000.0, 1200.0));
        houses.add(new House(250000.0, 1800.0));
        houses.add(new House(180000.0, 1500.0));
        houses.add(new House(320000.0, 2000.0));
        houses.add(new House(200000.0, 1600.0));

        Map<String, Integer> housesByPriceRange = new HashMap<>();
        Map<String, Double> avgSquareFootageByPriceRange = new HashMap<>();

        // Initialize maps with price ranges
        housesByPriceRange.put("$100,000-200,000", 0);
        housesByPriceRange.put("$200,000-300,000", 0);
        housesByPriceRange.put("$300,000-400,000", 0);
        housesByPriceRange.put("$400,000-500,000", 0);
        housesByPriceRange.put("Above $500,000", 0);

        avgSquareFootageByPriceRange.put("$100,000-200,000", 0.0);
        avgSquareFootageByPriceRange.put("$200,000-300,000", 0.0);
        avgSquareFootageByPriceRange.put("$300,000-400,000", 0.0);
        avgSquareFootageByPriceRange.put("$400,000-500,000", 0.0);
        avgSquareFootageByPriceRange.put("Above $500,000", 0.0);

        // Process housing data
        for (House house : houses) {
            double price = house.getPrice();
            double squareFootage = house.getSquareFootage();

            if (price >= 100000 && price < 200000) {
                housesByPriceRange.put("$100,000-200,000", housesByPriceRange.get("$100,000-200,000") + 1);
                avgSquareFootageByPriceRange.put("$100,000-200,000",
                        avgSquareFootageByPriceRange.get("$100,000-200,000") + squareFootage);
            } else if (price >= 200000 && price < 300000) {
                housesByPriceRange.put("$200,000-300,000", housesByPriceRange.get("$200,000-300,000") + 1);
                avgSquareFootageByPriceRange.put("$200,000-300,000",
                        avgSquareFootageByPriceRange.get("$200,000-300,000") + squareFootage);
            } else if (price >= 300000 && price < 400000) {
                housesByPriceRange.put("$300,000-400,000", housesByPriceRange.get("$300,000-400,000") + 1);
                avgSquareFootageByPriceRange.put("$300,000-400,000",
                        avgSquareFootageByPriceRange.get("$300,000-400,000") + squareFootage);
            } else if (price >= 400000 && price < 500000) {
                housesByPriceRange.put("$400,000-500,000", housesByPriceRange.get("$400,000-500,000") + 1);
                avgSquareFootageByPriceRange.put("$400,000-500,000",
                        avgSquareFootageByPriceRange.get("$400,000-500,000") + squareFootage);
            } else {
                housesByPriceRange.put("Above $500,000", housesByPriceRange.get("Above $500,000") + 1);
                avgSquareFootageByPriceRange.put("Above $500,000",
                        avgSquareFootageByPriceRange.get("Above $500,000") + squareFootage);
            }
        }

        // Calculate average square footage
        for (String range : avgSquareFootageByPriceRange.keySet()) {
            double avgSquareFootage = avgSquareFootageByPriceRange.get(range) / housesByPriceRange.get(range);
            avgSquareFootageByPriceRange.put(range, avgSquareFootage);
        }

        // Print results
        for (String range : housesByPriceRange.keySet()) {
            System.out.println("Price Range: " + range);
            System.out.println("Number of Houses: " + housesByPriceRange.get(range));
            System.out.println("Average Square Footage: " + avgSquareFootageByPriceRange.get(range));
            System.out.println();
        }
    }
}
