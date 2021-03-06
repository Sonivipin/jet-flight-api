package com.mycompany.jet.model;

import java.io.IOException;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateTimeDeserializer extends JsonDeserializer<Instant> {

  @Override
  public Instant deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
                  throws IOException, JsonProcessingException {
    return Instant.parse(jsonParser.getText());
  }
}