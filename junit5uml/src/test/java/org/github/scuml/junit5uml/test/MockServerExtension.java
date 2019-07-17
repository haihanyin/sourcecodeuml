package org.github.scuml.junit5uml.test;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MockServerExtension implements BeforeAllCallback {
    public void beforeAll(ExtensionContext context) throws Exception {
        context.getRoot().getStore(ExtensionContext.Namespace.GLOBAL)
                .getOrComputeIfAbsent(MyMockServer.class);
    }

    static class MyMockServer implements ExtensionContext.Store.CloseableResource {

        public void close() throws Throwable {
            System.out.println("close mock server");
        }
    }
}
