package com.lcrtech.productregistration.exception;

public class QuantityItemsException extends RuntimeException {

        @Override
        public String getMessage() {
            return "A quantidade solicitada excede o estoque disponível deste produto!";
        }
    }
