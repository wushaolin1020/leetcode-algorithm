package com.wsl.leetcode.algorithm;

/**
 * 实现 Trie (前缀树)
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ImplementTriePrefixTreeAlgorithm {
	
	/**
	 * 根节点
	 */
	private TrieNode root;
	
	/** Initialize your data structure here. */
	public ImplementTriePrefixTreeAlgorithm() {
		root = new TrieNode();
	}
	
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
				node.put(ch, new TrieNode());
            }
	        node = node.get(ch);
        }
        node.setEnd();
    }
	
	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = searchNode(word);
		return node != null && node.isEnd();
	}
	
	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode node = searchNode(prefix);
		return node != null;
	}
	
	/**
	 * 根据字符串前缀搜索节点
	 * @param prefix 字符串前缀
	 * @return
	 */
	private TrieNode searchNode(String prefix) {
		TrieNode node = root;
		for (char ch : prefix.toCharArray()) {
			if (node.containsKey(ch)) {
				node = node.get(ch);
			}else {
				return null;
			}
		}
		return node;
	}
	
	/**
	 * Trie（前缀树/字典树）
	 *
	 * 1，根节点不包含字符，除根节点意外每个节点只包含一个字符。
	 *
	 * 2，从根节点到某一个节点，路径上经过的字符连接起来，为该节点对应的字符串。
	 *
	 * 3，每个节点的所有子节点包含的字符串不相同。
	 */
	public static class TrieNode {
		
		/**
		 * 子节点
		 */
		private TrieNode[] children;
		/**
		 * 长度，小写字母只有26个
		 */
		private final int size = 26;
		/**
		 * 是否最后一个字符
		 */
		private boolean end;
		
		public TrieNode() {
			children = new TrieNode[size];
		}
		
		/**
		 * 判断是否包含字符
		 * @param ch
		 * @return
		 */
		public boolean containsKey(char ch) {
			return children[ch - 'a'] != null;
		}
		
		/**
		 * 新增字符节点
		 * @param ch
		 * @param node
		 */
		public void put(char ch, TrieNode node) {
			children[ch - 'a'] = node;
		}
		
		/**
		 * 获取字符节点
		 * @param ch
		 * @return
		 */
		public TrieNode get(char ch) {
			return children[ch - 'a'];
		}
		
		public boolean isEnd() {
			return end;
		}
		
		public void setEnd() {
			this.end = true;
		}
		
	}
	
	public static void main(String[] args) {
		ImplementTriePrefixTreeAlgorithm algorithm = new ImplementTriePrefixTreeAlgorithm();
		algorithm.insert("apple");
		System.out.println(algorithm.search("apple"));
		System.out.println(algorithm.startsWith("app"));
	}

}
