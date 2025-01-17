package com.codesoom.assignment.controller.user;

import com.codesoom.assignment.application.user.UserRegisterInterface;
import com.codesoom.assignment.domain.User;
import com.codesoom.assignment.dto.UserRegistrationData;
import com.codesoom.assignment.dto.UserResultData;
import com.codesoom.assignment.error.ResourceCreateException;
import com.codesoom.assignment.error.UserEmailDuplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserRegisterController {

    private final UserRegisterInterface userRegisterService;

    public UserRegisterController(UserRegisterInterface userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    /**
     * 사용자를 등록한다.
     *
     * @param registrationData 등록할 유저의 정보
     * @throws UserEmailDuplicationException 사용자의 Email이 중복되었을 경우
     * @throws ResourceCreateException 사용자 등록 반환값이 null일 경우
     * @return 저장된 유저의 정보
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserResultData create(@RequestBody @Valid UserRegistrationData registrationData) {
        User user = userRegisterService.registerUser(registrationData);
        if(user == null){
            throw new ResourceCreateException("사용자 생성에 실패하였습니다.[registerUser에서 null이 반환되었습니다.]");
        }
        return UserResultData.of(user);
    }
}
