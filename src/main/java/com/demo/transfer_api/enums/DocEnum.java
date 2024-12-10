package com.demo.transfer_api.enums;

public enum DocEnum {
    DNI("01"),
    LE("02"),
    LC("03"),
    CUIT("11"),
    CI("101"),
    PAS("125");

    private final String codigo;

    DocEnum(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}

