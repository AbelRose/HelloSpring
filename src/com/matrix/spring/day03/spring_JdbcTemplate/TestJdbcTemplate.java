package com.matrix.spring.day03.spring_JdbcTemplate;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestJdbcTemplate {

    ApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
    JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);

    @Test
    public void testUpdate() {
        // TODO
        // 注意 prepareStatement ? 占位符 有没有引号''的问题  很坑。。。


//        System.out.println(jdbcTemplate); // 若出现 Instantiation Fail 的话 可能是缺少jar包 导致的

        // 相当于DAO层
//        jdbcTemplate.update("insert into emp values (null, '张三', 23, '男' )");

//        String sql = "insert into emp values(null, ?, ?, ?)"; // ? 占位符 只有prepareStatement才可以用 (注意批量删除和批量修改(where id in ...)不可以使用 因为prepareStatement再set的时候会多加一个单引号 可以使用拼接的方法)
//        jdbcTemplate.update(sql, args); //args 是按照顺序的
//        jdbcTemplate.update(sql, "李四", 24, "女"); // 单个增删改

        String eids = "3,4,5";
        String sql = "delete from emp where eid in ("+eids+")";
        jdbcTemplate.update(sql);

        // 模糊查询的时候
        String mohu = "a";
        String sqls = "select * from emp where ename like '%?%'";//不能使用
        String sqlss = "select * from emp where ename like concat('%', ? ,'%')";//可以使用 '和'之间如果什么都没有的话就可以自动省略
    }

    @Test
    public void testBatchUpdate() {
        // 批量增删改
        String sql = "insert into emp values(null, ?, ?, ?)";
        ArrayList<Object[]> list = new ArrayList<>();
        list.add(new Object[] {"a1", 1, "男" });
        list.add(new Object[] {"a2", 2, "男" });
        list.add(new Object[] {"a3", 3, "男" });
        jdbcTemplate.batchUpdate(sql, list);
    }

    @Test
    public void testQueryForObject() {
//        jdbcTemplate.queryForObject(sql, requiredType);  获取单个的值
//        jdbcTemplate.queryForObject(sql, rowMapper); // 用于获取单条数据

//        String sql = "select eid, ename, age, sex from emp where eid = ?";
//        RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);   // 将列名(字段名或者字段名的别名)和属性名进行映射 (把查出来的字段名字 和 类中的属性创建映射关系)
//        Emp emp = jdbcTemplate.queryForObject(sql, new Object[]{1}, rowMapper);
//        System.out.println(emp);

        String sql = "select count(*) from emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    @Test
    public void testQuery() {
        String sql = "select eid, ename, age, sex from emp";
        RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);
        List<Emp> list = jdbcTemplate.query(sql, rowMapper);
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
}
