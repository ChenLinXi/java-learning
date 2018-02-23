package com.jason.reference;

public class Reference {

    private String reference;

    public Reference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "{"
            + "\"reference\":\"" + reference + "\""
            + "}";
    }
}
