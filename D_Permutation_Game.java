import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class D_Permutation_Game{

    
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
            int b = sc.nextInt();
            int s = sc.nextInt();
            int[] p = new int[n+1];
            long[] a = new long[n+1];
            for(int i=1;i<=n;i++) {
                p[i] = sc.nextInt();
            }
            for(int i=1;i<=n;i++) {
                a[i] = sc.nextInt();
            }
            // for(int i=0;i<n+1;i++) {
            //     System.out.print(p[i] + " ");
            // }
            long bodya_score = 0;
            long sasha_score = 0;
            long sasha_current = 0;
            long bodya_current = 0;
            long bodya_max = 0;
            long sasha_max = 0;
            for(int i=0;i<Math.min(k, n);i++) {
                bodya_max = Math.max(bodya_max, a[b]);
                sasha_max = Math.max(sasha_max, a[s]);
                sasha_current += a[s];
                bodya_current += a[b];
                sasha_score = Math.max(sasha_score, (sasha_current + (k-i-1)*(sasha_max)));
                bodya_score = Math.max(bodya_score, (bodya_current + (k-i-1)*(bodya_max)));
                b = p[b];
                s = p[s];
            }
            if(sasha_score > bodya_score) 
            System.out.println("Sasha");
            else if(bodya_score > sasha_score) 
            System.out.println("Bodya");
            else 
            System.out.println("Draw");
        }
        out.flush();
    }
}