if (s == null || s.equals("")) {
		return "";
	}
	int[][] a = new int[s.length()][s.length()];
	int iIdx = 0;
	int jIdx = 0;
	int max = 0;
	//pading
	for (int i = 0; i < a.length; i++) {
		a[i][i] = 1;
	}

	for (int k = 1; k < a.length; k++) {
		for (int i = 0; i < a.length - k; i++) {
			if (s.charAt(i) == s.charAt(i + k)) {//算当前
				//判断ij是相邻，还是间隔
				if (k > 1) {
					a[i][i + k] = (a[i + 1][i + k - 1] == 0 ? 0 : a[i + 1][i + k - 1] + 1);
				} else {
					a[i][i + k] = 2;
				}
				//判断表示符号
				if (a[i][i + k] > max) {
					iIdx = i;
					jIdx = i + k;
				}
			}

		}
	}
	return s.substring(iIdx, jIdx + 1);
