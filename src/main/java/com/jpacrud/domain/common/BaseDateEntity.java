package com.jpacrud.domain.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDateEntity {

    @CreatedDate //생성시간
    @Column(name = "create_date", updatable = false, columnDefinition = "DATETIME(6) comment '등록 일시'" )
    private LocalDateTime createDate;

    @LastModifiedDate // 수정시간
    @Column(name = "modify_date", columnDefinition = "DATETIME(6) comment '수정 일시'")
    private LocalDateTime modifyDate;
}
