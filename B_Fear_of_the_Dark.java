import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_Fear_of_the_Dark{

    
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
            int[] a = new int[2];
            int[] b = new int[2];
            int[] p = new int[2];
            p[0] = sc.nextInt();
            p[1] = sc.nextInt();
            a[0] = sc.nextInt();
            a[1] = sc.nextInt();
            b[0] = sc.nextInt();
            b[1] = sc.nextInt();
            double distAtoO = Math.sqrt(a[0] * a[0] + a[1] * a[1]);
		    double distAtoP = Math.sqrt((a[0] - p[0]) * (a[0] - p[0]) + (a[1] - p[1]) * (a[1] - p[1]));
		    double distBtoO = Math.sqrt(b[0] * b[0] + b[1] * b[1]);
		    double distBtoP = Math.sqrt((b[0] - p[0]) * (b[0] - p[0]) + (b[1] - p[1]) * (b[1] - p[1]));
		    double distAtoB = Math.sqrt((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
		    double half = distAtoB / 2;
		    if (distAtoO <= distBtoO && distAtoP <= distBtoP) {
		    	System.out.println(Math.max(distAtoO, distAtoP));
		    }
		    else if (distBtoO <= distAtoO && distBtoP <= distAtoP) {
		    	System.out.println(Math.max(distBtoO, distBtoP));
		    }
		    else if (distAtoO <= distBtoO && distAtoP >= distBtoP) {
		    	System.out.println(Math.max(Math.max(distBtoP, half), Math.max(distAtoO, half)));
		    }
		    else if (distAtoO >= distBtoO && distAtoP <= distBtoP) {
		    	System.out.println(Math.max(Math.max(distBtoO, half), Math.max(distAtoP, half)));
		    }
       }
        out.flush();
    }
}