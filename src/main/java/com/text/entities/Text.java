package com.text.entities;

import java.util.Objects;

public class Text extends Entity {
    private int numberLine;
    private int numberLetter;
    private int numberWord;
    private String word;
    private String letter;

    public int getNumberWord() {
        return numberWord;
    }
    public void setNumberWord(int numberWord) {
        this.numberWord = numberWord;
    }
    public int getNumberLetter() {
        return numberLetter;
    }
    public void setNumberLetter(int numberLetter) {
        this.numberLetter = numberLetter;
    }
    public int getNumberLine() {
        return numberLine;
    }
    public void setNumberLine(int numberLine) {
        this.numberLine = numberLine;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Text text = (Text) o;
        return numberLine == text.numberLine &&
                numberLetter == text.numberLetter &&
                numberWord == text.numberWord &&
                Objects.equals(word, text.word) &&
                Objects.equals(letter, text.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberLine, numberLetter, numberWord, word, letter);
    }
}
