package rezshak

type TreeNode struct {
	Val         int
	Left, Right *TreeNode
}

func NewTreeNode(val int) *TreeNode {
	return &TreeNode{
		Val: val,
	}
}

func NewTreeNodeWithChildren(val int, left, right *TreeNode) *TreeNode {
	return &TreeNode{
		Val:   val,
		Left:  left,
		Right: right,
	}
}
