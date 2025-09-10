class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        Set<Integer>[] languageSets = new Set[m];
        for (int i = 0; i < m; i++) {
            languageSets[i] = new HashSet<>();
            for (int language : languages[i]) {
                languageSets[i].add(language);
            }
        }

        List<int[]> needToTeach = new ArrayList<>();
        for (int[] friendship : friendships) {
            int user1 = friendship[0] - 1;
            int user2 = friendship[1] - 1;
            boolean canCommunicate = false;
            for (int language : languageSets[user1]) {
                if (languageSets[user2].contains(language)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                needToTeach.add(friendship);
            }
        }

        int minUsersToTeach = Integer.MAX_VALUE;
        for (int languageToTeach = 1; languageToTeach <= n; languageToTeach++) {
            int usersToTeach = 0;
            Set<Integer> users = new HashSet<>();
            for (int[] friendship : needToTeach) {
                int user1 = friendship[0] - 1;
                int user2 = friendship[1] - 1;

                if (!languageSets[user1].contains(languageToTeach) && !users.contains(user1)) {
                    usersToTeach++;
                    users.add(user1);
                }
                if (!languageSets[user2].contains(languageToTeach) && !users.contains(user2)) {
                    usersToTeach++;
                    users.add(user2);
                }
            }
            minUsersToTeach = Math.min(minUsersToTeach, usersToTeach);
        }

        return minUsersToTeach;
    }
}