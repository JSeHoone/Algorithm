import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());

        for (int i = 1; i <= loop; i++) {

            try {
                String commands = br.readLine();
                int arraySize = Integer.parseInt(br.readLine());

                LinkedList<Integer> linkedList = new LinkedList<>(
                    Arrays.stream(br.readLine().replaceAll("[\\[\\]\\s]", "").split(","))
                          .filter(s -> !s.isEmpty())  // 빈 문자열 체크 (배열 크기 0일때)
                          .map(Integer::parseInt)
                          .collect(Collectors.toList())
                );

                boolean reverseCheck = false;

                for (char command : commands.toCharArray()) {
                    if (command == 'R') {
                        reverseCheck = !reverseCheck;  // toggle 방식으로 축약 가능
                    }

                    if (command == 'D') {
                        if (linkedList.isEmpty()) {
                            throw new Exception("Empty List");
                        }
                        if (reverseCheck) {
                            linkedList.removeLast();
                        } else {
                            linkedList.removeFirst();
                        }
                    }
                }

                if (reverseCheck) {
                    Collections.reverse(linkedList);
                }

                // 결과 출력 형식을 [] 형태로 맞추기
                System.out.println(linkedList.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(",", "[", "]"))
                );

            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }
}
