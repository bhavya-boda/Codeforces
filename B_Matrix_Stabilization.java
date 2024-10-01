import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_Matrix_Stabilization{

    
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
            int m = sc.nextInt();
            int[][] a = new int[n][m];
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    int num = 0;
                    if(i > 0) 
                    num = Math.max(num, a[i-1][j]);
                    if(i < n-1)
                    num = Math.max(num, a[i+1][j]);
                    
                    if(j > 0) 
                    num = Math.max(num, a[i][j-1]);
                    if(j < m-1)
                    num = Math.max(num, a[i][j+1]);
                    a[i][j] = Math.min(a[i][j], num);
                }
            }
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
        out.flush();
    }
}