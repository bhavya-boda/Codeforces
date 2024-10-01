import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
public class C_Have_Your_Cake_and_Eat_It_Too{

    
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
            long[] a = new long[n];
            long[] b = new long[n];
            long[] c = new long[n];
            long total = 0;
            for(int i=0;i<n;i++) {
                a[i] = sc.nextLong();
                total += a[i];
            }
            for(int i=0;i<n;i++) {
                b[i] = sc.nextLong();
            }
            for(int i=0;i<n;i++) {
                c[i] = sc.nextLong();
            }
            total = (long)(Math.ceil(total/3.0));
            long curr = 0;
            int la = 0, ra = 0 , lb = 0 , rb = 0, lc = 0, rc = 0;
            int flag = 0;
            for(int i=0;i<n;i++) {
                if(flag == 0) {
                    curr += a[i];
                    if(curr >= total) {
                        flag = 1;
                        curr = 0;
                        ra = i+1;
                    }
                }
                else if(flag == 1) {
                    curr += b[i];
                    if(curr >= total) {
                        flag = 3;
                        curr = 0;
                        rb = i+1;
                    }
                }
                else {
                    curr += c[i];
                    if(curr >= total) {
                        flag = 4;
                        break;
                    }
                }
            }
            if(flag == 4) {
                la = 1;
                lb = ra+1;
                lc = rb+1;
                rc = n;
                System.out.println(la + " " + ra + " " + lb + " " + rb + " " + lc + " " + rc);
                continue;
            }
            else {
                la = lb = lc = ra = rb = rc = flag = 0;
                curr = 0;
            }
            for(int i=0;i<n;i++) {
                if(flag == 0) {
                    curr += a[i];
                    if(curr >= total) {
                        flag = 1;
                        curr = 0;
                        ra = i+1;
                    }
                }
                else if(flag == 1) {
                    curr += c[i];
                    if(curr >= total) {
                        flag = 3;
                        curr = 0;
                        rc = i+1;
                    }
                }
                else {
                    curr += b[i];
                    if(curr >= total) {
                        flag = 4;
                        break;
                    }
                }
            }
            if(flag == 4) {
                la = 1;
                lc = ra+1;
                lb = rc+1;
                rb = n;
                System.out.println(la + " " + ra + " " + lb + " " + rb + " " + lc + " " + rc);
                continue;
            } 
            else {
                la = lb = lc = ra = rb = rc = flag = 0;
                curr = 0;
            }
            for(int i=0;i<n;i++) {
                if(flag == 0) {
                    curr += b[i];
                    if(curr >= total) {
                        flag = 1;
                        curr = 0;
                        rb = i+1;
                    }
                }
                else if(flag == 1) {
                    curr += a[i];
                    if(curr >= total) {
                        flag = 3;
                        curr = 0;
                        ra = i+1;
                    }
                }
                else {
                    curr += c[i];
                    if(curr >= total) {
                        flag = 4;
                        break;
                    }
                }
            }
            if(flag == 4) {
                la = rb+1;
                lc = ra+1;
                rc = n;
                lb = 1;
                System.out.println(la + " " + ra + " " + lb + " " + rb + " " + lc + " " + rc);
                continue;
            }
            else {
                la = lb = lc = ra = rb = rc = flag = 0;
                curr = 0;
            }
            for(int i=0;i<n;i++) {
                if(flag == 0) {
                    curr += b[i];
                    if(curr >= total) {
                        flag = 1;
                        curr = 0;
                        rb = i+1;
                    }
                }
                else if(flag == 1) {
                    curr += c[i];
                    if(curr >= total) {
                        flag = 3;
                        curr = 0;
                        rc = i+1;
                    }
                }
                else {
                    curr += a[i];
                    if(curr >= total) {
                        flag = 4;
                        break;
                    }
                }
            }
            if(flag == 4) {
                lc = rb+1;
                lb = 1;
                la = rc+1;
                ra = n;
                System.out.println(la + " " + ra + " " + lb + " " + rb + " " + lc + " " + rc);
                continue;
            }
            else {
                la = lb = lc = ra = rb = rc = flag = 0;
                curr = 0;
            }
            for(int i=0;i<n;i++) {
                if(flag == 0) {
                    curr += c[i];
                    if(curr >= total) {
                        flag = 1;
                        curr = 0;
                        rc = i+1;
                    }
                }
                else if(flag == 1) {
                    curr += a[i];
                    if(curr >= total) {
                        flag = 3;
                        curr = 0;
                        ra = i+1;
                    }
                }
                else {
                    curr += b[i];
                    if(curr >= total) {
                        flag = 4;
                        break;
                    }
                }
            }
            if(flag == 4) {
                lc = 1;
                la = rc+1;
                lb = ra+1;
                rb = n;
                System.out.println(la + " " + ra + " " + lb + " " + rb + " " + lc + " " + rc);
                continue;
            }
            else {
                la = lb = lc = ra = rb = rc = flag = 0;
                curr = 0;
            }
            for(int i=0;i<n;i++) {
                if(flag == 0) {
                    curr += c[i];
                    if(curr >= total) {
                        flag = 1;
                        curr = 0;
                        rc = i+1;
                    }
                }
                else if(flag == 1) {
                    curr += b[i];
                    if(curr >= total) {
                        flag = 3;
                        curr = 0;
                        rb = i+1;
                    }
                }
                else {
                    curr += a[i];
                    if(curr >= total) {
                        flag = 4;
                        break;
                    }
                }
            }
            if(flag == 4) {
                lc = 1;
                lb = rc+1;
                la = rb+1;
                ra = n;
                System.out.println(la + " " + ra + " " + lb + " " + rb + " " + lc + " " + rc);
                continue;
            }
            else {
                System.out.println(-1);
            }
        }
        out.flush();
    }
}
