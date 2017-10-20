
public class BSTree {
	
	private BSTNode root;
	private String stringInOrder;
	private String stringPreOrder;
	
	public BSTree(){
		this.root = null;
	}
	
	class BSTNode {
		private String data;
		private BSTNode left;
		private BSTNode right;
		
		public BSTNode(String string) {
			this.data = string;			
		}
	}

	public void insert(String string) {
		// TODO Auto-generated method stub
		root = insert(string, root);
	}

	private BSTNode insert(String string, BSTNode node) {
		// TODO Auto-generated method stub
		if(node == null){
			node = new BSTNode(string);
			return node;
		}
		if(node.data.compareTo(string) <= 0){
			node.left = insert(string, node.left);
		}
		else if(node.data.compareTo(string) > 0){
			node.right = insert(string, node.right);
		}
		return node;
	}

	public boolean find(String string) {
		// TODO Auto-generated method stub
		return find(string, root);
	}

	private boolean find(String string, BSTNode node) {
		// TODO Auto-generated method stub
		if(node == null)
			return false;
		if(node.data.compareTo(string) == 0)
			return true;
		else if(node.data.compareTo(string) < 0)
			return find(string, node.left);
		else
			return find(string, node.right);
	}

	public void delete(String string) {
		// TODO Auto-generated method stub
		root = delete(string, root);
	}

	private BSTNode delete(String string, BSTNode node) {
		// TODO Auto-generated method stub
		if(node == null)
			return null;
		if(node.data.compareTo(string) == 0){
			if(node.left == null)
				return node.right;
			else if(node.right == null)
				return node.left;
			else{
				if(node.right.left == null){
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				}
				else{
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		}
		else if(string.compareTo(node.data) < 0)
			node.left = delete(string, node.left);
		else if(string.compareTo(node.data) > 0)
			node.right = delete(string, node.right);
		return node;
	}

	private String removeSmallest(BSTNode node) {
		// TODO Auto-generated method stub
		if(node.left.left == null){
			String smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		else{
			return removeSmallest(node.left);
		}
	}

	public Object toStringInOrder() {
		// TODO Auto-generated method stub 
		stringInOrder = "";
		inOrder(root);
		return stringInOrder.substring(0, stringInOrder.length()-1);
	}


	private void inOrder(BSTNode node) {
		// TODO Auto-generated method stub
		if(node != null){
			inOrder(node.right);
			stringInOrder = stringInOrder + node.data + " ";
			inOrder(node.left);
		}
	}

	public Object toStringPreOrder() {
		// TODO Auto-generated method stub
		stringPreOrder = "";
		preOrder(root);
		return stringPreOrder.substring(0, stringPreOrder.length()-1);
	}

	private void preOrder(BSTNode node) {
		// TODO Auto-generated method stub
		if(node != null){
			stringPreOrder = stringPreOrder + node.data + " ";
			preOrder(node.right);
			preOrder(node.left);
		}
	}
	
	

}
