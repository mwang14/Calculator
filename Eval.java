import javax.swing.SwingUtilities;




public class Eval {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gridlayout();
            }
        });
        
    }
    //evaluates the whole expression
    public String evaluateExpression(String expression) {
        //current closing and opening paren indexes
        expression = removeSpaces(expression);
        //System.out.println(expression);
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
                s == '5' ||
                s == '6' ||
                s == '7' ||
                s == '8' ||
                s == '9' ||
                s == '0' ||
                s == '.';
                
    }
    //Evaluate simple calculations within parenthesis
    public String evaluateSimple(String simple) {
        
        int exponent = simple.indexOf('^');
        int addition = simple.indexOf('+');
        int subtraction = simple.indexOf('-');
        int multiplication = simple.indexOf('*');
        int division = simple.indexOf('/');
        int place = 0;
        int place2 = simple.length();
        //evaluates exponents
    if (simple.contains("^")) {
            for (int i = exponent - 1; i >= 0; i--) {
                if (!isInteger(simple.charAt(i))) {
                    place = i + 1;
                    
                }
            }
            for (int i = exponent + 1; i < simple.length(); i++) {
                if (!isInteger(simple.charAt(i))) {
                    place2 = i;
                    break;
                }
            }
            String evaluated = Integer.toString((int)exponent(simple.substring(place, exponent), simple.substring(exponent+1, place2)));
            String newString = simple.substring(0, place) + evaluated + simple.substring(place2, simple.length());
            
           return evaluateSimple(newString);
            
        }
        //evaluates multiplication 
        else if (simple.contains("*")) {
            for (int i = multiplication - 1; i >= 0; i--) {
                if (!isInteger(simple.charAt(i))) {
                    place = i + 1;
                    break;
                }
            }
            for (int i = multiplication + 1; i < simple.length(); i++) {
                if (!isInteger(simple.charAt(i))) {
                    place2 = i;
                    break;
                }

            
        }
            String evaluated = Integer.toString((int)multiply(simple.substring(place, multiplication), simple.substring(multiplication+1, place2)));
            String newString = simple.substring(0, place) + evaluated + simple.substring(place2, simple.length());
            
           return evaluateSimple(newString);
        }
        //evaluates division
        else if (simple.contains("/")) {
            for (int i = division - 1; i >= 0; i--) {
                if (!isInteger(simple.charAt(i))) {
                    place = i + 1;
                    break;
                }
            }
            for (int i = division + 1; i < simple.length(); i++) {
                if (!isInteger(simple.charAt(i))) {
                    place2 = i;
                    break;
                }

            
        }
            String evaluated = Integer.toString((int)divide(simple.substring(place, division), simple.substring(division+1, place2)));
            String newString = simple.substring(0, place) + evaluated + simple.substring(place2, simple.length());
            
           return evaluateSimple(newString);
        }
    //Evaluates addition
        else if (simple.contains("+")) {
            for (int i = addition - 1; i >= 0; i--) {
                if (!isInteger(simple.charAt(i))) {
                    place = i + 1;
                    break;
                }
            }
            for (int i = addition + 1; i < simple.length(); i++) {
                if (!isInteger(simple.charAt(i))) {
                    place2 = i;
                    break;
                }

            
        }
            String evaluated = Integer.toString((int)add(simple.substring(place, addition), simple.substring(addition+1, place2)));
            String newString = simple.substring(0, place) + evaluated + simple.substring(place2, simple.length());
            
           return evaluateSimple(newString);
        }
    //Evaluates subtraction
        else if (simple.contains("-")) {
            for (int i = subtraction - 1; i >= 0; i--) {
                if (!isInteger(simple.charAt(i))) {
                    place = i;
                    break;
                }
            }
            for (int i = subtraction + 1; i < simple.length(); i++) {
                if (!isInteger(simple.charAt(i))) {
                    place2 = i;
                    break;
                }

            
        }
            String evaluated = Integer.toString((int)subtract(simple.substring(place, subtraction), simple.substring(subtraction+1, place2)));
            String newString = simple.substring(0, place) + evaluated + simple.substring(place2, simple.length());
            
           return evaluateSimple(newString);
           
        }
        else {
            return simple;
        }

        
    }
    public String removeSpaces(String expression) {
        //finds the index of space
        int spaceIndex = expression.indexOf(" ");
        while(spaceIndex != -1) {
            
            //gets rid of the space at that index
            //System.out.println(expression);
            expression = expression.substring(0, spaceIndex) + 
                    expression.substring(spaceIndex + 1);
            spaceIndex = expression.indexOf(" ");
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
        for(int i = close; i >= 0; i--) {
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