import java.io.*;
import java.util.*;

public class Main {
    static class CountryMedal {
        int country;
        int gold;
        int silver;
        int bronze;

        public CountryMedal(int country, int gold, int silver, int bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0], K = NK[1];

        List<CountryMedal> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] countryInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            CountryMedal country = new CountryMedal(countryInfo[0], countryInfo[1], countryInfo[2], countryInfo[3]);
            list.add(country);
        }

        list.sort(Comparator.comparingInt((CountryMedal c) -> c.gold).reversed()
                .thenComparing(Comparator.comparingInt((CountryMedal c) -> c.silver).reversed())
                .thenComparing(Comparator.comparingInt((CountryMedal c) -> c.bronze).reversed()));


        int rank = 1;

        for (int i = 0; i < N; i++) {
            if (i > 0) {
                CountryMedal prev = list.get(i - 1);
                CountryMedal cur  = list.get(i);
                boolean tie = (prev.gold == cur.gold &&
                        prev.silver == cur.silver &&
                        prev.bronze == cur.bronze);
                if (!tie) rank = i + 1; 
            }

            if (list.get(i).country == K) {
                System.out.println(rank);
                return;
            }
        }



    }


}
