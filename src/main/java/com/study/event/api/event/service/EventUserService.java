package com.study.event.api.event.service;

import com.study.event.api.event.repository.EventUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EventUserService {

    private final EventUserRepository eventUserRepository;

    // 이메일 중복확인 처리
    public boolean checkEmailDuplicate(String email) {
        boolean exists = eventUserRepository.existsByEmail(email);
        log.info("Checking email {} is duplicated: {}", email, exists);
        return exists;
    }

}
