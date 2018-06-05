package com.bottlerocket.coding.challenge.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMediaAsset is a Querydsl query type for MediaAsset
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMediaAsset extends EntityPathBase<MediaAsset> {

    private static final long serialVersionUID = 421029774L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMediaAsset mediaAsset = new QMediaAsset("mediaAsset");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QMediaContainer associatedContainer;

    //inherited
    public final DateTimePath<java.util.Calendar> dateCreated = _super.dateCreated;

    public final DateTimePath<java.util.Calendar> dateExpired = createDateTime("dateExpired", java.util.Calendar.class);

    //inherited
    public final DateTimePath<java.util.Calendar> dateUpdated = _super.dateUpdated;

    //inherited
    public final StringPath id = _super.id;

    public final QLookupReference mediaType;

    public final StringPath name = createString("name");

    public final StringPath url = createString("url");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QMediaAsset(String variable) {
        this(MediaAsset.class, forVariable(variable), INITS);
    }

    public QMediaAsset(Path<? extends MediaAsset> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMediaAsset(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMediaAsset(PathMetadata metadata, PathInits inits) {
        this(MediaAsset.class, metadata, inits);
    }

    public QMediaAsset(Class<? extends MediaAsset> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.associatedContainer = inits.isInitialized("associatedContainer") ? new QMediaContainer(forProperty("associatedContainer"), inits.get("associatedContainer")) : null;
        this.mediaType = inits.isInitialized("mediaType") ? new QLookupReference(forProperty("mediaType"), inits.get("mediaType")) : null;
    }

}

