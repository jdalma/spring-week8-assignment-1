package com.codesoom.assignment.application.user;

import com.codesoom.assignment.domain.User;
import com.codesoom.assignment.dto.UserRegistrationData;

public interface UserRegisterInterface {
    /**
     * 사용자를 등록한다.
     *
     * @param registrationData 등록할 유저의 정보
     * @return 저장된 유저의 정보
     */
    User registerUser(UserRegistrationData registrationData);
}
