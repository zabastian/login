package com.example.demo.homePage;

import com.example.demo.entity.User;
import com.example.demo.repository.MuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomePageService {

    private final HomePageRepository homePageRepository;
    private final MuRepository muRepository ;

    public HomePageResponse HomepageWelcome(HomePageRequest homePageRequest, Long userId, String role) {

        User user1 = muRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("id정보가 다릅니다.")) ;

//        if(!"USER".equals(role)) {
//            throw new IllegalArgumentException("USERROLE이 USER가 아닙니다.");
//        }
        // 이미 customFilter 에서 기능 구현함

        if ( !homePageRequest.getUserId().equals(user1.getId())) {
            throw new IllegalArgumentException("로그인 시 userId 정보가 일치하지 않습니다.");
        }

//        User user = muRepository.findById(homePageRequest.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException("비밀번호가 다릅니다."));

        HomePage homepage = new HomePage(homePageRequest.getMessage(), user1);

        homePageRepository.save(homepage);

        return new HomePageResponse(homepage.getMessage(), user1.getId());
    }
}
