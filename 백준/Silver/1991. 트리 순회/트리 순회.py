import sys
input = sys.stdin.readline

tree_dict = {}

n=int(input())
for i in range(n):
    root, left, right = input().split()
    tree_dict[root] = [left, right]

def preorder(root):
    if root != '.':
        print(root, end="")
        preorder(tree_dict[root][0])
        preorder(tree_dict[root][1])
def inorder(root):
    if root != '.':
        inorder(tree_dict[root][0])
        print(root, end="")
        inorder(tree_dict[root][1])
def postorder(root):
    if root != '.':
        postorder(tree_dict[root][0])
        postorder(tree_dict[root][1])
        print(root, end="")

preorder("A")
print()
inorder("A")
print()
postorder("A")
