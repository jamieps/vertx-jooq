/*
 * This file is generated by jOOQ.
 */
package generated.cf.reactive.guice.vertx.tables.daos;


import generated.cf.reactive.guice.vertx.enums.Someenum;
import generated.cf.reactive.guice.vertx.tables.Something;
import generated.cf.reactive.guice.vertx.tables.records.SomethingRecord;

import io.github.jklingsporn.vertx.jooq.shared.reactive.AbstractReactiveVertxDAO;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;


import java.util.concurrent.CompletableFuture;
import io.github.jklingsporn.vertx.jooq.completablefuture.VertxDAO;
import io.github.jklingsporn.vertx.jooq.completablefuture.reactivepg.ReactiveCompletableFutureQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.inject.Singleton
public class SomethingDao extends AbstractReactiveVertxDAO<SomethingRecord, generated.cf.reactive.guice.vertx.tables.pojos.Something, Integer, CompletableFuture<List<generated.cf.reactive.guice.vertx.tables.pojos.Something>>, CompletableFuture<generated.cf.reactive.guice.vertx.tables.pojos.Something>, CompletableFuture<Integer>, CompletableFuture<Integer>> implements io.github.jklingsporn.vertx.jooq.completablefuture.VertxDAO<SomethingRecord,generated.cf.reactive.guice.vertx.tables.pojos.Something,Integer> {
    @javax.inject.Inject

    /**
     * @param configuration The Configuration used for rendering and query execution.
     * @param vertx the vertx instance
     */
    public SomethingDao(Configuration configuration, io.reactiverse.pgclient.PgClient delegate, io.vertx.core.Vertx vertx) {
        super(Something.SOMETHING, generated.cf.reactive.guice.vertx.tables.pojos.Something.class, new ReactiveCompletableFutureQueryExecutor<SomethingRecord,generated.cf.reactive.guice.vertx.tables.pojos.Something,Integer>(configuration,delegate,generated.cf.reactive.guice.vertx.tables.mappers.RowMappers.getSomethingMapper(),vertx));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(generated.cf.reactive.guice.vertx.tables.pojos.Something object) {
        return object.getSomeid();
    }

    /**
     * Find records that have <code>someString IN (values)</code> asynchronously
     */
    public CompletableFuture<List<generated.cf.reactive.guice.vertx.tables.pojos.Something>> findManyBySomestring(List<String> values) {
        return findManyByCondition(Something.SOMETHING.SOMESTRING.in(values));
    }

    /**
     * Find records that have <code>someHugeNumber IN (values)</code> asynchronously
     */
    public CompletableFuture<List<generated.cf.reactive.guice.vertx.tables.pojos.Something>> findManyBySomehugenumber(List<Long> values) {
        return findManyByCondition(Something.SOMETHING.SOMEHUGENUMBER.in(values));
    }

    /**
     * Find records that have <code>someSmallNumber IN (values)</code> asynchronously
     */
    public CompletableFuture<List<generated.cf.reactive.guice.vertx.tables.pojos.Something>> findManyBySomesmallnumber(List<Short> values) {
        return findManyByCondition(Something.SOMETHING.SOMESMALLNUMBER.in(values));
    }

    /**
     * Find records that have <code>someRegularNumber IN (values)</code> asynchronously
     */
    public CompletableFuture<List<generated.cf.reactive.guice.vertx.tables.pojos.Something>> findManyBySomeregularnumber(List<Integer> values) {
        return findManyByCondition(Something.SOMETHING.SOMEREGULARNUMBER.in(values));
    }

    /**
     * Find records that have <code>someDouble IN (values)</code> asynchronously
     */
    public CompletableFuture<List<generated.cf.reactive.guice.vertx.tables.pojos.Something>> findManyBySomedouble(List<Double> values) {
        return findManyByCondition(Something.SOMETHING.SOMEDOUBLE.in(values));
    }

    /**
     * Find records that have <code>someEnum IN (values)</code> asynchronously
     */
    public CompletableFuture<List<generated.cf.reactive.guice.vertx.tables.pojos.Something>> findManyBySomeenum(List<Someenum> values) {
        return findManyByCondition(Something.SOMETHING.SOMEENUM.in(values));
    }

    /**
     * Find records that have <code>someJsonObject IN (values)</code> asynchronously
     */
    public CompletableFuture<List<generated.cf.reactive.guice.vertx.tables.pojos.Something>> findManyBySomejsonobject(List<JsonObject> values) {
        return findManyByCondition(Something.SOMETHING.SOMEJSONOBJECT.in(values));
    }

    /**
     * Find records that have <code>someJsonArray IN (values)</code> asynchronously
     */
    public CompletableFuture<List<generated.cf.reactive.guice.vertx.tables.pojos.Something>> findManyBySomejsonarray(List<JsonArray> values) {
        return findManyByCondition(Something.SOMETHING.SOMEJSONARRAY.in(values));
    }

    /**
     * Find records that have <code>someTimestamp IN (values)</code> asynchronously
     */
    public CompletableFuture<List<generated.cf.reactive.guice.vertx.tables.pojos.Something>> findManyBySometimestamp(List<LocalDateTime> values) {
        return findManyByCondition(Something.SOMETHING.SOMETIMESTAMP.in(values));
    }

    @Override
    public ReactiveCompletableFutureQueryExecutor<SomethingRecord,generated.cf.reactive.guice.vertx.tables.pojos.Something,Integer> queryExecutor(){
        return (ReactiveCompletableFutureQueryExecutor<SomethingRecord,generated.cf.reactive.guice.vertx.tables.pojos.Something,Integer>) super.queryExecutor();
    }
}
