import java.util.*;

class Solution {
    class Song {
        int index;
        String genre;
        int plays;

        Song(int index, String genre, int plays) {
            this.index = index;
            this.genre = genre;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        List<Song> songList = new ArrayList<>();

        for(int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            songList.add(new Song(i, genres[i], plays[i]));
        }

        songList.sort((a, b) -> {
            if (!genrePlayCount.get(a.genre).equals(genrePlayCount.get(b.genre))) {
                return genrePlayCount.get(b.genre) - genrePlayCount.get(a.genre);
            } else if (a.plays != b.plays) {
                return b.plays - a.plays;
            } else {
                return a.index - b.index;
            }
        });

        Map<String, Integer> genreCount = new HashMap<>();
        List<Integer> bestAlbum = new ArrayList<>();

        for (Song song : songList) {
            genreCount.put(song.genre, genreCount.getOrDefault(song.genre, 0) + 1);
            if (genreCount.get(song.genre) <= 2) {
                bestAlbum.add(song.index);
            }
        }

        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }
}
