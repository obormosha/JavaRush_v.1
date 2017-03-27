package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "hvok", "meo", "rad", "ran", "nar"));

        /*
        int[][] crossword = new int[][]{
                {'d', 'e', 'r', 'l', 'k'},
                {'s', 'a', 'm', 'e', 'o'},
                {'n', 'g', 'r', 'o', 'v'},
                {'h', 'p', 'r', 'n', 'h'},
                {'o', 'e', 'e', 'j', 'j'}
        };

        System.out.println(detectAllWords(crossword, "home", "same", "hnr"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> thisWords = new ArrayList<>();

        for (String word : words) {
            Word thisWord = new Word(word);
            thisWords.add(thisWord);
            ArrayList<int[]> pairPointFirstLetter = searchFirstLetter(crossword, word.charAt(0));
            boolean isEndPairSerched = false;

            for (int i = 0; i < pairPointFirstLetter.size(); i++) {
                int firstX = pairPointFirstLetter.get(i)[1];
                int firstY = pairPointFirstLetter.get(i)[0];
                thisWord.setStartPoint(firstX, firstY);

                int endX = 0;
                int endY = 0;

                if (isConformityLeft(crossword, word.charAt(1), firstX, firstY)) {
                    int shift = 1;
                    for (int k = 2; k < word.length(); k++) {
                        if (isConformityLeft(crossword, word.charAt(k), firstX - shift, firstY)) {
                            shift++;
                            if (k == word.length() - 1) {
                                endX = firstX - shift;
                                endY = firstY;
                                isEndPairSerched = true;
                            }
                        }
                    }
                }

                if (isConformityRight(crossword, word.charAt(1), firstX, firstY)) {
                    int shift = 1;
                    for (int k = 2; k < word.length(); k++) {
                        if (isConformityRight(crossword, word.charAt(k), firstX + shift, firstY)) {
                            shift++;
                            if (k == word.length() - 1) {
                                endX = firstX + shift;
                                endY = firstY;
                                isEndPairSerched = true;
                            }
                        }
                    }
                }
                if (isConformityUp(crossword, word.charAt(1), firstX, firstY)) {
                    int shift = 1;
                    for (int k = 2; k < word.length(); k++) {
                        if (isConformityUp(crossword, word.charAt(k), firstX, firstY - shift)) {
                            shift++;
                            if (k == word.length() - 1) {
                                endX = firstX;
                                endY = firstY - shift;
                                isEndPairSerched = true;
                            }
                        }
                    }
                }

                if (isConformityDown(crossword, word.charAt(1), firstX, firstY)) {
                    int shift = 1;
                    for (int k = 2; k < word.length(); k++) {
                        if (isConformityDown(crossword, word.charAt(k), firstX, firstY + shift)) {
                            shift++;
                            if (k == word.length() - 1) {
                                endX = firstX;
                                endY = firstY + shift;
                                isEndPairSerched = true;
                            }
                        }
                    }
                }


                if (isConformityLeftUpDiagonal(crossword, word.charAt(1), firstX, firstY)) {
                    int shift = 1;
                    for (int k = 2; k < word.length(); k++) {
                        if (isConformityLeftUpDiagonal(crossword, word.charAt(k), firstX - shift, firstY - shift)) {
                            shift++;
                            if (k == word.length() - 1) {
                                endX = firstX - shift;
                                endY = firstY - shift;
                                isEndPairSerched = true;
                            }
                        }
                    }
                }

                if (isConformityLeftDownDiagonal(crossword, word.charAt(1), firstX, firstY)) {
                    int shift = 1;
                    for (int k = 2; k < word.length(); k++) {
                        if (isConformityLeftDownDiagonal(crossword, word.charAt(k), firstX - shift, firstY + shift)) {
                            shift++;
                            if (k == word.length() - 1) {
                                endX = firstX - shift;
                                endY = firstY + shift;
                                isEndPairSerched = true;
                            }
                        }
                    }
                }

                if (isConformityRightUpDiagonal(crossword, word.charAt(1), firstX, firstY)) {
                    int shift = 1;
                    for (int k = 2; k < word.length(); k++) {
                        if (isConformityRightUpDiagonal(crossword, word.charAt(k), firstX + shift, firstY - shift)) {
                            shift++;
                            if (k == word.length() - 1) {
                                endX = firstX + shift;
                                endY = firstY - shift;
                                isEndPairSerched = true;
                            }
                        }
                    }
                }

                if (isConformityRightDownDiagonal(crossword, word.charAt(1), firstX, firstY)) {
                    int shift = 1;
                    for (int k = 2; k < word.length(); k++) {
                        if (isConformityRightDownDiagonal(crossword, word.charAt(k), firstX + shift, firstY + shift)) {
                            shift++;
                            if (k == word.length() - 1) {
                                endX = firstX + shift;
                                endY = firstY + shift;
                                isEndPairSerched = true;
                            }
                        }
                    }
                }

                if (isEndPairSerched) {
                    thisWord.setEndPoint(endX, endY);
                    break;
                }


            }
        }
        return thisWords;
    }

    static ArrayList<int[]> searchFirstLetter(int[][] crossword, char ch) {
        ArrayList<int[]> firstLetter = new ArrayList<>();

        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length; j++) {
                if (ch == crossword[i][j]) {
                    firstLetter.add(new int[]{i, j});
                }
            }
        }
        return firstLetter;
    }

    static boolean isConformityLeft(int[][] crossword, char ch, int x, int y) {
        if (x == 0) {
            return false;
        } else if (crossword[y][x - 1] == ch) {
            return true;
        }
        return false;
    }

    static boolean isConformityRight(int[][] crossword, char ch, int x, int y) {
        if (x == crossword[0].length - 1) {
            return false;
        } else if (crossword[y][x + 1] == ch) {
            return true;
        }
        return false;
    }

    static boolean isConformityUp(int[][] crossword, char ch, int x, int y) {
        if (y == 0) {
            return false;
        } else if (crossword[y - 1][x] == ch) {
            return true;
        }
        return false;
    }

    static boolean isConformityDown(int[][] crossword, char ch, int x, int y) {
        if (y == crossword.length - 1) {
            return false;
        } else if (crossword[y + 1][x] == ch) {
            return true;
        }
        return false;
    }

    static boolean isConformityLeftUpDiagonal(int[][] crossword, char ch, int x, int y) {
        if (x == 0 || y == 0) {
            return false;
        } else if (crossword[y - 1][x - 1] == ch) {
            return true;
        }
        return false;
    }

    static boolean isConformityLeftDownDiagonal(int[][] crossword, char ch, int x, int y) {
        if (x == 0 || y == crossword.length - 1) {
            return false;
        } else if (crossword[y + 1][x - 1] == ch) {
            return true;
        }
        return false;
    }

    static boolean isConformityRightUpDiagonal(int[][] crossword, char ch, int x, int y) {
        if (x == crossword[0].length - 1 || y == 0) {
            return false;
        } else if (crossword[y - 1][x + 1] == ch) {
            return true;
        }
        return false;
    }

    static boolean isConformityRightDownDiagonal(int[][] crossword, char ch, int x, int y) {
        if (x == crossword[0].length - 1 || y == crossword.length - 1) {
            return false;
        } else if (crossword[y + 1][x + 1] == ch) {
            return true;
        }
        return false;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
