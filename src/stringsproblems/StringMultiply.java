package stringsproblems;

public class StringMultiply {
    public String multiply(String n1, String n2) {
        if(n1 == "0" || n2 == "0") return "0";
        
        int n = n1.length();
        int m = n2.length();
        
        int[] res = new int[n+m];
        
        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                int mul = (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
                int sum = res[i+j+1] + mul;
                res[i+j+1] = sum % 10;
                res[i+j] += sum/10;
            } 
        }
        StringBuilder bs = new StringBuilder();
        
        for(int r = 0 ; r < res.length; r++) {
            if(bs.length() == 0 && res[r] == 0) continue;
            bs.append(res[r]);
        }
        
        return bs.length() != 0 ? bs.toString() : "0";
    }
}
