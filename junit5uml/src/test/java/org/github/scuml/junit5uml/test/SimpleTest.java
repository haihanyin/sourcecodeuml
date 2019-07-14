package org.github.scuml.junit5uml.test;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SimpleTest {

    @Test
    void sayHello() {
        System.out.println("Hello, junit5 test!");
    }

    @RepeatedTest(2)
    void sayHelloMore() {
        System.out.println("Hello, junit5 test!");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void sayHello12345(int version) {
        System.out.println("Hello, junit" + version + " test!");
    }
}
