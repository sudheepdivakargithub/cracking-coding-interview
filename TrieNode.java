import java.util.HashMap;

class Solution {
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("Programming");
		trie.insert("is");
		trie.insert("a");
		trie.insert("way");
		trie.insert("of");
		trie.insert("life");
		
		System.out.println(trie.find("Programming"));
		
	}
		
}


class TrieNode {
	private HashMap<Character,TrieNode> children;
	private String content;
	private boolean isWord;
	
	public TrieNode() {
		children = new HashMap<>();
	}
	
	public void setEndOfWord(boolean isWord) {
		this.isWord = isWord;
	}
	
	public HashMap<Character,TrieNode> getChildren(){
		return this.children;
	}
	
	public boolean isEndOfWord() {
		return this.isWord;
	}
}

class Trie {
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode current = root;
		for(char l:word.toCharArray()) {
			current = current.getChildren().computeIfAbsent(l,c -> new TrieNode());
		}
		current.setEndOfWord(true);
	}
	
	public boolean find(String word) {
		TrieNode current = root;
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			TrieNode node = current.getChildren().get(ch);
			if(node == null) {
				return false;
			}
			current = node; 
		}
		return current.isEndOfWord();
	}
}