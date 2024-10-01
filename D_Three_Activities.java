import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class D_Three_Activities{

    
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
            long[][] a = new long[n][2];
            long[][] b = new long[n][2];
            long[][] c = new long[n][2];
            for(int i=0;i<n;i++) {
                a[i][0] = sc.nextLong();
                a[i][1] = i+1;
            }
            for(int i=0;i<n;i++) {
                b[i][0] = sc.nextLong();
                b[i][1] = i+1;
            }
            for(int i=0;i<n;i++) {
                c[i][0] = sc.nextLong();
                c[i][1] = i+1;
            }
            Arrays.sort(a, Comparator.comparingLong(arr -> arr[0]));
            Arrays.sort(b, Comparator.comparingLong(arr -> arr[0]));
            Arrays.sort(c, Comparator.comparingLong(arr -> arr[0]));
            long ans = 0;
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    for(int k=0;k<3;k++) {
                        if(a[n-i-1][1] != b[n-1-j][1] && b[n-1-j][1] != c[n-1-k][1] && a[n-1-i][1] != c[n-1-k][1])
                        ans = Math.max((a[n-i-1][0]+b[n-j-1][0]+c[n-k-1][0]) , ans);
                    }
                }
            }
            System.out.println(ans);
        }
        out.flush();
    }
}