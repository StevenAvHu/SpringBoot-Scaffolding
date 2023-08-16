package com.myJar.bussiness.bean;

import com.myJar.bussiness.dao.CheckUserRoleDao;
import com.myJar.bussiness.entity.UserRoleEntity;
import com.myJar.bussiness.properties.ConfigProperties;
import com.myJar.exception.MyJarBussinessException;
import com.myJar.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author 胡宇鑫
 * @date 2023/7/18 10:08
 * @description
 */
@Component
@Slf4j
public class CheckService {
    /**
     * configProperties
     */
    private ConfigProperties configProperties;

    /**
     * checkUserRoleDao
     */
    private CheckUserRoleDao checkUserRoleDao;

    /**
     * bean注入
     *
     * @param configProperties configProperties
     */
    @Autowired
    public void setConfigProperties(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    /**
     * bean 注入
     *
     * @param checkUserRoleDao checkUserRoleDao
     */
    @Autowired
    public void setCheckUserRoleDao(CheckUserRoleDao checkUserRoleDao) {
        this.checkUserRoleDao = checkUserRoleDao;
    }

    /**
     * 校验角色属性
     *
     * @param arg       拥有注解的参数
     * @param roleTypes 角色类别 0：管理员用户 1：普通用户
     */
    public void checkUserRole(Object arg, String roleTypes) {
        if (roleTypes == null) {
            log.warn("无角色属性，不进行校验");
            return;
        }
        try {
            Class<?> clazz = arg.getClass();
            // 获取userCode 属性值
            Field userCodeField = CheckFieldManager.getUserCodeField(clazz, "userCode");
            if (Objects.isNull(userCodeField)) {
                log.warn("{}类未获取到userCode属性，不进行角色校验", clazz.getName());
                return;
            }
            userCodeField.setAccessible(true);
            String userCode = (String) userCodeField.get(arg);
            Field imCustNoField = CheckFieldManager.getImCustNoField(clazz, "imCustNo");
            if (Objects.isNull(imCustNoField)) {
                log.warn("{}类未获取到imCustNo属性，不进行角色校验", clazz.getName());
                return;
            }
            imCustNoField.setAccessible(true);
            String imCustNo = (String) imCustNoField.get(arg);
            UserRoleEntity userRoleType = checkUserRoleDao.getUserRoleType(configProperties.getCustInfoTableName(), imCustNo, userCode);
            AssertUtil.notNull(userRoleType, "用户不存在");
            AssertUtil.isTrue(roleTypes.equals(userRoleType.getRoleType()), "角色校验失败，角色类型不符合");
        } catch (MyJarBussinessException e) {
            log.error("角色校验失败", e);
            throw new MyJarBussinessException("角色校验失败", e);
        } catch (Exception e) {
            log.warn("角色校验内部错误", e);
        }

    }
}
