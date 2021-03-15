package ktx.common

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.EXPRESSION,
    AnnotationTarget.PROPERTY
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Desc(
    val desc: String = "",
    val createVersion: String = "",

    val changeVersion: String = "",
    val changeDesc: String = ""
)