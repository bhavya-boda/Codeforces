import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_Vika_and_the_Bridge{

    
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
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
            }
            int[] exists = new int[k+1];
            int[] repeats = new int[k+1];
            for(int i=0;i<=k;i++) {
                exists[i] = 0;
                repeats[i] = 0;
            }
            TreeMap<Integer, Integer> check = new TreeMap<>();
            for(int i=0;i<n;i++) {
                if(!check.containsKey(a[i])) {
                    exists[a[i]] = i;
                }
                else {
                    if(i-check.get(a[i])-1 > exists[a[i]]) {
                        repeats[a[i]] = exists[a[i]];
                        exists[a[i]] = i-check.get(a[i])-1;
                    }
                    else if(i-check.get(a[i])-1 <= exists[a[i]] && i-check.get(a[i])-1 >= repeats[a[i]]) {
                        repeats[a[i]] = i-check.get(a[i])-1;
                    }
                }
                check.put(a[i], i);
            }

            for(int i : check.keySet()) {
                if(n-1-check.get(i) > exists[i]) {
                    repeats[i] = exists[i];
                    exists[i] = n-1-check.get(i);
                }
                else if(n-1-check.get(i) <= exists[i] && n-check.get(i)-1 >= repeats[i]) {
                    repeats[i] = n-check.get(i)-1;
                }
            }

            int ans = Integer.MAX_VALUE;
            for(int i : check.keySet()) {
                // System.out.println(exists[i] + " " + repeats[i] + " " + i);
                int num = Math.max(exists[i]/2, repeats[i]);
                ans = Math.min(ans , num);
            }
            System.out.println(ans);
        }
        out.flush();
    }
}