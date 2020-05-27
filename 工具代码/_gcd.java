private int gcd(int dy, int dx) {//求最大公约数，防止有没有约尽的数据
		if (dx == 0)
			return dy;
		else
			return gcd(dx, dy % dx);
	}
