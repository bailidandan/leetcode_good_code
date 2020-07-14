package pa3;
import java.util.*;
import java.util.stream.Collectors;

/**员工
 * @author Yang
 * @create 2020-07-09 19:57
 */
class Employee {

    private String name;   // 姓
    private String city;   // 城市
    private Integer sales;  // 销售额

    public Employee(String name, String city, Integer sales) {
        this.name = name;
        this.city = city;
        this.sales = sales;
    }

    public Employee(String city, Integer sales) {
        this.city = city;
        this.sales = sales;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
    // getter(),setter() ....略

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", sales=" + sales +
                '}';
    }
}

public class test3 {
    public static void main(String[] args) {
        test3 t = new test3();
        t.getEmps();
        t.test5();
        System.out.println("-----------------------------------------------------");
        t.test3();
        System.out.println("-----------------------------------------------------");
        t.test4();
        System.out.println("-----------------------------------------------------");
        t.test6();
        System.out.println("-----------------------------------------------------");
        t.test7();
    }
    //-------------------生成测试数据---------------------
    private List<Employee> getEmps(){
        List<Employee> list = new ArrayList<>();
        Random rd = new Random();
        String[] citys = {"北京","上海","广州","杭州","深圳"};
        String[] firstName = {"张","李","杨","宁","刘","王","高","葛"};
        Integer[] sales = {100,50,30,20};

        for (int i = 0; i < 10; i++) {
            String city = citys[rd.nextInt(5)];
            Integer sale = sales[rd.nextInt(4)];
            String fname = firstName[rd.nextInt(firstName.length)];

            list.add(new Employee(fname,city,sale));
        }

        return list;
    }
    /**
     *  groupBy方法1，groupingBy(Function)
     *
     *  要求：先按city分组，每个分组里面是一个员工集合
     */
    public void test5(){
        List<Employee> emps = getEmps();

        Map<String, List<Employee>> map = emps.stream().collect(Collectors.groupingBy(Employee::getCity));

        map.forEach((key,val)->{
            System.out.println("城市："+key+" ---员工集： "+val);
        });
    }
    /**
     * 城市：广州 ---员工集： [Employee{name='1', city='广州', sales=100}, Employee{name='5', city='广州', sales=20}, Employee{name='6', city='广州', sales=30}, Employee{name='8', city='广州', sales=30}]
     * 城市：上海 ---员工集： [Employee{name='0', city='上海', sales=30}]
     * 城市：杭州 ---员工集： [Employee{name='2', city='杭州', sales=50}, Employee{name='7', city='杭州', sales=30}]
     * 城市：北京 ---员工集： [Employee{name='3', city='北京', sales=30}, Employee{name='4', city='北京', sales=50}, Employee{name='9', city='北京', sales=30}]
     */

    /**
     *  groupBy方法2，groupingBy(Function,Collector)
     *
     *  要求：先按city分组 ，再对组里面的成员，统计总销售额
     */
    public void test3(){
        List<Employee> emps = getEmps();
        for (Employee emp : emps) {
            System.out.println(emp);
        }

        Map<String, Integer> map = emps.stream().
                collect(Collectors.groupingBy(Employee::getCity, Collectors.summingInt(Employee::getSales)));
        //                                    先按city分组                                  再对组里面的成员，统计总销售额
        map.forEach((key,val)->{
            System.out.println("城市："+key+" 销售总额："+val);
        });
    }
    /**
     * Employee{name='0', city='上海', sales=50}
     * Employee{name='1', city='广州', sales=20}
     * Employee{name='2', city='广州', sales=30}
     * Employee{name='3', city='广州', sales=20}
     * Employee{name='4', city='杭州', sales=30}
     * Employee{name='5', city='杭州', sales=50}
     * Employee{name='6', city='北京', sales=50}
     * Employee{name='7', city='广州', sales=20}
     * Employee{name='8', city='杭州', sales=100}
     * Employee{name='9', city='广州', sales=30}
     * 城市：广州 销售总额：120
     * 城市：上海 销售总额：50
     * 城市：杭州 销售总额：180
     * 城市：北京 销售总额：50
     */
    /**
     * groupBy方法2，groupingBy(Function,Collector)
     *
     * 即：获取每个城市的姓氏集
     * 先按城市分组，再对每个组里面的员工姓名放入Set，得到每个城市的姓氏集
     */
    public void test4(){
        List<Employee> emps = getEmps();
        Map<String, Set<String>> map = emps.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getName, Collectors.toSet())));
        map.forEach((key,val)->{
            System.out.println(""+key+" ---人员姓名： "+val);
        });
    }
    /**
     * 上海 ---人员姓名： [葛]
     * 广州 ---人员姓名： [张, 刘, 王]
     * 杭州 ---人员姓名： [杨, 刘, 葛]
     */

    /**
     * groupBy方法2，groupingBy(Function,Collector)
     * 要求：每个城市中销售额最大的员工
     *      先按城市分组，在求分组里面销售额最大的员工
     */
    public void test6(){
        List<Employee> emps = getEmps();

        Map<String, Employee> map = emps.stream().collect(Collectors.groupingBy(Employee::getCity,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSales)), Optional::get)));

        map.forEach((key,val)->{
            System.out.println("城市："+key+" 销售额最大员工："+val);
        });
    }
    /**
     * Employee{name='杨', city='北京', sales=100}
     * Employee{name='杨', city='杭州', sales=20}
     * Employee{name='葛', city='深圳', sales=30}
     * Employee{name='张', city='上海', sales=50}
     * Employee{name='杨', city='广州', sales=50}
     * Employee{name='张', city='上海', sales=20}
     * Employee{name='张', city='上海', sales=50}
     * Employee{name='刘', city='北京', sales=50}
     * Employee{name='高', city='深圳', sales=100}
     * Employee{name='葛', city='深圳', sales=30}
     * 城市：广州 销售额最大员工：Employee{name='杨', city='广州', sales=50}
     * 城市：上海 销售额最大员工：Employee{name='张', city='上海', sales=50}
     * 城市：杭州 销售额最大员工：Employee{name='杨', city='杭州', sales=20}
     * 城市：深圳 销售额最大员工：Employee{name='高', city='深圳', sales=100}
     * 城市：北京 销售额最大员工：Employee{name='杨', city='北京', sales=100}
     */

    /**
     * 3个参数的方法：groupingBy(Function,Supplier,Collector)
     * 要求：要计算每个城市中人的姓氏集，并对城市名称进行排序
     * 先按城市分组，在对每个城市
     */
    public void test7(){
        List<Employee> emps = getEmps();
        TreeMap<String, Set<String>> map = emps.stream().collect(Collectors.groupingBy(Employee::getCity, TreeMap::new, Collectors.mapping(Employee::getName, Collectors.toSet())));
        map.forEach((key,val)->{
            System.out.println("城市："+key+" 姓氏集："+val);
        });
    }
    /**
     * 城市：上海 姓氏集：[刘]
     * 城市：北京 姓氏集：[宁, 李]
     * 城市：广州 姓氏集：[张, 高, 葛]
     * 城市：杭州 姓氏集：[张, 高, 葛]
     */

}
