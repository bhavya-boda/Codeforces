import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class D_Rudolf_and_the_Ball_Game{

    
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
            long n = sc.nextInt();
            long m = sc.nextInt();
            long x = sc.nextInt();
            Set<Long> check1 = new TreeSet<>();
            Set<Long> check2 = new TreeSet<>();
            check1.add(x);
            for(long i=0;i<m;i++) {
                long r = sc.nextInt();
                char c = sc.next().charAt(0);
                if(check1.isEmpty()) {
                    if(c == '0') {
                        for(long j : check2) {
                            if(j+r <= n)
                            check1.add((j+r));
                            else 
                            check1.add((j+r-n));
                        }
                    }
                    else if(c == '1') {
                        for(long j : check2) {
                            if(j-r > 0)
                            check1.add(j-r);
                            else 
                            check1.add(j-r+n);
                        }
                    }
                    else {
                        for(long j : check2) {
                            if(j+r <= n)
                            check1.add((j+r));
                            else 
                            check1.add((j+r-n));
                        }
                        for(long j : check2) {
                            if(j-r > 0)
                            check1.add(j-r);
                            else 
                            check1.add(j-r+n);
                        }
                    }
                    check2.clear();
                }
                else {
                    if(c == '0') {
                        for(long j : check1) {
                            if(j+r <= n)
                            check2.add((j+r));
                            else 
                            check2.add((j+r-n));
                        }
                    }
                    else if(c == '1') {
                        for(long j : check1) {
                            if(j-r > 0)
                            check2.add(j-r);
                            else 
                            check2.add(j-r+n);
                        }
                    }
                    else {
                        for(long j : check1) {
                            if(j+r <= n)
                            check2.add((j+r));
                            else 
                            check2.add((j+r-n));
                        }
                        for(long j : check1) {
                            if(j-r > 0)
                            check2.add(j-r);
                            else 
                            check2.add(j-r+n);
                        }
                    }
                    check1.clear();
                }
            }
            if(check1.isEmpty()) {
                System.out.println(check2.size());
                for(long j : check2) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            else {
                System.out.println(check1.size());
                for(long j : check1) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
        out.flush();
    }
}