package org.example;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountWordsTest {
    @Test
    void twoWordsEndingWithS() { // 1
        int words = new CountWords().count("dogs cats");
        assertThat(words).isEqualTo(2);
    }
    @Test
    void noWordsAtAll() { // 2
        int words = new CountWords().count("dog cat");
        assertThat(words).isEqualTo(0);
    }
    @Test
    void wordsThatEndInR() { // 1
        int words = new CountWords().count("car bar");
        assertThat(words).isEqualTo(2);
    }
    @Test
    void twoWordsEndingWithSorR() { // 1
        int words = new CountWords().count("dogs car");
        assertThat(words).isEqualTo(2);
    }

}