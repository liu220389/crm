package com.ttc.crms.mapper;

import com.ttc.crms.entity.Dept;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeptMapper {
    List<Dept> findBynameLike(@Param("dname") String dname);
    List<Dept> findAll();

    //    @Insert( "  insert  into dept values (  #{deptno },#{dname},#{loc}  )   " )
//    ���myBatis���������Ƕ������͵ģ���ô�� #{  }ֻ�ܷ�������
    int addNew(Dept dept);
    @Update(  "  UPDATE crm.dept t\n" +
            "SET t.dname = #{dname} ,\n" +
            "    t.loc   = #{loc}   \n" +
            "WHERE t.deptno =   #{deptno }   "  )
    int modOne(Dept dept);
}
