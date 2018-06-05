package com.bottlerocket.coding.challenge.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLookupType is a Querydsl query type for LookupType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLookupType extends EntityPathBase<LookupType> {

    private static final long serialVersionUID = -190976522L;

    public static final QLookupType lookupType = new QLookupType("lookupType");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Calendar> dateCreated = _super.dateCreated;

    //inherited
    public final DateTimePath<java.util.Calendar> dateUpdated = _super.dateUpdated;

    public final StringPath description = createString("description");

    //inherited
    public final StringPath id = _super.id;

    public final BooleanPath isActive = createBoolean("isActive");

    public final SetPath<LookupReference, QLookupReference> lookupReferences = this.<LookupReference, QLookupReference>createSet("lookupReferences", LookupReference.class, QLookupReference.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QLookupType(String variable) {
        super(LookupType.class, forVariable(variable));
    }

    public QLookupType(Path<? extends LookupType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLookupType(PathMetadata metadata) {
        super(LookupType.class, metadata);
    }

}

