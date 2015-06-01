
public class Parens {
    public static void main(String[] args) {
        
    }

    public int findFirstClosingParen(String s) {
        int place = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ')') {
                return place;
            }
            else {
                place = place + 1;
            }
        }
        return place;
    }
    
    public int findLastOpeningParen(String s) {
        
    }
}