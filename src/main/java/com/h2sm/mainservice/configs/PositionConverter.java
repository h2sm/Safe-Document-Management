package com.h2sm.mainservice.configs;

import com.h2sm.mainservice.dtos.Position;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PositionConverter implements AttributeConverter<Position, String> {
    @Override
    public String convertToDatabaseColumn(Position position) {
        return position.name();
    }

    @Override
    public Position convertToEntityAttribute(String s) {
        return Position.valueOf(s);
    }
}
