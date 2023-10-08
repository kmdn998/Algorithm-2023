import java.io.*;

public class Main {
	
	static class Node{
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
		}
		
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		
		}

	
		public void insert(int n){
			
            if(n < this.data){ 
            	
                if(this.left == null)
                    this.left  = new Node(n);
                
                else this.left.insert(n);
            } 
            else { 
            
                if(this.right == null)
                    this.right = new Node(n);
                
                else this.right.insert(n);
				}
			}
		}
	
	
		public static void postorder(Node node) {
			if (node != null)
			{
				postorder(node.left);
				postorder(node.right);
				System.out.println(node.data);
			}
		}
		public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Node rt = new Node(Integer.parseInt(br.readLine()));
			
			while (true) {
				String s = br.readLine();
				if ( s == null || s.equals("")) break;
				rt.insert(Integer.parseInt(s));
			}
			postorder(rt);
		
		}
	}


