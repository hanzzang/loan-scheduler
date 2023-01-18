package com.task.loanscheduler.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLoan is a Querydsl query type for Loan
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLoan extends EntityPathBase<Loan> {

    private static final long serialVersionUID = -457571525L;

    public static final QLoan loan = new QLoan("loan");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> interestRate = createNumber("interestRate", Double.class);

    public final NumberPath<Long> loanAmount = createNumber("loanAmount", Long.class);

    public final StringPath loanDate = createString("loanDate");

    public final NumberPath<Integer> loanTerm = createNumber("loanTerm", Integer.class);

    public final EnumPath<LoanType> loanType = createEnum("loanType", LoanType.class);

    public QLoan(String variable) {
        super(Loan.class, forVariable(variable));
    }

    public QLoan(Path<? extends Loan> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLoan(PathMetadata metadata) {
        super(Loan.class, metadata);
    }

}

