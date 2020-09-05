package com.text.entities;

import java.util.Objects;

public class Text extends Entity {

    private String fullText;

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Text text = (Text) o;
        return Objects.equals(fullText, text.fullText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fullText);
    }
}