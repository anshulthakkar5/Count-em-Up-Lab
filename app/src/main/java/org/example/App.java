package org.example;

public class App {

    public static void main(String[] args) {

        // Create a GroceryCounter object
        GroceryCounter counter = new GroceryCounter();

        // Test increments
        counter.tens();        // +10.00
        counter.ones();        // +1.00
        counter.tenths();      // +0.10
        counter.hundredths();  // +0.01

        // Display total
        System.out.println("Total: " + counter.total());

        // Force overflow test
        for(int i = 0; i < 1000; i++) {
            counter.tens(); // eventually exceeds 9999
        }

        // Display overflow count
        System.out.println("Overflows: " + counter.overflows());

        // Clear counter
        counter.clear();
        System.out.println("After clear: " + counter.total());
    }
}
