import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_Matrix_of_Differences{

    
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
            int left = 1; 
            int right = n*n;
            int[][] a = new int[n][n];
            for(int i=0;i<n;i++) {
                if(i % 2 == 0) {
                    for(int j=0;j<n;j++) {
                        if((i+j) % 2 == 0) {
                            a[i][j] = right;
                            right--;
                        }
                        else{
                            a[i][j] = left;
                            left++;
                        }
                    }
                }
                else {
                    for(int j=n-1;j>=0;j--) {
                        if((i+j) % 2 == 0) {
                            a[i][j] = right--;
                        }
                        else
                        a[i][j] = left++;
                    }
                }
            }
            
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
        out.flush();
    }
}