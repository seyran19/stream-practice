package org.example.algs.original;

/// После того как оба вызова maxDepth() выполнены,
///  метод возвращает максимальное из двух значений глубины (leftDepth или rightDepth) плюс 1.
///  Это необходимо, потому что каждый уровень дерева добавляет 1 к общей глубине.
///
/// Рекурсия продолжается до тех пор, пока не будут достигнуты конечные узлы
///  (где root == null), после чего метод начнёт возвращаться вверх по стеку вызовов,
///  каждый раз добавляя 1 к максимальной глубине.
public class MaximumDepthOfBinaryTree {

    public int maxDepth(SumOfLeftLeaves.TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
