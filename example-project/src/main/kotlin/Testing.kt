import org.apache.commons.lang3.StringUtils

class Testing {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // The intention of this is testing that both Gradle and IntelliJ are able to resolve dependencies
            // even though they are placed in a repository, which is only configured in the Custom Gradle Distribution.
            println(StringUtils.trim("   Hello World    "))
        }
    }
}
