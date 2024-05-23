import java.util.HashMap;
import java.util.Map;

public interface tries_insertion_operation {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
    class Trie {
        private TrieNode root;
        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                curr.children.putIfAbsent(ch, new TrieNode());
                curr = curr.children.get(ch);
            }
            curr.isEndOfWord = true;
        }
        TrieNode getRoot() {
            return root;
        }
    }
    public class Main {
        public static void printWords(TrieNode node, String prefix) {
            if (node.isEndOfWord) {
                System.out.println(prefix);
            }

            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                printWords(entry.getValue(), prefix + entry.getKey());
            }
        }
        public static void main(String[] args) {
            Trie car = new Trie();
            // Inserting the elements
            car.insert("Lamborghini");
            car.insert("Mercedes-Benz");
            car.insert("Land Rover");
            car.insert("Maruti Suzuki");
            // Print the inserted objects
            System.out.print("Tries elements are: \n");
            printWords(car.getRoot(), ""); // Access root using the public method
        }
    }
}
