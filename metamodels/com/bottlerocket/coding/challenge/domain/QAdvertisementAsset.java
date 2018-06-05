package com.bottlerocket.coding.challenge.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAdvertisementAsset is a Querydsl query type for AdvertisementAsset
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdvertisementAsset extends EntityPathBase<AdvertisementAsset> {

    private static final long serialVersionUID = -560992243L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAdvertisementAsset advertisementAsset = new QAdvertisementAsset("advertisementAsset");

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

    public final StringPath productDescription = createString("productDescription");

    //inherited
    public final StringPath url;

    //inherited
    public final NumberPath<Integer> version;

    public QAdvertisementAsset(String variable) {
        this(AdvertisementAsset.class, forVariable(variable), INITS);
    }

    public QAdvertisementAsset(Path<? extends AdvertisementAsset> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAdvertisementAsset(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAdvertisementAsset(PathMetadata metadata, PathInits inits) {
        this(AdvertisementAsset.class, metadata, inits);
    }

    public QAdvertisementAsset(Class<? extends AdvertisementAsset> type, PathMetadata metadata, PathInits inits) {
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
    }

}

