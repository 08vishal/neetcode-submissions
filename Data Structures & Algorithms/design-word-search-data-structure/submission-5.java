class TrieNode {
    Map<Character, TrieNode> children;
    boolean word;

    public TrieNode() {
        children = new HashMap<>();
        word = false;
    } 
}
class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode node) {
        TrieNode curr = node;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode child : curr.children.values()) {
                    if (dfs(word, i+1, child)) return true;
                }
                return false;
            } else {
                if (!curr.children.containsKey(c)) return false;
                curr = curr.children.get(c);
            }
        }

        return curr.word;
    }
}
