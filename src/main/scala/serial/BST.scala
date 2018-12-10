package serial

abstract class BSTNode[T <% Ordered[T]]{
    def left: BSTNode[T] = null
    def right: BSTNode[T] = null
    def insert(element: T): BSTNode[T]
}

class EmptyBSTNode[T <% Ordered[T]]() extends BSTNode[T]{
    def insert(value: T): BSTNode[T] = {
        new NonEmptyBSTNode(value)
    }
    override def toString = "{.}"
}

class NonEmptyBSTNode[T <% Ordered[T]](element: T, left: BSTNode[T], right: BSTNode[T]) extends BSTNode[T]{
    def this(element: T){
        this(element, new EmptyBSTNode(), new EmptyBSTNode())
    }

    def insert(value: T): BSTNode[T] = {
        if(element == value)
            this
        else if(element > value)
            new NonEmptyBSTNode(element, left insert value, right)
        else new NonEmptyBSTNode(element, left, right insert value)
            
    }

    override def toString = "{" + left + element + right + "}" 
}

class BinarySearchTree[T <% Ordered[T]]{
    val root = new EmptyBSTNode[T]()
    def insert(value : T) = root insert value
    override def toString = "" + root
}

/*
// CASE CLASS IMPLEMENTATION OF BINARY SEARCH TREE \_('_')_/
case class NonEmptyBSTNode[T <% Ordered[T]](element: T, left: BSTNode[T], right: BSTNode[T]) extends BSTNode[T]{
    override def toString = {
        "{" + left + element + right + "}"
    }
}

case class EmptyBSTNode[T <% Ordered[T]](left: BSTNode[T], right: BSTNode[T]) extends BSTNode[T]{
    override def toString = {
        "{.}"
    }
}

class BinarySearchTree[T <% Ordered[T]](root: BSTNode[T]){

    def this(){
        this(EmptyBSTNode[T](null,null))
    }
    
    def incl(element: T): BinarySearchTree[T] = {
        new BinarySearchTree(insert(root, element))

    }
    def insert(node: BSTNode[T], element: T): BSTNode[T] = node match{
        case EmptyBSTNode(_, _) => new NonEmptyBSTNode(element, new EmptyBSTNode(null, null), new EmptyBSTNode(null,null))
        case NonEmptyBSTNode(value, left, right) => 
            {
                if(value == element)
                    node
                else if(value > element)
                    new NonEmptyBSTNode(value, insert(node.left, element), node.right)
                else
                    new NonEmptyBSTNode(value, node.left, insert(node.right, element))
            }
    }

    override def toString = {
        "" + root
    }

    
}
*/

