package com.umc.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1473754022L;

    public static final QUser user = new QUser("user");

    public final com.umc.demo.domain.common.QBaseEntity _super = new com.umc.demo.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final NumberPath<Integer> gender = createNumber("gender", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> inactiveDate = createDateTime("inactiveDate", java.time.LocalDateTime.class);

    public final StringPath name = createString("name");

    public final StringPath Nickname = createString("Nickname");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> phoneStatus = createNumber("phoneStatus", Integer.class);

    public final NumberPath<Integer> role = createNumber("role", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<com.umc.demo.domain.mapping.UserFood, com.umc.demo.domain.mapping.QUserFood> userFoods = this.<com.umc.demo.domain.mapping.UserFood, com.umc.demo.domain.mapping.QUserFood>createList("userFoods", com.umc.demo.domain.mapping.UserFood.class, com.umc.demo.domain.mapping.QUserFood.class, PathInits.DIRECT2);

    public final ListPath<com.umc.demo.domain.mapping.UserMission, com.umc.demo.domain.mapping.QUserMission> userMissions = this.<com.umc.demo.domain.mapping.UserMission, com.umc.demo.domain.mapping.QUserMission>createList("userMissions", com.umc.demo.domain.mapping.UserMission.class, com.umc.demo.domain.mapping.QUserMission.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

