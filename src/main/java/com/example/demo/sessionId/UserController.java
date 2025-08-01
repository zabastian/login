//package com.example.demo.cotroller;
//
//
//import com.example.demo.request.UserRequest;
//import com.example.demo.response.UserResponse;
//import com.example.demo.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.web.ReactiveOffsetScrollPositionHandlerMethodArgumentResolver;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///*//    private final UserService userService;
////
////    public ResponseEntity<UserResponse> signUp(@RequestBody UserRequest userRequest) {
////        UserResponse userResponse = userService.userResponseService(
////                userRequest.getUsername(), //userRequest.getUsername()으로 값을 가져오고 그 값을 다시 String username에 보내는 것이다.
////                userRequest.getPassword()
////        );
////
////        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
////        //여기에 userResponse가 오는이유는 ResponseEntity로 이루어진 UserResponse에 해당하는 객체를
////        //()안에 넣을 수 있기 때문에 userResponse가 오는것이다.
////
////    }
//
//    //UserResponse userResponse는 값을 가져와서 사용하는게 아니라 값을 정의하는것이기 때문 new UserResponse를 service단에 생성해야 하는것이고
//    //Public UserResponse(User savedUser) {
//    //        this.username = savedUser.getUsername();
//    //    }
//    //}
//    //이렇게 쓰인것은 값을 가져와서 사용하는 것이기 때문에 생성자를 new User를 안만들어도 되는것인데(이미 new User()로 정의되어 있겠지 라고 생각)
//    //그럼 User savedUser = userRepository.save(user); 란 무엇인가 라는 의문이 들 수있다.
//
//    // 이건 User라는 savedUser를 정의하고 그거에 대한 new User를 그럼 UserRepository에서 생성해야 한다고 생각할 수 있는데
//    // 이 경우는 특수하게 save()라는 역할이 함수를 저장하고 반환하는 역할이기 때문에 생성자를 만들지 안흔 변칙적인 영속성 함수라고 생각하자*/
//
//@RestController
//@RequestMapping("/user/api/login")
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//
//    @PostMapping("/users")
//    public ResponseEntity<UserResponse> signUp(@RequestBody UserRequest userRequest) {
////      return new ResponseEntity<>(userService.userResponseService(userRequest), HttpStatus.CREATED);
//        UserResponse response = userService.userResponseService(userRequest);
//        URI location = URI.create("/users/" + response.getId());
//        return ResponseEntity.created(location).body(response); // 내부에서 당연히 new로 만듬
//    }
//
//    @GetMapping("/users/{userId}")
//    public ResponseEntity<UserResponse> getSignUp(@PathVariable Long userId) {
//        //        return new ResponseEntity<>(userService.getUserResponseService(userId), HttpStatus.OK);
//        return ResponseEntity.ok(userService.getUserResponseService(userId));
//    }
//
//    @GetMapping("/users")
//    public ResponseEntity<List<UserResponse>> getSignUpList() {
////        return new ResponseEntity<>(userService.getUserResponseServiceList(), HttpStatus.OK);
//        return ResponseEntity.ok(userService.getUserResponseServiceList());
//    }
//
//    @DeleteMapping("/users/{userId}")
//    public ResponseEntity<Void> deleteSignUp(@PathVariable Long userId) {
//        userService.deleteUserServiceSignUp(userId);
////        return new ResponseEntity<>(HttpStatus.OK);
//        return ResponseEntity.noContent().build();
//    }
//
//
//}

