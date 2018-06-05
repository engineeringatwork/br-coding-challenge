package com.bottlerocket.coding.challenge.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseEntity is a Querydsl query type for BaseEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QBaseEntity extends EntityPathBase<BaseEntity> {

    private static final long serialVersionUID = 1579828278L;

    public static final QBaseEntity baseEntity = new QBaseEntity("baseEntity");

    public final DateTimePath<java.util.Calendar> dateCreated = createDateTime("dateCreated", java.util.Calendar.class);

    public final DateTimePath<java.util.Calendar> dateUpdated = createDateTime("dateUpdated", java.util.Calendar.class);

    public final StringPath id = createString("id");

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QBaseEntity(String variable) {
        super(BaseEntity.class, forVariable(variable));
    }

    public QBaseEntity(Path<? extends BaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseEntity(PathMetadata metadata) {
        super(BaseEntity.class, metadata);
    }

}

