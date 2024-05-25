package com.rentify.rms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "likes", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "property_id"}))
public class Like {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class LikeId implements Serializable {
        private int userId;
        private int propertyId;
    }

    @EmbeddedId
    private LikeId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("propertyId")
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    public Like(User user, Property property) {
        this.user = user;
        this.property = property;
        this.id = new LikeId(user.getId(), property.getId());
    }
}
