package com.matrix.spring.day02.ioc.scope;

public class Student {

    private Integer sid;
    private String sname;

    public Student() {
        System.out.println("若只出现了一次，说明是singleton否则是prototype。因为构造方法只执行了一次 "); // 若出现了两次 说明是 prototype
    }

    public Student(Integer sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                '}';
    }
}
