import java.util.*;

class EmployeeWorkHours {
    private String employeeName;
    private int[] dailyHours;

    public EmployeeWorkHours(String employeeName, int[] dailyHours) {
        this.employeeName = employeeName;
        this.dailyHours = dailyHours;
    }

    public int getTotalHours() {
        int total = 0;
        for (int hours : dailyHours) {
            total += hours;
        }
        return total;
    }
}

public class WorkHoursAnalyzer {
    public static void main(String[] args) {
        List<EmployeeWorkHours> workHoursList = new ArrayList<>();
        workHoursList.add(new EmployeeWorkHours("Employee1", new int[]{8, 8, 8, 8, 8}));
        workHoursList.add(new EmployeeWorkHours("Employee2", new int[]{7, 7, 8, 8, 8}));
        workHoursList.add(new EmployeeWorkHours("Employee3", new int[]{9, 9, 9, 9, 9}));
        workHoursList.add(new EmployeeWorkHours("Employee4", new int[]{6, 6, 7, 7, 7}));
        workHoursList.add(new EmployeeWorkHours("Employee5", new int[]{8, 8, 8, 9, 9}));

        int moreThan40Hours = 0;
        int exactly40Hours = 0;
        int lessThan40Hours = 0;

        Map<Integer, Integer> dailyHoursSum = new HashMap<>();

        for (EmployeeWorkHours employee : workHoursList) {
            int totalHours = employee.getTotalHours();
            if (totalHours > 40) {
                moreThan40Hours++;
            } else if (totalHours == 40) {
                exactly40Hours++;
            } else {
                lessThan40Hours++;
            }

            for (int hours : employee.dailyHours) {
                dailyHoursSum.put(hours, dailyHoursSum.getOrDefault(hours, 0) + 1);
            }
        }

        // Calculate average hours worked per day for each group
        Map<String, Double> avgHoursPerDay = new HashMap<>();
        for (int hours : dailyHoursSum.keySet()) {
            avgHoursPerDay.put("More than 40 hours", (double) dailyHoursSum.get(hours) / moreThan40Hours);
            avgHoursPerDay.put("Exactly 40 hours", (double) dailyHoursSum.get(hours) / exactly40Hours);
            avgHoursPerDay.put("Less than 40 hours", (double) dailyHoursSum.get(hours) / lessThan40Hours);
        }

        // Print results
        System.out.println("Employees who worked more than 40 hours: " + moreThan40Hours);
        System.out.println("Average hours worked per day for this group:");
        avgHoursPerDay.entrySet().stream().filter(entry -> entry.getKey().equals("More than 40 hours")).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println();

        System.out.println("Employees who worked exactly 40 hours: " + exactly40Hours);
        System.out.println("Average hours worked per day for this group:");
        avgHoursPerDay.entrySet().stream().filter(entry -> entry.getKey().equals("Exactly 40 hours")).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println();

        System.out.println("Employees who worked less than 40 hours: " + lessThan40Hours);
        System.out.println("Average hours worked per day for this group:");
        avgHoursPerDay.entrySet().stream().filter(entry -> entry.getKey().equals("Less than 40 hours")).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
