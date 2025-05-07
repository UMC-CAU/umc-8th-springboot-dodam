package com.umc.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInquiryImage is a Querydsl query type for InquiryImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiryImage extends EntityPathBase<InquiryImage> {

    private static final long serialVersionUID = 1496487267L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInquiryImage inquiryImage = new QInquiryImage("inquiryImage");

    public final StringPath id = createString("id");

    public final QInquiry inquiry;

    public final StringPath url = createString("url");

    public QInquiryImage(String variable) {
        this(InquiryImage.class, forVariable(variable), INITS);
    }

    public QInquiryImage(Path<? extends InquiryImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInquiryImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInquiryImage(PathMetadata metadata, PathInits inits) {
        this(InquiryImage.class, metadata, inits);
    }

    public QInquiryImage(Class<? extends InquiryImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inquiry = inits.isInitialized("inquiry") ? new QInquiry(forProperty("inquiry"), inits.get("inquiry")) : null;
    }

}

