


public class Eval {
    
    public static void main(String[] args) {
        Eval e = new Eval();
        String s = new String("343434^4594^5");
        String s2 = new String("3^3^3");
        //System.out.println(s.indexOf('3'));
        System.out.println(e.evaluateSimple("2^2^2^2^2"));
        //System.out.println(e.isInteger(s2.charAt(3)));
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
    //Checks if a String is an integer versus an operation
    public boolean isInteger(char s) {
        return s == '1' ||
                s == '2' ||
                s == '3' ||
                s == '4' ||
                s == '5'||
                s == '6' ||
                s == '7' ||
                s == '8' ||
                s == '9' ||
                s == '0' ||
                s == '.';
                
    }
    //FINISH THIS
    public String evaluateSimple(String simple) {
        
        int exponent = simple.indexOf('^');
        int addition = simple.indexOf('+');
        int subtraction = simple.indexOf('-');
        int multiplication = simple.indexOf('*');
        int division = simple.indexOf('/');
        int place = 0;
        int place2 = simple.length();
        
       // System.out.println(simple);
        
        if (simple.contains("^")) {
            for (int i = exponent - 1; i >= 0; i--) {
                if (!isInteger(simple.charAt(i))) {
                    //place = simple.indexOf(simple.charAt(i)) + 1;
                    place = i;
                    
                }
            }
            for (int i = exponent + 1; i < simple.length(); i++) {
                if (!isInteger(simple.charAt(i))) {
                    //place2 = simple.indexOf(simple.charAt(i)) - 1;
                    place2 = i;
                    break;
                }
            }
        }
        else {
            return simple;
        }
        //System.out.println(isInteger(simple.charAt(3)));
        //System.out.println("Place: " + place + ". Exponent: " + exponent + ". Place 2: " + place2);
        
        String evaluated = Integer.toString((int)exponent(simple.substring(place, exponent), simple.substring(exponent+1, place2)));
        String newString = simple.substring(0, place) + evaluated + simple.substring(place2, simple.length());
        
       return evaluateSimple(newString);
        //return simple.substring(exponent+1, place2);
       // return Integer.toString(place2);
        //return Integer.toString((int)exponent(simple.substring(place, exponent),simple.substring(exponent+1, place2)));
        //return newString;
        
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