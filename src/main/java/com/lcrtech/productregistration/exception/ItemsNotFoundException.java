package com.lcrtech.productregistration.exception;

public class ItemsNotFoundException extends RuntimeException {

        @Override
        public String getMessage() {
            return "A quantidade solicitada excede o estoque disponível deste produto!";
        }
    }
