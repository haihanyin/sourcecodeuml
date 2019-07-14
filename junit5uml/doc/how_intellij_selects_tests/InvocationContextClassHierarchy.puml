@startuml

package junit-jupiter-api {
    interface TestTemplateInvocationContext
}
package junit-jupiter-engine {
    class RepeatedTestInvocationContext
}
package junit-jupiter-params {
    class ParameterizedTestInvocationContext
}

TestTemplateInvocationContext <|-- RepeatedTestInvocationContext
TestTemplateInvocationContext <|-- ParameterizedTestInvocationContext

@enduml