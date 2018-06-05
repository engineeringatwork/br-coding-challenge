package com.bottlerocket.coding.challenge.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVideoAsset is a Querydsl query type for VideoAsset
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVideoAsset extends EntityPathBase<VideoAsset> {

    private static final long serialVersionUID = 1158285655L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVideoAsset videoAsset = new QVideoAsset("videoAsset");

    public final QMediaAsset _super;

    // inherited
    public final QMediaContainer associatedContainer;

    //inherited
    public final DateTimePath<java.util.Calendar> dateCreated;

    //inherited
    public final DateTimePath<java.util.Calendar> dateExpired;

    //inherited
    public final DateTimePath<java.util.Calendar> dateUpdated;

    //inherited
    public final StringPath id;

    // inherited
    public final QLookupReference mediaType;

    //inherited
    public final StringPath name;

    //inherited
    public final StringPath url;

    //inherited
    public final NumberPath<Integer> version;

    public final QLookupReference videoType;

    public QVideoAsset(String variable) {
        this(VideoAsset.class, forVariable(variable), INITS);
    }

    public QVideoAsset(Path<? extends VideoAsset> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVideoAsset(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVideoAsset(PathMetadata metadata, PathInits inits) {
        this(VideoAsset.class, metadata, inits);
    }

    public QVideoAsset(Class<? extends VideoAsset> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QMediaAsset(type, metadata, inits);
        this.associatedContainer = _super.associatedContainer;
        this.dateCreated = _super.dateCreated;
        this.dateExpired = _super.dateExpired;
        this.dateUpdated = _super.dateUpdated;
        this.id = _super.id;
        this.mediaType = _super.mediaType;
        this.name = _super.name;
        this.url = _super.url;
        this.version = _super.version;
        this.videoType = inits.isInitialized("videoType") ? new QLookupReference(forProperty("videoType"), inits.get("videoType")) : null;
    }

}

