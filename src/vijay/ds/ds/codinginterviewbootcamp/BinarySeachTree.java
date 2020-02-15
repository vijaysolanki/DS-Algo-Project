package vijay.ds.ds.codinginterviewbootcamp;

public class BinarySeachTree {
  
}

class BSTNode
{

  Integer data ;
  BSTNode left;
  BSTNode right;
  
  public BSTNode(int data) {
    this.data = data;
    left=right= null;
  }
  
 /* public void insertHelper(int data)
  {
    insert(this,data);
  }
  public BSTNode insert(BSTNode root, int data)
  {
    if(null == root)
    {
      BSTNode newNode = new BSTNode(data);
      root = newNode;
      return root;
    }
    
    if(data < root.data )
    {
      return root.left = insert(root.left, data);
    }
    else 
    {
      return root.right = insert(root.right, data);
    }
  }*/
  

  public BSTNode contains(int data)
  {
    if(this.data == data)
    {
      return this;
    }
    
    if(data < this.data && null != this.left)
    {
      return this.left.contains(data);
    }
    else if(data > this.data && null != this.right)
    {
      return this.right.contains(data);
    }
    
    return null;
  }
  
  public void insert(int data)
  {
    if(data < this.data && null != this.left)
    {
      this.left.insert(data);
    }
    else if(data< this.data)
    {
      this.left = new BSTNode(data);
    }
    else if(data > this.data && null != this.right)
    {
      this.right.insert(data);
    }
    else if(data > this.data)
    {
      this.right = new BSTNode(data);
    }
  }
  
}

