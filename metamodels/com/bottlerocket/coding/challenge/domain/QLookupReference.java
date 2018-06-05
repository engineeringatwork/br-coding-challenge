package com.bottlerocket.coding.challenge.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLookupReference is a Querydsl query type for LookupReference
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLookupReference extends EntityPathBase<LookupReference> {

    private static final long serialVersionUID = 623752719L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLookupReference lookupReference = new QLookupReference("lookupReference");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Calendar> dateCreated = _super.dateCreated;

    //inherited
    public final DateTimePath<java.util.Calendar> dateUpdated = _super.dateUpdated;

    public final StringPath description = createString("description");

    //inherited
    public final StringPath id = _super.id;

    public final QLookupType lookupType;

    public final StringPath name = createString("name");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QLookupReference(String variable) {
        this(LookupReference.class, forVariable(variable), INITS);
    }

    public QLookupReference(Path<? extends LookupReference> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLookupReference(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLookupReference(PathMetadata metadata, PathInits inits) {
        this(LookupReference.class, metadata, inits);
    }

    public QLookupReference(Class<? extends LookupReference> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lookupType = inits.isInitialized("lookupType") ? new QLookupType(forProperty("lookupType")) : null;
    }

}

