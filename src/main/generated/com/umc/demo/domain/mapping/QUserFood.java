package com.umc.demo.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserFood is a Querydsl query type for UserFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserFood extends EntityPathBase<UserFood> {

    private static final long serialVersionUID = 466850296L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserFood userFood = new QUserFood("userFood");

    public final com.umc.demo.domain.QFoodCategory foodCategory;

    public final StringPath id = createString("id");

    public final com.umc.demo.domain.QUser user;

    public QUserFood(String variable) {
        this(UserFood.class, forVariable(variable), INITS);
    }

    public QUserFood(Path<? extends UserFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserFood(PathMetadata metadata, PathInits inits) {
        this(UserFood.class, metadata, inits);
    }

    public QUserFood(Class<? extends UserFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new com.umc.demo.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.user = inits.isInitialized("user") ? new com.umc.demo.domain.QUser(forProperty("user")) : null;
    }

}

