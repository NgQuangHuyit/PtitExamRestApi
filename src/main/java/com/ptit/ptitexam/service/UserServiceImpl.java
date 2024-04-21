package com.ptit.ptitexam.service;

import com.ptit.ptitexam.entity.User;
import com.ptit.ptitexam.exceptions.NotFoundException;
import com.ptit.ptitexam.exceptions.UsernameOrEmailAlreadyExists;
import com.ptit.ptitexam.payload.LoginDto;
import com.ptit.ptitexam.payload.RegisterDto;
import com.ptit.ptitexam.payload.UserDetailDto;
import com.ptit.ptitexam.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ModelMapper modelMapper;

//    private boolean checkPasswordPatten(String password) {
//        return true
//    }

    @Override
    public UserDetailDto registerUser(RegisterDto registerDto) {
        if(userRepository.existsByUsernameOrEmail(registerDto.getUsername(), registerDto.getEmail())) {
            throw new UsernameOrEmailAlreadyExists();
        }
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        user.setIsActive(true);
        userRepository.save(user);
        return modelMapper.map(user, UserDetailDto.class);
    }

    @Override
    public boolean loginAccount(LoginDto loginDto) {
        User accountEntity = userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
        return accountEntity != null;
    }

    @Override
    public UserDetailDto findAccountById(Long id) {
         User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User", "id", id));
         return modelMapper.map(user, UserDetailDto.class);
    }

    @Override
    public UserDetailDto updateUser(Long id, UserDetailDto userDetailDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("user", "id", id));
        user.setPassword(userDetailDto.getPassword());
        user.setEmail(userDetailDto.getEmail());
        user.setFullname(userDetailDto.getFullname());
        user.setDob(userDetailDto.getDob());
        user.setIsActive(userDetailDto.getIsActive());
        user.setPhoneNumber(userDetailDto.getPhoneNumber());
        userRepository.save(user);
        return userDetailDto;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDetailDto> findAll() {
        List<User> accounts = userRepository.findAll();
        return accounts.stream()
                .map((acc) -> this.modelMapper.map(acc, UserDetailDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDetailDto> searchByFullName(String fullname) {
        return userRepository.findAllByFullnameContainingIgnoreCase(fullname).stream()
                .map((user) -> this.modelMapper.map(user, UserDetailDto.class))
                .toList();
    }
}
