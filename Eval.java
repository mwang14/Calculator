


public class Eval {
    
    public static void main(String[] args) {
    }
    //evaluates the whole expression
    public String evaluateExpression(String expression) {
        //current closing and opening paren indexes
        int close, open;
        //finds the first closing paren
        close = findFirstClosingParen(expression);
        //while there is a closing paren
        while(close != -1) {
            open = findOpeningParen(expression, close);
            //replaces the paren set with the evaluation of the paren set
            expression = expression.substring(0, open) +
                    evaluateSimple(expression.substring(open + 1, close))
                    + expression.substring(close + 1, expression.length());
            close = findFirstClosingParen(expression);
        }
        return evaluateSimple(expression);
    }
    //FINISH THIS
    private String evaluateSimple(String simple) {
        // TODO Auto-generated method stub
        return null;
    }
    public String removeSpaces(String expression) {
        //finds the index of space
        int spaceIndex = expression.indexOf(' ');
        while(spaceIndex != -1) {
            //gets rid of the space at that index
            expression = expression.substring(0, spaceIndex) + 
                    expression.substring(spaceIndex + 1, expression.length());
        }
        //returns the expression without spaces
        return expression;
    }
    public int findFirstClosingParen(String s) {
        //goes through string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //if it finds the closing paren it returns the index
            if (c == ')') {
                return i;
            }
        }
        //if a closing paren isn't found, it returns -1
        return -1;
    }
    
    public int findOpeningParen(String s, int close) {
        //goes through string starting from closing paren
        for(int i = close; i >= 0; i++) {
           char c = s.charAt(i);
           //returns the index if the character is found
           if(c == '(') {
               return i;
           }
        }
        //returns -1 if no opening paren is found
        return -1;
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