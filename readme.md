## 个人的Leetcode刷题笔记

## 暴力搜索算法

### 链表题

一般使用双指针解法

[86 - partition list](./partition_list_86)



### 二叉树

1、是否可以通过遍历一遍二叉树得到答案？如果可以，用一个 traverse 函数配合外部变量来实现。

2、是否可以定义一个递归函数，通过子问题（子树）的答案推导出原问题的答案？如果可以，写出这个递归函数的定义，并充分利用这个函数的返回值。

3、无论使用哪一种思维模式，你都要明白二叉树的每一个节点需要做什么，需要在什么时候（前中后序）做。

（解题无非是遍历或者分解)

套路:
需要使用子树信息时使用后序遍历, 并且规划好返回值

[669 - trim a binary tree](./trim_a_binary_search_tree_669)
<br />
[124 - binary tree max path sum](./bt_max_path_sum_124)
<br />
[543 - diameter in binary search tree](./diameter_bst_543)
<br />
[669 - trim a binary search tree](./trim_a_binary_search_tree_669)


### BFS

[752 - open the lock](./open_the_lock_752)
<br />
[773 - sliding puzzle](./sliding_puzzle_773)
