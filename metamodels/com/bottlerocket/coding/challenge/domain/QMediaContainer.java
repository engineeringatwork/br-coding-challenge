package com.bottlerocket.coding.challenge.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMediaContainer is a Querydsl query type for MediaContainer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMediaContainer extends EntityPathBase<MediaContainer> {

    private static final long serialVersionUID = 430000671L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMediaContainer mediaContainer = new QMediaContainer("mediaContainer");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final SetPath<MediaAsset, QMediaAsset> assets = this.<MediaAsset, QMediaAsset>createSet("assets", MediaAsset.class, QMediaAsset.class, PathInits.DIRECT2);

    public final QLookupReference containerType;

    //inherited
    public final DateTimePath<java.util.Calendar> dateCreated = _super.dateCreated;

    //inherited
    public final DateTimePath<java.util.Calendar> dateUpdated = _super.dateUpdated;

    public final StringPath description = createString("description");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QMediaContainer(String variable) {
        this(MediaContainer.class, forVariable(variable), INITS);
    }

    public QMediaContainer(Path<? extends MediaContainer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMediaContainer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMediaContainer(PathMetadata metadata, PathInits inits) {
        this(MediaContainer.class, metadata, inits);
    }

    public QMediaContainer(Class<? extends MediaContainer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.containerType = inits.isInitialized("containerType") ? new QLookupReference(forProperty("containerType"), inits.get("containerType")) : null;
    }

}

