import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_Fibonaccharsis{

    
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


    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        int[] a = new int[200001];
        int[] b = new int[200001];
        a[1] = 1;
        a[2] = 0;
        b[1] = 0;
        b[2] = 1;
        for(int i=3;i<200001;i++) {
            a[i] = a[i-1]+a[i-2];
            b[i] = b[i-1]+b[i-2];
        }
        while (t-- > 0) {
            double n = sc.nextInt();
            int k = sc.nextInt();
            if(k >= 200001) {
                System.out.println(0);
                continue;
            }
            int count = 0;
            
            // System.out.println(b[k]);
            int check = (int)(n/b[k]);
            // System.out.println(a[k]);
            while(check >= 0) {
                double a_i = n-check*b[k];
                if(((int)(a_i/a[k]) == (a_i/a[k])) && a_i/a[k] <= check) {
                    count++;
                    // System.out.println(a_i);
                }
                if(a_i/a[k] > check) {
                    break;
                }
                // System.out.println(check + " " + a_i);
                check--;
            }
            System.out.println(count);
        }
        out.flush();
    }
}