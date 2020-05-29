package test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.*;

class User {
	
	private Integer id ;
	private String name ;
	private String sex;
	private Integer age;
	private String weight;
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setSex(String sex){
		this.sex= sex;
	}

	public String getSex(){
		return this.sex;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
	
	public void setAge(Integer age){
		this.age = age;
	}
	public Integer getAge(){
		return this.age;
	}
	
	public void setWeight(String weight){
		this.weight = weight;
	}

	public String getWeight(){
		return this.weight;
	}
}

public class test5 {
	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		List<User> list = new ArrayList<User>();

		// stream().forEach()遍历集合
		list.stream().forEach(user->{System.out.println(user.getId());});

		//分组
		Map<String, List<User>> groupBySex = userList.stream().collect(Collectors.groupingBy(User::getSex));
		//遍历分组
		for (Map.Entry<String, List<User>> entryUser : groupBySex.entrySet()) {
	    	String key = entryUser.getKey();
	    	List<User> entryUserList = entryUser.getValue();
		}

		// 多分组字段
		// 字段写入
		Function<User, List<Object>> compositeKey = f 
				-> Arrays.<Object>asList(f.getAge(), f.getSex(), f.getName());
		// 分组
		Map<Object, List<User>> map = userList.stream().collect(Collectors
				.groupingBy(compositeKey, Collectors.toList()));
		//遍历分组
		for (Map.Entry<Object, List<User>> entryUser : map.entrySet()) {
	 	    List<Object> key = (List<Object>) entryUser.getKey();
	  	    Integer age= (Integer) key.get(0);
	  	    String sex=  key.get(1).toString() ;
	  	    String name=  key.get(2).toString();
	   	    List<User> entryUserList = entryUser.getValue();
	 	}
	        
		//排序
		//根据字段排序
		userList = userList.sort(Comparator.comparing(User::getId));
		//多字段排序，根年龄、性别排序
		userList = userList.sort(Comparator.comparing(User::getAge).thenComparing(User::getSex));
		
		//某字段去重
		userList = userList.stream().map(x->x.getName()).distinct().collect(Collectors.toList());
		
		//过滤
		userList = userList.stream().filter(x->StringUtils.isNotEmpty(x.getName()))..collect(Collectors.toList());

		//求和
		int sumAge = userList.stream().mapToInt(User::getAge).sum();
		BigDecimal totalQuantity = userList.stream().map(User::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
		
		//最值
		//最小
		Integer minAge = userList.stream().map(User::getAge).min(Integer::compareTo).get();
		//最大
		Integer maxAge = userList.stream().map(User::getAge).max(Integer::compareTo).get();
		
		// 赋相同值
		userList.stream().forEach(a -> a.setAge(17));

		// foreach
		userList.forEach(s -> System.out.println(s.getId()));
		// lambda分页
			
		List<User> result = userList.stream().skip(pageSize * (pageIndex - 1))
				.limit(pageSize).collect(Collectors.toList());


	}
	
}
