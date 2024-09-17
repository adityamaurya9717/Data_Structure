package commonQuestions;

public class GCD {

    public static void main(String[] args) {
        int a=48;
        int b=12;
        //int lcm = lcm(a,b);
       // System.out.println(lcm);

        int result = gcd(a,b);
        System.out.println(result);

    }
     // Find out the GCD of a Number  using Euclidean Algorithm  (recursive)
    public static int gcd(int a, int b) {
        if( b==0){
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }
    // Find out the LCM of a Number
    public static int lcm(int a, int b) {
        return (a*b)/gcd(a,b);
    }
}
