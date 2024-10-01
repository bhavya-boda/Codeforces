/*
                वक्रतुण्ड महाकाय सूर्यकोटि समप्रभ।    
                निर्विघ्नं कुरु मे देव सर्वकार्येषु सर्वदा।     
*/

import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
public class D_Robert_Hood_and_Mrs_Hood{

        
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


    public static long pow(long x, long p) {
        x %= mod;
        long ans = 1;
        while (p > 0) {
            if (p % 2 == 1) ans = ans * x % mod;
            x = x * x % mod;
            p /= 2;
        }
        return ans;
    }

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int k = sc.nextInt();
            TreeMap<Integer, Integer> start = new TreeMap<>();
            TreeMap<Integer, Integer> end = new TreeMap<>();
            for(int i=0;i<k;i++) {
                int one = sc.nextInt();
                int two = sc.nextInt() + 1;
                start.put(one, start.getOrDefault(one, 0)+1);
                end.put(two, end.getOrDefault(two, 0)+1);
            }
            long curr = 0;
            for(int i=1;i<=d;i++) {
                curr += start.getOrDefault(i, 0);
            }
            long max = curr;
            long min = curr;
            int bro = 1;
            int mom = 1;
            for(int i=2;i<=n-d+1;i++) {
                curr -= end.getOrDefault(i, 0);
                curr += start.getOrDefault(i+d-1, 0);

                if(curr > max) {
                    max = curr;
                    bro = i;
                }

                if(curr < min) {
                    min = curr;
                    mom = i;
                }
            }
            System.out.println(bro + " " + mom);
        }
        out.flush();
    }
}

