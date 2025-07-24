class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);

        queue.add(beginWord);
        visited.add(beginWord);

        int count = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                String node = queue.remove();
                if (node.equals(endWord)) {
                    return count;
                }

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    for (int i = 0; i < node.length(); i++) {
                        String neighbour = node.substring(0, i) + ch + node.substring(i+1);
                        if (!visited.contains(neighbour) && wordSet.contains(neighbour)) {
                            queue.add(neighbour);
                            visited.add(neighbour);
                        }
                    } 
                }
            }
            ++count;
        }
        return 0;
    }
}