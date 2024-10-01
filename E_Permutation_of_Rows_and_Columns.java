import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class E_Permutation_of_Rows_and_Columns{

    
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
            int m = sc.nextInt();
            int[][] a = new int[n][m];
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int[][] b = new int[n][m];
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    b[i][j] = sc.nextInt();
                }
            }
            
            TreeMap<Integer, Integer> check = new TreeMap<>();
            for(int i=0;i<m;i++) {
                check.put(b[0][i], i);
            }

            int flag = 1;
            int row = -1;
            for(int i=0;i<n;i++) {
                if(check.containsKey(a[i][0])) {
                    row = i;
                    flag = 0;
                    break;
                }
            }

            if(flag == 1) {
                flag = 0;
                System.out.println("NO");
                continue;
            }

            if(row != 0) {
                for(int i=0;i<m;i++) {
                    a[0][i] = (a[0][i] + a[row][i]) - (a[row][i] = a[0][i]);
                }
            }

            for(int i=0;i<m;i++) {
                if(!check.containsKey(a[0][i])) {
                    flag = 1;
                    break;
                }
                int column = check.get(a[0][i]);
                if(a[0][i] == b[0][i])
                continue;
                else {
                    for(int j=0;j<n;j++) {
                        a[j][i] = (a[j][i] + a[j][column]) - (a[j][column] = a[j][i]);
                    }
                    i--;
                }
            }

            if(flag == 1) {
                System.out.println("NO");
                continue;
            }

            check.clear();
            for(int i=0;i<n;i++) {
                check.put(b[i][0], i);
            }

            for(int i=0;i<n;i++) {
                if(!check.containsKey(a[i][0])) {
                    flag = 1;
                    break;
                }
                int rows = check.get(a[i][0]);
                if(a[i][0] == b[i][0])
                continue;
                else {
                    for(int j=0;j<m;j++) {
                        a[i][j] = (a[i][j] + a[rows][j]) - (a[rows][j] = a[i][j]);
                    }
                    i--;
                }
            }


            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(a[i][j] != b[i][j]) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1)
                break;
            }

            if(flag == 1)
            System.out.println("NO");
            else 
            System.out.println("YES");
        }
        out.flush();
    }
}