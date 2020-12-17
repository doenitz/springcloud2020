package com.yin.springcloud.dao;

import com.yin.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 尹诚
 * @parm
 * @date 2020/11/6 10:33
 */
@Mapper
public interface PaymentDao {
    @Insert("INSERT INTO payment (id,serial) VALUES(#{payment.id},#{payment.serial})")
    public int create(@Param("payment") Payment payment);
    @Select("SELECT * from payment where id=#{id}")
    public Payment getPaymentById(@Param("id") Integer id);
}
