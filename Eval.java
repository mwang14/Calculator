


public class Eval {
    
    public static void main(String[] args) {
    }
    public double add(String s, String s2) {
        double num = Double.parseDouble(s);
        double num2 = Double.parseDouble(s2);
        return num + num2;
    }
    
    public double subtract(String s, String s2) {
        double num = Double.parseDouble(s);
        double num2 = Double.parseDouble(s2);
        return num - num2;
    }
    
    public double multiply(String s, String s2) {
        double num = Double.parseDouble(s);
        double num2 = Double.parseDouble(s2);
        return num * num2;
    }
    
    public double divide(String s, String s2) {
        double num = Double.parseDouble(s);
        double num2 = Double.parseDouble(s2);
        return num / num2;
    }
    
    public double exponent(String s, String s2) {
        double num = Double.parseDouble(s);
        double num2 = Double.parseDouble(s2);
        return Math.pow(num, num2);
    }
}