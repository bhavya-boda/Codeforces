import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_Collecting_Game {

    
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
            int[][] a = new int[n][3];
            for(int i=0;i<n;i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = i+1;
            }
            long[] p = new long[n];
            Arrays.sort(a, Comparator.comparingInt(arr -> arr[0]));
            p[0] = a[0][0];
            for(int i=0;i<n;i++) {
                a[i][2] = i;
            }
            int k = 0;
            int i = 1;
            while(i < n && k < n) {
                while(p[k] >= a[i][0]) {
                    p[k] += a[i][0];
                    a[k][2]++;
                    i++;
                    if(i >= n)
                    break;
                }
                k++;
                if(k >= n)
                break;
                while(k < i) {
                    p[k] = p[k-1];
                    a[k][2] = a[k-1][2];
                    k++;
                    if(k >= n)
                    break;
                }
                if(i >= n || k >= n)
                break;
                p[k] = p[Math.max(k-1,0)] + a[i][0];
                i++;
                if(i >= n)
                break;
            }
            Arrays.sort(a, Comparator.comparingInt(arr -> arr[1]));
            for(i=0;i<n;i++) {
                System.out.print(a[i][2] + " ");
            }
            System.out.println();
        }
        out.flush();
    }
    
}