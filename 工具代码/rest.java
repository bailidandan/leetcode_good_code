for (String key : map.keySet()) {
		type = map.get(key);
	}
	
	type = type.substring(0, i) + type.substring(i + 1, type.length());
	
	String content = "";
	String pattern = ".*@";
	Pattern r = Pattern.compile(pattern);
	Matcher m = r.matcher(content);
	while (m.find()) {
		S = S.replace(m.group(), "");
	}
	
	String content = "";
	String pattern = ".*@";
	Pattern r = Pattern.compile(pattern);
	Matcher m = r.matcher(S);
	if (m.find()) {
		content = m.group(0);
	}
