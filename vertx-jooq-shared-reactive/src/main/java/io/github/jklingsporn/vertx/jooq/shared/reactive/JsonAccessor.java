package io.github.jklingsporn.vertx.jooq.shared.reactive;

import io.reactiverse.pgclient.Row;
import io.reactiverse.pgclient.data.Json;
import io.reactiverse.pgclient.impl.data.JsonImpl;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

/**
 * Created by jensklingsporn on 07.08.18.
 */
public class JsonAccessor {

    private JsonAccessor(){}

    public static JsonObject getJsonObject(Row row, String field){
        return (JsonObject) getJson(row,field).value();
    }

    public static JsonArray getJsonArray(Row row, String field){
        return (JsonArray) getJson(row,field).value();
    }

    public static Json getJson(Row row, String field) {
        return row.getJson(field) == null ? JsonImpl.NULL : row.getJson(field);
    }

}
