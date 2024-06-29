# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        answer = ListNode(next = ListNode())
        node = answer.next

        if (list1 is None) and (list2 is None):
            return None

        list_ = []
        while True:
            if list1 is None:
                break
            list_.append(list1.val)
            if list1.next is None:
                break
            list1 = list1.next
        while True:
            if list2 is None:
                break
            list_.append(list2.val)
            if list2.next is None:
                break
            list2 = list2.next

        list_.sort()

        for index,data in enumerate(list_):
            if index == len(list_) -1 :
                node.val = data
                node.next = None
                break
            node.val = data
            node.next = ListNode(next = ListNode())
            node = node.next

        return answer.next
