import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class A_Jellyfish_and_Game{

    
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
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            int maxa = 0, mina = Integer.MAX_VALUE, minb = Integer.MAX_VALUE, maxb = 0;
            long suma = 0, sumb = 0;
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
                if(a[i] > maxa) 
                maxa = a[i];
                if(a[i] < mina)
                mina = a[i];
                suma += a[i];
            }

            for(int i=0;i<m;i++) {
                b[i] = sc.nextInt();
                if(b[i] > maxb)
                maxb = b[i];
                if(b[i] < minb)
                minb = b[i];
                sumb += b[i];
            }

            if(mina >= maxb) {
                if(k % 2 == 0) {
                    System.out.println(suma-maxa+minb);
                }
                else {
                    System.out.println(suma);
                }
            }
            else if(k % 2 == 1) {
                System.out.println(suma-mina+maxb);
            }
            else if(k % 2 == 0) {
                System.out.println(suma-mina+maxb-Math.max(maxa, maxb)+Math.min(mina, minb));
            }
        }
        out.flush();
    }
}