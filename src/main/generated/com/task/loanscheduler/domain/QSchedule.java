package com.task.loanscheduler.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSchedule is a Querydsl query type for Schedule
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSchedule extends EntityPathBase<Schedule> {

    private static final long serialVersionUID = -1925205150L;

    public static final QSchedule schedule = new QSchedule("schedule");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> interestBalance = createNumber("interestBalance", Long.class);

    public final NumberPath<Long> loanBalance = createNumber("loanBalance", Long.class);

    public final NumberPath<Long> loanId = createNumber("loanId", Long.class);

    public final NumberPath<Long> monthlyInterest = createNumber("monthlyInterest", Long.class);

    public final NumberPath<Long> monthlyPayment = createNumber("monthlyPayment", Long.class);

    public final NumberPath<Long> monthlyPrincipal = createNumber("monthlyPrincipal", Long.class);

    public final NumberPath<Integer> paymentCount = createNumber("paymentCount", Integer.class);

    public final StringPath paymentDate = createString("paymentDate");

    public QSchedule(String variable) {
        super(Schedule.class, forVariable(variable));
    }

    public QSchedule(Path<? extends Schedule> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSchedule(PathMetadata metadata) {
        super(Schedule.class, metadata);
    }

}

