package com.example.demo.mapper;

import java.util.List;

import com.example.demo.dto.UserDto;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    // 모든 유저 출력
    @Select("select * from USER;")
    @Results(id = "userResultMap", value = { // database의 column명과 UserDto class의 변수명을 매핑 시킨다.
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "age", column = "age")
    })
    List<UserDto> getUsers();

    // 유저 생성
    @Insert("insert into USER(first_name, last_name, age) values (#{first_name}, #{last_name}, #{age});")
    int createUser(@Param("first_name") String firstName, @Param("last_name") String lastName, @Param("age") int age);

    // 유저 출력
    @Select("select * from USER where id = #{id}")
    @ResultMap("userResultMap") // @Results에 id를 선언함으로써 @ResultMap으로 재사용 가능하다.
    UserDto getUser(@Param("id") int id);

    // 유저 업데이트
    @Update("update USER set first_name = #{first_name}, last_name = #{last_name}, age = #{age} where id = #{id};")
    @ResultMap("userResultMap")
    int updateUser(@Param("id") int id, @Param("first_name") String firstName, @Param("last_name") String lastName, @Param("age") int age);

    // 유저 삭제
    @Delete("delete from USER where id = #{id}")
    int deleteUser(@Param("id") int id);
}