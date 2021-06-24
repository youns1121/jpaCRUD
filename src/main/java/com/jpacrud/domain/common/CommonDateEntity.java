package com.jpacrud.domain.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class CommonDateEntity {
    @CreatedDate //생성시간
    private LocalDateTime createDate;

    @LastModifiedBy // 수정시간
    private LocalDateTime modifyDate;
}
