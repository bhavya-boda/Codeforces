import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_Sum_of_Two_Numbers{

    
    // Time complexity = O(sqrt(n))
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //GCD OF TWO NUMBERS
    public static long gcd(long a, long b){
        if(a == 0){
            return b;
        }

        return gcd(b % a, a);
    }

    //LCM OF TWO NUMBERS
    public static long LCM(int a, int b){
        return  ((long) a * b) / gcd(a, b);
    }

    //    FOR TAKING FASTER INPUTS
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static int decimalToBinary(int decimal) {
        if (decimal == 0) {
            return 0;
        }
        int binary = 0;
        int place = 1;
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary += remainder * place;
            place *= 10;
            decimal = decimal / 2;
        }
        return binary;
    }


    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s1 = "";
            String s2 = "";
            while(n != 0) {
                if(n % 2 != 0) {
                    if(s1.compareTo(s2) >= 0) {
                        s2 = String.valueOf((n%10)/2+1) + s2;
                        s1 = String.valueOf((n%10)/2) + s1;
                    }
                    else if(s1.compareTo(s2) < 0) {
                        s2 = String.valueOf((n%10)/2) + s2;
                        s1 = String.valueOf((n%10)/2+1) + s1;
                    }
                }
                else {
                    s2 = String.valueOf((n%10)/2) + s2;
                    s1 = String.valueOf((n%10)/2) + s1;
                }
                n /= 10;
            }
            while(s1.charAt(0) == '0' && s1.length() != 1) {
                s1 = s1.substring(1);
            }
            while(s2.charAt(0) == '0' && s2.length() != 1) {
                s2 = s2.substring(1);
            }
            System.out.println(s1 + " " + s2);
        }
        out.flush();
    }
}