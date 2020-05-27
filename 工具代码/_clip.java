int[] a = new int[nums.length + 1];
	for (int i = 1; i < a.length; i++) {
		a[i] = a[i - 1] + nums[i - 1];
	}

	for (int i = 0; i < a.length; i++) {
		for (int j = i + 2; j < a.length; j++) {//片段至少取2个
			int temp = a[j] - a[i];
		}
	}
