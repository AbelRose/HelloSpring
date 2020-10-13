package com.matrix.spring.day02.ioc.beanlife;

public class Person {

    private Integer id;
    private String sex;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("生命周期Two: 依赖注入");
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("生命周期One: 创建对象");
    }

//    // 第四步是使用对象
//    @Override
//    public String toString() {
//        return "生命周期Four: 使用";
//    }


    @Override
    public String toString() {
        return  "生命周期Four: " + "Person{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void init() {
        System.out.println("生命周期Three: 初始化"); // 需要在xml里面指定配置 init-method="init"
    }

    public void destroy() {
        System.out.println("生命周期Five: 销毁"); // 需要在xml里面指定配置 destroy-method="destroy" 在关闭容器的时候销毁ac.close()
    }

}
