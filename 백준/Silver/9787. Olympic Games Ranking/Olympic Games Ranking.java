import java.io.*;
import java.util.*;

public class Main {
    static class NationsInfo {
        String name;
        int gold;
        int silver;
        int bronze;
        int totalMedal;

        NationsInfo (String name, int gold, int silver, int bronze, int totalMedal) {
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.totalMedal = totalMedal;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<NationsInfo> nationsList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] info = line.split("\\s+");
            if (info.length < 4) continue;

            int gold   = Integer.parseInt(info[1]);
            int silver = Integer.parseInt(info[2]);
            int bronze = Integer.parseInt(info[3]);
            int totalMedal = gold + silver + bronze;

            nationsList.add(new NationsInfo(info[0], gold, silver, bronze, totalMedal));
        }

        nationsList.sort(
                Comparator.comparingInt((NationsInfo s) -> s.gold).reversed()
                        .thenComparing(Comparator.comparingInt((NationsInfo s) -> s.silver).reversed())
                        .thenComparing(Comparator.comparingInt((NationsInfo s) -> s.bronze).reversed())
                        .thenComparing(s -> s.name) 
        );

        int rank = 1;
        for (int i = 0; i < nationsList.size(); i++) {
            if (i > 0) {
                NationsInfo prev = nationsList.get(i - 1);
                NationsInfo cur  = nationsList.get(i);
                boolean tie = (prev.gold == cur.gold &&
                        prev.silver == cur.silver &&
                        prev.bronze == cur.bronze);
                if (!tie) {
                    rank = i + 1;
                }
            }
            NationsInfo x = nationsList.get(i);
            System.out.println(rank + " " + x.name + " " + x.gold + " " + x.silver + " " + x.bronze + " " + x.totalMedal);
        }



    }


}
