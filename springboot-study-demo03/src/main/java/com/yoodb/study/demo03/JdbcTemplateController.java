package com.yoodb.study.demo03;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.yoodb.study.demo03.bean.BootUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jte")
public class JdbcTemplateController {
    @Autowired
    private JdbcTemplate oneSqlSessionTemplate;

    @Autowired
    private JdbcTemplate twoSqlSessionTemplate;

    @RequestMapping("/getOneUsers")
    public List<Map<String, Object>> getOneUsers(){
        String sql = "select * from boot_user";
        List<Map<String, Object>> list =  twoSqlSessionTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }

    @RequestMapping("/getTwoUsers")
    public List<BootUser> getTwoUsers() {
        List<BootUser> list = twoSqlSessionTemplate.query("select id,user_name " +
                "name,detail from boot_user", new BeanPropertyRowMapper<>(BootUser.class));
        return list;
    }
    
}

