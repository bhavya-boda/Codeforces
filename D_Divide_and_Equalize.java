import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
public class D_Divide_and_Equalize {
    
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
        while (t-- != 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
            }
            Map<Integer, Integer> check = new HashMap<>();
            for(int i=0;i<n;i++) {
                int count = 0;
                while(a[i] % 2 == 0) {
                    count++;
                    a[i] /= 2;
                }
                if (count > 0) {
                    check.put(2, check.getOrDefault(2, 0)+count);
                }
                for (int j = 3; j <= Math.sqrt(a[i]); j += 2) {
                    count = 0;
                    while (a[i] % j == 0) {
                        count++;
                        a[i] /= j;
                    }
                    if (count > 0) {
                        check.put(j, check.getOrDefault(j, 0)+count);
                    }
                }
                if (a[i] > 2) {
                    check.put(a[i], check.getOrDefault(a[i], 0)+1);
                }
            }
            boolean flag = true;
            for(int i : check.keySet()) {
                if(check.get(i) %  n != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag)
            ha();
            else 
            na();
        }
        out.flush();
    }
}
