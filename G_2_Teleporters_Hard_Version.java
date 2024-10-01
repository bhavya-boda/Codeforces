import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class G_2_Teleporters_Hard_Version{

    
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
            long[] a = new long[n];
            long[] b = new long[n];
            long c = sc.nextInt();
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
                b[i] = a[i] + i + 1;
                a[i] = a[i] + Math.min(i+1, n-i);
            }
            long min = Integer.MAX_VALUE;
            long index = -1;
            int flag = 0;
            for(int i=0;i<n;i++) {
                if(flag == 1 && i >= (n+1)/2)
                break;
                if(b[i] < min) {
                    min = b[i];
                    index = i;
                }
                if(b[i] <= c) 
                flag = 1;
            }
            for(int i=0;i<n;i++) {
                if(i != index)
                b[i] = a[i];
                else 
                b[i] = Integer.MAX_VALUE;
            }
            long sum = 0;
            long count = 0;
            sum += min;
            if(sum <= c)
            count++;
            Arrays.sort(b);
            for(int i=0;i<n;i++) {
                sum += b[i];
                if(sum <= c)
                count++;
                else 
                break;
            }
            System.out.println(count);
        }
        out.flush();
    }
}