import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_2_D_Traveling{

    
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
            int k = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            long[] x = new long[n];
            long[] y = new long[n];
            for(int i=0;i<n;i++) {
                x[i] = sc.nextLong();
                y[i] = sc.nextLong();
            }
            long check = Integer.MAX_VALUE;
            if(a <= k && b <= k) {
                System.out.println(0);
            }
            else if(a <= k) {
                check = Long.MAX_VALUE;
                for(int i=0;i<k;i++) {
                    check = Math.min(Math.abs(x[b-1]-x[i]) + Math.abs(y[b-1]-y[i]), check);
                }
                System.out.println(check);
            }
            else if(b <= k) {
                check = Long.MAX_VALUE;
                for(int i=0;i<k;i++) {
                    check = Math.min(Math.abs(x[a-1]-x[i]) + Math.abs(y[a-1]-y[i]), check);
                }
                System.out.println(check);
            }
            else {
                check = Math.abs(x[a-1]-x[b-1]) + Math.abs(y[a-1]-y[b-1]);
                long d1 = Long.MAX_VALUE, d2 = Long.MAX_VALUE;
                for(int i=0;i<k;i++) {
                    d1 = Math.min(d1, (Math.abs(x[a-1]-x[i]) + Math.abs(y[a-1]-y[i])));
                    d2 = Math.min(d2, (Math.abs(x[b-1]-x[i]) + Math.abs(y[b-1]-y[i])));
                }
                if(d1+d2 >= 0)
                check = Math.min(check, d1+d2);
                System.out.println(check);
            }
        } 
        out.flush();
    }
}