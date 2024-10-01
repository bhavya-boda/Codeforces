import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class D_Apple_Tree{

    
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

    public static long dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> edges, long[] ans) {
        visited[node] = true;

        int flag = 0;
        for(Integer it : edges.get(node)) {
            if(visited[it] == false) {
                flag = 1;
                ans[node] += dfs(it, visited, edges, ans);
            }
        }
        if(flag == 0) {
            ans[node] = 1;
            return 1;
        }
        else {
            return ans[node];
        }
    }


    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>(n+1);
            for(int i=0;i<n+1;i++) {
                edges.add(new ArrayList<>());
            }
            for(int i=0;i<n-1;i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                // System.out.println(a + " " + b);
                edges.get(a).add(b);
                edges.get(b).add(a);
            }
            int q = sc.nextInt();
            long[] ans = new long[n+1];
            boolean[] visited = new boolean[n+1];
            ans[1] = dfs(1, visited, edges, ans);
            for(int i=0;i<q;i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(ans[x]*ans[y]);
            }
        }
        out.flush();
    }
}