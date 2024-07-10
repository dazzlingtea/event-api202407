package com.study.event.api.event.repository;

import com.study.event.api.event.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventRepositoryCustom {

    Page<Event> findEvents(Pageable pageable, String sort);

    // ... 필요한 거 작성하면 됨 -> JPA 리포지토리에 상속

}
