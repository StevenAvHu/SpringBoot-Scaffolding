package com.myJar.bussiness.dao;

import com.myJar.bussiness.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @program: springCloud
 * @description: 校验用户信息
 * @author: 胡宇鑫
 * @create: 2023-08-16 10:47
 **/
@Repository
@Mapper
public interface CheckUserRoleDao {

    @Select("select im_cust_no,user_code,role_type from ${tableName} where im_cust_no = ${imCustNo} and user_code = {userCode}")
    UserRoleEntity getUserRoleType(@Param("tableName") String tableName,
                                   @Param("imCustNo") String imCustNo,
                                   @Param("userCode") String userCode);
}
