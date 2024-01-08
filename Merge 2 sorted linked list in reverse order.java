class GfG
{
    Node mergeResult(Node node1, Node node2)
    {
	    Node head=null;
	    //pointers for traversing the linked lists
	    Node p1=node1,p2=node2;
	    while(p1!=null && p2!=null){
	        if(p1.data<p2.data){
	            Node n=new Node(p1.data);
	            n.next=head;
	            head=n;
	            p1=p1.next;
	        }
	        else{
	            Node n=new Node(p2.data);
	            n.next=head;
	            head=n;
	            p2=p2.next;
	        }
	    }
	    //if any elements are left in any linked list
	    while(p1!=null){
	        Node n=new Node(p1.data);
	        n.next=head;
	        head=n;
	        p1=p1.next;
	    }
	    while(p2!=null){
	        Node n=new Node(p2.data);
	        n.next=head;
	        head=n;
	        p2=p2.next;
	    }
	    return head;
    }
}
