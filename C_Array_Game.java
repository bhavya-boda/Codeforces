import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class C_Array_Game{

    
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

    public static void navi() {
        System.out.println();
    }

    public static int mod = 1000000007;


    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- != 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long[] a = new long[(int)n];
            long min = Long.MAX_VALUE;
            for(int i=0;i<n;i++) {
                a[i] = sc.nextLong();
                min = Math.min(a[i], min);
            }
            if(k >= 3) {
                System.out.println(0);
            }
            else if(k == 1) {
                Arrays.sort(a);
                for(int i=1;i<n;i++) {
                    min = Math.min(min, a[i]-a[i-1]);
                }
                System.out.println(min);
            }
            else {
                boolean flag = false;
                Arrays.sort(a);
                for(int i=0;i<n-1;i++) {
                    for(int j=i+1;j<n;j++) {
                        long num = Math.abs(a[i]-a[j]);
                        min = Math.min(num, min);
                        int l = 0;
                        int r = (int)n-1;
                        int mid = l+(r-l)/2;
                        while(l <= r) {
                            mid = l+(r-l)/2;
                            if(a[mid] > num)
                            r = mid-1;
                            else if(a[mid] < num) {
                                l = mid+1;
                            }
                            else {
                                min = 0;
                                flag = true;
                                break;
                            }
                            min = Math.min(min, Math.abs(a[mid]-num));
                        }
                        min = Math.min(min, Math.abs(a[mid]-num));
                        if(flag)
                        break;
                    }
                    if(flag)
                    break;
                }
                System.out.println(min);
            }
        }
        out.flush();
    }
}