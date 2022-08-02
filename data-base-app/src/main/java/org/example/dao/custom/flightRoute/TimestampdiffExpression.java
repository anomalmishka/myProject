package org.example.dao.custom.flightRoute;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.compile.RenderingContext;
import org.hibernate.query.criteria.internal.expression.function.BasicFunctionExpression;

import java.io.Serializable;

public class TimestampdiffExpression extends BasicFunctionExpression<String> implements Serializable {
    public TimestampdiffExpression(CriteriaBuilderImpl criteriaBuilder, Class<String> javaType,
                                   String functionName) {
        super(criteriaBuilder, javaType, functionName);
    }

    @Override
    public String render(RenderingContext renderingContext) {
        return getFunctionName();
    }
}