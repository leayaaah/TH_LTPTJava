/*
 * @ (#) JsonUtil        1.0     2/1/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package iuh.fit.mapper;

import jakarta.json.Json;
import jakarta.json.JsonWriterFactory;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonGeneratorFactory;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 2/1/2026  7:31 AM
 */
public class JsonUtil {
    private static final Map<String,?>  CONFIG = Map.of(
            JsonGenerator.PRETTY_PRINTING, true
    );
    private static JsonGeneratorFactory FACTORY = Json.createGeneratorFactory(CONFIG);


    public static JsonGenerator createGenerator(StringWriter writer) {
        return FACTORY.createGenerator(writer);
    }
}

