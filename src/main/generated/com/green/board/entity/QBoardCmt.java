package com.green.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardCmt is a Querydsl query type for BoardCmt
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardCmt extends EntityPathBase<BoardCmt> {

    private static final long serialVersionUID = 910731183L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardCmt boardCmt = new QBoardCmt("boardCmt");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QBoard board;

    public final StringPath cmt = createString("cmt");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> icmt = createNumber("icmt", Long.class);

    public final StringPath pw = createString("pw");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath writer = createString("writer");

    public QBoardCmt(String variable) {
        this(BoardCmt.class, forVariable(variable), INITS);
    }

    public QBoardCmt(Path<? extends BoardCmt> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardCmt(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardCmt(PathMetadata metadata, PathInits inits) {
        this(BoardCmt.class, metadata, inits);
    }

    public QBoardCmt(Class<? extends BoardCmt> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board")) : null;
    }

}

