package org.github.scuml.junit5uml.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(MockServerExtension.class)
class BeforeAfterTest {

    /**
     *  check TestMethodTestDescriptor.execute()
     */

    @BeforeEach
    void beforeEachMethod() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("AfterEach");
    }

    @BeforeAll
    static void beforeAllMethod() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void afterAllMethod() {
        System.out.println("AfterAll");
    }

    @Test
    void greeting() {
        System.out.println("Nihao, junit5 test!");
    }


}
