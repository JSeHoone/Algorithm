class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            int index = 0;
            boolean isValid = true;

            for (char c : skillTree.toCharArray()) {
                String skillChar = String.valueOf(c);

                if (skill.contains(skillChar)) {
                    if (skill.charAt(index) == c) {
                        index++;
                    } else {
                        isValid = false;
                        break;
                    }
                }

            }

            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}