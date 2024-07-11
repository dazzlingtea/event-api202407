package com.study.event.api.event.dto.request;

import lombok.*;

@Getter @ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventUserSaveDto {

    private String email;
    private String password;

}
