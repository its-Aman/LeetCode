carry = 0;
}
curr.next = new ListNode(add);
curr = curr.next;
l1 = l1.next;
}
​
while(l2 != null) {
int add = l2.val + carry;
if(add > 9) {
carry = 1;
add = add % 10;
} else {
carry = 0;
}
curr.next = new ListNode(add);
curr = curr.next;
l2 = l2.next;
}
if(carry != 0)
curr.next = new ListNode(carry);
return ans.next;
}
}