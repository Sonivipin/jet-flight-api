package com.mycompany.jet.model;

import java.io.IOException;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateTimeSerializer extends JsonSerializer<Instant> {

  @Override
  public void serialize(final Instant instant, final JsonGenerator jsonGenerator,
                  final SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
    jsonGenerator.writeString(instant.toString());
  }
}
