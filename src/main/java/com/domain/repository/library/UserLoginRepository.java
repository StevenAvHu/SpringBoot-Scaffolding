package com.domain.repository.library;

import com.entity.library.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper
@Repository
public interface UserLoginRepository {
    UserEntity queryUserInformation(@Param("username") String username,
                                    @Param("password") String password);
}
