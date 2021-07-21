package com.jpacrud.domain.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class CommonDateEntity {

    @CreatedDate //생성시간
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @LastModifiedBy // 수정시간
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;
}
