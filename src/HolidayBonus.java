/*
 * Class: CMSC203 
 * Instructor: Aygun
 * Description: The HolidayBonus class calculates holiday bonuses for employees based on their sales data.
 It includes methods to compute individual bonuses for each row (store) and the total bonus for all stores,
  using the sales data provided in a two-dimensional array.
 * Due: 11/18/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Leslie N. Guevara Amaya
*/
public class HolidayBonus {

    private static final double BONUS_PER_POSITIVE = 10.0;

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            double bonus = 0.0;
            for (double value : data[i]) {
                if (value > 0) {
                    bonus += BONUS_PER_POSITIVE;
                }
            }
            bonuses[i] = bonus;
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double totalBonus = 0.0;
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }
        return totalBonus;
    }
}
