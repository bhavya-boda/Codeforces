import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class C_Game_with_Multiset{

    
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

    public static long decimalToBinary(long decimal) {
        if (decimal == 0) {
            return 0;
        }
        long binary = 0;
        long place = 1;
        while (decimal > 0) {
            long remainder = decimal % 2;
            binary += remainder * place;
            place *= 10;
            decimal = decimal / 2;
        }
        return binary;
    }


    public static void ha() {
        System.out.println("YES");
    }

    public static void na() {
        System.out.println("NO");
    }

    public static void line() {
        System.out.println();
    }

    public static int mod = 1000000007;


    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        int[] a = new int[30];
        while (t-- != 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x == 1) {
                a[y]++;
            }
            else {
                for(int i=29;i>=0;i--) {
                    int check = y/ (int)Math.pow(2, i);
                    y -= (int)Math.pow(2, i)*Math.min(check, a[i]);
                }
                if(y == 0)
                ha();
                else 
                na();
            }
        }
        out.flush();
    }
}