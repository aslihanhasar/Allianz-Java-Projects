package main.java.util;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID uuid;

    @CreatedDate
    private Date creationDate;

    @LastModifiedDate
    private Date updatedDate;

    @PrePersist
    protected void onCreate() {
        setUuid(java.util.UUID.randomUUID());
    }
}
