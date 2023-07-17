/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	ans, sum := &ListNode{}, 0
	head := &ListNode{-1, ans}
	s1, s2, s3 := list.New(), list.New(), list.New()
	h1, h2 := l1, l2

	for h1 != nil || h2 != nil {

		if h1 != nil {
			s1.PushFront(h1.Val)
			h1 = h1.Next
		}

		if h2 != nil {
			s2.PushFront(h2.Val)
			h2 = h2.Next
		}
	}

	for s1.Len() != 0 && s2.Len() != 0 {
		x, y := s1.Front(), s2.Front()
		z := x.Value.(int) + y.Value.(int) + sum
		sum = int(z / 10)
		s3.PushFront(int(z % 10))
		s1.Remove(x)
		s2.Remove(y)
	}

	for s1.Len() != 0 {
		x := s1.Front()
		z := x.Value.(int) + sum
		sum = int(z / 10)
		s3.PushFront(int(z % 10))
		s1.Remove(x)
	}

	for s2.Len() != 0 {
		y := s2.Front()
		z := y.Value.(int) + sum
		sum = int(z / 10)
		s3.PushFront(int(z % 10))
		s2.Remove(y)
	}

	if sum > 0 {
		s3.PushFront(sum)
	}

	for s3.Len() != 0 {
		z := s3.Front()
		ans.Val = z.Value.(int)
		s3.Remove(z)

		if s3.Len() != 0 {
			ans.Next = &ListNode{}
			ans = ans.Next
		}
	}

	ans.Next = nil

	return head.Next
}