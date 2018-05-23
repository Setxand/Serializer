package com.customSerialization.logic;

import java.io.Serializable;

public interface Serializer {
    String serializeToJson(Serializable object);
    String serializeAddressToProps(Object object);
}
