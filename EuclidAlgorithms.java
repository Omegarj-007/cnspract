public class EuclidAlgorithms {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    static int extendedGCD(int a, int b, int[] xy) {
        if (b == 0) {
            xy[0] = 1;
            xy[1] = 0;
            return a;
        }
        int[] temp = new int[2];
        int gcd = extendedGCD(b, a % b, temp);
        xy[0] = temp[1];
        xy[1] = temp[0] - (a / b) * temp[1];
        return gcd;
    }
    public static void main(String[] args) {
        int a = 30, b = 20;
        int resultGCD = gcd(a, b);
        System.out.println("GCD of " + a + " and " + b + " is: " + resultGCD);
        int[] xy = new int[2]; 
        int gcd = extendedGCD(a, b, xy);
        System.out.println("Using Extended Euclid's Algorithm:");
        System.out.println("GCD: " + gcd + ", x: " + xy[0] + ", y: " + xy[1]);
    }
}
