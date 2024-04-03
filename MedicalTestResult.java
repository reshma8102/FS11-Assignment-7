import java.util.*;

class MedicalTestResult {
    private String patientName;
    private double resultValue;

    public MedicalTestResult(String patientName, double resultValue) {
        this.patientName = patientName;
        this.resultValue = resultValue;
    }

    public double getResultValue() {
        return resultValue;
    }
}

public class MedicalTestAnalyzer {
    public static void main(String[] args) {
        List<MedicalTestResult> testResults = new ArrayList<>();
        testResults.add(new MedicalTestResult("Patient1", 80.0));
        testResults.add(new MedicalTestResult("Patient2", 95.0));
        testResults.add(new MedicalTestResult("Patient3", 120.0));
        testResults.add(new MedicalTestResult("Patient4", 60.0));
        testResults.add(new MedicalTestResult("Patient5", 110.0));

        Map<String, Integer> patientsByResultRange = new HashMap<>();
        Map<String, Double> avgValueByResultRange = new HashMap<>();

        // Initialize maps with result ranges
        patientsByResultRange.put("Normal", 0);
        patientsByResultRange.put("Borderline", 0);
        patientsByResultRange.put("High", 0);

        avgValueByResultRange.put("Normal", 0.0);
        avgValueByResultRange.put("Borderline", 0.0);
        avgValueByResultRange.put("High", 0.0);

        // Process medical test results
        for (MedicalTestResult result : testResults) {
            double value = result.getResultValue();
            if (value <= 100) {
                patientsByResultRange.put("Normal", patientsByResultRange.get("Normal") + 1);
                avgValueByResultRange.put("Normal", avgValueByResultRange.get("Normal") + value);
            } else if (value <= 150) {
                patientsByResultRange.put("Borderline", patientsByResultRange.get("Borderline") + 1);
                avgValueByResultRange.put("Borderline", avgValueByResultRange.get("Borderline") + value);
            } else {
                patientsByResultRange.put("High", patientsByResultRange.get("High") + 1);
                avgValueByResultRange.put("High", avgValueByResultRange.get("High") + value);
            }
        }

        // Calculate average value
        for (String range : avgValueByResultRange.keySet()) {
            double avgValue = avgValueByResultRange.get(range) / patientsByResultRange.get(range);
            avgValueByResultRange.put(range, avgValue);
        }

        // Print results
        for (String range : patientsByResultRange.keySet()) {
            System.out.println("Result Range: " + range);
            System.out.println("Number of Patients: " + patientsByResultRange.get(range));
            System.out.println("Average Value: " + avgValueByResultRange.get(range));
            System.out.println();
        }
    }
}
