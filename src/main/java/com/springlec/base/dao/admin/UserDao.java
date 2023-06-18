package com.springlec.base.dao.admin;

import com.springlec.base.model.admin.UserDto;

import java.util.ArrayList;

public interface UserDao {
    ArrayList<UserDto> searchUser();
    ArrayList<UserDto> searchGender();
    ArrayList<UserDto> searchAge();
    ArrayList<UserDto> searchInsertdate();
}
