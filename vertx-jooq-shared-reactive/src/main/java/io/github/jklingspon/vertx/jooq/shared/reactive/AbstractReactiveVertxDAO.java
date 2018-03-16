package io.github.jklingspon.vertx.jooq.shared.reactive;

import io.github.jklingsporn.vertx.jooq.shared.internal.AbstractVertxDAO;
import io.github.jklingsporn.vertx.jooq.shared.internal.QueryExecutor;
import io.vertx.core.impl.Arguments;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.function.Function;

/**
 * Abstract base class for all async DAOs.
 * @param <R> the <code>Record</code> type.
 * @param <P> the POJO-type
 * @param <T> the Key-Type
 * @param <FIND_MANY> the result type returned for all findManyXYZ-operations. This varies on the VertxDAO-subtypes, e.g. {@code Future<List<P>>}.
 * @param <FIND_ONE> the result type returned for all findOneXYZ-operations. This varies on the VertxDAO-subtypes , e.g. {@code Future<P>}.
 * @param <EXECUTE> the result type returned for all insert, update and delete-operations. This varies on the VertxDAO-subtypes, e.g. {@code Future<Integer>}.
 * @param <INSERT_RETURNING> the result type returned for the insertReturning-operation. This varies on the VertxDAO-subtypes, e.g. {@code Future<T>}.
 */
public abstract class AbstractReactiveVertxDAO<R extends UpdatableRecord<R>, P, T, FIND_MANY, FIND_ONE,EXECUTE, INSERT_RETURNING> extends AbstractVertxDAO<R,P,T,FIND_MANY,FIND_ONE, EXECUTE, INSERT_RETURNING>{

    static EnumSet<SQLDialect> SUPPORTED_DIALECTS = EnumSet.of(SQLDialect.POSTGRES,SQLDialect.POSTGRES_9_3,SQLDialect.POSTGRES_9_4,SQLDialect.POSTGRES_9_5);

    protected AbstractReactiveVertxDAO(Table<R> table, Class<P> type, QueryExecutor<R, T, FIND_MANY, FIND_ONE, EXECUTE, INSERT_RETURNING> queryExecutor, Configuration configuration) {
        super(table, type, queryExecutor, configuration);
        Arguments.require(SUPPORTED_DIALECTS.contains(configuration.dialect()),"Only Postgres supported");
    }

    /**
     * @return the converter used to convert the returned primary key to type T. Since the input argument of the Function
     * is always a Long, only non-compound numeric keys can be returned. This method gets automatically overridden during
     * DAO-creation depending on T.
     */
    @SuppressWarnings("unchecked")
    protected Function<Object,T> keyConverter(){
        return o -> {
            com.julienviet.pgclient.Row row = (com.julienviet.pgclient.Row) o;
            TableField<R, ?>[] fields = getTable().getPrimaryKey().getFieldsArray();
            if(fields.length == 1){
                return (T)row.getValue(fields[0].getName());
            }
            //compound key is of type Record
            Record record = DSL.using(configuration()).newRecord(fields);
            Arrays.stream(fields).forEach(f -> record.set((TableField<R,Object>)f,row.getValue(f.getName())));
            return (T)record;
        };
    }

    @Override
    public INSERT_RETURNING insertReturningPrimary(P object) {
        DSLContext dslContext = DSL.using(configuration());
        return queryExecutor().insertReturning(dslContext.insertInto(getTable()).set(newRecord(dslContext, object)).returning(getTable().getPrimaryKey().getFieldsArray()), keyConverter());
    }
}