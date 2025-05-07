package com.umc.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserPoint is a Querydsl query type for UserPoint
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserPoint extends EntityPathBase<UserPoint> {

    private static final long serialVersionUID = 2136392022L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserPoint userPoint = new QUserPoint("userPoint");

    public final com.umc.demo.domain.common.QBaseEntity _super = new com.umc.demo.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> points = createNumber("points", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QUserPoint(String variable) {
        this(UserPoint.class, forVariable(variable), INITS);
    }

    public QUserPoint(Path<? extends UserPoint> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserPoint(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserPoint(PathMetadata metadata, PathInits inits) {
        this(UserPoint.class, metadata, inits);
    }

    public QUserPoint(Class<? extends UserPoint> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

