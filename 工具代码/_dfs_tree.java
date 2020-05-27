private void recurs(TreeNode root, String str) {
		if (root.left == null && root.right == null) {
			str += root.val;
			if (OK(str)) {
				max++;
			}
			return;
		}
		str += root.val;
		if (root.left != null)
			recurs(root.left, str);
		if (root.right != null)
			recurs(root.right, str);
	}
