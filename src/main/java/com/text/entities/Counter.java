package com.text.entities;

import java.util.Objects;

public class Counter extends Entity{
    private int numberLine;
    private int numberLetter;
    private int numberWord;
    private String word;
    private char letter;

    public int getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(int numberLine) {
        this.numberLine = numberLine;
    }

    public int getNumberLetter() {
        return numberLetter;
    }

    public void setNumberLetter(int numberLetter) {
        this.numberLetter = numberLetter;
    }

    public int getNumberWord() {
        return numberWord;
    }

    public void setNumberWord(int numberWord) {
        this.numberWord = numberWord;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Counter counter = (Counter) o;
        return numberLine == counter.numberLine &&
                numberLetter == counter.numberLetter &&
                numberWord == counter.numberWord &&
                letter == counter.letter &&
                Objects.equals(word, counter.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberLine, numberLetter, numberWord, word, letter);
    }
}
