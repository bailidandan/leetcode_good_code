String s = "bbbab";
	int[][] dp = new int[s.length()][s.length()];
	for (int i = 0; i < dp.length; i++) {
		dp[i][i] = 1;
	}
	for (int k = 1; k < dp.length; k++) {//(跨度1,2,3,4（拉锯值）
		for (int i = 0; i < dp.length - k; i++) {//起始点0,1,2,3,(逆方向相加，最大位置)
			if (s.charAt(i) == s.charAt(i + k)) {
				dp[i][i + k] = Math.max(Math.max(dp[i][i + k - 1], dp[i + 1][i + k]), dp[i + 1][i + k - 1] + 2);
			} else {
				dp[i][i + k] = Math.max(dp[i][i + k - 1], dp[i + 1][i + k]);
			}
		}
	}
	// for (int i = 0; i < dp.length; i++) {
	// 	for (int j = 0; j < dp.length; j++) {
	// 		System.out.print(dp[i][j]);
	// 	}
	// 	System.out.println();
	// }
	return dp[0][s.length() - 1];
