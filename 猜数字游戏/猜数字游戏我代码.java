class Solution {
  public String getHint(String secret, String guess) {
		 int a=0,b=0;
		 for (int i = 0; i < guess.length(); i++) {
			char c = guess.charAt(i);
			if (c == secret.charAt(i)) {
				a++;
				guess = guess.substring(0,i)+guess.substring(i+1,guess.length());
				secret = secret.substring(0, i) + secret.substring(i + 1, secret.length());
                i--;
			} 
		 }

		 for (int i = 0; i < guess.length(); i++) {
			char c = guess.charAt(i);
			if (secret.contains(c+"")) {
				b++;
				guess = guess.substring(0,i)+guess.substring(i+1,guess.length());
				int k = secret.indexOf(c);
				secret = secret.substring(0, k) + secret.substring(k + 1, secret.length());
                i--;
			}
		}
		 return a+"A"+b+"B";
	 }
}
