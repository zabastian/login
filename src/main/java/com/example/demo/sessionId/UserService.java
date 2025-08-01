//package com.example.demo.service;
//
//import com.example.demo.entity.User;
//import com.example.demo.globalExceptionHandler.CollectionRuntimeException;
//import com.example.demo.globalExceptionHandler.UserRuntimeException;
//import com.example.demo.repository.UserRepository;
//import com.example.demo.request.UserRequest;
//import com.example.demo.response.UserResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
////@RequiredArgsConstructor
//public class UserService{
//
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//
//    }
//
//    public UserResponse userResponseService(UserRequest userRequest) {
//
//        User user = new User(userRequest.getUsername(), userRequest.getPassword());
//
//        User savedUser = userRepository.save(user);
//
//        return new UserResponse(savedUser);
//
//    }
//
//    public UserResponse getUserResponseService(Long userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() ->new RuntimeException(/*Long.toString(userId))*/ "해당 유저의 아이디를 찾을 수 없습니다" + userId));
//        return new UserResponse(user);
//    }
//
//    public List<UserResponse> getUserResponseServiceList() {
//
//        List<User> userList = userRepository.findAll();
//
//        return userList.stream()
//                .map(user -> new UserResponse(user))
////                .map(UserResponse::new)
//                .toList();
//        //List를 stream으로 변환하고 user를 UserResponse에 넣은다음에 다시 list로 변환(list에는 map이 없기 때문에, stream으로 변환해줘야함)
//
//       /* List<UserResponse> userResponseList = new ArrayList<>();
//
//        for(User a : userList) {
//            UserResponse userResponse = new UserResponse(a);
//            userResponseList.add(userResponse);
//
//        }
//
//        return userResponseList;*//*
//*/
//    }
//
//        public void deleteUserServiceSignUp(Long userId) {
//
//                User user = userRepository.findById(userId)
//                    .orElseThrow(() -> CollectionRuntimeException.userNotFoundException(userId));
//
//           userRepository.delete(user);
//        }
//}