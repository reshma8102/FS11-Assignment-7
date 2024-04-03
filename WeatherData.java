import java.util.*;

class WeatherData {
    private double temperature;
    private double humidity;

    public WeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }
}

public class WeatherAnalyzer {
    public static void main(String[] args) {
        List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData(5.0, 60.0));
        weatherDataList.add(new WeatherData(15.0, 50.0));
        weatherDataList.add(new WeatherData(25.0, 70.0));
        weatherDataList.add(new WeatherData(-5.0, 80.0));
        weatherDataList.add(new WeatherData(10.0, 45.0));

        Map<String, Integer> daysByTemperatureRange = new HashMap<>();
        Map<String, Double> avgHumidityByTemperatureRange = new HashMap<>();

        // Initialize maps with temperature ranges
        daysByTemperatureRange.put("<0°C", 0);
        daysByTemperatureRange.put("0-10°C", 0);
        daysByTemperatureRange.put("10-20°C", 0);
        daysByTemperatureRange.put(">20°C", 0);

        avgHumidityByTemperatureRange.put("<0°C", 0.0);
        avgHumidityByTemperatureRange.put("0-10°C", 0.0);
        avgHumidityByTemperatureRange.put("10-20°C", 0.0);
        avgHumidityByTemperatureRange.put(">20°C", 0.0);

        // Process weather data
        for (WeatherData data : weatherDataList) {
            double temperature = data.getTemperature();
            double humidity = data.getHumidity();

            if (temperature < 0) {
                daysByTemperatureRange.put("<0°C", daysByTemperatureRange.get("<0°C") + 1);
                avgHumidityByTemperatureRange.put("<0°C", avgHumidityByTemperatureRange.get("<0°C") + humidity);
            } else if (temperature >= 0 && temperature <= 10) {
                daysByTemperatureRange.put("0-10°C", daysByTemperatureRange.get("0-10°C") + 1);
                avgHumidityByTemperatureRange.put("0-10°C", avgHumidityByTemperatureRange.get("0-10°C") + humidity);
            } else if (temperature > 10 && temperature <= 20) {
                daysByTemperatureRange.put("10-20°C", daysByTemperatureRange.get("10-20°C") + 1);
                avgHumidityByTemperatureRange.put("10-20°C", avgHumidityByTemperatureRange.get("10-20°C") + humidity);
            } else {
                daysByTemperatureRange.put(">20°C", daysByTemperatureRange.get(">20°C") + 1);
                avgHumidityByTemperatureRange.put(">20°C", avgHumidityByTemperatureRange.get(">20°C") + humidity);
            }
        }

        // Calculate average humidity
        for (String range : avgHumidityByTemperatureRange.keySet()) {
            double avgHumidity = avgHumidityByTemperatureRange.get(range) / daysByTemperatureRange.get(range);
            avgHumidityByTemperatureRange.put(range, avgHumidity);
        }

        // Print results
        for (String range : daysByTemperatureRange.keySet()) {
            System.out.println("Temperature Range: " + range);
            System.out.println("Number of Days: " + daysByTemperatureRange.get(range));
            System.out.println("Average Humidity: " + avgHumidityByTemperatureRange.get(range));
            System.out.println();
        }
    }
}
