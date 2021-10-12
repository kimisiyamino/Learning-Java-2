// code by eleonoralion
// 17.02.2021

/* Школьный этап всероссийской олимпиады, 9-11 классы, Москва (версия CF)
B. Наборы пирожных
https://codeforces.com/gym/102811/problem/B
*/

public class Main2{
    public static void main(String[] args) throws java.io.IOException{
        java.io.BufferedReader bf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int A = Integer.parseInt(bf.readLine());
        int B = Integer.parseInt(bf.readLine());
        long startTime = System.currentTimeMillis();

        if((A+B) % 3 != 0) {
            System.out.println(-1);
        }else{
            int aab = 0, bba = 0;
            do {
                if (A < B) { B -= 2; A -= 1; bba++; }
                else {       B -= 1; A -= 2; aab++; }
            }while(A != 0 && B != 0);
            if(A == 0 && B == 0)
                System.out.println(aab + " " + bba);
            else
                System.out.println(-1);
        }
        System.out.println(System.currentTimeMillis()-startTime);
    }
}