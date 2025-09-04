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
        CountryMedal country1 = list.get(0);
        for (int i = 1; i < N; i++) {
            CountryMedal nextCountry = list.get(i);

            if (country1.gold == nextCountry.gold && country1.silver == nextCountry.silver && country1.bronze == nextCountry.bronze) {
                if (nextCountry.country == K) {
                    System.out.println(rank);
                    break;
                }
            } else {
                country1 = nextCountry;
                rank++;

            }

            if (nextCountry.country == K) {
                System.out.println(i+1);
                break;
            }
        }


    }


}
